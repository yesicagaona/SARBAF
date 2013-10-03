/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.conn;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            System.out.println("Conexion a Base de Datos " + url + " . . . . Ok");
        } catch (SQLException ex) {
            System.out.println("|----> Error en ConectarDB.conectar() \n"+ex);
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
        
    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando conexion a " + url + " . . . . Ok");
        } catch (SQLException ex) {
            System.out.println("|----> Error en ConectarDB.cerrarConexion() \n"+ex);
        }
        conexion = null;
    }
}
