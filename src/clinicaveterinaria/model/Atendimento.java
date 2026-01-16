package clinicaveterinaria.model;

import clinicaveterinaria.model.Enums.Procedimento;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe Model para Atendimento
 * @author Artur
 */
public class Atendimento { 
    private Procedimento procedimento;
    private Pet petAtendido;
    private MedVet vetResponsavel;
    private LocalDate data; 
    private LocalTime hora; 
    private String descricao;
    private int duracaoMinutos; 

    
    /**
     * Construtor da Classe
     */
    public Atendimento(Procedimento procedimento, Pet petAtendido, MedVet vetResponsavel, LocalDate data, LocalTime hora, String descricao) {
        this.procedimento = procedimento;
        this.petAtendido = petAtendido;
        this.vetResponsavel = vetResponsavel;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public boolean temConflito(LocalTime horaInicioNovo, int duracaoMinutosNovo) {
        LocalTime horaFimNovo = horaInicioNovo.plusMinutes(duracaoMinutosNovo);

        LocalTime meuInicio = this.getHora();
        LocalTime meuFim = meuInicio.plusMinutes(this.getDuracaoMinutos());

        return horaInicioNovo.isBefore(meuFim) && horaFimNovo.isAfter(meuInicio);
    }
    //Getters e Setters

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos; 
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Pet getPetAtendido() {
        return petAtendido;
    }

    public void setPetAtendido(Pet petAtendido) {
        this.petAtendido = petAtendido;
    }

    public MedVet getVetResponsavel() {
        return vetResponsavel;
    }

    public void setVetResponsavel(MedVet vetResponsavel) {
        this.vetResponsavel = vetResponsavel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}