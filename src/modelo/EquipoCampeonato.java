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
public class EquipoCampeonato {
   private int id_equipo, id_campeonato;

    public EquipoCampeonato() {
    }

    public EquipoCampeonato(int id_equipo, int id_campeonato) {
        this.id_equipo = id_equipo;
        this.id_campeonato = id_campeonato;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(int id_campeonato) {
        this.id_campeonato = id_campeonato;
    }
   
   
}
