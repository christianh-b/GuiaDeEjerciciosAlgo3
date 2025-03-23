package chat.model;

import java.util.HashMap;

public class Usuario {
    private String nombre;
    private int id;
    private HashMap<Integer, Chat> chats;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.chats = new HashMap<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getId() {
        return this.id;
    }

    public HashMap<Integer, Chat> getChats() {
        return this.chats;
    }

    public Boolean esMiembroDelChat(int chatId){
        return this.chats.containsKey(chatId);
    }
}
