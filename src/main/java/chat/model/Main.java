package chat.model;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        Usuario usuario1 = app.crearUsuario("Juan");
        Usuario usuario2 = app.crearUsuario("Maria");
        Usuario usuario3 = app.crearUsuario("Pedro");
        Usuario usuario4 = app.crearUsuario("Ana");

        Chat chat = app.crearChat(new ArrayList<>(List.of(usuario1, usuario2, usuario3)));

        app.enviarMensaje(usuario1.getId(), chat.getChatId(), "Hola Maria");
        app.enviarMensaje(usuario2.getId(), chat.getChatId(), "Hola Juan, Como estas?");
        app.enviarMensaje(usuario3.getId(), chat.getChatId(), "Hola Juan, Quiere tomar un cafe?");
        app.enviarMensaje(usuario1.getId(), chat.getChatId(), "Si, vamos a un cafe");
        app.enviarMensaje(usuario2.getId(), chat.getChatId(), "Tambien me gustaria tomar un cafe");
        app.enviarMensaje(usuario3.getId(), chat.getChatId(), "Genial, cuando nos encontramos?");

        // Como no pertenece al chat no deberia de guardarse este mensaje en el chat
        app.enviarMensaje(usuario4.getId(), chat.getChatId(), "Hola Juan");

        ArrayList<Mensaje> historial = app.getHistorial(chat.getChatId());

        for (Mensaje mensaje : historial) {
            System.out.println(mensaje);
        }
    }
}
