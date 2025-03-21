package fiuba.model;

public class Main {
    public static void main(String[] args) {
        SistemaFiuba fiuba = new SistemaFiuba();

        Alumno alumno1 = fiuba.inscribirAlumno("CHRISTIAN");
        fiuba.inscribirAlumnoCarrera(alumno1.getPadron(), "INF-2023");
        fiuba.aprobarMateria(alumno1, "INF-2023", "TB021");
        fiuba.aprobarMateria(alumno1, "INF-2023", "CB100");
        fiuba.aprobarMateria(alumno1, "INF-2023", "TB025");
        fiuba.aprobarMateria(alumno1, "INF-2023", "CB001");
        fiuba.aprobarMateria(alumno1, "INF-2023", "CB002");
        fiuba.aprobarMateria(alumno1, "INF-2023", "TB024");
        fiuba.consultarEstadoCarrera(alumno1.getPadron(), "INF-2023");
        fiuba.aprobarMateria(alumno1, "INF-2023", "61.07");
        fiuba.aprobarMateria(alumno1, "INF-2023", "CB005");
        fiuba.consultarEstadoCarrera(alumno1.getPadron(), "INF-2023");

        Alumno alumno2 = fiuba.inscribirAlumno("JOHN DOE");
        fiuba.inscribirAlumnoCarrera(alumno2.getPadron(), "86V14");
        fiuba.consultarEstadoCarrera(alumno2.getPadron(), "86V14");
        fiuba.aprobarMateria(alumno2, "86V14", "95.14");
        fiuba.aprobarMateria(alumno2, "86V14", "95.15");
        fiuba.aprobarMateria(alumno2, "86V14", "95.02");
        fiuba.aprobarMateria(alumno2, "86V14", "81.11");
        fiuba.aprobarMateria(alumno2, "86V14", "81.11");
        fiuba.aprobarMateria(alumno2, "86V14", "81.01");
        fiuba.aprobarMateria(alumno2, "86V14", "81.02");
        fiuba.aprobarMateria(alumno2, "86V14", "95.06");
        fiuba.consultarEstadoCarrera(alumno2.getPadron(), "86V14");
    }
}
