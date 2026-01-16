package clinicaveterinaria.model.Enums;

// Enum para adicionar o tipo Procedimento
public enum Procedimento {
    CONSULTA("Consulta"),
    CIRURGIA("Cirurgia"),
    VACINACAO("Vacinação"),
    EXAME("Exame");

    private final String descricao;

    Procedimento(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
