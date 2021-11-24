/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.Connection;
import conexion.Conexion;
import java.sql.SQLException;
import modelo.Arbitro;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author TonyMontanaPC
 */
public class Registro {

    public boolean agregarJugador(Jugador jugador){

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO jugador(id_jugador,pnombre,apaterno,posicion,equipo_id_equipo)VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, jugador.getId_equipo());
            stmt.setString(2, jugador.getPnombre());
            stmt.setString(3, jugador.getApaterno());
            stmt.setString(4, jugador.getPosicion());
            stmt.setInt(5, jugador.getId_equipo());

            stmt.executeUpdate();
            cnx.close();
            stmt.close();
            System.out.println("Jugador insertado correctamente");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo insertar jugador " + e.getMessage());
            return false;
        }            
    }
    
    public boolean agregarEquipo(Equipo equipo){

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO jugador(id_equipo,nombre,cancha_local)VALUES (?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, equipo.getId_equipo());
            stmt.setString(2, equipo.getNombre());
            stmt.setString(3, equipo.getCancha_local());           

            stmt.executeUpdate();
            cnx.close();
            stmt.close();
            System.out.println("Equipo insertado correctamente");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo insertar equipo " + e.getMessage());
            return false;
        }


    }

        public boolean agregarArbitro(Arbitro arbitro){

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO jugador(id_arbitro,asignado,nombre)VALUES (?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, arbitro.getId_arbitro());
            stmt.setBoolean(2, arbitro.isAsignado());
            stmt.setString(3, arbitro.getNombre());            

            stmt.executeUpdate();
            cnx.close();
            stmt.close();
            System.out.println("Arbitro insertado correctamente");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo insertar arbitro " + e.getMessage());
            return false;
        }            
    }

}


