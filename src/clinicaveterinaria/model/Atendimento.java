package clinicaveterinaria.model;
import clinicaveterinaria.model.Enums.Procedimento;
import java.time.LocalDate;
import java.time.LocalTime;

public class Atendimento {
    private Procedimento procedimento;
    private Pet petAtendido;
    private MedVet vetResponsavel;
    private int duracaoMinutos;
    private LocalDate data; 
    private LocalTime hora; 
    private String descricao;

    public Atendimento(Procedimento procedimento, Pet petAtendido, MedVet vetResponsavel, LocalDate data, LocalTime hora, String descricao) {
        this.procedimento = procedimento;
        this.petAtendido = petAtendido;
        this.vetResponsavel = vetResponsavel;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public void setDuracaoMinutos(int duracao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
