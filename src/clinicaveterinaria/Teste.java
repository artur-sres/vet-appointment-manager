/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaveterinaria;

import clinicaveterinaria.controller.AtendimentoController;
import clinicaveterinaria.controller.PetController;
import clinicaveterinaria.controller.TutorController;
import clinicaveterinaria.controller.VeterinarioController;
import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Procedimento;
import clinicaveterinaria.model.Enums.Sexo;
import clinicaveterinaria.model.MedVet;
import clinicaveterinaria.model.Tutor;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Artur
 */
public class Teste {
    public static void testeTutores(){
        TutorController.listaTutores.add(new Tutor(
            "Artur Rabelo", 
            "artur@gmail.com", 
            "(88) 98166-4707", 
            "Morada Nova- CE", 
            "08957033351"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Ilbsberg Sena", 
            "ilbs@gmail.com", 
            "(21) 94002-8922", 
            "Brawl Stars", 
            "23456789011"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Leticia Nascimento", 
            "leticia@gmail.com", 
            "(41) 99999-4321", 
            "Quixadá - CE", 
            "345.678.901-22"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Pedro Lucas Rabelo Lima", 
            "pedro@gmail.com", 
            "(71) 98888-9876", 
            "Fazenda do Carlinhos Maia", 
            "45678901233"
        ));
        TutorController.listaTutores.add(new Tutor(
            "Thalia Silva", 
            "thalia@gmail.com", 
            "(85) 99111-2222", 
            "Fortaleza - CE", 
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
            "Dr. Dilmara Nascimento",
            "deolane.vet@hotmail.com",
            "11988887777"
        ));
        VeterinarioController.listaVeterinarios.add(new MedVet(
            "Dr. Cecilia Nascimento",
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
                    "Não gosta muito de crianças",
                    false, 
                    true  
            ); 
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(1),
                    Especie.CACHORRO,
                    "Nino",
                    "SRD",
                    Sexo.MACHO,
                    "5.2",
                    LocalDate.of(2021, 2, 15),
                    "Nenhuma",
                    "Não gosta que façam carinho",
                    false,
                    true
            );
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(2),
                    Especie.GATO,
                    "Bigode",
                    "SRD",
                    Sexo.MACHO,
                    "3.0",
                    LocalDate.of(2023, 11, 20),
                    "Nenhuma",
                    "Muito manso",
                    true,
                    false
            );
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(2),
                    Especie.GATO,
                    "Lua",
                    "SRD",
                    Sexo.FEMEA,
                    "3.3",
                    LocalDate.of(2023, 11, 20),
                    "Nenhuma",
                    "Muito medrosa",
                    false,
                    true
            );
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(2),
                    Especie.CACHORRO,
                    "Sky",
                    "Pinscher",
                    Sexo.MACHO,
                    "3.6",
                    LocalDate.of(2017, 11, 20),
                    "Nenhuma",
                    "Não gosta de desconhecidos e late muito e morde",
                    false,
                    true
            );
            PetController.cadastrarPet(
                    TutorController.listaTutores.get(2),
                    Especie.CACHORRO,
                    "Sky",
                    "SRD",
                    Sexo.MACHO,
                    "8.6",
                    LocalDate.of(2017, 11, 20),
                    "Nenhuma",
                    "Muito energético e gosta de montar",
                    false,
                    true
            );
        } catch (Exception ex) {
            System.getLogger(Teste.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void testeAtendimentos() {
        try {
            if (PetController.listaPets.isEmpty() || VeterinarioController.listaVeterinarios.isEmpty()) {
                System.out.println("Não há pets ou veterinários suficientes para gerar atendimentos de teste.");
                return;
            }

            // Atendimento 1: Hoje às 10:00 - Lylica com Dr. Leticia
            Atendimento a1 = new Atendimento(
                    Procedimento.CONSULTA,
                    PetController.listaPets.get(0),          
                    VeterinarioController.listaVeterinarios.get(0), 
                    LocalDate.now(),                         
                    LocalTime.of(10, 0),                     
                    "Animal apresentando cansaço."
            );
            a1.setDuracaoMinutos(60);
            AtendimentoController.cadastrar(a1);

            Atendimento a2 = new Atendimento(
                Procedimento.VACINACAO,
                PetController.listaPets.get(1),          
                VeterinarioController.listaVeterinarios.get(1), 
                LocalDate.now(),             
                LocalTime.of(8, 0),
                "Reforço da vacina V4."
            );
            a2.setDuracaoMinutos(30);
            AtendimentoController.cadastrar(a2);
            
            Atendimento a3 = new Atendimento(
                Procedimento.CIRURGIA,
                PetController.listaPets.get(1),          
                VeterinarioController.listaVeterinarios.get(1), 
                LocalDate.now(),             
                LocalTime.of(15, 30),
                "Castração."
            );
            a3.setDuracaoMinutos(90);
            AtendimentoController.cadastrar(a3);
            
            Atendimento a4 = new Atendimento(
                Procedimento.CIRURGIA,
                PetController.listaPets.get(3),          
                VeterinarioController.listaVeterinarios.get(0), 
                LocalDate.now(),             
                LocalTime.of(15, 30),
                "Castração."
            );
            a4.setDuracaoMinutos(90);
            AtendimentoController.cadastrar(a4);

            Atendimento a5 = new Atendimento(
                Procedimento.EXAME,
                PetController.listaPets.get(2),          
                VeterinarioController.listaVeterinarios.get(2), 
                LocalDate.now(),             
                LocalTime.of(8, 0),
                "Raio-X."
            );
            a5.setDuracaoMinutos(30);
            AtendimentoController.cadastrar(a5);
            
        } catch (Exception e) {
            System.out.println("Erro ao gerar atendimentos: " + e.getMessage());
        }
    }
}
