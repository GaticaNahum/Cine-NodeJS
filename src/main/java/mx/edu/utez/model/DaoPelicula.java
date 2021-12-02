package mx.edu.utez.model;

import mx.edu.utez.util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPelicula {
    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;

    public List<Pelicula> findAll() {
        List<Pelicula> pelicula = new ArrayList<>();
        try {
            con = ConnectionMysql.getConnection();
            String query = "SELECT id,titulo,descripcion,sinopsis,rating,fechaRegistro,fechaUpdate,estado,categoria FROM pelicula;";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Pelicula pelicula1 = new Pelicula();
                pelicula1.setId(rs.getInt("id"));
                pelicula1.setTitulo(rs.getString("titulo"));
                pelicula1.setDescripcion(rs.getString("descripcion"));
                pelicula1.setSinopsis(rs.getString("sinopsis"));
                pelicula1.setRating(rs.getInt("rating"));
                pelicula1.setFechaRegistro(rs.getString("fechaRegistro"));
                pelicula1.setFechaUpdate(rs.getString("fechaUpdate"));
                pelicula1.setEstado(rs.getInt("estado"));
                pelicula1.setCategoria(rs.getInt("categoria"));
                pelicula.add(pelicula1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return pelicula;
    }

    public Pelicula findById(int id) {
        Pelicula pelicula = new Pelicula();
        try {
            con = ConnectionMysql.getConnection();
            String query = "SELECT id,titulo,descripcion,sinopsis,rating,fechaRegistro,fechaUpdate,estado,categoria FROM pelicula WHERE id = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setSinopsis(rs.getString("sinopsis"));
                pelicula.setRating(rs.getInt("rating"));
                pelicula.setFechaRegistro(rs.getString("fechaRegistro"));
                pelicula.setFechaUpdate(rs.getString("fechaUpdate"));
                pelicula.setEstado(rs.getInt("estado"));
                pelicula.setCategoria(rs.getInt("categoria"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return pelicula;
    }



    public boolean insertPeli( boolean insert ,Pelicula pelicula,int id){
        boolean state = false;
        try{
            con = ConnectionMysql.getConnection();
            if(insert){
                String query = "INSERT INTO pelicula(titulo, descripcion, sinopsis, rating,fechaRegistro,fechaUpdate, estado, categoria) values(?,?,?,?,?,?,?,?);";
                pstm = con.prepareStatement(query);
                pstm.setString(1, pelicula.getTitulo());
                pstm.setString(2, pelicula.getDescripcion());
                pstm.setString(3, pelicula.getSinopsis());
                pstm.setInt(4, pelicula.getRating());
                pstm.setString(5, pelicula.getFechaRegistro());
                pstm.setString(6, pelicula.getFechaUpdate());
                pstm.setInt(7, pelicula.getEstado());
                pstm.setInt(8, pelicula.getCategoria());
            }else{
                String query = "UPDATE pelicula SET titulo = ?,descripcion = ?, sinopsis = ?, rating = ?, fechaUpdate = ?, estado = ?  ,categoria = ? WHERE id = ?;";
                pstm = con.prepareStatement(query);
                pstm.setString(1, pelicula.getTitulo());
                pstm.setString(2, pelicula.getDescripcion());
                pstm.setString(3, pelicula.getSinopsis());
                pstm.setInt(4, pelicula.getRating());
                pstm.setString(5, pelicula.getFechaUpdate());
                pstm.setInt(6, pelicula.getEstado());
                pstm.setInt(7, pelicula.getCategoria());
                pstm.setInt(8, id);

            }
            state = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return state;
    }

    public boolean deletePeli(int id){
        boolean state = false;
        try{
            con = ConnectionMysql.getConnection();
            String query = "delete from pelicula where id = ?;";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            state = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return state;
    }



    public void closeConnection(){
        try{
            if(con != null){
                con.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(rs != null){
                rs.close();
            }
            if(statement != null){
                statement.close();
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
