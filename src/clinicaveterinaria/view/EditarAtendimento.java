package clinicaveterinaria.view;

import clinicaveterinaria.controller.AtendimentoController;
import clinicaveterinaria.controller.PetController;
import clinicaveterinaria.controller.VeterinarioController;
import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.Enums.Procedimento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.model.Pet;
import clinicaveterinaria.util.DataUtil;
import clinicaveterinaria.util.GerenciadorViews; 
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;

// View para a edição de um Atendimento
public class EditarAtendimento extends javax.swing.JFrame {
    private final Atendimento atendimentoOriginal;

    public EditarAtendimento(Atendimento atendimento) {
        initComponents();
        GerenciadorViews.configurar(this);   
        this.atendimentoOriginal = atendimento;
        inicializarListas();
        preencherCampos();
    }
    
    // Preenche as listas com as informações necessárias para um agendamento
    private void inicializarListas() {
        DataUtil.inicializarCombosAgendamento(cmbDia1, cmbMes1, cmbAno1);

        cmbAno1.addActionListener(evt -> {
            try {
                int ano = Integer.parseInt((String) cmbAno1.getSelectedItem());
                DataUtil.atualizarMesesAgendamento(cmbMes1, ano);
                DataUtil.atualizarDiasAgendamento(cmbDia1, cmbMes1, cmbAno1);
                atualizarListaHorarios();
            } catch (NumberFormatException e) {}
        });
        
        cmbMes1.addActionListener(evt -> {
            DataUtil.atualizarDiasAgendamento(cmbDia1, cmbMes1, cmbAno1);
            atualizarListaHorarios();
        });
        
        cmbDia1.addActionListener(evt -> atualizarListaHorarios());

        ActionListener listenerGeral = e -> atualizarListaHorarios();
        comboVet.addActionListener(listenerGeral);
        comboPet.addActionListener(listenerGeral);
        cmbDuracao.addActionListener(listenerGeral);

        comboVet.removeAllItems();
        for (Veterinario vet : VeterinarioController.getListaVeterinarios()) {
            comboVet.addItem(vet.getNome());
        }

        comboPet.removeAllItems();
        for (Pet pet : PetController.getListaPets()) {
            comboPet.addItem(pet.getNome());
        }

        comboAtendimento.removeAllItems();
        for (Procedimento proc : Procedimento.values()) {
            comboAtendimento.addItem(proc.name());
        }

        cmbDuracao.removeAllItems();
        for (int i = 30; i <= 240; i += 30) {
            cmbDuracao.addItem(String.valueOf(i));
        }
    }

    // Preenche as comboBox com as informações atuais do Atendimento a ser editado
    private void preencherCampos() {
        if (atendimentoOriginal == null) return;

        comboVet.setSelectedItem(atendimentoOriginal.getVetResponsavel().getNome());
        comboPet.setSelectedItem(atendimentoOriginal.getPetAtendido().getNome());
        comboAtendimento.setSelectedItem(atendimentoOriginal.getProcedimento().name());
        cmbDuracao.setSelectedItem(String.valueOf(atendimentoOriginal.getDuracaoMinutos()));
        txtDescricao.setText(atendimentoOriginal.getDescricao());

        LocalDate data = atendimentoOriginal.getData();
        
        String nomeMes = DataUtil.getNomeMes(data.getMonthValue()); 
        cmbAno1.setSelectedItem(String.valueOf(data.getYear())); 
        cmbMes1.setSelectedItem(nomeMes);     
        cmbDia1.setSelectedItem(String.format("%02d", data.getDayOfMonth()));
        cmbHora.setSelectedItem(atendimentoOriginal.getHora().toString());
    }

    // Os listeners fazem com que os horários disponíveis sempre estejam de acordo com as entidades selecionadas
    private void atualizarListaHorarios() {
        cmbHora.removeAllItems();   
        
        try {
            //Se faltar qualquer dado, para não dar erro no terminal
            Veterinario vet = getVetSelecionado();
            Pet pet = getPetSelecionado();
            LocalDate data = getDataSelecionada();
            
            if (vet == null || pet == null || data == null) {
                return;
            }
            int duracao = Integer.parseInt((String) cmbDuracao.getSelectedItem());
            List<String> horarios = AtendimentoController.buscarHorariosDisponiveis(vet, pet, data, duracao, this.atendimentoOriginal);
            for (String h : horarios) {
                cmbHora.addItem(h);
            }
            
            if (horarios.isEmpty()) {
                cmbHora.addItem("Sem horários");
            }

        } catch (NumberFormatException e) {
            // Ignora erros 
        }
    }
    
    private Veterinario getVetSelecionado() {
        String nome = (String) comboVet.getSelectedItem();
        if (nome == null) return null;
        for (Veterinario v : VeterinarioController.getListaVeterinarios()) {
            if (v.getNome().equals(nome)) return v;
        }
        return null;
    }

    private Pet getPetSelecionado() {
        String nome = (String) comboPet.getSelectedItem();
        if (nome == null) return null;
        for (Pet p : PetController.getListaPets()) {
            if (p.getNome().equals(nome)) return p;
        }
        return null;
    }

    private LocalDate getDataSelecionada() {
        try {
            return DataUtil.montarData(cmbDia1, cmbMes1, cmbAno1);
        } catch (Exception e) { return null; }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        cmbAno1 = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        comboAtendimento = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        comboPet = new javax.swing.JComboBox<>();
        cmbDuracao = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboVet = new javax.swing.JComboBox<>();
        cmbHora = new javax.swing.JComboBox<>();
        cmbDia1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbMes1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edição de Atendimento");

        jLabel6.setText("Horários Disponíveis:");

        cmbAno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel2.setText("Tipo de Atendimento:");

        comboAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalvar.setText("Aplicar Alterações");
        btnSalvar.addActionListener(this::btnSalvarActionPerformed);

        jLabel3.setText("Paciente (Pet):");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        comboPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDuracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Veterinario Responsável:");

        jLabel8.setText("Duração Estimada (Min) :");

        comboVet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horários" }));

        cmbDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Data:");

        cmbMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
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
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAno1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
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
                .addGap(18, 18, 18)
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Faz algumas verificações e edita o objeto final
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            Veterinario vet = getVetSelecionado();
            Pet pet = getPetSelecionado();
            LocalDate data = getDataSelecionada();
            String horarioTexto = (String) cmbHora.getSelectedItem();

            if (vet == null || pet == null) {
                JOptionPane.showMessageDialog(this, "Veterinário e Pet são obrigatórios!");
                return;
            }
            if (comboAtendimento.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Selecione o Tipo de Atendimento!");
                return;
            }
            if (horarioTexto == null || horarioTexto.equals("Sem horários")) {
                JOptionPane.showMessageDialog(this, "Selecione um horário válido!");
                return;
            }

            // Se trocou de Veterinário: Tira da agenda do antigo, põe na do novo
            if (!atendimentoOriginal.getVetResponsavel().equals(vet)) {
                atendimentoOriginal.getVetResponsavel().getAgendaConsultas().remove(atendimentoOriginal);
                vet.getAgendaConsultas().add(atendimentoOriginal);
                atendimentoOriginal.setVetResponsavel(vet);
            }

            // Se trocou de Pet: Tira do histórico do antigo, põe no do novo
            if (!atendimentoOriginal.getPetAtendido().equals(pet)) {
                atendimentoOriginal.getPetAtendido().getHistorico().remove(atendimentoOriginal);
                pet.getHistorico().add(atendimentoOriginal);
                atendimentoOriginal.setPetAtendido(pet);
            }
            
            // Atualiza os dados simples
            atendimentoOriginal.setData(data);
            atendimentoOriginal.setHora(LocalTime.parse(horarioTexto));
            atendimentoOriginal.setDuracaoMinutos(Integer.parseInt((String) cmbDuracao.getSelectedItem()));
            atendimentoOriginal.setProcedimento(Procedimento.valueOf((String) comboAtendimento.getSelectedItem()));
            atendimentoOriginal.setDescricao(txtDescricao.getText());

            JOptionPane.showMessageDialog(this, "Atendimento atualizado com sucesso!");
            this.dispose();

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbAno1;
    private javax.swing.JComboBox<String> cmbDia1;
    private javax.swing.JComboBox<String> cmbDuracao;
    private javax.swing.JComboBox<String> cmbHora;
    private javax.swing.JComboBox<String> cmbMes1;
    private javax.swing.JComboBox<String> comboAtendimento;
    private javax.swing.JComboBox<String> comboPet;
    private javax.swing.JComboBox<String> comboVet;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}
