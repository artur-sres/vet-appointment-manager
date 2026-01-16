package clinicaveterinaria.model.Enums;

// Enum para adicionar o tipo Especie
public enum Especie {
    CACHORRO("Cachorro"),
    GATO("Gato");
    
    private final String descricao;

    Especie(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
