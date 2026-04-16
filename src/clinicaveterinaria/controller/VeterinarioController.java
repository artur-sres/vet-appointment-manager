package clinicaveterinaria.controller;

import clinicaveterinaria.model.Veterinario;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;
import java.io.*;

// Classe que guarda toda a lógica que gerencia os veterinários
// Metódos possuem nomes autoexplicativos
public class VeterinarioController {
    private static final ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    private static final String ARQUIVO_VETERINARIOS = "database/veterinarios.txt";
    
    public static void cadastrarVeterinario(String nome, String email, String telefone) throws Exception{
        validarDados(nome, email, telefone);
        Veterinario novoVeterinario = new Veterinario(nome, email, telefone);
        listaVeterinarios.add(novoVeterinario);
        
        salvarDados();
    }
    
    public static void editarVeterinario(Veterinario veterinario, String nome, String email, String telefone)throws Exception{
        validarDados(nome, email, telefone);
        veterinario.setNome(nome);
        veterinario.setEmail(email);
        veterinario.setTelefone(telefone);
        
        salvarDados();
    }
    
    public static void salvarDados() throws Exception{File arquivo = new File(ARQUIVO_VETERINARIOS);
        File diretorio = arquivo.getParentFile(); 
        
        if (diretorio != null && !diretorio.exists()) {
            diretorio.mkdirs(); 
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Veterinario vet : listaVeterinarios) {
                String linha = String.format("%s;%s;%s;%s",
                        vet.getNome(),
                        vet.getEmail(),
                        vet.getTelefone(),
                        vet.isAtivo()
                );
                writer.write(linha);
                writer.newLine();
            }
        } catch (Exception e) {
            throw new Exception ("Não foi possivel salvar os dados");
        }
    }

    public static void carregarDados() throws Exception{
        File arquivo = new File(ARQUIVO_VETERINARIOS);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados.length >= 4) {
                    String nome = dados[0];
                    String email = dados[1];
                    String telefone = dados[2];
                    boolean ativo = Boolean.parseBoolean(dados[3]);

                    Veterinario vet = new Veterinario(nome, email, telefone);
                    vet.setAtivo(ativo); 
                    
                    listaVeterinarios.add(vet);
                }
            }
        } catch (Exception e) {
            throw new Exception ("Não foi possivel carregar os dados");
        }
    }

    public static ArrayList<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }
    
    
}
