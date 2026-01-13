package clinicaveterinaria.controller;

import clinicaveterinaria.model.Atendimento;
import java.util.ArrayList;

/**
 * Classe que guarda os metódos responsáveis por cuidar da lógica dos agendamentos de Atendimentos
 * @author Artur
 */
public class AtendimentoController {
    public static ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();

    /**
     * Chama o construtor para Atendimento e adiciona um novo atendimento na lista, relacionando com um MedVet e com um Pet
     */
    public static void cadastrar(Atendimento novoAtendimento) {
        listaAtendimentos.add(novoAtendimento);

        novoAtendimento.getPetAtendido().getHistorico().add(novoAtendimento);
        novoAtendimento.getVetResponsavel().getAgendaConsultas().add(novoAtendimento);
    }
    
    /**
     * Metódo responsável por remover um Atendimento
     */
    public static void remover(Atendimento atendimento) {
        if (atendimento == null) {
            return;
        }

        if (atendimento.getPetAtendido() != null) {
            atendimento.getPetAtendido().getHistorico().remove(atendimento);
        }    
        
        if (atendimento.getVetResponsavel() != null) {
            atendimento.getVetResponsavel().getAgendaConsultas().remove(atendimento);
        }
        
        listaAtendimentos.remove(atendimento);
    }
}