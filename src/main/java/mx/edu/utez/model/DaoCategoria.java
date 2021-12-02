package mx.edu.utez.model;

import mx.edu.utez.util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria {
    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;

    public List<Categoria> findAll() {
        List<Categoria> customers = new ArrayList<>();
        try {
            con = ConnectionMysql.getConnection();
            String query = "SELECT id,nombre FROM categoria;";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
                customers.add(categoria);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return customers;
    }

    public Categoria findById(int id) {
        Categoria categoria = new Categoria();
        try {
            con = ConnectionMysql.getConnection();
            String query = "SELECT id,nombre FROM categoria WHERE id = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return categoria;
    }


    public boolean insertCategory( boolean insert, Categoria categoria,int id){
        boolean state = false;
        try{
            con = ConnectionMysql.getConnection();
            if(insert){
                String query = "INSERT INTO categoria(nombre) values(?);";
                pstm = con.prepareStatement(query);
                pstm.setString(1, categoria.getNombre());

            }else{
                String query = "UPDATE categoria SET nombre = ? WHERE id = ?;";
                pstm = con.prepareStatement(query);
                pstm.setString(1, categoria.getNombre());
                pstm.setInt(2,id);
            }
            state = pstm.executeUpdate() == 1;
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            closeConnection();
        }
        return state;
    }


    public boolean delete(int id){
        boolean state = false;
        try{
            con = ConnectionMysql.getConnection();
            String query = "delete from categoria where id = ?;";
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
