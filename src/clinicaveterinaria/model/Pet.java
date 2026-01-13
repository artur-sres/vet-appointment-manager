package clinicaveterinaria.model;

import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Sexo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.Period;

/**
 * Classe Model para Pet
 * @author Artur
 */
public class Pet {
    protected Especie especie;
    protected String nome;
    protected LocalDate dataNascimento;
    protected int idade;
    protected Sexo sexo;
    protected boolean isCastrado;
    protected boolean isVacinado;
    protected double peso;
    protected String temperamento;
    protected String raca;
    protected String alergias;
    protected Tutor tutor;
    protected ArrayList<Atendimento> consultasHistorico = new ArrayList<>();


    /**
     * Construtor
     */
    public Pet(Especie especie, String nome, LocalDate dataNascimento, Sexo sexo, boolean isCastrado,  boolean isVacinado, double peso, String temperamento, String raca, String alergias, Tutor tutor) {
        this.especie = especie;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        LocalDate hoje = LocalDate.now();
        this.idade = Period.between(this.dataNascimento, hoje).getYears();
        this.sexo = sexo;
        this.isCastrado = isCastrado;
        this.isVacinado = isVacinado;
        this.peso = peso;
        this.temperamento = temperamento;
        this.raca = raca;
        this.alergias = alergias;
        this.tutor = tutor;
    }
    
    /**
     * Verifica se o Pet já tem algum agendamento que pode vir a conflitar com um futuro novo Agendamento
     * Esse metodo é usado quando se esta cadastrando um novo Atendimento
     * @return uma chamada para a função que contém toda a lógica necessária, retorna um valor booleano
     */
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos) {
        return isHorarioDisponivel(dataAtendimento, horaInicio, duracaoMinutos, null);
    }
    
    /**
     * Verifica se um horario é vago para adicionar um novo agendamento para o Pet
     * Este metodo é usado quando se vai editar um agendamento, então ele ignora o horario do agendamento atual para que ele apareça normalmente
     * @return um valor booleano, se True = horario dispoíivel, se False = horario não disponível
     */
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos, Atendimento ignorar) {
        LocalTime horaFim = horaInicio.plusMinutes(duracaoMinutos);

        for (Atendimento agendado : this.consultasHistorico) {
            if (ignorar != null && agendado.equals(ignorar)) {
                continue; 
            }

            if (agendado.getData().equals(dataAtendimento)) {
                LocalTime inicioAgendado = agendado.getHora();
                LocalTime fimAgendado = inicioAgendado.plusMinutes(agendado.getDuracaoMinutos());

                if (horaInicio.isBefore(fimAgendado) && horaFim.isAfter(inicioAgendado)) {
                    return false; 
                }
            }
        }
        return true; 
    }
    
    //Getters e Setters
    public int getIdade() {
        LocalDate hoje = LocalDate.now();
        setIdade(Period.between(this.dataNascimento, hoje).getYears());
        return this.idade;
    }
    
    private void setIdade(int idade){
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public boolean getIsCastrado() {
        return isCastrado;
    }

    public void setIsCastrado(boolean isCastrado) {
        this.isCastrado = isCastrado;
    }

    public boolean getIsVacinado() {
        return isVacinado;
    }

    public void setIsVacinado(boolean isVacinado) {
        this.isVacinado = isVacinado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public ArrayList<Atendimento> getConsultasHistorico() {
        return consultasHistorico;
    }

    public void setConsultasHistorico(ArrayList<Atendimento> consultasHistorico) {
        this.consultasHistorico = consultasHistorico;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public ArrayList<Atendimento> getHistorico() {
        return consultasHistorico;
    }
    
    
}
