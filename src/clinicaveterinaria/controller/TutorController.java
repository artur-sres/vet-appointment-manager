package clinicaveterinaria.controller;
import clinicaveterinaria.model.Tutor;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;
import clinicaveterinaria.model.Pet;
import java.io.*;

// Classe que guarda toda a lógica que gerencia os tutores
// Metódos possuem nomes autoexplicativos
public class TutorController {
    private static final ArrayList<Tutor> listaTutores = new ArrayList<>();
    private static final String ARQUIVO_DADOS = "tutores.txt";
    
    public static void cadastrarTutor(String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        Tutor novoTutor = new Tutor(nome, email, telefone, endereco, cpf);
        listaTutores.add(novoTutor);
        salvarDados();
    }
   
    public static void editarTutor(Tutor tutor, String nome, String email, String telefone, String endereco, String cpf)throws Exception{
        validarDados(nome, email, telefone, endereco, cpf);
        tutor.setNome(nome);
        tutor.setEmail(email);
        tutor.setTelefone(telefone);
        tutor.setEndereco(endereco);
        tutor.setCpf(cpf);
        salvarDados();
    }
    
    // Ao excluír um tutor, todos os pets vínculados a ele também são apagados da memória
    public static void excluirTutor(Tutor tutor) throws Exception{
        if (tutor == null) return;
        java.util.ArrayList<Pet> aux = new ArrayList<>(tutor.getAnimais());
        
        for (Pet pet : aux) {
            PetController.excluirPet(pet); 
        }

        listaTutores.remove(tutor);
        salvarDados();
    }

    public static ArrayList<Tutor> getListaTutores() {
        return listaTutores;
    }
    
    public static void salvarDados () throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_DADOS))) {
            for (Tutor tutor : listaTutores) {
                String linha = String.format("%s;%s;%s;%s;%s",
                        tutor.getNome(),      
                        tutor.getEmail(),     
                        tutor.getTelefone(),  
                        tutor.getEndereco(),  
                        tutor.getCPF()        
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Não foi possivel salvar os dados");
        }
    }
    
    public static void carregarDados() throws Exception {
        File arquivo = new File(ARQUIVO_DADOS);
        if (!arquivo.exists()) {
            return; 
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";"); 
                if (dados.length == 5) {
                    Tutor tutor = new Tutor(dados[0], dados[1], dados[2], dados[3], dados[4]);
                    listaTutores.add(tutor);
                }
            }
        } catch (IOException e) {
            throw new Exception ("Não foi possivel carregar os dados");
        }
    }
}