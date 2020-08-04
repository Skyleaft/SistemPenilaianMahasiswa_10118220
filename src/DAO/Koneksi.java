/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

/**
 *
 * @author Milzan-PC
 */
public class Koneksi {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public String query;
    public int count;
    public PreparedStatement ps;

    private String port, ip, db, user, pass;

    public void setDB() {
        ip = "localhost";
        port = "3306";
        db = "java_akdmk";
        user = "root";
        pass = "";
    }

    public void konek() {
        try {
            setDB();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+db+"", user, pass);
            st = (Statement) con.createStatement();
            //System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("error di method konek" + e);
        }
    }

    public void ambil(){
        try {
            konek();
            rs=st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("error di method ambil "+e);
        }
    }

    public void crud(){
        try {
            konek();
            count = st.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Ada error di crud "+e);
        }
    }

    public void crudstatement() throws SQLException{
        try{
            ps = con.prepareStatement(query);
        } catch(SQLException ex){
            System.out.println("Error "+ ex);
        }
    }
}
