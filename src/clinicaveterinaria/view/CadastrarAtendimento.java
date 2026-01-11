/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package clinicaveterinaria.view;

import clinicaveterinaria.controller.VeterinarioController;
import clinicaveterinaria.controller.PetController;
import clinicaveterinaria.model.MedVet;
import clinicaveterinaria.model.Pet;
import clinicaveterinaria.model.Enums.Procedimento; // Para o tipo de atendimento
import java.awt.HeadlessException;

/**
 *
 * @author Artur
 */
public class CadastrarAtendimento extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastrarAtendimento.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public CadastrarAtendimento() {
        initComponents();
        inicializarListas();
    }
    
    private void inicializarListas() {
        // 1. Configura os ANOS (Ano atual e próximo)
        cmbAno1.removeAllItems();
        int anoAtual = java.time.LocalDate.now().getYear();
        cmbAno1.addItem(String.valueOf(anoAtual));
        cmbAno1.addItem(String.valueOf(anoAtual + 1));

        // 2. Adiciona Ação ao mudar o ANO
        cmbAno1.addActionListener(evt -> atualizarMeses());

        // 3. Adiciona Ação ao mudar o MÊS
        cmbMes1.addActionListener(evt -> atualizarDias());

        // 4. Carrega as listas iniciais
        atualizarMeses();

        // --- O RESTO (Vet, Pet, Atendimento...) CONTINUA IGUAL ---

        // Preenche Veterinários
        comboVet.removeAllItems();
        for (clinicaveterinaria.model.MedVet vet : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
            comboVet.addItem(vet.getNome());
        }

        // Preenche Pets
        comboPet.removeAllItems();
        for (clinicaveterinaria.model.Pet pet : clinicaveterinaria.controller.PetController.listaPets) {
            comboPet.addItem(pet.getNome());
        }

        // Preenche Procedimentos
        comboAtendimento.removeAllItems();
        for (clinicaveterinaria.model.Enums.Procedimento proc : clinicaveterinaria.model.Enums.Procedimento.values()) {
            comboAtendimento.addItem(proc.name());
        }

        // Preenche Duração
        cmbDuracao.removeAllItems();
        for (int i = 30; i <= 240; i += 30) {
            cmbDuracao.addItem(String.valueOf(i));
        }
    }

    // --- Métodos novos para filtrar as datas ---

    private void atualizarMeses() {
        String anoSelecionadoStr = (String) cmbAno1.getSelectedItem();
        if (anoSelecionadoStr == null) return;

        int anoSelecionado = Integer.parseInt(anoSelecionadoStr);
        int anoAtual = java.time.LocalDate.now().getYear();
        int mesAtual = java.time.LocalDate.now().getMonthValue(); // 1 a 12

        // Remove listener temporariamente para não travar
        java.awt.event.ActionListener[] listeners = cmbMes1.getActionListeners();
        for (java.awt.event.ActionListener l : listeners) cmbMes1.removeActionListener(l);

        cmbMes1.removeAllItems();
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        // Se for o ano atual, começa do mês atual. Se for ano que vem, mostra todos.
        int inicio = (anoSelecionado == anoAtual) ? (mesAtual - 1) : 0;

        for (int i = inicio; i < meses.length; i++) {
            cmbMes1.addItem(meses[i]);
        }

        // Devolve o listener
        for (java.awt.event.ActionListener l : listeners) cmbMes1.addActionListener(l);

        atualizarDias(); // Força atualizar os dias também
    }

    private void atualizarDias() {
        String anoStr = (String) cmbAno1.getSelectedItem();
        String mesStr = (String) cmbMes1.getSelectedItem();

        if (anoStr == null || mesStr == null) return;

        int ano = Integer.parseInt(anoStr);
        int mes = getNumeroMes(mesStr);

        java.time.LocalDate hoje = java.time.LocalDate.now();

        // Descobre quantos dias tem aquele mês
        java.time.YearMonth anoMes = java.time.YearMonth.of(ano, mes);
        int diasNoMes = anoMes.lengthOfMonth();

        // Se for Mês e Ano atuais, começa do dia de hoje. Senão, começa do dia 1.
        int diaInicial = 1;
        if (ano == hoje.getYear() && mes == hoje.getMonthValue()) {
            diaInicial = hoje.getDayOfMonth();
        }

        cmbDia1.removeAllItems();
        for (int i = diaInicial; i <= diasNoMes; i++) {
            String dia = (i < 10) ? "0" + i : String.valueOf(i);
            cmbDia1.addItem(dia);
        }
    }

    private int getNumeroMes(String nomeMes) {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(nomeMes)) {
                return i + 1; // Retorna 1 para Janeiro, 2 para Fevereiro...
            }
        }
        return 1; // Padrão
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDia = new javax.swing.JComboBox<>();
        cmbMes = new javax.swing.JComboBox<>();
        cmbAno = new javax.swing.JComboBox<>();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboAtendimento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboPet = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboVet = new javax.swing.JComboBox<>();
        cmbDia1 = new javax.swing.JComboBox<>();
        cmbMes1 = new javax.swing.JComboBox<>();
        cmbAno1 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnHorariosDisponiveis = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmbDuracao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbHora = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Agendar Atendimento:");

        jLabel2.setText("Tipo de Atendimento:");

        comboAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Paciente (Pet):");

        comboPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Veterinario Responsável:");

        comboVet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbAno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnHorariosDisponiveis.setText("Ver Horários Disponíveis Para a Data");
        btnHorariosDisponiveis.addActionListener(this::btnHorariosDisponiveisActionPerformed);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        cmbDuracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Duração Estimada (Min) :");

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horários" }));

        jLabel5.setText("Data:");

        jLabel6.setText("Horários Disponíveis:");

        jLabel9.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboVet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboAtendimento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnHorariosDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDuracao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboVet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHorariosDisponiveis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHorariosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorariosDisponiveisActionPerformed
        cmbHora.removeAllItems();
        try {
            // ... (Parte de pegar o veterinário continua igual) ...
            String nomeVetSelecionado = (String) comboVet.getSelectedItem();
            clinicaveterinaria.model.MedVet vetReal = null;
            for (clinicaveterinaria.model.MedVet v : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
                if (v.getNome().equals(nomeVetSelecionado)) {
                    vetReal = v;
                    break;
                }
            }
            if (vetReal == null) return;

            // --- ATENÇÃO AQUI: Mudança na forma de pegar o Mês ---
            String dia = (String) cmbDia1.getSelectedItem();
            String ano = (String) cmbAno1.getSelectedItem();
            String nomeMes = (String) cmbMes1.getSelectedItem();
            int mes = getNumeroMes(nomeMes); // Usando nosso método novo!

            java.time.LocalDate dataConsulta = java.time.LocalDate.of(Integer.parseInt(ano), mes, Integer.parseInt(dia));

            // ... (Duração continua igual) ...
            int duracaoMinutos = Integer.parseInt((String) cmbDuracao.getSelectedItem());

            java.time.LocalTime horarioAnalise = java.time.LocalTime.of(8, 0);
            java.time.LocalTime fimDia = java.time.LocalTime.of(17, 0);

            // Pega a hora de AGORA para comparar
            java.time.LocalTime agora = java.time.LocalTime.now();

            while (horarioAnalise.isBefore(fimDia)) {

                // --- NOVO FILTRO: Se for hoje e o horário já passou, PULA ---
                if (dataConsulta.equals(java.time.LocalDate.now()) && horarioAnalise.isBefore(agora)) {
                    horarioAnalise = horarioAnalise.plusMinutes(30);
                    continue;
                }

                // Verifica disponibilidade do médico
                if (vetReal.isHorarioDisponivel(dataConsulta, horarioAnalise, duracaoMinutos)) {
                    cmbHora.addItem(horarioAnalise.toString());
                }
                horarioAnalise = horarioAnalise.plusMinutes(30);
            }

            if (cmbHora.getItemCount() == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nenhum horário disponível para esta data!");
            }

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnHorariosDisponiveisActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            // 1. Validar e Montar a DATA
            String dia = (String) cmbDia1.getSelectedItem();
            String ano = (String) cmbAno1.getSelectedItem();
            int mes = getNumeroMes((String) cmbMes1.getSelectedItem());
            java.time.LocalDate data = java.time.LocalDate.of(Integer.parseInt(ano), mes, Integer.parseInt(dia));

            // 2. Validar e Montar a HORA
            String horaTexto = (String) cmbHora.getSelectedItem();
            if (horaTexto == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Selecione um horário disponível!");
                return;
            }
            java.time.LocalTime hora = java.time.LocalTime.parse(horaTexto);

            // 3. Recuperar o VETERINÁRIO Real (pelo nome)
            String nomeVet = (String) comboVet.getSelectedItem();
            clinicaveterinaria.model.MedVet vetReal = null;
            for (clinicaveterinaria.model.MedVet v : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
                if (v.getNome().equals(nomeVet)) {
                    vetReal = v;
                    break;
                }
            }

            // 4. Recuperar o PET Real (pelo nome)
            String nomePet = (String) comboPet.getSelectedItem();
            clinicaveterinaria.model.Pet petReal = null;
            for (clinicaveterinaria.model.Pet p : clinicaveterinaria.controller.PetController.listaPets) {
                if (p.getNome().equals(nomePet)) {
                    petReal = p;
                    break;
                }
            }

            // 5. Recuperar o Procedimento e Descrição
            String nomeProc = (String) comboAtendimento.getSelectedItem();
            clinicaveterinaria.model.Enums.Procedimento procedimento = clinicaveterinaria.model.Enums.Procedimento.valueOf(nomeProc);
            String descricao = txtDescricao.getText();

            // 6. Criar o Objeto Atendimento
            clinicaveterinaria.model.Atendimento novoAtendimento = new clinicaveterinaria.model.Atendimento(
                procedimento, petReal, vetReal, data, hora, descricao
            );
            
            // Define a duração (se não tiver no construtor, usamos o set)
            int duracao = Integer.parseInt((String) cmbDuracao.getSelectedItem());
            novoAtendimento.setDuracaoMinutos(duracao); // <--- Certifique-se que criou esse método set no passo anterior!

            // 7. SALVAR (Aqui precisamos do Controller de Atendimento)
            // Por enquanto vamos apenas imprimir para testar:
            System.out.println("Atendimento Criado com sucesso para: " + petReal.getNome());
            
            clinicaveterinaria.controller.AtendimentoController.cadastrar(novoAtendimento); 
            
            javax.swing.JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!");
            this.dispose();

        } catch (HeadlessException | NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnHorariosDisponiveis;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbAno;
    private javax.swing.JComboBox<String> cmbAno1;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbDia1;
    private javax.swing.JComboBox<String> cmbDuracao;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JComboBox<String> cmbMes1;
    private javax.swing.JComboBox<String> comboAtendimento;
    private javax.swing.JComboBox<String> comboPet;
    private javax.swing.JComboBox<String> comboVet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}
