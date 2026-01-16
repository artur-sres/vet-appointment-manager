package clinicaveterinaria;

import clinicaveterinaria.view.Menu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Classe main do programa
public class Main {
    public static void main(String[] args) {  
        // Aplica o Look And Feel do Sistema Operacional 
        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            
        }
        
        // Entidades de testes para o programa não ser inicializado sem dados
        Teste.testeTutores();
        Teste.testeVeterinarios();
        Teste.testePets();
        Teste.testeAtendimentos();
      
        // Chamada do menu principal
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}