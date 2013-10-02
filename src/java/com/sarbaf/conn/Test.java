/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SentenciaSQL st=new SentenciaSQL();
        ResultSet ejecutarSelect = st.ejecutarSelect("select * from users");
        if(ejecutarSelect!=null){
            try {
                System.out.println("|--------------------------------------|");
                while (ejecutarSelect.next()) {
                    System.out.println("|---> Nombre: "+ejecutarSelect.getObject("nombres")+" "+
                            ejecutarSelect.getObject("apellidos"));
                }
                System.out.println("|--------------------------------------|");
                ejecutarSelect.close();
                st.closeSentencia();
                st.closeConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
