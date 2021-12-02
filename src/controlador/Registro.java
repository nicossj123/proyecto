/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.Connection;
import conexion.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Arbitro;
import modelo.Campeonato;
import modelo.Equipo;
import modelo.Jugador;
import modelo.Partido;
import java.util.Date;

/**
 *
 * @author TonyMontanaPC
 */
public class Registro {

    public boolean agregarCampeonato(Campeonato campeonato) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO campeonato(id_campeonato,cant_equipos)VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //stmt.setInt(1, jugador.getId_equipo());
            stmt.setInt(1, campeonato.getId_campeonato());
            stmt.setInt(2, campeonato.getCant_equipos());
            

            stmt.executeUpdate();
            cnx.close();
            stmt.close();
            System.out.println("Campeonato insertado correctamente");
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo insertar campeonato" + e.getMessage());
            return false;
        }
    }
    
    public boolean agregarJugador(Jugador jugador) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO jugador(nombre,apaterno,posicion,id_equipo)VALUES (?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //stmt.setInt(1, jugador.getId_equipo());
            stmt.setString(1, jugador.getPnombre());
            stmt.setString(2, jugador.getApaterno());
            stmt.setString(3, jugador.getPosicion());
            stmt.setInt(4,jugador.getId_equipo());

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

            String query = "INSERT INTO equipo(nombre,cancha_local)VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //stmt.setInt(1, equipo.getId_equipo());
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getCancha_local());

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

            String query = "INSERT INTO arbitro(asignado,nombre)VALUES (?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            //stmt.setInt(1, arbitro.getId_arbitro());
            stmt.setBoolean(1, arbitro.isAsignado());
            stmt.setString(2, arbitro.getNombre());

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
    
     
    public boolean agregarPartido(Partido partido){
        Date date;
        try {
            
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO partido(duracion_min,id_arbitro,id_campeonato,cancha,fecha) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            date = partido.getFecha();
            stmt.setInt(1, partido.getDuracion_min());
            stmt.setInt(2, partido.getId_arbitro());            
            stmt.setInt(3, partido.getId_campeonato());
            stmt.setString(4, partido.getCancha());
            stmt.setDate(5, new java.sql.Date(date.getTime()));
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("No se pudo agregar partido sql "+e.getMessage());
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

            String query = "SELECT id_partido,duracion_min,id_arbitro,id_campeonato,cancha,fecha FROM partido WHERE id_partido=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_partido);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                partido.setId_partido(rs.getInt("id_partido"));
                partido.setDuracion_min(rs.getInt("duracion_min"));
                partido.setId_arbitro(rs.getInt("id_arbitro"));
                partido.setId_campeonato(rs.getInt("id_campeonato"));
                partido.setCancha(rs.getString("cancha"));
                partido.setFecha(rs.getDate("fecha"));
                
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
            
            String query = "SELECT * FROM jugador where id_equipo=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_equipo);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Jugador jugador = new Jugador();
                jugador.setId_jugador(rs.getInt("id_jugador"));
                jugador.setPnombre(rs.getString("pnombre"));
                jugador.setApaterno(rs.getString("apaterno"));
                jugador.setPosicion(rs.getString("posicion"));
                jugador.setId_equipo(rs.getInt("id_equipo"));
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
            
            String query = "SELECT * FROM partido where id_campeonato=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_campeonato);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Partido partido = new Partido();
                partido.setId_partido(rs.getInt("id_partido"));
                partido.setDuracion_min(rs.getInt("duracion_min"));
                partido.setId_arbitro(rs.getInt("id_arbitro"));
                partido.setId_campeonato(rs.getInt("id_campeonato"));
                partido.setCancha(rs.getString("cancha"));
                partido.setFecha(rs.getDate("fecha"));
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

    public List<Arbitro> listarArbitros(){
        List<Arbitro> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT id_arbitro,asignado,nombre FROM arbitro";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Arbitro arbitro = new Arbitro();
                arbitro.setId_arbitro(rs.getInt("id_arbitro"));
                arbitro.setAsignado(rs.getBoolean("asignado"));
                arbitro.setNombre(rs.getString("nombre"));
                lista.add(arbitro);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar arbitros "+ e.getMessage());
        }
        return lista;
    }

    public List<Partido> listarPartidos2(){
        List<Partido> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM partido";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Partido partido = new Partido();
                partido.setId_partido(rs.getInt("id_partido"));
                partido.setDuracion_min(rs.getInt("duracion_min"));
                partido.setId_arbitro(rs.getInt("id_arbitro"));
                partido.setId_campeonato(rs.getInt("id_campeonato"));
                partido.setCancha(rs.getString("cancha"));
                partido.setFecha(rs.getDate("fecha"));
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
    
    public boolean insertarArbitro(int id_arbitro,int id_partido){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
        
            String query = "UPDATE partido SET id_arbitro=? WHERE id_partido=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_arbitro);
            stmt.setInt(2, id_partido);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        }
        
        catch (SQLException e) {
            System.out.println("No se pudo ingresar arbitro a partido"+e.getMessage());
            return false;
        }
        
    }
    
    public List<Campeonato> listarCampeonatos(){
        List<Campeonato> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM campeonato";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Campeonato campeonato = new Campeonato();
                campeonato.setId_campeonato(rs.getInt("id_campeonato"));
                campeonato.setCant_equipos(rs.getInt("cant_equipos"));                
                lista.add(campeonato);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar campeonatos "+ e.getMessage());
        }
        return lista;
    }

    public boolean insertarPartido(int id_partido,int id_campeonato){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
        
            String query = "UPDATE partido SET id_campeonato=? WHERE id_partido=?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, id_campeonato);
            stmt.setInt(2, id_partido);
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        }
        
        catch (SQLException e) {
            System.out.println("No se pudo ingresar campeonato a partido"+e.getMessage());
            return false;
        }
        
    }
    
    public List<Equipo> listarEquipos(){
        List<Equipo> lista = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "SELECT * FROM equipo";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Equipo equipo = new Equipo();
                equipo.setId_equipo(rs.getInt("id_equipo"));
                equipo.setNombre(rs.getString("nombre"));  
                equipo.setCancha_local(rs.getString("cancha_local"));
                lista.add(equipo);
            }
            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println("Error SQL al listar equipos "+ e.getMessage());
        }
        return lista;
    }
    
//    public List<Jugador> listarJugadores(int id_equipo){
//        List<Jugador> lista = new ArrayList<>();
//        try {
//            Conexion con = new Conexion();
//            Connection cnx = con.obtenerConexion();
//            
//            String query = "SELECT * FROM jugador where id_equipo=?";
//            PreparedStatement stmt = cnx.prepareStatement(query);
//            stmt.setInt(1, id_equipo);
//            
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()){
//                Jugador jugador = new Jugador();
//                jugador.setId_jugador(rs.getInt("id_jugador"));
//                jugador.setPnombre(rs.getString("pnombre"));
//                jugador.setApaterno(rs.getString("apaterno"));
//                jugador.setPosicion(rs.getString("posicion"));
//                jugador.setId_equipo(rs.getInt("id_equipo"));                
//                lista.add(jugador);
//            }
//            rs.close();
//            stmt.close();
//            cnx.close();
//        } catch (SQLException e) {
//            System.out.println("Error SQL al listar jugadores "+ e.getMessage());
//        }
//        return lista;
}






