package clinicaveterinaria.controller;

import clinicaveterinaria.model.MedVet;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;

/**
 * Classe que guarda os metódos responsáveis por cuidar da lógica dos MedVet
 * @author Artur
 */
public class VeterinarioController {
    private static ArrayList<MedVet> listaVeterinarios = new ArrayList<>();
    
    /**
     * Chama o construtor para MedVet e adiciona na listaVeterinarios
     * @throws Exception 
     */
    public static void cadastrarVeterinario(String nome, String email, String telefone) throws Exception{
        validarDados(nome, email, telefone);
        MedVet novoVeterinario = new MedVet(nome, email, telefone);
        listaVeterinarios.add(novoVeterinario);
    }
    
    /**
     * Edita os dados de um MedVet já existente
     * @throws Exception Quando dados inválidos são inseridos
     */
    public static void editarVeterinario(MedVet veterinario, String nome, String email, String telefone)throws Exception{
        validarDados(nome, email, telefone);
        veterinario.setNome(nome);
        veterinario.setEmail(email);
        veterinario.setTelefone(telefone);
        
    }

    public static ArrayList<MedVet> getListaVeterinarios() {
        return listaVeterinarios;
    }
    
    
}
