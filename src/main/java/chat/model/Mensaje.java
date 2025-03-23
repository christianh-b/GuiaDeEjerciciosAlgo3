package chat.model;

import java.util.Date;

public class Mensaje {
    private Usuario emisor;
    private Date fecha;
    private String texto;

    public Mensaje(Usuario emisor, Date fecha, String texto) {
        this.emisor = emisor;
        this.fecha = fecha;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "[" + this.emisor.getNombre() + "] - " + this.fecha + "\n" + this.texto;
    }
}
