package clinicaveterinaria;

import clinicaveterinaria.controller.AtendimentoController;
import clinicaveterinaria.controller.PetController;
import clinicaveterinaria.controller.TutorController;
import clinicaveterinaria.controller.VeterinarioController;
import clinicaveterinaria.view.Menu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JOptionPane;

//Classe main do programa
public class Main {
    public static void main(String[] args) {  
        // "javax.swing.plaf.nimbus.NimbusLookAndFeel"
        
        // Aplica o Look And Feel do Sistema Operacional 
        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            
        }
        try {
            TutorController.carregarDados();
            VeterinarioController.carregarDados();
            PetController.carregarDados();
            AtendimentoController.carregarDados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
        
        // Chamada do menu principal
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}