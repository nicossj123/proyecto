
package modelo;


public class Campeonato {
    private int id_campeonato,cant_equipos;
    private String equipo_campeonato;

    public Campeonato() {
    }

    public Campeonato(int id_campeonato, int cant_equipos, String equipo_campeonato) {
        this.id_campeonato = id_campeonato;
        this.cant_equipos = cant_equipos;
        this.equipo_campeonato = equipo_campeonato;
    }

    public int getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(int id_campeonato) {
        this.id_campeonato = id_campeonato;
    }

    public int getCant_equipos() {
        return cant_equipos;
    }

    public void setCant_equipos(int cant_equipos) {
        this.cant_equipos = cant_equipos;
    }

    public String getEquipo_campeonato() {
        return equipo_campeonato;
    }

    public void setEquipo_campeonato(String equipo_campeonato) {
        this.equipo_campeonato = equipo_campeonato;
    }
    
    
}
