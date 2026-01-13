package clinicaveterinaria.model;

/**
 * Classe Model para Pessoa
 * @author Artur
 */
public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected String telefone;

    /**
     * Construtor
     */
    public Pessoa(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
