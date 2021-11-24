
package modelo;


public class Arbitro {
    private int id_arbitro;
    private boolean asignado;
    private String nombre;

    public Arbitro() {
    }

    public Arbitro(int id_arbitro, boolean asignado, String nombre) {
        this.id_arbitro = id_arbitro;
        this.asignado = asignado;
        this.nombre = nombre;
    }

    public int getId_arbitro() {
        return id_arbitro;
    }

    public void setId_arbitro(int id_arbitro) {
        this.id_arbitro = id_arbitro;
    }

    public boolean isAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
