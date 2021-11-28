/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.Connection;
import conexion.Conexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Arbitro;
import modelo.Campeonato;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;

/**
 *
 * @author TonyMontanaPC
 */
public class Registro {

    public boolean agregarJugador(Jugador jugador) {

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

    public boolean agregarEquipo(Equipo equipo) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO equipo(id_equipo,nombre,cancha_local)VALUES (?,?,?)";
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

    public boolean agregarArbitro(Arbitro arbitro) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO arbitro(id_arbitro,asignado,nombre)VALUES (?,?,?)";
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
    
    public boolean agregarEquipoCampeonato(Equipo equipo, Campeonato campeonato) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO EquipoCampeonato(equipo_id_equipo,campeonato_id_campeonato)VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, equipo.getId_equipo());
            stmt.setInt(2, campeonato.getId_campeonato());
            

            stmt.executeUpdate();
            cnx.close();
            stmt.close();
            System.out.println("Equipo insertado correctamente");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo insertar equipo al campeonato " + e.getMessage());
            return false;
        }
    }
     
    public boolean agregarPartido(Partido partido){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO partido(id_partido,duracion_min,id_arbitro,id_campeonato,cancha,fecha) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, partido.getId_partido());
            stmt.setInt(2, partido.getDuracion_min());
            stmt.setString(3, partido.getCancha());
            stmt.setDate(4, (Date) partido.getFecha());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo agregar partido "+e.getMessage());
            return false;
        }
    }
    
    public boolean agregarEquipoPartido(Equipo equipo,Partido partido){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
        
            String query = "INSERT INTO equipopartido (equipo_id_equipo,partido_id_partido) VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, equipo.getId_equipo());
            stmt.setInt(2, partido.getId_partido());
        
            stmt.executeQuery();
            stmt.close();
            cnx.close();
            return true;
        } catch (Exception e) {            
            return false;
        }                        
    }        
    
    public boolean eliminarArbitro(int id_arbitro){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM arbitro WHERE id_arbitro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_arbitro);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el arbitro "+e.getMessage());
            return false;
        }
    }

    public boolean eliminarCampeonato(int id_campeonato){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM campeonato WHERE id_campeonato=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_campeonato);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el campeonato "+e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarEquipo(int id_equipo){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM equipo WHERE id_equipo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_equipo);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el equipo"+e.getMessage());
            return false;
        }
    }

    public boolean eliminarJugador(int id_jugador){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM jugador WHERE id_jugador=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_jugador);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar jugador"+e.getMessage());
            return false;
        }
    }

    public boolean eliminarPartido(int id_partido){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM partido WHERE id_partido=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_partido);
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar partido"+e.getMessage());
            return false;
        }
    }

    public Arbitro buscarArbitro(int id_arbitro) {

        Arbitro arbitro = new Arbitro();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT id_arbitro,asignado,nombre FROM arbitro WHERE id_arbitro=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_arbitro);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                arbitro.setId_arbitro(rs.getInt("id_arbitro"));
                arbitro.setAsignado(rs.getBoolean("asignado"));
                arbitro.setNombre(rs.getString("nombre"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar arbitro " + e.getMessage());
        }
        return arbitro;
    }

    public Campeonato buscarCampeonato(int id_campeonato) {

        Campeonato campeonato = new Campeonato();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT id_campeonato,cant_equipos FROM campeonato WHERE id_campeonato=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_campeonato);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                campeonato.setId_campeonato(rs.getInt("id_campeonato"));
                campeonato.setCant_equipos(rs.getInt("cant_equipos"));
                
                
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar campeonato " + e.getMessage());
        }
        return campeonato;
    }

    public Equipo buscarEquipo(int id_equipo) {

        Equipo equipo = new Equipo();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT id_equipo,nombre,cancha_local FROM equipo WHERE id_equipo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_equipo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                equipo.setId_equipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));
                equipo.setCancha_local(rs.getString("cancha_local"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar equipo " + e.getMessage());
        }
        return equipo;
    }

    public Jugador buscarJugador(int id_jugador) {

        Jugador jugador = new Jugador();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT id_jugador,pnombre,apaterno,posicion,id_equipo FROM jugador WHERE id_jugador=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_jugador);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                jugador.setId_jugador(rs.getInt("id_equipo"));
                jugador.setPnombre(rs.getString("pnombre"));
                jugador.setApaterno(rs.getString("apaterno"));
                jugador.setPosicion(rs.getString("posicion"));
                jugador.setId_equipo(rs.getInt("id_equipo"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar jugador " + e.getMessage());
        }
        return jugador;
    }

    public Partido buscarPartido(int id_partido) {

        Partido partido = new Partido();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT id_partido,duracion_min,id_arbitro,cancha,fecha FROM partido WHERE id_partido=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_partido);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                partido.setId_partido(rs.getInt("id_partido"));
                partido.setDuracion_min(rs.getInt("duracion_min"));
                partido.setCancha(rs.getString("cancha"));
                partido.setFecha(rs.getDate("fecha"));
                partido.setId_arbitro(rs.getInt("id_arbitro"));
                
                
            }
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error SQL al listar partido " + e.getMessage());
        }
        return partido;            
    }
    
    public List<Jugador> listarJugadores(int id_equipo){
        List<Jugador> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM jugador where equipo_id_equipo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_equipo);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.setId_jugador(rs.getInt("id_jugador"));
                jugador.setPnombre(rs.getString("pnombre"));
                jugador.setApaterno(rs.getString("apaterno"));
                jugador.setPosicion(rs.getString("posicion"));
                jugador.setId_equipo(rs.getInt("equipo_id_equipo"));
                lista.add(jugador);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar jugadores "+ e.getMessage());
        }
        return lista;
    }
    
    public List<Partido> listarPartidos(int id_campeonato){
        List<Partido> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM partido where campeonato_id_campeonato=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_campeonato);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Partido partido = new Partido();
                partido.setId_partido(rs.getInt("id_partido"));
                partido.setDuracion_min(rs.getInt("duracion_min"));
                partido.setId_campeonato(rs.getInt("id_campeonato"));
                partido.setId_arbitro(rs.getInt("id_arbitro"));                
                lista.add(partido);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar partidos "+ e.getMessage());
        }
        return lista;
    }
}

