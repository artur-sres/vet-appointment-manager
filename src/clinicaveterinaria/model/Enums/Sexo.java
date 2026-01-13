package clinicaveterinaria.model.Enums;

/**
 * Classe Enum para adicionar o tipo Sexo
 * @author Artur
 */
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