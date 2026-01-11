
package clinicaveterinaria.model;

import java.util.ArrayList;

public class MedVet extends Pessoa {
    private ArrayList<Atendimento> agendaConsultas;

    public MedVet(String nome, String email, String telefone) {
        super(nome, email, telefone);
    }
    
}
