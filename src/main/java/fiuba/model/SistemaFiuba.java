package fiuba.model;

import java.util.HashMap;

public class SistemaFiuba {
    private HashMap<Integer, Alumno> alumnos;
    private HashMap<String, Carrera> carreras;
    private int idPadron;

    public SistemaFiuba() {
        this.alumnos = new HashMap<>();
        this.carreras = new HashMap<>();
        this.idPadron = 0;

        Materia materia1 = new Materia("FUNDAMENTOS DE PROGRAMACIÓN", "TB021", 6);
        Materia materia2 = new Materia("ALGORITMOS Y PROGRAMACION I", "95.14", 6);
        Materia materia3 = new Materia("ALGORITMOS Y ESTRUCTURAS DE DATOS", "CB100", 6);
        Materia materia4 = new Materia("ALGORITMOS Y PROGRAMACION II", "95.15", 6);
        Materia materia5 = new Materia("PARADIGMAS DE PROGRAMACION", "TB025", 6);
        Materia materia6 = new Materia("ALGORITMOS Y PROGRAMACION III", "95.02", 6);
        Materia materia7 = new Materia("MATEMATICA DISCRETA", "61.07", 6);
        Materia materia8 = new Materia("MATEMATICA DISCRETA", "81.11", 6);
        Materia materia9 = new Materia("ANALISIS MATEMATICO II", "CB001", 8);
        Materia materia10 = new Materia("ANALISIS MATEMATICO II", "81.01", 8);
        Materia materia11 = new Materia("ALGEBRA LINEAL", "CB002", 8);
        Materia materia12 = new Materia("ALGEBRA II", "81.02", 8);
        Materia materia13 = new Materia("ANALISIS MATEMATICO III", "CB005", 6);
        Materia materia14 = new Materia("TEORIA DE ALGORITMOS", "TB024", 6);
        Materia materia15 = new Materia("TEORIA DE ALGORITMOS", "95.06", 6);

        HashMap<String, Materia> materiasObligatoriasInformatica = new HashMap<>();
        materiasObligatoriasInformatica.put(materia1.getCodigo(), materia1);
        materiasObligatoriasInformatica.put(materia3.getCodigo(), materia3);
        materiasObligatoriasInformatica.put(materia5.getCodigo(), materia5);
        materiasObligatoriasInformatica.put(materia9.getCodigo(), materia9);
        materiasObligatoriasInformatica.put(materia11.getCodigo(), materia11);
        materiasObligatoriasInformatica.put(materia14.getCodigo(), materia14);

        HashMap<String, Materia> materiasOptativasInformatica = new HashMap<>();
        materiasOptativasInformatica.put(materia7.getCodigo(), materia7);
        materiasOptativasInformatica.put(materia13.getCodigo(), materia13);

        HashMap<String, Materia> materiasObligatoriasSistemas = new HashMap<>();
        materiasObligatoriasSistemas.put(materia2.getCodigo(), materia2);
        materiasObligatoriasSistemas.put(materia4.getCodigo(), materia4);
        materiasObligatoriasSistemas.put(materia6.getCodigo(), materia6);
        materiasObligatoriasSistemas.put(materia8.getCodigo(), materia8);
        materiasObligatoriasSistemas.put(materia10.getCodigo(), materia10);
        materiasObligatoriasSistemas.put(materia12.getCodigo(), materia12);

        HashMap<String, Materia> materiasOptativasSistemas = new HashMap<>();
        materiasOptativasSistemas.put(materia15.getCodigo(), materia15);

        Carrera informatica = new Carrera("Ingenieria en Informatica", "INF-2023", 52,
                materiasObligatoriasInformatica,
                materiasOptativasInformatica);

        Carrera sistemas = new Carrera("Licenciatura en Analisis de Sistemas", "86V14", 52,
                materiasObligatoriasSistemas,
                materiasOptativasSistemas);

        this.carreras.put(informatica.getCodigoDeCarrera(), informatica);
        this.carreras.put(sistemas.getCodigoDeCarrera(), sistemas);
    }

    public Alumno inscribirAlumno(String nombre) {
        Alumno alumno = new Alumno(nombre, ++idPadron);
        this.alumnos.put(idPadron, alumno);
        return alumno;
    }

    public void inscribirAlumnoCarrera(int padron, String codigoCarrera) {
        if (!esAlumnoValido(padron) || !esCarreraValida(codigoCarrera)) {
            System.out.println("ERROR padron y/o codigo de carrera invalido");
            return;
        }
        Carrera carrera = this.carreras.get(codigoCarrera);
        this.alumnos.get(padron).getCarrerasEnCurso().put(codigoCarrera, carrera);
        System.out.println("Alumno inscripto exitosamente a la carrera: " + carrera.getNombre().toUpperCase());
    }


    public void aprobarMateria(Alumno alumno, String codigoCarrera, String codigoMateria) {
        if (esAlumnoValido(alumno.getPadron()) && esCarreraValida(codigoCarrera) && alumno.alumnoCursaCarrera(codigoCarrera)) {
            Materia obligatoria = alumno.getCarrerasEnCurso().get(codigoCarrera).
                    getMateriasObligatorias().getOrDefault(codigoMateria, null);
            Materia optativa = alumno.getCarrerasEnCurso().get(codigoCarrera).
                    getMateriasOptativas().getOrDefault(codigoMateria, null);

            if (obligatoria != null) {
                alumno.getMateriasAprobadas().add(obligatoria);
            } else if (optativa != null) {
                alumno.getMateriasAprobadas().add(optativa);
            } else {
                System.out.println("ERROR materia invalida");
            }
        } else {
            System.out.println("ERROR al aprobar materia");
        }
    }

    public void consultarEstadoCarrera(int padron, String codigoCarrera) {
        if (!esAlumnoValido(padron) || !esCarreraValida(codigoCarrera)) {
            System.out.println("ERROR padron y/o codigo de carrera invalido");
            return;
        }

        Alumno alumno = this.alumnos.get(padron);

        if (!alumno.alumnoCursaCarrera(codigoCarrera)) {
            System.out.println("ERROR el alumno no esta inscripto en esta carrera");
        } else {
            Carrera carrera = alumno.getCarrerasEnCurso().get(codigoCarrera);
            int creditosObtenidos = creditosPorMateriasAprobadas(alumno);

            if (creditosObtenidos >= carrera.getCreditosMinimos()) {
                System.out.println("El alumno se recibio de la carrera: " + carrera.getNombre().toUpperCase());
            } else {
                System.out.println("El alumno todavia no se recibio");
            }
            
        }
    }

    private int creditosPorMateriasAprobadas(Alumno alumno) {
        int creditos = 0;

        for (Materia materia : alumno.getMateriasAprobadas()) {
            creditos += materia.getCreditos();
        }

        return creditos;
    }

    public HashMap<Integer, Alumno> getAlumnos() {
        return this.alumnos;
    }

    public HashMap<String, Carrera> getCarreras() {
        return this.carreras;
    }

    public Boolean esAlumnoValido(int padron) {
        return this.alumnos.containsKey(padron);
    }

    public Boolean esCarreraValida(String codigoCarrera) {
        return this.carreras.containsKey(codigoCarrera);
    }
}
