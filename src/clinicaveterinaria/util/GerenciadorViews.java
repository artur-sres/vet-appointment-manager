package clinicaveterinaria.util;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GerenciadorViews {
    public static void configurar(JFrame janela) {
        janela.setIconImage(new ImageIcon(janela.getClass().getResource("/clinicaveterinaria/imagens/icon.png")).getImage());
        janela.setLocationRelativeTo(null);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}