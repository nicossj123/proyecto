/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author tomaz
 */
public class JugadorPartido {
    private int jugador_id_jugador,partido_id_partido;

    public JugadorPartido() {
    }

    public JugadorPartido(int jugador_id_jugador, int partido_id_partido) {
        this.jugador_id_jugador = jugador_id_jugador;
        this.partido_id_partido = partido_id_partido;
    }

    public int getJugador_id_jugador() {
        return jugador_id_jugador;
    }

    public void setJugador_id_jugador(int jugador_id_jugador) {
        this.jugador_id_jugador = jugador_id_jugador;
    }

    public int getPartido_id_partido() {
        return partido_id_partido;
    }

    public void setPartido_id_partido(int partido_id_partido) {
        this.partido_id_partido = partido_id_partido;
    }

    
}
