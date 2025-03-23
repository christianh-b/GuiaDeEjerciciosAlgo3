package cartelera.model;

import java.util.Stack;

public class Usuario {
    private String nombre;
    private String contrasenia;
    private int id;
    private boolean esPersonal;
    private boolean sesionActiva;
    private Stack<Mensaje> mensajesEnviados;
    private Stack<Mensaje> mensajesRecibiddos;

    public Usuario(String nombre, String contrasenia, int id, boolean esPersonal) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.id = id;
        this.esPersonal = esPersonal;
        this.sesionActiva = false;
        this.mensajesEnviados = new Stack<>();
        this.mensajesRecibiddos = new Stack<>();
        }

    public String getNombre() {
        return this.nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public int getId() {
        return this.id;
    }

    public boolean usuarioConSesionActiva() {return this.sesionActiva;}

    public boolean getEsPersonal() {
        return this.esPersonal;
    }

    public Stack<Mensaje> getMensajesEnviados() {
        return this.mensajesEnviados;
    }

    public Stack<Mensaje> getMensajesRecibiddos() {
        return this.mensajesRecibiddos;
    }

    public void setSesionActiva(boolean sesionActiva) {this.sesionActiva = sesionActiva;}
}



