/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Jugador {
    private int id_jugador;
    private String pnombre,apaterno,posicion;
    private int id_equipo;

    public Jugador() {
    }

    public Jugador(int id_jugador, String pnombre, String apaterno, String posicion, int id_equipo) {
        this.id_jugador = id_jugador;
        this.pnombre = pnombre;
        this.apaterno = apaterno;
        this.posicion = posicion;
        this.id_equipo = id_equipo;
    }

    public int getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    
}
