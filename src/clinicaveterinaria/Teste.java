package clinicaveterinaria;

import clinicaveterinaria.controller.AtendimentoController;
import clinicaveterinaria.controller.*;
import clinicaveterinaria.model.*;
import clinicaveterinaria.model.Enums.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

/**
 * Classe que guarda os testes com dados ficticius para que o programa não inicie vazio
 * @author Artur
 */
public class Teste {
    public static void testeTutores() {

        TutorController.getListaTutores().add(new Tutor(
            "Gabriel Santos", 
            "gabriel.s@gmail.com", 
            "(11) 98765-4321", 
            "São Paulo - SP", 
            "123.456.789-00"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Artur Rabelo", 
            "artur@gmail.com", 
            "(88) 98166-4707", 
            "Morada Nova- CE", 
            "08957033351"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Mariana Costa", 
            "mari.costa@hotmail.com", 
            "(31) 99876-5432", 
            "Belo Horizonte - MG", 
            "234.567.890-12"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Ilbsberg Sena", 
            "ilbs@gmail.com", 
            "(21) 94002-8922", 
            "Brawl Stars", 
            "23456789011"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Rafael Souza", 
            "rafael.souza@outlook.com", 
            "(41) 91234-5678", 
            "Curitiba - PR", 
            "34567890123"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Leticia Nascimento", 
            "leticia@gmail.com", 
            "(41) 99999-4321", 
            "Quixadá - CE", 
            "345.678.901-22"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Beatriz Lima", 
            "bia.lima@gmail.com", 
            "(81) 98888-7777", 
            "Recife - PE", 
            "456.789.012-34"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Lucas Pereira", 
            "lucas.p@yahoo.com", 
            "(51) 97777-6666", 
            "Porto Alegre - RS", 
            "56789012345"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Pedro Lucas Rabelo Lima", 
            "pedro@gmail.com", 
            "(71) 98888-9876", 
            "Melancias - CE", 
            "45678901233"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Fernanda Oliveira", 
            "nanda.oli@gmail.com", 
            "(85) 99999-1111", 
            "Russas - CE", 
            "678.901.234-56"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Diego Martins", 
            "diego.m@uol.com.br", 
            "(61) 98111-2233", 
            "Brasília - DF", 
            "78901234567"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Thalia Silva", 
            "thalia@gmail.com", 
            "(85) 99111-2222", 
            "Fortaleza - CE", 
            "56789012344"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Camila Alves", 
            "camilinha@gmail.com", 
            "(71) 98222-3344", 
            "Salvador - BA", 
            "890.123.456-78"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Rodrigo Ferreira", 
            "rodrigo.f@gmail.com", 
            "(92) 99333-4455", 
            "Manaus - AM", 
            "90123456789"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Juliana Mendes", 
            "ju.mendes@hotmail.com", 
            "(48) 98444-5566", 
            "Florianópolis - SC", 
            "012.345.678-90"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Bruno Castro", 
            "bruno.c@gmail.com", 
            "(62) 99555-6677", 
            "Goiânia - GO", 
            "12345678901"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Vanessa Lopes", 
            "nessa.lopes@outlook.com", 
            "(27) 99666-7788", 
            "Vitória - ES", 
            "234.567.890-12"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Thiago Barbosa", 
            "thiago.barbosa@gmail.com", 
            "(84) 99777-8899", 
            "Natal - RN", 
            "34567890123"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Larissa Dias", 
            "lari.dias@yahoo.com", 
            "(65) 99888-9900", 
            "Cuiabá - MT", 
            "456.789.012-34"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Eduardo Rocha", 
            "edu.rocha@gmail.com", 
            "(82) 98123-4567", 
            "Maceió - AL", 
            "56789012345"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Sofia Azevedo", 
            "sofia.azevedo@gmail.com", 
            "(91) 98234-5678", 
            "Belém - PA", 
            "678.901.234-56"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Guilherme Pinto", 
            "gui.pinto@uol.com.br", 
            "(86) 98345-6789", 
            "Teresina - PI", 
            "78901234567"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Isabela Correia", 
            "isa.correia@gmail.com", 
            "(67) 98456-7890", 
            "Campo Grande - MS", 
            "890.123.456-78"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Renan Cardoso", 
            "renan.cardoso@hotmail.com", 
            "(83) 98567-8901", 
            "João Pessoa - PB", 
            "90123456789"
        ));
        TutorController.getListaTutores().add(new Tutor(
            "Aline Teixeira", 
            "aline.teixeira@gmail.com", 
            "(79) 98678-9012", 
            "Aracaju - SE", 
            "012.345.678-90"
        ));
    }

    public static void testeVeterinarios(){
        VeterinarioController.getListaVeterinarios().add(new MedVet(
            "Dr. Leticia Nascimento",
            "Leticia@gmail.com",
            "88940028922"
        ));
        VeterinarioController.getListaVeterinarios().add(new MedVet(
            "Dr. Dilmara Nascimento",
            "dilmara.vet@hotmail.com",
            "11988887777"
        ));
        VeterinarioController.getListaVeterinarios().add(new MedVet(
            "Dr. Cecilia Nascimento",
            "cecilia.vet@hotmail.com",
            "11988887777"
        ));
    }
    

    public static void testePets() {
        try {
            // --- PETS DOS TUTORES ORIGINAIS (Índices ajustados conforme a nova lista) ---

            // Tutor: Artur Rabelo (Agora no índice 1)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(1),
                Especie.CACHORRO, "Lylica", "Maltês", Sexo.MACHO, "5.2",
                LocalDate.of(2015, 5, 21), "Nenhuma", "Não gosta muito de crianças", false, true
            );

            // Tutor: Ilbsberg Sena (Agora no índice 3)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(3),
                Especie.CACHORRO, "Nino", "SRD", Sexo.MACHO, "5.2",
                LocalDate.of(2021, 2, 15), "Nenhuma", "Não gosta que façam carinho", false, true
            );

            // Tutor: Leticia Nascimento (Agora no índice 5) - Tem 3 pets
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(5),
                Especie.GATO, "Bigode", "SRD", Sexo.MACHO, "3.0",
                LocalDate.of(2023, 11, 20), "Nenhuma", "Muito manso", true, false
            );
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(5),
                Especie.GATO, "Lua", "SRD", Sexo.FEMEA, "3.3",
                LocalDate.of(2023, 11, 20), "Nenhuma", "Muito medrosa", false, true
            );
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(5),
                Especie.CACHORRO, "Sky", "Pinscher", Sexo.MACHO, "3.6",
                LocalDate.of(2017, 11, 20), "Nenhuma", "Late muito e morde", false, true
            );

            // Tutor: Pedro Lucas (Agora no índice 8)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(8),
                Especie.CACHORRO, "Rex", "Pastor Alemão", Sexo.MACHO, "35.0",
                LocalDate.of(2019, 8, 10), "Ração com corante", "Cão de guarda", true, true
            );

            // Tutor: Thalia Silva (Agora no índice 11)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(11),
                Especie.GATO, "Mingau", "Siamês", Sexo.MACHO, "4.0",
                LocalDate.of(2020, 1, 5), "Nenhuma", "Dorme o dia todo", true, true
            );

            // --- PETS DOS NOVOS TUTORES ---

            // Tutor: Gabriel Santos (0)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(0),
                Especie.CACHORRO, "Thor", "Golden Retriever", Sexo.MACHO, "28.5",
                LocalDate.of(2018, 6, 15), "Poeira", "Muito brincalhão", true, true
            );

            // Tutor: Mariana Costa (2)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(2),
                Especie.GATO, "Luna", "Persa", Sexo.FEMEA, "3.8",
                LocalDate.of(2021, 3, 10), "Nenhuma", "Exige escovação diária", false, true
            );

            // Tutor: Rafael Souza (4)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(4),
                Especie.CACHORRO, "Paçoca", "Vira lata", Sexo.MACHO, "12.0",
                LocalDate.of(2016, 9, 22), "Nenhuma", "Come chinelos", true, true
            );

            // Tutor: Beatriz Lima (6)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(6),
                Especie.CACHORRO, "Mel", "Shih Tzu", Sexo.FEMEA, "6.5",
                LocalDate.of(2022, 12, 01), "Nenhuma", "Adora colo", false, false
            );
            // Beatriz tem dois
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(6),
                Especie.CACHORRO, "Amora", "Shih Tzu", Sexo.FEMEA, "6.0",
                LocalDate.of(2023, 01, 15), "Nenhuma", "Irmã da Mel", false, false
            );

            // Tutor: Lucas Pereira (7)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(7),
                Especie.GATO, "Garfield", "Exótico", Sexo.MACHO, "6.0",
                LocalDate.of(2019, 5, 30), "Nenhuma", "Gosta de lasanha", true, true
            );

            // Tutor: Fernanda Oliveira (9)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(9),
                Especie.CACHORRO, "Belinha", "Poodle", Sexo.FEMEA, "7.2",
                LocalDate.of(2014, 4, 20), "Nenhuma", "Idosa e cega de um olho", true, true
            );

            // Tutor: Diego Martins (10)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(10),
                Especie.CACHORRO, "Hulk", "Pitbull", Sexo.MACHO, "32.0",
                LocalDate.of(2020, 10, 10), "Picada de abelha", "Dócil com família", true, true
            );

            // Tutor: Camila Alves (12)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(12),
                Especie.GATO, "Fumaça", "Cinza", Sexo.MACHO, "5.0",
                LocalDate.of(2018, 2, 28), "Nenhuma", "Escalador", true, true
            );

            // Tutor: Rodrigo Ferreira (13)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(13),
                Especie.CACHORRO, "Bob", "Labrador", Sexo.MACHO, "30.0",
                LocalDate.of(2017, 7, 07), "Carne de porco", "Ama nadar", true, true
            );

            // Tutor: Juliana Mendes (14)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(14),
                Especie.CACHORRO, "Fred", "Pug", Sexo.MACHO, "9.0",
                LocalDate.of(2021, 8, 14), "Problemas respiratórios", "Ronca muito", false, true
            );

            // Tutor: Bruno Castro (15)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(15),
                Especie.GATO, "Tom", "SRD", Sexo.MACHO, "4.2",
                LocalDate.of(2022, 6, 12), "Nenhuma", "Caçador de ratos", true, false
            );

            // Tutor: Vanessa Lopes (16)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(16),
                Especie.CACHORRO, "Lola", "Bulldog Francês", Sexo.FEMEA, "11.5",
                LocalDate.of(2019, 11, 03), "Gramíneas", "Teimosa", true, true
            );

            // Tutor: Thiago Barbosa (17)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(17),
                Especie.CACHORRO, "Tobby", "Beagle", Sexo.MACHO, "13.0",
                LocalDate.of(2020, 4, 01), "Nenhuma", "Uiva quando sozinho", true, true
            );

            // Tutor: Larissa Dias (18)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(18),
                Especie.GATO, "Salem", "Preto", Sexo.MACHO, "4.5",
                LocalDate.of(2021, 10, 31), "Nenhuma", "Gato da bruxa", true, true
            );

            // Tutor: Eduardo Rocha (19)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(19),
                Especie.CACHORRO, "Max", "Border Collie", Sexo.MACHO, "18.0",
                LocalDate.of(2022, 1, 20), "Nenhuma", "Hiperativo", false, true
            );

            // Tutor: Sofia Azevedo (20)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(20),
                Especie.CACHORRO, "Kiara", "Chow Chow", Sexo.FEMEA, "22.0",
                LocalDate.of(2018, 9, 15), "Nenhuma", "Língua azul", true, true
            );

            // Tutor: Guilherme Pinto (21)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(21),
                Especie.CACHORRO, "Zeus", "Rottweiler", Sexo.MACHO, "40.0",
                LocalDate.of(2017, 3, 10), "Nenhuma", "Gigante gentil", true, true
            );

            // Tutor: Isabela Correia (22)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(22),
                Especie.GATO, "Marie", "Angorá", Sexo.FEMEA, "3.5",
                LocalDate.of(2023, 2, 14), "Nenhuma", "Muito peluda", false, false
            );

            // Tutor: Renan Cardoso (23)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(23),
                Especie.CACHORRO, "Bolt", "Husky Siberiano", Sexo.MACHO, "25.0",
                LocalDate.of(2020, 12, 25), "Calor excessivo", "Gosta de fugir", true, true
            );

            // Tutor: Aline Teixeira (24)
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(24),
                Especie.CACHORRO, "Kika", "Chihuahua", Sexo.FEMEA, "2.5",
                LocalDate.of(2021, 6, 06), "Nenhuma", "Tremedeira constante", false, true
            );

            // --- EXTRAS PARA FECHAR 30 ---
            PetController.cadastrarPet(
                TutorController.getListaTutores().get(0), // Gabriel ganha mais um
                Especie.GATO, "Mochi", "Siamês", Sexo.MACHO, "3.9",
                LocalDate.of(2024, 1, 10), "Nenhuma", "Filhote novo", false, false
            );

            PetController.cadastrarPet(
                TutorController.getListaTutores().get(24), // Aline ganha mais um
                Especie.CACHORRO, "Billy", "Yorkshire", Sexo.MACHO, "3.0",
                LocalDate.of(2019, 5, 20), "Nenhuma", "Usa lacinho", true, true
            );

        } catch (Exception ex) {
            System.getLogger("TestePets").log(System.Logger.Level.ERROR, "Erro ao cadastrar pets de teste", ex);
        }
    }

    public static void testeAtendimentos() {
        try {
            if (PetController.getListaPets().isEmpty() || VeterinarioController.getListaVeterinarios().isEmpty()) {
                System.out.println("ERRO: Cadastre Pets e Veterinários primeiro!");
                return;
            }

            Random random = new Random();

            // Define o intervalo de datas: 10/01/2026 a 30/01/2026
            LocalDate dataInicio = LocalDate.of(2026, 1, 10);
            LocalDate dataFim = LocalDate.of(2026, 1, 30);

            // Arrays auxiliares para dar variedade nas descrições
            String[] descricoesSimples = {"Check-up de rotina", "Vacina anual", "Aplicação de remédio", "Retorno"};
            String[] descricoesMedias = {"Animal vomitando", "Coceira intensa", "Dor na pata", "Não está comendo", "Exame de sangue"};
            String[] descricoesComplexas = {"Castração", "Cirurgia ortopédica", "Limpeza de tártaro", "Sutura de ferimento"};

            // Loop percorrendo dia por dia
            for (LocalDate data = dataInicio; !data.isAfter(dataFim); data = data.plusDays(1)) {

                // Lógica para determinar quantos atendimentos teremos no dia
                int qtdAtendimentosHoje;

                // Verifica se está no intervalo crítico (dia 19 ao 28)
                boolean periodoCritico = !data.isBefore(LocalDate.of(2026, 1, 19)) && 
                                         !data.isAfter(LocalDate.of(2026, 1, 28));

                if (periodoCritico) {
                    // Entre dia 19 e 28: Gera entre 5 e 8 atendimentos (Garante o mínimo de 5)
                    qtdAtendimentosHoje = 5 + random.nextInt(4); 
                } else {
                    // Nos outros dias: Gera entre 2 e 4 atendimentos
                    qtdAtendimentosHoje = 2 + random.nextInt(3);
                }

                // Gera os agendamentos do dia
                for (int i = 0; i < qtdAtendimentosHoje; i++) {

                    // Escolhe aleatoriamente um Pet e um Veterinário das listas
                    var pet = PetController.getListaPets().get(random.nextInt(PetController.getListaPets().size()));
                    var vet = VeterinarioController.getListaVeterinarios().get(random.nextInt(VeterinarioController.getListaVeterinarios().size()));

                    // Define horário aleatório entre 08:00 e 17:00
                    LocalTime hora = LocalTime.of(8 + random.nextInt(10), random.nextBoolean() ? 0 : 30);

                    // Define o tipo de procedimento e duração aleatoriamente para variar
                    Procedimento proc;
                    String descricao;
                    int duracao;

                    int tipoSorteio = random.nextInt(100); // Sorteio percentual

                    if (tipoSorteio < 40) { // 40% de chance ser Consulta
                        proc = Procedimento.CONSULTA;
                        descricao = descricoesMedias[random.nextInt(descricoesMedias.length)];
                        duracao = 30 + random.nextInt(31); // 30 a 60 min
                    } else if (tipoSorteio < 70) { // 30% de chance ser Vacina/Exame
                        proc = random.nextBoolean() ? Procedimento.VACINACAO : Procedimento.EXAME;
                        descricao = descricoesSimples[random.nextInt(descricoesSimples.length)];
                        duracao = 20; 
                    } else { // 30% de chance ser Cirurgia
                        proc = Procedimento.CIRURGIA;
                        descricao = descricoesComplexas[random.nextInt(descricoesComplexas.length)];
                        duracao = 60 + random.nextInt(61); // 60 a 120 min
                    }

                    // Cria e cadastra
                    Atendimento atendimento = new Atendimento(
                        proc, pet, vet, data, hora, descricao
                    );
                    atendimento.setDuracaoMinutos(duracao);

                    // Aqui seria bom ter uma validação se o vet já não está ocupado nesse horário
                    // Mas para massa de dados bruta, vamos forçar o cadastro:
                    AtendimentoController.cadastrar(atendimento);
                }
            }

            System.out.println("Massa de dados de Atendimentos gerada com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao gerar atendimentos em massa: " + e.getMessage());
        }
    }
}
