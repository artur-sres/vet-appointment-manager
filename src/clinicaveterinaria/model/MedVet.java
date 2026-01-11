
package clinicaveterinaria.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class MedVet extends Pessoa {
    private ArrayList<Atendimento> agendaConsultas = new ArrayList<>();

    public MedVet(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }
    
    // Adicione o LocalDate nos parâmetros
    public boolean isHorarioDisponivel(java.time.LocalDate dataConsulta, java.time.LocalTime horaInicio, int duracaoMinutos) {
        java.time.LocalTime almocoInicio = java.time.LocalTime.of(11, 30);
        java.time.LocalTime almocoFim = java.time.LocalTime.of(14, 00);
        java.time.LocalTime fimExpediente = java.time.LocalTime.of(17, 00);

        java.time.LocalTime horaFim = horaInicio.plusMinutes(duracaoMinutos);

        // --- REGRA 1: Horário Fixo (Almoço e Fim de Expediente) ---
        if (horaFim.isAfter(fimExpediente)) return false;

        boolean antesDoAlmoco = !horaInicio.isBefore(java.time.LocalTime.of(8, 0)) && (horaFim.isBefore(almocoInicio) || horaFim.equals(almocoInicio));
        boolean depoisDoAlmoco = (horaInicio.isAfter(almocoFim) || horaInicio.equals(almocoFim));

        if (!antesDoAlmoco && !depoisDoAlmoco) return false; // Se violou regra de almoço/expediente, já recusa

        // --- REGRA 2: Verificar Conflito na Agenda (NOVO!) ---
        for (Atendimento agendado : this.agendaConsultas) {
            // Só importa se for no MESMO dia
            if (agendado.getData().equals(dataConsulta)) {

                // Calcula inicio e fim do agendamento que já existe
                java.time.LocalTime inicioAgendado = agendado.getHora();
                java.time.LocalTime fimAgendado = inicioAgendado.plusMinutes(agendado.getDuracaoMinutos());

                // Verifica se os tempos se sobrepõem
                // (Se o novo começa antes do outro terminar E termina depois do outro começar)
                if (horaInicio.isBefore(fimAgendado) && horaFim.isAfter(inicioAgendado)) {
                    return false; // CONFLITO ENCONTRADO! O horário está ocupado.
                }
            }
        }

        return true; // Se passou por tudo, está livre!
    }

    // Como deve ficar (CORRETO):
    public ArrayList<Atendimento> getAgendaConsultas() {
        return this.agendaConsultas;
    }
}
