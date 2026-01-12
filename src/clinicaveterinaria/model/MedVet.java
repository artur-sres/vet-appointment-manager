package clinicaveterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MedVet extends Pessoa {
    private ArrayList<Atendimento> agendaConsultas = new ArrayList<>();
    private boolean ativo = true;

    public MedVet(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }

    // --- MÉTODOS DE VALIDAÇÃO ---

    // Método 1: Usado no CADASTRO (Não ignora ninguém)
    public boolean isHorarioDisponivel(LocalDate dataConsulta, LocalTime horaInicio, int duracaoMinutos) {
        return isHorarioDisponivel(dataConsulta, horaInicio, duracaoMinutos, null);
    }

    // Método 2: Usado na EDIÇÃO (Ignora o agendamento atual para não dar conflito com ele mesmo)
    public boolean isHorarioDisponivel(LocalDate dataConsulta, LocalTime horaInicio, int duracaoMinutos, Atendimento ignorar) {
        if (!this.ativo) return false;
        LocalTime almocoInicio = LocalTime.of(11, 30);
        LocalTime almocoFim = LocalTime.of(14, 00);
        LocalTime inicioExpediente = LocalTime.of(8, 0);
        LocalTime fimExpediente = LocalTime.of(17, 00);
        
        LocalTime horaFim = horaInicio.plusMinutes(duracaoMinutos);

        // 1. Validações Fixas (Expediente e Almoço)
        if (horaFim.isAfter(fimExpediente) || horaInicio.isBefore(inicioExpediente)) return false;

        boolean antesDoAlmoco = !horaInicio.isBefore(inicioExpediente) && (horaFim.isBefore(almocoInicio) || horaFim.equals(almocoInicio));
        boolean depoisDoAlmoco = (horaInicio.isAfter(almocoFim) || horaInicio.equals(almocoFim)) && !horaFim.isAfter(fimExpediente);

        if (!antesDoAlmoco && !depoisDoAlmoco) return false;

        // 2. Validação de Agenda (Conflitos)
        for (Atendimento agendado : this.agendaConsultas) {
            
            // O PULO DO GATO: Se for o atendimento que estamos editando, PULA ele!
            if (ignorar != null && agendado.equals(ignorar)) {
                continue; 
            }

            if (agendado.getData().equals(dataConsulta)) {
                LocalTime inicioAgendado = agendado.getHora();
                LocalTime fimAgendado = inicioAgendado.plusMinutes(agendado.getDuracaoMinutos());

                // Se houver sobreposição de horários
                if (horaInicio.isBefore(fimAgendado) && horaFim.isAfter(inicioAgendado)) {
                    return false; // Ocupado!
                }
            }
        }

        return true; // Livre!
    }

    // --- Getters e Setters ---
    public ArrayList<Atendimento> getAgendaConsultas() { return agendaConsultas; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}