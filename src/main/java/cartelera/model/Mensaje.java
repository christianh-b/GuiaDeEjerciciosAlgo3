package cartelera.model;

import java.util.Date;

public class Mensaje {
    private Usuario emisor;
    private Usuario receptor;
    private Date fecha;
    private String contenido;

    public Mensaje(Usuario emisor, Usuario receptor, Date fecha, String contenido) {
        this.emisor = emisor;
        this.receptor = receptor;
        this.fecha = fecha;
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Emisor: [" + this.emisor.getNombre() + "]" + "\nFecha: " +
                this.fecha + "\nMensaje: " + this.contenido;
    }

    public Usuario getEmisor() {
        return this.emisor;
    }

    public Usuario getReceptor() {
        return this.receptor;
    }
}
