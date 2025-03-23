package chat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class App {
    private int idUsuarios;
    private int idChats;
    private HashMap<Integer, Usuario> usuarios;
    private HashMap<Integer, Chat> historialDeChats;

    public App() {
        this.idUsuarios = 0;
        this.idChats = 0;
        this.usuarios = new HashMap<>();
        this.historialDeChats = new HashMap<>();
    }

    public Usuario crearUsuario(String nombre) {
        Usuario usuario = new Usuario(nombre, ++this.idUsuarios);
        this.usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Chat crearChat(ArrayList<Usuario> usuarios) {
        Chat chat = new Chat(usuarios, ++this.idChats);

        for (Usuario usuario : usuarios) {
            usuario.getChats().put(chat.getChatId(), chat);
        }

        this.historialDeChats.put(this.idChats, chat);
        return chat;
    }

    public void enviarMensaje(int userId, int chatId, String texto) {
        if (!esUsuarioValido(userId) || !esChatValido(chatId)) {
            return;
        }

        Usuario usuario = this.usuarios.get(userId);
        Chat chat = this.historialDeChats.get(chatId);

        if (usuario.esMiembroDelChat(chatId)) {
            Mensaje mensaje = new Mensaje(usuario, new Date(), texto);
            chat.getMensajes().add(mensaje);
        }
    }

    public ArrayList<Mensaje> getHistorial(int chatId) {
        return esChatValido(chatId) ? this.historialDeChats.get(chatId).getMensajes() : null;
    }

    private Boolean esUsuarioValido(int userId) {
        return this.usuarios.containsKey(userId);
    }

    private Boolean esChatValido(int chatId) {
        return this.historialDeChats.containsKey(chatId);
    }
}
