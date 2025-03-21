package fiuba.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Alumno {
    private String nombre;
    private int padron;
    private ArrayList<Materia> materiasAprobadas;
    private HashMap<String, Carrera> carrerasEnCurso;

    public Alumno(String nombre, int padron) {
        this.nombre = nombre;
        this.padron = padron;
        this.materiasAprobadas = new ArrayList<>();
        this.carrerasEnCurso = new HashMap<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPadron() {
        return this.padron;
    }

    public ArrayList<Materia> getMateriasAprobadas() {
        return this.materiasAprobadas;
    }

    public HashMap<String, Carrera> getCarrerasEnCurso() {
        return this.carrerasEnCurso;
    }
}
