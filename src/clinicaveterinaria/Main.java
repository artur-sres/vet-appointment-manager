package clinicaveterinaria;

import clinicaveterinaria.view.Menu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {       
        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        
        }
        
        Teste.testeTutores();
        Teste.testeVeterinarios();
        Teste.testePets();
      
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}