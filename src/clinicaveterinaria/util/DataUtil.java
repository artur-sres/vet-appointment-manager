package clinicaveterinaria.util;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Classe para auxiliar na criação de datas
 * @author Artur
 */
public class DataUtil {

    /**
     * Adiciona as datas em comboBox para auxiliar as jFrame 
     */
    public static void inicializarCombos(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) {
        cmbDia.removeAllItems();
        cmbMes.removeAllItems();
        cmbAno.removeAllItems();

        for (int i = 1; i <= 31; i++) {
            cmbDia.addItem(String.format("%02d", i));
        }

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        cmbMes.setModel(new DefaultComboBoxModel<>(meses));

        int anoAtual = LocalDate.now().getYear();
        for (int i = 1990; i <= anoAtual; i++) {
            cmbAno.addItem(String.valueOf(i));
        }
    }

    /**
     * Monta uma data no formato brasileiro
     * @return Uma data no formato brasileiro
     * @throws Exception 
     */
    public static LocalDate montarData(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) throws Exception {
        try {
            int dia = Integer.parseInt(cmbDia.getSelectedItem().toString());
            int mes = cmbMes.getSelectedIndex() + 1;
            int ano = Integer.parseInt(cmbAno.getSelectedItem().toString());

            return LocalDate.of(ano, mes, dia);
        } catch (NumberFormatException e) {
            throw new Exception("Data inválida! Verifique o dia e o mês.");
        }
    }
}