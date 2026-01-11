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
}