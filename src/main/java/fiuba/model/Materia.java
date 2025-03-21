package fiuba.model;

public class Materia {
    private String codigo;
    private String nombre;
    private int creditos;

    public Materia(String nombre, String codigo, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCreditos() {
        return this.creditos;
    }
}
