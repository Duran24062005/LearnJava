package LIncensesManager;

import java.io.Serializable;

public class Licencia implements Serializable {
    private Persona persona;
    private String numero, categoria;

    public Licencia(Persona perosna, String codigo, String categoria) {
        this.persona = perosna;
        this.numero = codigo;
        this.categoria = categoria;
    }

    public Persona getPersona() {
        return persona;
    }

    public String getNumero() {
        return numero;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        String text = """
                %s
                Numero: %s
                Categoria: %s
                        """.formatted(persona, numero, categoria);
        return text;
    }
}
