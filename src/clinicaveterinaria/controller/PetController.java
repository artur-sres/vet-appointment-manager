package clinicaveterinaria.controller;

import clinicaveterinaria.model.Enums.*;
import clinicaveterinaria.model.*;
import static clinicaveterinaria.util.ValidarDados.*;
import java.time.LocalDate;
import java.util.ArrayList;

// Classe com guarda toda a lógica responsável por gerenciar os pets
// Metódos possuem nomes autoexplicativos
public class PetController {
    private static final ArrayList<Pet> listaPets = new ArrayList<>();
    
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
    }
    
    public static void excluirPet(Pet pet) {
        if (pet == null) {
            return;
        }
        
        // Cancelar todos os agendamentos desse Pet
        // Cria uma cópia da lista para não dar erro ao remover enquanto percorre
        java.util.ArrayList<Atendimento> aux = new java.util.ArrayList<>(pet.getHistorico());
        
        for (Atendimento agendamento : aux) {
            AtendimentoController.remover(agendamento);
        }

        if (pet.getTutor() != null) {
            pet.getTutor().getAnimais().remove(pet);
        }
        
        listaPets.remove(pet);
    }

    public static ArrayList<Pet> getListaPets() {
        return listaPets;
    }
    
    
}

