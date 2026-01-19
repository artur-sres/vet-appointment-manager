package clinicaveterinaria.controller;

import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.model.Pet;
import clinicaveterinaria.model.Enums.Procedimento;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

// Classe que guarda toda a lógica que gerencia os atendimentos
// Metódos possuem nomes autoexplicativos
public class AtendimentoController {
    private static final ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();
    private static final String ARQUIVO_ATENDIMENTOS = "atendimentos.txt";

    public static void cadastrar(Atendimento novoAtendimento) throws Exception {
        listaAtendimentos.add(novoAtendimento);

        novoAtendimento.getPetAtendido().getHistorico().add(novoAtendimento);
        novoAtendimento.getVetResponsavel().getAgendaConsultas().add(novoAtendimento);
        
        salvarDados();
    }
    
    public static void remover(Atendimento atendimento) throws Exception{
        if (atendimento == null) return;

        if (atendimento.getPetAtendido() != null) {
            atendimento.getPetAtendido().getHistorico().remove(atendimento);
        }    
        
        if (atendimento.getVetResponsavel() != null) {
            atendimento.getVetResponsavel().getAgendaConsultas().remove(atendimento);
        }
        
        listaAtendimentos.remove(atendimento);
        
        salvarDados();
    }

    public static void salvarDados() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_ATENDIMENTOS))) {
            for (Atendimento att : listaAtendimentos) {
                // Estrutura: PROCEDIMENTO;EMAIL_VET;CPF_TUTOR;NOME_PET;DATA;HORA;DURACAO;DESCRICAO
                String linha = String.format("%s;%s;%s;%s;%s;%s;%d;%s",
                    att.getProcedimento().name(),
                    att.getVetResponsavel().getEmail(),      
                    att.getPetAtendido().getTutor().getCPF(),
                    att.getPetAtendido().getNome(),          
                    att.getData(),
                    att.getHora(),
                    att.getDuracaoMinutos(),
                    att.getDescricao()
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new Exception ("Não foi possivel salvar os dados");
        }
    }

    public static void carregarDados() throws Exception{
        File arquivo = new File(ARQUIVO_ATENDIMENTOS);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados.length >= 8) {
                    // Recupera os identificadores
                    Procedimento proc = Procedimento.valueOf(dados[0]);
                    String emailVet = dados[1];
                    String cpfTutor = dados[2];
                    String nomePet = dados[3];
                    LocalDate data = LocalDate.parse(dados[4]);
                    LocalTime hora = LocalTime.parse(dados[5]);
                    int duracao = Integer.parseInt(dados[6]);
                    String descricao = dados[7];

                    Veterinario vet = encontrarVeterinario(emailVet);
                    Pet pet = encontrarPet(cpfTutor, nomePet);

                    if (vet != null && pet != null) {
                        Atendimento att = new Atendimento(proc, pet, vet, data, hora, descricao);
                        att.setDuracaoMinutos(duracao);

                        listaAtendimentos.add(att);
                        
                        vet.getAgendaConsultas().add(att);
                        pet.getHistorico().add(att);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception ("Não foi possivel carregar os dados");
        }
    }

    // Métodos Auxiliares para buscar objetos nas outras listas
    private static Veterinario encontrarVeterinario(String email) {
        for (Veterinario v : VeterinarioController.getListaVeterinarios()) {
            if (v.getEmail().equalsIgnoreCase(email)) return v;
        }
        return null;
    }

    private static Pet encontrarPet(String cpfTutor, String nomePet) {
        for (Pet p : PetController.getListaPets()) {
            // Verifica se o pet tem esse nome E se pertence ao dono daquele CPF
            if (p.getNome().equalsIgnoreCase(nomePet) && 
                p.getTutor().getCPF().equals(cpfTutor)) {
                return p;
            }
        }
        return null;
    }
    
    public static List<Atendimento> getAtendimentosDoDia() {
        List<Atendimento> agendaDia = new ArrayList<>();
        LocalDate dia = LocalDate.now();

        for (Atendimento a : listaAtendimentos) {
            if (a.getData().equals(dia)) {
                agendaDia.add(a);
            }
        }
        Collections.sort(agendaDia, Comparator.comparing(Atendimento::getHora));
        return agendaDia;
    }
    
    public static List<String> buscarHorariosDisponiveis(Veterinario vet, Pet pet, LocalDate data, int duracaoMin, Atendimento ignorar) {
        List<String> horariosLivres = new ArrayList<>();
        LocalTime horarioAnalise = LocalTime.of(8, 0);
        LocalTime fimDia = LocalTime.of(17, 0);
        LocalTime agora = LocalTime.now();

        while (horarioAnalise.isBefore(fimDia)) {
            if (data.equals(LocalDate.now()) && horarioAnalise.isBefore(agora)) {
                horarioAnalise = horarioAnalise.plusMinutes(30);
                continue;
            }
            boolean medicoLivre = vet.isHorarioDisponivel(data, horarioAnalise, duracaoMin, ignorar);
            boolean petLivre = pet.isHorarioDisponivel(data, horarioAnalise, duracaoMin, ignorar);

            if (medicoLivre && petLivre) {
                horariosLivres.add(horarioAnalise.toString());
            }
            horarioAnalise = horarioAnalise.plusMinutes(30);
        }
        return horariosLivres;
    }
    
    public static void excluir(Atendimento atendimento) throws Exception {
        remover(atendimento); 
    }
    
    public static ArrayList<Atendimento> getListaAtendimentos() {
        return listaAtendimentos;
    }
}