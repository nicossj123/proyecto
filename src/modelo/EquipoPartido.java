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
public class EquipoPartido {
    private int equipo_id_equipo,partido_id_partido;

    public EquipoPartido() {
    }

    public EquipoPartido(int equipo_id_equipo, int partido_id_partido) {
        this.equipo_id_equipo = equipo_id_equipo;
        this.partido_id_partido = partido_id_partido;
    }

    public int getEquipo_id_equipo() {
        return equipo_id_equipo;
    }

    public void setEquipo_id_equipo(int equipo_id_equipo) {
        this.equipo_id_equipo = equipo_id_equipo;
    }

    public int getPartido_id_partido() {
        return partido_id_partido;
    }

    public void setPartido_id_partido(int partido_id_partido) {
        this.partido_id_partido = partido_id_partido;
    }

    


}
