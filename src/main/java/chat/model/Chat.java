package chat.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Chat {
    private int id;
    private HashMap<Integer, Usuario> usuarios;
    private ArrayList<Mensaje> mensajes;

    public Chat(ArrayList<Usuario> usuarios, int id) {
        this.usuarios = new HashMap<>();
        this.id = id;
        this.mensajes = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            this.usuarios.put(usuario.getId(), usuario);
        }
    }

    public int getChatId() {
        return this.id;
    }

    public HashMap<Integer, Usuario> getUsuarios() {
        return this.usuarios;
    }

    public ArrayList<Mensaje> getMensajes() {
        return this.mensajes;
    }
}
