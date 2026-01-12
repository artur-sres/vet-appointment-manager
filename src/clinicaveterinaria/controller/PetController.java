package clinicaveterinaria.controller;

import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Sexo;
import clinicaveterinaria.model.Pet;
import clinicaveterinaria.model.Tutor;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.time.LocalDate;
import java.util.ArrayList;

public class PetController {
    public static ArrayList<Pet> listaPets = new ArrayList<>();
    
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
    }
   
    // Adicione este método na classe PetController
    public static void editarPet(Pet pet, Tutor novoTutor, clinicaveterinaria.model.Enums.Especie especie, String nome, String raca, clinicaveterinaria.model.Enums.Sexo sexo, String pesoTexto, java.time.LocalDate nascimento, String alergias, String temperamento, boolean vacinado, boolean castrado) throws Exception {
        validarDados(nome, raca, alergias, temperamento);

        double peso = 0.0;
        try {
            peso = Double.parseDouble(pesoTexto.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new Exception("O peso informado é inválido!");
        }

        // --- LÓGICA DE TROCA DE TUTOR (Resolve o Problema 2) ---
        // Verifica se há um novo tutor E se ele é diferente do atual
        if (novoTutor != null && pet.getTutor() != novoTutor) {
            System.out.println("Alterando tutor de " + pet.getTutor().getNome() + " para " + novoTutor.getNome());

            // 1. Remove o pet da lista do tutor ANTIGO
            pet.getTutor().getAnimais().remove(pet);

            // 2. Atualiza o tutor no objeto Pet (Esta linha é CRUCIAL)
            pet.setTutor(novoTutor);

            // 3. Adiciona o pet na lista do NOVO tutor
            novoTutor.adicionarPet(pet);
        }

        // --- ATUALIZAÇÃO DOS OUTROS DADOS ---
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
    }
    
    public static void excluirPet(Pet pet) {
        if (pet == null) return;

        // 1. Cancelar todos os agendamentos desse Pet (Libera horários dos Vets)
        // Criamos uma cópia da lista para não dar erro ao remover enquanto percorre
        java.util.ArrayList<Atendimento> copiahistorico = new java.util.ArrayList<>(pet.getHistorico());
        
        for (Atendimento agendamento : copiahistorico) {
            AtendimentoController.remover(agendamento);
        }

        // 2. Remover o Pet da lista do seu Tutor
        if (pet.getTutor() != null) {
            pet.getTutor().getAnimais().remove(pet);
        }

        // 3. Remover o Pet da lista geral do sistema
        listaPets.remove(pet);
        
        System.out.println("Pet " + pet.getNome() + " excluído com sucesso!");
    }
}

