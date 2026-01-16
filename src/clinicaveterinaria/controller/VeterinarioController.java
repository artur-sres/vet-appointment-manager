package clinicaveterinaria.controller;

import clinicaveterinaria.model.Veterinario;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;

// Classe que guarda toda a lógica que gerencia os veterinários
// Metódos possuem nomes autoexplicativos
public class VeterinarioController {
    private static final ArrayList<Veterinario> listaVeterinarios = new ArrayList<>();
    
    public static void cadastrarVeterinario(String nome, String email, String telefone) throws Exception{
        validarDados(nome, email, telefone);
        Veterinario novoVeterinario = new Veterinario(nome, email, telefone);
        listaVeterinarios.add(novoVeterinario);
    }
    
    public static void editarVeterinario(Veterinario veterinario, String nome, String email, String telefone)throws Exception{
        validarDados(nome, email, telefone);
        veterinario.setNome(nome);
        veterinario.setEmail(email);
        veterinario.setTelefone(telefone);
        
    }

    public static ArrayList<Veterinario> getListaVeterinarios() {
        return listaVeterinarios;
    }
    
    
}
