package clinicaveterinaria.util;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class DataUtil {
    private static final String[] meses = {
        "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    };
    
    public static void inicializarCombosCadastro(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) {
        cmbDia.removeAllItems();
        cmbMes.removeAllItems();
        cmbAno.removeAllItems();

        for (int i = 1; i <= 31; i++) {
            cmbDia.addItem(String.format("%02d", i));
        }

        cmbMes.setModel(new DefaultComboBoxModel<>(meses));

        int anoAtual = LocalDate.now().getYear();
        for (int i = 1990; i <= anoAtual; i++) {
            cmbAno.addItem(String.valueOf(i));
        }
    }
    
    public static void inicializarCombosAgendamento(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) {
        // 1. Preenche Anos (Atual + 1)
        cmbAno.removeAllItems();
        int anoAtual = LocalDate.now().getYear();
        cmbAno.addItem(String.valueOf(anoAtual));
        cmbAno.addItem(String.valueOf(anoAtual + 1));

        // 2. Preenche Meses (Com lógica de bloquear passado)
        atualizarMesesAgendamento(cmbMes, anoAtual);
        
        // 3. Preenche Dias (Com lógica de bloquear passado e dias corretos do mês)
        atualizarDiasAgendamento(cmbDia, cmbMes, cmbAno);
    }
    
    public static void atualizarMesesAgendamento(JComboBox cmbMes, int anoSelecionado) {
        // Remove listeners para evitar disparos acidentais
        ActionListener[] listeners = cmbMes.getActionListeners();
        for (ActionListener l : listeners) cmbMes.removeActionListener(l);

        cmbMes.removeAllItems();
        
        int anoAtual = LocalDate.now().getYear();
        int mesAtual = LocalDate.now().getMonthValue(); // 1 a 12
        
        // Se for o ano atual, começa do mês atual. Se for ano que vem, começa de Janeiro.
        int inicio = (anoSelecionado == anoAtual) ? (mesAtual - 1) : 0;

        for (int i = inicio; i < meses.length; i++) {
            cmbMes.addItem(meses[i]);
        }
        
        // Devolve os listeners
        for (ActionListener l : listeners) cmbMes.addActionListener(l);
    }
    
    public static void atualizarDiasAgendamento(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) {
        if (cmbAno.getSelectedItem() == null || cmbMes.getSelectedItem() == null) return;

        int ano = Integer.parseInt((String) cmbAno.getSelectedItem());
        int mes = getNumeroMes((String) cmbMes.getSelectedItem());
        
        cmbDia.removeAllItems();
        
        YearMonth anoMes = YearMonth.of(ano, mes);
        int diasNoMes = anoMes.lengthOfMonth(); // Já calcula se é bissexto ou se tem 30/31 dias
        
        LocalDate hoje = LocalDate.now();
        int diaInicial = 1;
        
        if (ano == hoje.getYear() && mes == hoje.getMonthValue()) {
            diaInicial = hoje.getDayOfMonth();
        }

        for (int i = diaInicial; i <= diasNoMes; i++) {
            cmbDia.addItem(String.format("%02d", i));
        }
    }

    public static LocalDate montarData(JComboBox cmbDia, JComboBox cmbMes, JComboBox cmbAno) throws Exception {
        try {
            int dia = Integer.parseInt(cmbDia.getSelectedItem().toString());
            // Usa o getNumeroMes para garantir compatibilidade caso mude a ordem ou texto
            int mes = getNumeroMes(cmbMes.getSelectedItem().toString()); 
            int ano = Integer.parseInt(cmbAno.getSelectedItem().toString());

            return LocalDate.of(ano, mes, dia);
        } catch (Exception e) {
            throw new Exception("Data inválida ou incompleta.");
        }
    }
    
    public static int getNumeroMes(String nomeMes) {
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(nomeMes)) return i + 1;
        }
        return 1;
    }
    
    public static String getNomeMes(int numeroMes) { 
        if (numeroMes < 1 || numeroMes > 12) {
            return "Janeiro";
        }
        return meses[numeroMes - 1];
    }
}