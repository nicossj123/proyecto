/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author TonyMontanaPC
 */
public class Partido {
    private int id_partido,duracion_min,id_campeonato,id_arbitro;

    public Partido() {
    }

    public Partido(int id_partido, int duracion_min, int id_campeonato, int id_arbitro) {
        this.id_partido = id_partido;
        this.duracion_min = duracion_min;
        this.id_campeonato = id_campeonato;
        this.id_arbitro = id_arbitro;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(int duracion_min) {
        this.duracion_min = duracion_min;
    }

    public int getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(int id_campeonato) {
        this.id_campeonato = id_campeonato;
    }

    public int getId_arbitro() {
        return id_arbitro;
    }

    public void setId_arbitro(int id_arbitro) {
        this.id_arbitro = id_arbitro;
    }
    




}
    

