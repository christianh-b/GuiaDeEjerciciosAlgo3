package fiuba.model;

import java.util.HashMap;

public class Carrera {
    private String nombre;
    private String codigoDeCarrera;
    private int creditosMinimos;
    private HashMap<String, Materia> materiasObligatorias;
    private HashMap<String, Materia> materiasOptativas;

    public Carrera(String nombre, String codigoDeCarrera, int creditosMinimos,
                   HashMap<String, Materia> materiasObligatorias,
                   HashMap<String, Materia> materiasOptativas) {
        this.nombre = nombre;
        this.codigoDeCarrera = codigoDeCarrera;
        this.creditosMinimos = creditosMinimos;
        this.materiasObligatorias = materiasObligatorias;
        this.materiasOptativas = materiasOptativas;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCreditosMinimos() {
        return this.creditosMinimos;
    }

    public String getCodigoDeCarrera() {
        return this.codigoDeCarrera;
    }

    public HashMap<String, Materia> getMateriasObligatorias() {
        return this.materiasObligatorias;
    }

    public HashMap<String, Materia> getMateriasOptativas() {
        return this.materiasOptativas;
    }
}
