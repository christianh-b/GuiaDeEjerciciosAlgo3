package cartelera.model;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SistemaDeMensajeria sistema = SistemaDeMensajeria.getInstance();

        Usuario juan = sistema.crearUsuario("Juan", "1234", false);
        Usuario maria = sistema.crearUsuario("Maria", "5678", true);

        sistema.iniciarSesion(juan.getId(), "1234");
        sistema.enviarMensaje(new Mensaje(juan, maria, new Date(), "Hola maria, como estas?"));
        sistema.verMensajesEnviados();
        sistema.enviarMensaje(new Mensaje(juan, maria, new Date(), "Te veo en el comedor a las 12"));
        sistema.cerrarSistema();
        sistema.cerrarSesion();

        sistema.iniciarSesion(maria.getId(), "5678");
        sistema.verMensajesRecibidos();
        sistema.cerrarSistema();
    }
}
