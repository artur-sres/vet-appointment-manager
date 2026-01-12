package clinicaveterinaria.controller;

import clinicaveterinaria.model.Atendimento;
import java.util.ArrayList;

public class AtendimentoController {
    public static ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();

    public static void cadastrar(Atendimento novoAtendimento) {
        listaAtendimentos.add(novoAtendimento);
        
        // 2. Adiciona no Histórico do PET
        // (Certifique-se que a classe Pet tem o método getHistorico ou getConsultas)
        novoAtendimento.getPetAtendido().getHistorico().add(novoAtendimento);
        
        // 3. Adiciona na Agenda do VETERINÁRIOs
        // (Certifique-se que MedVet tem getAgendaConsultas)
        novoAtendimento.getVetResponsavel().getAgendaConsultas().add(novoAtendimento);
        
        System.out.println("Atendimento vinculado ao Pet e ao Vet com sucesso!");
    }
    
    public static void remover(Atendimento atendimento) {
        if (atendimento == null) return;

        // 1. Remove da lista geral do sistema
        listaAtendimentos.remove(atendimento);
        
        // 2. Remove do Histórico do PET (para não aparecer mais na ficha dele)
        if (atendimento.getPetAtendido() != null) {
            atendimento.getPetAtendido().getHistorico().remove(atendimento);
        }
        
        // 3. Remove da Agenda do VETERINÁRIO (LIBERA O HORÁRIO para outro paciente)
        if (atendimento.getVetResponsavel() != null) {
            atendimento.getVetResponsavel().getAgendaConsultas().remove(atendimento);
        }
        
        System.out.println("Atendimento removido e horário liberado!");
    }
}