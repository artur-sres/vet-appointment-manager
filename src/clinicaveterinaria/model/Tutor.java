package clinicaveterinaria.model;
import java.util.ArrayList;

public class Tutor extends Pessoa{
    private String endereco;
    private String cpf;
    private ArrayList<Pet> pets;

    //Construtor
    public Tutor(String nome, String email, String telefone, String endereco, String cpf) {
        super(nome, email, telefone);
        this.endereco = endereco;
        this.cpf = cpf;
        this.pets = new ArrayList<>();
    }

    public void adicionarPet(Pet novoPet){
        pets.add(novoPet);
    }
    
    //Getters
    public String getEndereco() {
        return endereco;
    }
    public String getCPF() {
        return cpf;
    }
    public ArrayList<Pet> getAnimais() {
        return pets;
    }

    
    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setAnimais(ArrayList<Pet> animais) {
        this.pets = animais;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
