package clinicaveterinaria.controller;
import clinicaveterinaria.model.Tutor;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;
import clinicaveterinaria.model.Pet;

/**
 * Classe que guarda os metódos responsáveis por cuidar da lógica dos Tutores
 * @author Artur
 */
public class TutorController {
    public static ArrayList<Tutor> listaTutores = new ArrayList<>();
    
    /**
     * Chama o construtor para Tutor e adiciona na listaTutores
     * @throws Exception 
     */
    public static void cadastrarTutor(String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        Tutor novoTutor = new Tutor(nome, email, telefone, endereco, cpf);
        listaTutores.add(novoTutor);
    }
    
    /**
     * Edita os dados de um Tutor já existente
     * @throws Exception Quando dados inválidos são inseridos
     */
    public static void editarTutor(Tutor tutor, String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        tutor.setNome(nome);
        tutor.setEmail(email);
        tutor.setTelefone(telefone);
        tutor.setEndereco(endereco);
        tutor.setCpf(cpf);
    }
    
    /**
     * Exclui um Tutor ja existente, e exclui todos os Pets vinculados a ele
     */
    public static void excluirTutor(Tutor tutor) {
        if (tutor == null) return;
        java.util.ArrayList<Pet> aux = new java.util.ArrayList<>(tutor.getAnimais());
        
        for (Pet pet : aux) {
            PetController.excluirPet(pet); 
        }

        listaTutores.remove(tutor);
        
        System.out.println("Tutor " + tutor.getNome() + " e seus animais foram excluídos!");
    }
}