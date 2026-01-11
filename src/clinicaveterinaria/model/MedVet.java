
package clinicaveterinaria.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class MedVet extends Pessoa {
    private ArrayList<Atendimento> agendaConsultas;

    public MedVet(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }
    
    public boolean isHorarioTrabalho(java.time.LocalTime horaInicio, int duracaoMinutos) {
        java.time.LocalTime almocoInicio = java.time.LocalTime.of(11, 30);
        java.time.LocalTime almocoFim = java.time.LocalTime.of(14, 00);
        java.time.LocalTime fimExpediente = java.time.LocalTime.of(17, 00);

        // Calcula que horas terminaria o atendimento
        java.time.LocalTime horaFim = horaInicio.plusMinutes(duracaoMinutos);

        // Regra 1: Não pode terminar depois das 17h
        if (horaFim.isAfter(fimExpediente)) return false;

        // Regra 2: Verifica colisão com o almoço
        // Se começa antes do almoço, tem que terminar antes ou no início dele
        boolean antesDoAlmoco = !horaInicio.isBefore(java.time.LocalTime.of(8, 0)) && (horaFim.isBefore(almocoInicio) || horaFim.equals(almocoInicio));

        // Se começa depois do almoço
        boolean depoisDoAlmoco = (horaInicio.isAfter(almocoFim) || horaInicio.equals(almocoFim));

    return antesDoAlmoco || depoisDoAlmoco;
}

    public Object getAgendaConsultas() {
        return this.agendaConsultas;
    }
}
