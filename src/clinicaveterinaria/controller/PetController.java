package clinicaveterinaria.controller;

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
    public static void editarPet(Pet pet, Tutor novoTutor, Especie especie, String nome, String raca, Sexo sexo, String pesoTexto, LocalDate nascimento, String alergias, String temperamento, boolean vacinado, boolean castrado) throws Exception {
        // Validações básicas
        validarDados(nome, raca, alergias, temperamento);

        double peso = 0.0;
        try {
            peso = Double.parseDouble(pesoTexto.replace(",", "."));
        } catch (NumberFormatException e) {
            throw new Exception("O peso informado é inválido!");
        }

        // Atualiza os dados do objeto Pet
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

        // Lógica para Troca de Tutor (se o tutor selecionado for diferente do atual)
        if (novoTutor != null && !pet.getTutor().equals(novoTutor)) {
            // Remove o pet da lista do tutor antigo
            pet.getTutor().getAnimais().remove(pet);
            
            // Define o novo tutor e adiciona o pet na lista dele
            pet.setTutor(novoTutor);
            novoTutor.adicionarPet(pet);
        }
    }
}

