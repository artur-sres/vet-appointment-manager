package clinicaveterinaria.model.Enums;

// Enum para adicionar o tipo Sexo
public enum Sexo {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}