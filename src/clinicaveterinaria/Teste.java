/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria;

import clinicaveterinaria.controller.PetController;
import clinicaveterinaria.controller.TutorController;
import clinicaveterinaria.controller.VeterinarioController;
import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Sexo;
import clinicaveterinaria.model.MedVet;
import clinicaveterinaria.model.Tutor;
import java.time.LocalDate;

/**
 *
 * @author Artur
 */
public class Teste {
    public static void testeTutores(){
        TutorController.listaTutores.add(new Tutor(
            "Artur Saraiva Rabelo", 
            "artur@gmail.com", 
            "(88) 98166-4707", 
            "Morada Nova- CE", 
            "08957033351"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Cícero Ilbsberg Nobre de Sena", 
            "fubuki25s@gmail.com", 
            "(21) 94002-8922", 
            "Brawl Stars", 
            "23456789011"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Leticia Nascimento", 
            "litiçaGnomia@gmail.com", 
            "(41) 99999-4321", 
            "Quixadá - CE", 
            "345.678.901-22"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Pedro Lucas Rabelo Lima", 
            "gay@gmail.com", 
            "(71) 98888-9876", 
            "Fazenda do Carlinhos Maia", 
            "45678901233"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Thalia Silva", 
            "lesbicaApaixonadaPorUmGay@gmail.com", 
            "(85) 99111-2222", 
            "Coitadolândia - Fortaleza", 
            "56789012344"
        ));
    }

    public static void testeVeterinarios(){
        VeterinarioController.listaVeterinarios.add(new MedVet(
            "Dr. Leticia Nascimento",
            "Leticia@gmail.com",
            "88940028922"
        ));
        VeterinarioController.listaVeterinarios.add(new MedVet(
            "Dr. Deolane",
            "deolane.vet@hotmail.com",
            "11988887777"
        ));
    }
    
    public static void testePets() {
        try {
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(0),
                    Especie.CACHORRO,
                    "Lylica",
                    "Maltês",
                    Sexo.MACHO,
                    "5.2",
                    LocalDate.of(2015, 5, 21),
                    "Nenhuma",
                    "Não gosta de crianças",
                    false, 
                    true  
            ); 
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(1),
                    Especie.GATO,
                    "Lua",
                    "SRD",
                    Sexo.FEMEA,
                    "2.2",
                    LocalDate.of(2021, 2, 15),
                    "Dipirona",
                    "Medrosa",
                    true,
                    false
            );
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(1),
                    Especie.GATO,
                    "Bigode",
                    "SRD",
                    Sexo.MACHO,
                    "15.0",
                    LocalDate.of(2018, 11, 20),
                    "Picada de Abelha",
                    "Calmo",
                    true,
                    false
            );
        } catch (Exception ex) {
            System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
