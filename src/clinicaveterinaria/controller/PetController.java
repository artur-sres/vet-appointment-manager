package clinicaveterinaria.controller;

import clinicaveterinaria.model.Enums.*;
import clinicaveterinaria.model.*;
import static clinicaveterinaria.util.ValidarDados.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

// Classe com guarda toda a lógica responsável por gerenciar os pets
// Metódos possuem nomes autoexplicativos
public class PetController {
    private static final ArrayList<Pet> listaPets = new ArrayList<>();
    private static final String ARQUIVO_PETS = "pets.txt";
    
    public static void cadastrarPet(Tutor tutor, Especie especie, String nome, String raca, Sexo sexo, String pesoTexto, LocalDate nascimento, String alergias, String temperamento, boolean vacinado, boolean castrado) throws Exception{
        validarDados(nome, raca, alergias, temperamento);
        
        double peso = 0.0;
        try {
            peso = Double.parseDouble(pesoTexto.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new Exception("O peso informado é inválido!");
        }
        
        Pet novoPet = new Pet(especie, nome, nascimento, Sexo.MACHO, castrado, vacinado, peso, temperamento, raca, alergias, tutor);
        tutor.adicionarPet(novoPet);
        listaPets.add(novoPet);
        
        salvarDados();
    }
   
    public static void editarPet(Pet pet, Tutor novoTutor, clinicaveterinaria.model.Enums.Especie especie, String nome, String raca, clinicaveterinaria.model.Enums.Sexo sexo, String pesoTexto, java.time.LocalDate nascimento, String alergias, String temperamento, boolean vacinado, boolean castrado) throws Exception {
        validarDados(nome, raca, alergias, temperamento);

        double peso = 0.0;
        try {
            peso = Double.parseDouble(pesoTexto.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new Exception("O peso informado é inválido!");
        }

        // Troca de tutor
        if (novoTutor != null && pet.getTutor() != novoTutor) {
            pet.getTutor().getAnimais().remove(pet);
            pet.setTutor(novoTutor);
            novoTutor.adicionarPet(pet);
        }

        pet.setEspecie(especie);
        pet.setNome(nome);
        pet.setRaca(raca);
        pet.setSexo(sexo);
        pet.setPeso(peso);
        pet.setDataNascimento(nascimento);
        pet.setAlergias(alergias);
        pet.setTemperamento(temperamento);
        pet.setIsVacinado(vacinado);
        pet.setIsCastrado(castrado);
        
        salvarDados();
    }
    
    public static void excluirPet(Pet pet) throws Exception{
        if (pet == null) {
            return;
        }
        
        // Cancelar todos os agendamentos desse Pet
        java.util.ArrayList<Atendimento> aux = new java.util.ArrayList<>(pet.getHistorico());
        
        for (Atendimento agendamento : aux) {
            AtendimentoController.remover(agendamento);
        }

        if (pet.getTutor() != null) {
            pet.getTutor().getAnimais().remove(pet);
        }
        
        listaPets.remove(pet);
        
        salvarDados();
    }
    
    public static void salvarDados() throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_PETS))) {
            for (Pet pet : listaPets) {
                // Formato corrigido usando .name() para os Enums
                String linha = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s",
                        pet.getTutor().getCPF(), 
                        pet.getNome(),
                        pet.getEspecie().name(), 
                        pet.getRaca(),
                        pet.getSexo().name(), 
                        pet.getPeso(),
                        pet.getDataNascimento(),
                        pet.getAlergias(),
                        pet.getTemperamento(),
                        pet.getIsVacinado(),
                        pet.getIsCastrado()
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (Exception e) {
            throw new Exception ("Não foi possivel salvar os dados");
        }
    }

    public static void carregarDados() throws Exception {
        File arquivo = new File(ARQUIVO_PETS);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo)))  {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados.length >= 11) {
                    String cpfTutor = dados[0];

                    Tutor tutor = encontrarTutorPorCpf(cpfTutor);

                    if (tutor != null) {
                        String nome = dados[1];
                        Especie especie = Especie.valueOf(dados[2]);
                        String raca = dados[3];
                        Sexo sexo = Sexo.valueOf(dados[4]);
                        double peso = Double.parseDouble(dados[5]);
                        LocalDate nascimento = LocalDate.parse(dados[6]);
                        String alergias = dados[7];
                        String temperamento = dados[8];
                        boolean vacinado = Boolean.parseBoolean(dados[9]);
                        boolean castrado = Boolean.parseBoolean(dados[10]);


                        Pet pet = new Pet(especie, nome, nascimento, sexo, castrado, vacinado, peso, temperamento, raca, alergias, tutor);

                        listaPets.add(pet);
                        tutor.adicionarPet(pet); 
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception ("Não foi possivel carregar os dados");
        }
    }

    // Método auxiliar para buscar o Tutor na lista do TutorController
    private static Tutor encontrarTutorPorCpf(String cpf) {
        for (Tutor t : TutorController.getListaTutores()) {
            if (t.getCPF().equals(cpf)) {
                return t;
            }
        }
        return null;
    }

    public static ArrayList<Pet> getListaPets() {
        return listaPets;
    }
 
}

