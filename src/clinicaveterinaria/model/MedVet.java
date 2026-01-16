package clinicaveterinaria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe Model para MedVet
 * @author Artur
 */
public class MedVet extends Pessoa {
    private ArrayList<Atendimento> agendaConsultas = new ArrayList<>();
    private boolean ativo = true;

    /**
     * Construtor da Classe
     */
    public MedVet(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }

    /**
     * Verifica se um determinado agendamento pode ser feito naquele intervalo de tempo dentro dos horarios idisponiveis do MedVet
     * Esse metodo é o que é chamado no cadastro de um novo Atendimento
     * @return a chamada do metodo que possui toda a lógica implementada
     */
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos) {
        return isHorarioDisponivel(dataAtendimento, horaInicio, duracaoMinutos, null);
    }

    /**
     * Verifica se tem um horario disponivel determinado agendamento ser feito naquele intervalo de tempo dentro dos horarios idisponiveis do MedVet
     * O metodo pode receber um Atendimento que será editado para que o horario atual não seja ignorado e tambem apareça nas opções
     * @return um valor booleano, se True = Disponível, se False = Não Disponível
     */
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos, Atendimento ignorar) {
        if (!this.ativo) return false;
        
        //Define os intervalos de tempo úteis
        LocalTime almocoInicio = LocalTime.of(11, 30);
        LocalTime almocoFim = LocalTime.of(14, 00);
        LocalTime inicioExpediente = LocalTime.of(8, 0);
        LocalTime fimExpediente = LocalTime.of(17, 00);
        
        LocalTime horaFim = horaInicio.plusMinutes(duracaoMinutos);

        if (horaFim.isAfter(fimExpediente) || horaInicio.isBefore(inicioExpediente)) {
            return false;
        }
        
        boolean antesDoAlmoco = !horaInicio.isBefore(inicioExpediente) && (horaFim.isBefore(almocoInicio) || horaFim.equals(almocoInicio));
        boolean depoisDoAlmoco = (horaInicio.isAfter(almocoFim) || horaInicio.equals(almocoFim)) && !horaFim.isAfter(fimExpediente);

        if (!antesDoAlmoco && !depoisDoAlmoco) return false;

        //Validação da agenda para evitar conflitos
        for (Atendimento agendado : this.agendaConsultas) {
            
             if (ignorar != null && agendado.equals(ignorar)) {
                 continue;
             }

            if (agendado.getData().equals(dataAtendimento)) {
                if (agendado.temConflito(horaInicio, duracaoMinutos)) {
                    return false; 
                }
            }
        }
        return true;
    }

    //Getters e Setters
    public ArrayList<Atendimento> getAgendaConsultas() { 
        return agendaConsultas; 
    }
    
    public boolean isAtivo() {
        return ativo; 
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo; 
    }
}