package cartelera.model;

import java.util.HashMap;
import java.util.Iterator;

public class SistemaDeMensajeria {
    private static SistemaDeMensajeria instance;
    private int idUsuarios;
    private HashMap<Integer, Usuario> usuarios;
    private Usuario usuarioActual;

    private SistemaDeMensajeria() {
        this.usuarios = new HashMap<>();
        this.idUsuarios = 0;
    }

    public static SistemaDeMensajeria getInstance() {return instance == null ?
            instance = new SistemaDeMensajeria() : instance;}

    public Usuario crearUsuario(String nombre, String contrasenia, Boolean esPersonal) {
        Usuario usuario = new Usuario(nombre, contrasenia, ++idUsuarios, esPersonal);
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public void iniciarSesion(int idUsuario, String contrasenia) {
        if (!esUsuarioValido(idUsuario) || !esContraseniaValida(idUsuario, contrasenia)) {
            System.out.println("Usuario o contrasenia invalido");
            return;
        }
        this.usuarioActual = this.usuarios.get(idUsuario);
        System.out.println("Sesion iniciada con exito");
    }

    public void cerrarSesion() {
        if (this.usuarioActual == null) {
            System.out.println("No hay ninguna sesion activa");
            return;
        }
        this.usuarioActual = null;
        System.out.println("Sesion cerrada con exito");
    }

    public void cerrarSistema() {
        if (this.usuarioActual == null || !this.usuarioActual.getEsPersonal()) {
            System.out.println("Error, solo el personal autorizado puede cerrar la sesion");
            return;
        }
        this.usuarioActual = null;
        this.usuarios.clear();
        System.out.println("El sistema se cerro correctamente");

    }

    public void verMensajesEnviados() {
        if (this.usuarioActual == null) {return;}
        Iterator<Mensaje> mensajes = getIteradorMensajesEnviados();
        while (mensajes.hasNext()) {
            Mensaje mensaje = mensajes.next();
            System.out.println(mensaje);
        }
    }

    public void verMensajesRecibidos() {
        if (this.usuarioActual == null) {return;}
        Iterator<Mensaje> mensajes = getIteradorMensajesRecibidos();
        while (mensajes.hasNext()) {
            Mensaje mensaje = mensajes.next();
            System.out.println(mensaje);
        }
    }

    public void enviarMensaje(Mensaje mensaje) {
        if (!esUsuarioValido(mensaje.getEmisor().getId()) || !esUsuarioValido(mensaje.getReceptor().getId())) {return;}
        Usuario emisor = mensaje.getEmisor();
        Usuario receptor = mensaje.getReceptor();

        emisor.getMensajesEnviados().push(mensaje);
        receptor.getMensajesRecibiddos().push(mensaje);
    }

    private Iterator<Mensaje> getIteradorMensajesEnviados() {
        return this.usuarioActual.getMensajesEnviados().iterator();
    }

    private Iterator<Mensaje> getIteradorMensajesRecibidos() {
        return this.usuarioActual.getMensajesRecibiddos().iterator();
    }

    private Boolean esUsuarioValido(int idUsuario) {return this.usuarios.containsKey(idUsuario);}

    private Boolean esContraseniaValida(int idUsuario ,String contrasenia) { return this.usuarios.get(idUsuario).getContrasenia().equals(contrasenia); }
}
