/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.conn;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class ConectarDB {

    private Connection conexion = null;
    private String servidor = "localhost:3306";
    private String database = "ejemplo";
    private String usuario = "root";
    private String password = "root";
    private String url = "";

    public ConectarDB() {}

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            url = "jdbc:mysql://" + servidor + "/" + database;
            conexion = (Connection) DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos " + url + " . . . . .Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public ConectarDB(String servidor, String database, String usuario, String password) {
        this.servidor=servidor;
        this.database=database;
        this.usuario=usuario;
        this.password=password;
    }

    public Connection getConexion() {
        return conexion;
    }
        
    public Connection cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando conexion a " + url + " . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion = null;
        return conexion;
    }
}
