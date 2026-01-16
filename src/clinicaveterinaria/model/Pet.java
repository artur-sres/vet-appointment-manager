package clinicaveterinaria.model;

import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Sexo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.Period;

// Model para Pet
public class Pet {
    private Especie especie;
    private String nome;
    private LocalDate dataNascimento;
    private int idade;
    private Sexo sexo;
    private boolean isCastrado;
    private boolean isVacinado;
    private double peso;
    private String temperamento;
    private String raca;
    private String alergias;
    private Tutor tutor;
    private ArrayList<Atendimento> consultasHistorico = new ArrayList<>();

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
    
    // Verifica se o Pet já tem algum agendamento que pode vir a conflitar com um futuro novo Agendamento
    // Esse metodo é usado quando se esta cadastrando um novo Atendimento
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos) {
        return isHorarioDisponivel(dataAtendimento, horaInicio, duracaoMinutos, null);
    }
    
    // Verifica se um horario é vago para adicionar um novo agendamento para o Pet
    // Este metodo é usado quando se vai editar um agendamento, então ele ignora o horario do agendamento atual para que ele apareça normalmente
    public boolean isHorarioDisponivel(LocalDate dataAtendimento, LocalTime horaInicio, int duracaoMinutos, Atendimento ignorar) {
        for (Atendimento agendado : this.consultasHistorico) {
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
