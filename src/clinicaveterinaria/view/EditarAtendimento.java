package clinicaveterinaria.view;

import clinicaveterinaria.model.Atendimento;
import clinicaveterinaria.model.MedVet;
import clinicaveterinaria.model.Pet;
import clinicaveterinaria.model.Enums.Procedimento;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class EditarAtendimento extends javax.swing.JFrame {

    private Atendimento atendimentoOriginal;

    // Construtor que recebe o atendimento para editar
    public EditarAtendimento(Atendimento atendimento) {
        initComponents();
        this.atendimentoOriginal = atendimento;
        
        // 1. Carrega as listas vazias (igual ao Cadastro)
        inicializarListas();
        
        // 2. Seleciona os itens certos baseados no atendimento original
        preencherCampos();
    }

    public EditarAtendimento() {
        initComponents();
        inicializarListas();
    }

    // --- Mesma lógica do Cadastro para encher as caixinhas ---
    private void inicializarListas() {
        // Preenche Anos
        cmbAno1.removeAllItems();
        int anoAtual = LocalDate.now().getYear();
        cmbAno1.addItem(String.valueOf(anoAtual));
        cmbAno1.addItem(String.valueOf(anoAtual + 1));
        
        // Listeners para atualizar dias/meses automaticamente
        cmbAno1.addActionListener(evt -> atualizarMeses());
        cmbMes1.addActionListener(evt -> atualizarDias());

        // Preenche Vets, Pets, Procedimentos e Duração
        comboVet.removeAllItems();
        for (MedVet vet : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
            // Só adiciona ativos, MAS se o vet original estiver inativo, ele precisa aparecer!
            if (vet.isAtivo() || (atendimentoOriginal != null && vet.equals(atendimentoOriginal.getVetResponsavel()))) {
                 comboVet.addItem(vet.getNome());
            }
        }

        comboPet.removeAllItems();
        for (Pet pet : clinicaveterinaria.controller.PetController.listaPets) {
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
        
        atualizarMeses(); // Dispara a cascata inicial
    }

    // --- Lógica EXCLUSIVA da Edição: Selecionar o que já estava salvo ---
    private void preencherCampos() {
        if (atendimentoOriginal == null) return;

        // 1. Seleciona Vet e Pet pelos nomes
        comboVet.setSelectedItem(atendimentoOriginal.getVetResponsavel().getNome());
        comboPet.setSelectedItem(atendimentoOriginal.getPetAtendido().getNome());
        comboAtendimento.setSelectedItem(atendimentoOriginal.getProcedimento().name());
        cmbDuracao.setSelectedItem(String.valueOf(atendimentoOriginal.getDuracaoMinutos()));
        txtDescricao.setText(atendimentoOriginal.getDescricao());

        // 2. Seleciona a Data (Mais chatinho, tem que converter)
        LocalDate data = atendimentoOriginal.getData();
        
        // Seleciona Ano
        cmbAno1.setSelectedItem(String.valueOf(data.getYear()));
        
        // Seleciona Mês (Converte número 1 -> "Janeiro")
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        if (data.getMonthValue() >= 1 && data.getMonthValue() <= 12) {
            cmbMes1.setSelectedItem(meses[data.getMonthValue() - 1]);
        }
        
        // Força atualizar os dias para o mês selecionado aparecer correto
        atualizarDias();
        
        // Seleciona Dia (Formata 5 -> "05" se necessário)
        String diaFormatado = String.format("%02d", data.getDayOfMonth());
        cmbDia1.setSelectedItem(diaFormatado);

        // 3. Adiciona a hora atual na lista (para não parecer vazio) e seleciona
        cmbHora.removeAllItems();
        cmbHora.addItem(atendimentoOriginal.getHora().toString());
    }
    
    private void atualizarMeses() {
        // ... (Copie o código do atualizarMeses do CadastrarAtendimento aqui) ...
        // É exatamente igual, só lembre de copiar para cá.
        // Vou resumir para não estourar o limite, mas você deve copiar de lá.
        String anoStr = (String) cmbAno1.getSelectedItem();
        if (anoStr == null) return;
        // ... lógica de recarregar cmbMes1 ...
        atualizarDias();
    }

    private void atualizarDias() {
        // ... (Copie o código do atualizarDias do CadastrarAtendimento aqui) ...
        // É essencial ter esse método aqui também.
        String mesStr = (String) cmbMes1.getSelectedItem();
        if (mesStr == null) return;
        int ano = Integer.parseInt((String) cmbAno1.getSelectedItem());
        int mes = getNumeroMes(mesStr);
        // ... lógica de recarregar cmbDia1 ...
    }

    private int getNumeroMes(String nomeMes) {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", 
                          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        for (int i = 0; i < meses.length; i++) {
            if (meses[i].equals(nomeMes)) return i + 1;
        }
        return 1;
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnHorariosDisponiveis = new javax.swing.JButton();
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

        jLabel6.setText("Horários Disponíveis:");

        cmbAno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Descrição:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Editar Atendimento");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel2.setText("Tipo de Atendimento:");

        btnHorariosDisponiveis.setText("Ver Horários Disponíveis Para a Data");
        btnHorariosDisponiveis.addActionListener(this::btnHorariosDisponiveisActionPerformed);

        comboAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalvar.setText("Salvar");
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
                .addContainerGap(31, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnHorariosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorariosDisponiveisActionPerformed
        cmbHora.removeAllItems();
        try {
            // Recupera Vet selecionado
            String nomeVet = (String) comboVet.getSelectedItem();
            MedVet vetReal = null;
            for (MedVet v : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
                if (v.getNome().equals(nomeVet)) { vetReal = v; break; }
            }
            if (vetReal == null) return;

            // Monta Data
            int ano = Integer.parseInt((String) cmbAno1.getSelectedItem());
            int mes = getNumeroMes((String) cmbMes1.getSelectedItem());
            int dia = Integer.parseInt((String) cmbDia1.getSelectedItem());
            LocalDate dataConsulta = LocalDate.of(ano, mes, dia);

            int duracao = Integer.parseInt((String) cmbDuracao.getSelectedItem());
            
            // Loop de horários (08:00 as 17:00)
            LocalTime horario = LocalTime.of(8, 0);
            LocalTime fimDia = LocalTime.of(17, 0);
            LocalTime agora = LocalTime.now();

            while (horario.isBefore(fimDia)) {
                // Filtro de passado (se for hoje)
                if (dataConsulta.equals(LocalDate.now()) && horario.isBefore(agora)) {
                    horario = horario.plusMinutes(30);
                    continue;
                }

                // VALIDAÇÃO ESPECIAL: Passamos 'this.atendimentoOriginal' para ele se ignorar!
                // (Isso exige que você tenha atualizado o MedVet.java conforme falamos antes)
                if (vetReal.isHorarioDisponivel(dataConsulta, horario, duracao, this.atendimentoOriginal)) {
                    cmbHora.addItem(horario.toString());
                }
                
                horario = horario.plusMinutes(30);
            }
            
            if (cmbHora.getItemCount() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum horário disponível nesta data.");
            } else {
                JOptionPane.showMessageDialog(this, "Horários atualizados! Selecione um na lista.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar horários: " + e.getMessage());
        }
    }//GEN-LAST:event_btnHorariosDisponiveisActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            // 1. Validações básicas
            if (cmbHora.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Por favor, verifique os horários e selecione um.");
                return;
            }

            // 2. Coleta os dados novos das caixinhas
            int ano = Integer.parseInt((String) cmbAno1.getSelectedItem());
            int mes = getNumeroMes((String) cmbMes1.getSelectedItem());
            int dia = Integer.parseInt((String) cmbDia1.getSelectedItem());
            LocalDate novaData = LocalDate.of(ano, mes, dia);
            
            LocalTime novaHora = LocalTime.parse((String) cmbHora.getSelectedItem());
            int novaDuracao = Integer.parseInt((String) cmbDuracao.getSelectedItem());
            String novaDescricao = txtDescricao.getText();
            
            // Pega os objetos reais (Vet/Pet) novamente caso tenha mudado
            String nomeVet = (String) comboVet.getSelectedItem();
            MedVet novoVet = null; 
            for(MedVet v : clinicaveterinaria.controller.VeterinarioController.listaVeterinarios) {
                if(v.getNome().equals(nomeVet)) { novoVet = v; break; }
            }
            
            // 3. Atualiza o objeto Original
            atendimentoOriginal.setData(novaData);
            atendimentoOriginal.setHora(novaHora);
            atendimentoOriginal.setDuracaoMinutos(novaDuracao);
            atendimentoOriginal.setDescricao(novaDescricao);
            atendimentoOriginal.setVetResponsavel(novoVet); 
            // (Opcional: atualizar Pet e Procedimento também se quiser permitir trocar)

            JOptionPane.showMessageDialog(this, "Agendamento atualizado com sucesso!");
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnHorariosDisponiveis;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbAno1;
    private javax.swing.JComboBox<String> cmbDia1;
    private javax.swing.JComboBox<String> cmbDuracao;
    private javax.swing.JComboBox<String> cmbHora;
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
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}
