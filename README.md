# Sistema de Clínica Veterinária

![Java](https://img.shields.io/badge/Java-orange?logo=java&logoColor=white)
![UFC](https://img.shields.io/badge/Universidade%20Federal%20do%20Cear%C3%A1-blue)
![Programação Orientada a Objetos](https://img.shields.io/badge/Programação%20Orientada%20a%20Objetos-orange)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

## Sobre o Projeto

O projeto foi o trabalho final para a disciplina de Programação Orientada a Objetos, ministrada pelo Prof. Dr. Mayrton Dias de Queiroz.

O projeto tem como objetivo simular o dia a dia de uma clínica, permitindo o gerenciamento completo de tutores, animais (pets) e veterinários, além do agendamento de atendimentos.

## Funcionalidades Principais

O sistema conta com uma interface gráfica amigável desenvolvida em Swing, oferecendo as seguintes funcionalidades através de um menu principal:

* **Gestão de Cadastros:**
    * **Tutores:** Cadastro completo com dados pessoais (Nome, CPF, Endereço, Telefone) e associação com seus animais.
    * **Pets:** Registro detalhado dos animais (Nome, Espécie, Raça, Idade, Histórico Médico).
    * **Veterinários:** Cadastro da equipe médica da clínica.

* **Gerenciamento e Listagem:**
    * Visualização de listas completas de tutores, pets e veterinários cadastrados.
    * Funcionalidades de **Atualização** e **Remoção** de registros existentes.

* **Agendamentos (Agenda do Dia):**
    * Agendamento de **Atendimentos**.
    * Visualização rápida da agenda do dia na tela inicial.

## Estrutura do Projeto

O código segue o padrão de projeto MVC para melhor organização e escalabilidade:

* **`src/clinicaveterinaria/Main.java`**: Classe principal que inicializa a aplicação e carrega o Menu.
* **`view`**: Contém todas as telas da interface gráfica (`Menu`, `CadastrarTutor`, `CadastrarPet`, `ListaGerenciar...`).
* **`model`**: Classes que representam as entidades do negócio (`Pet`, `Tutor`, `Veterinario`, `Consulta`). Utiliza conceitos de POO como herança (ex: `Tutor` e `Veterinario` herdando de `Pessoa`).
* **`controller`**: Classes responsáveis pela lógica de controle e comunicação entre a interface e os modelos (`PetController`, `TutorController`, etc.).
* **`util`**: Classes utilitárias para validação de dados e formatação.

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Interface Gráfica:** Java Swing
* **IDE Recomendada:** NetBeans
* **Bibliotecas Externas:**
    * **[Caelum Stella Core](https://github.com/caelum/caelum-stella)** (`caelum-stella-core-2.2.2.jar`): Utilizada para validação robusta de CPFs brasileiros.
    * **[Commons Validator](https://commons.apache.org/proper/commons-validator/)** (`commons-validator-1.10.1.jar`): Utilizada para validação segura de formatos de e-mail.

## Como Executar

1.  Certifique-se de ter o Java (JDK) instalado em sua máquina.
2.  Clone este repositório.
3.  Compile o projeto através de sua IDE de preferência ou via linha de comando.
4.  Execute a classe principal:
    <br></br>
    ```bash
    java -cp bin clinicaveterinaria.Main
    ```
    
## "Problemas"
Durante o desenvolvimento deste projeto aprendi algumas ferramentas novas, e por conta disso, é possível notar uma diferença de codificação entre os mudulos iniciais e os modulos finais.

Ao implementar o módulo de Atendimentos, a complexidade aumentou significativamente e tive um pouco de dificuldade de lídar, e por isso acabou que parte da lógica de decisão findou sendo implementada diretamente nas Views. Reconheço que isso é um problema no encapsulamento do código pois essa lógica deveria estar exclusivamente nos Controllers.

Durante o desenvolvimento, aprendi algumas tecnicas novas (listeners, por exemplo) que estão presentes nas telas mais recentes mas não nas mais antigas. Optei por não refatora-las já que estavam estáveis e o prazo de entrega já estava proximo.

## Autor

Feito por **[Artur Saraiva Rabelo](https://github.com/artur-sres)**.

