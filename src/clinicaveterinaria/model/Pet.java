package clinicaveterinaria.model;

import clinicaveterinaria.model.Enums.Especie;
import clinicaveterinaria.model.Enums.Sexo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

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
    protected ArrayList<Atendimento> consultasAgendadas;
    protected ArrayList<Atendimento> consultasHistorico;


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
        this.consultasAgendadas = new ArrayList<>();
        this.consultasHistorico = new ArrayList<>();
    }
    
    
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

    public ArrayList<Atendimento> getConsultasAgendadas() {
        return consultasAgendadas;
    }

    public void setConsultasAgendadas(ArrayList<Atendimento> consultasAgendadas) {
        this.consultasAgendadas = consultasAgendadas;
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
    
    
}
