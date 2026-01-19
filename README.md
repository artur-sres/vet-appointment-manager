# Sistema de Clínica Veterinária

![Java](https://img.shields.io/badge/Java-orange?logo=java&logoColor=white)
![UFC](https://img.shields.io/badge/Universidade%20Federal%20do%20Cear%C3%A1-blue)
![Programação Orientada a Objetos](https://img.shields.io/badge/Programação%20Orientada%20a%20Objetos-orange)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)

## Sobre o Projeto

Este projeto foi desenvolvido como trabalho final para a disciplina de **Programação Orientada a Objetos**, ministrada pelo Prof. Dr. Mayrton Dias de Queiroz, na Universidade Federal do Ceará (UFC).

O objetivo é simular o dia a dia de uma clínica veterinária, permitindo o gerenciamento completo de tutores, animais (pets) e veterinários, além do agendamento de atendimentos.

> **Curiosidade:** A inspiração para o tema veio de uma amiga, Letícia, que cursa Medicina Veterinária. Frequentemente brincamos que eu serei o desenvolvedor do sistema oficial quando ela abrir sua própria clínica no futuro.

## Funcionalidades Principais

O sistema conta com uma interface gráfica amigável desenvolvida em Swing, oferecendo as seguintes funcionalidades:

* **Gestão de Cadastros (CRUD):**
    * **Tutores:** Cadastro completo com validação de dados (Nome, CPF, Endereço, Telefone).
    * **Pets:** Registro detalhado dos animais (Nome, Espécie, Raça, Peso, Histórico).
    * **Veterinários:** Cadastro da equipe médica da clínica.

* **Agendamentos e Atendimentos:**
    * Marcação de consultas vinculando um Tutor, um Pet e um Veterinário.
    * Verificação automática de disponibilidade de horário.
    * Histórico de procedimentos realizados.

* **Persistência de Dados:**
    * O sistema salva automaticamente todos os registros (Tutores, Pets, Veterinários e Atendimentos) em arquivos de texto (`.txt`), garantindo que os dados não sejam perdidos ao fechar a aplicação.

## Estrutura do Projeto

O código segue o padrão de arquitetura **MVC** (Model-View-Controller) para melhor organização e escalabilidade:

* **`src/clinicaveterinaria/Main.java`**: Classe principal que inicializa a aplicação e carrega os dados.
* **`view`**: Contém as telas da interface gráfica (`Menu`, `CadastrarTutor`, `VisualizarAtendimento`, etc.).
* **`model`**: Classes que representam as entidades do negócio (`Pet`, `Tutor`, `Veterinario`, `Atendimento`).
* **`controller`**: Camada responsável pela regra de negócio, validações e persistência dos dados (`PetController`, `TutorController`, etc.).
* **`util`**: Classes utilitárias para validação de dados (CPF, Email) e formatação.

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Interface Gráfica:** Java Swing
* **IDE Recomendada:** NetBeans
* **Bibliotecas Externas:**
    * **[Caelum Stella Core](https://github.com/caelum/caelum-stella)**: Utilizada para validação robusta de CPFs brasileiros.
    * **[Commons Validator](https://commons.apache.org/proper/commons-validator/)**: Utilizada para validação segura de formatos de e-mail.

## Como Executar

1. Certifique-se de ter o **Java (JDK)** instalado em sua máquina.
2. Clone este repositório.
3. Abra o projeto no **NetBeans** (recomendado, pois o projeto utiliza a estrutura de arquivos desta IDE).
4. Caso prefira linha de comando, compile e execute a classe principal:
   ```bash
   java -cp bin clinicaveterinaria.Main
    
## Alguns Prints do Sistema

![Menu do Sistema](assets/1.png)
![Menu do Sistema](assets/foto.png)
![Menu do Sistema](assets/2.png)
![Menu do Sistema](assets/6.png)

## Autor

Feito por **[Artur Saraiva Rabelo](https://github.com/artur-sres)**.

