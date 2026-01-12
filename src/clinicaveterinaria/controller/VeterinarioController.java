/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria.controller;

import clinicaveterinaria.model.MedVet;
import static clinicaveterinaria.util.ValidarDados.validarDados;
import java.util.ArrayList;

/**
 *
 * @author Artur
 */
public class VeterinarioController {
    public static ArrayList<MedVet> listaVeterinarios = new ArrayList<>();
    
    public static void cadastrarVeterinario(String nome, String email, String telefone) throws Exception{
        validarDados(nome, email, telefone);
        MedVet novoVeterinario = new MedVet(nome, email, telefone);
        listaVeterinarios.add(novoVeterinario);
    }
    
    public static void editarVeterinario(MedVet veterinario, String nome, String email, String telefone)throws Exception{
        validarDados(nome, email, telefone);
        veterinario.setNome(nome);
        veterinario.setEmail(email);
        veterinario.setTelefone(telefone);
        
    }
    
}
