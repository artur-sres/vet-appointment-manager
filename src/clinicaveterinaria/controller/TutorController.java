package clinicaveterinaria.controller;
import clinicaveterinaria.model.Tutor;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;
    import clinicaveterinaria.model.Pet;

public class TutorController {
    public static ArrayList<Tutor> listaTutores = new ArrayList<>();
    
    public static void cadastrarTutor(String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        Tutor novoTutor = new Tutor(nome, email, telefone, endereco, cpf);
        listaTutores.add(novoTutor);
    }
    
    public static void editarTutor(Tutor tutor, String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        tutor.setNome(nome);
        tutor.setEmail(email);
        tutor.setTelefone(telefone);
        tutor.setEndereco(endereco);
        tutor.setCpf(cpf);
    }
    
    // Adicione esta importação


    // Adicione este método na classe TutorController
    public static void excluirTutor(Tutor tutor) {
        if (tutor == null) return;

        // 1. Excluir todos os Pets desse Tutor
        // (Usamos cópia da lista para evitar erros de modificação simultânea)
        java.util.ArrayList<Pet> copiaPets = new java.util.ArrayList<>(tutor.getAnimais());
        
        for (Pet pet : copiaPets) {
            PetController.excluirPet(pet); // Chama o método que criamos acima
        }

        // 2. Remover o Tutor da lista geral
        listaTutores.remove(tutor);
        
        System.out.println("Tutor " + tutor.getNome() + " e seus animais foram excluídos!");
    }
}