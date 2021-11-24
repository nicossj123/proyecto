/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Equipo {
    private int id_equipo;
    private String nombre,cancha_local;

    public Equipo() {
    }

    public Equipo(int id_equipo, String nombre, String cancha_local) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.cancha_local = cancha_local;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCancha_local() {
        return cancha_local;
    }

    public void setCancha_local(String cancha_local) {
        this.cancha_local = cancha_local;
    }

    
    
    
}
