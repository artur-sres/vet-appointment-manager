package clinicaveterinaria.controller;

import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.model.Pet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Classe que guarda toda a lógica que gerencia os atendimentos
// Metódos possuem nomes autoexplicativos
public class AtendimentoController {
    private static final ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();

    public static void cadastrar(Atendimento novoAtendimento) {
        listaAtendimentos.add(novoAtendimento);

        novoAtendimento.getPetAtendido().getHistorico().add(novoAtendimento);
        novoAtendimento.getVetResponsavel().getAgendaConsultas().add(novoAtendimento);
    }
    
    public static void remover(Atendimento atendimento) {
        if (atendimento == null) {
            return;
        }

        if (atendimento.getPetAtendido() != null) {
            atendimento.getPetAtendido().getHistorico().remove(atendimento);
        }    
        
        if (atendimento.getVetResponsavel() != null) {
            atendimento.getVetResponsavel().getAgendaConsultas().remove(atendimento);
        }
        
        listaAtendimentos.remove(atendimento);
    }

    public static List<Atendimento> getAtendimentosDoDia() {
        List<Atendimento> agendaDia = new ArrayList<>();
        LocalDate dia = LocalDate.now();

        for (Atendimento a : listaAtendimentos) {
            if (a.getData().equals(dia)) {
                agendaDia.add(a);
            }
        }
        
        // Ordena a lista: Para cada objeto Atendimento da lista ele pega a hora e coloca na posição correta
        Collections.sort(agendaDia, Comparator.comparing(Atendimento::getHora));

        return agendaDia;
    }
    
    // Esse metódo retorna uma lista de horários disponívies para agendar atendimentos
    // Verifica se não conflita com outros horários já agendados para Veterinários ou para Pets
    public static List<String> buscarHorariosDisponiveis(Veterinario vet, Pet pet, LocalDate data, int duracaoMin, Atendimento ignorar) {
        List<String> horariosLivres = new ArrayList<>();
        
        LocalTime horarioAnalise = LocalTime.of(8, 0);
        LocalTime fimDia = LocalTime.of(17, 0);
        LocalTime agora = LocalTime.now();

        while (horarioAnalise.isBefore(fimDia)) {
            // Não mostrar horários passados se for o dia atual
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
    
    public static void excluir(Atendimento atendimento) {
        if (atendimento == null) return;

        // Remove das listas individuais
        if (atendimento.getVetResponsavel() != null) {
            atendimento.getVetResponsavel().getAgendaConsultas().remove(atendimento);
        }
        if (atendimento.getPetAtendido() != null) {
            atendimento.getPetAtendido().getHistorico().remove(atendimento);
        }

        // Remove da lista geral
        listaAtendimentos.remove(atendimento);
    }
    
    //Getters e Setters 
    public static ArrayList<Atendimento> getListaAtendimentos() {
        return listaAtendimentos;
    }
    
    
}