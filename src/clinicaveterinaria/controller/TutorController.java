package clinicaveterinaria.controller;
import clinicaveterinaria.model.Tutor;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;
import clinicaveterinaria.model.Pet;

// Classe que guarda toda a lógica que gerencia os tutores
// Metódos possuem nomes autoexplicativos
public class TutorController {
    private static final ArrayList<Tutor> listaTutores = new ArrayList<>();
    
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
    
    // Ao excluír um tutor, todos os pets vínculados a ele também são apagados da memória
    public static void excluirTutor(Tutor tutor) {
        if (tutor == null) return;
        java.util.ArrayList<Pet> aux = new ArrayList<>(tutor.getAnimais());
        
        for (Pet pet : aux) {
            PetController.excluirPet(pet); 
        }

        listaTutores.remove(tutor);
    }

    public static ArrayList<Tutor> getListaTutores() {
        return listaTutores;
    }
    
    
}