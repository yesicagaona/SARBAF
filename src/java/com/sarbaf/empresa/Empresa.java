/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.empresa;

import com.sarbaf.conn.SentenciaSQL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class Empresa {
    
    private SentenciaSQL st;

    public Empresa() {
        st=null;
    }
    
    public void consultarEmpresa(EmpresaBean empresa){
        st=new SentenciaSQL();
        ResultSet rs = st.ejecutarSelect("select * from empresa");
        if(rs!=null) {
            try {
                while (rs.next()) {
                    System.out.println("nombre empresa: "+rs.getObject("nombre_empresa")
                            + "telefono: "+rs.getObject("telefono")
                            + "direccion: "+rs.getObject("direccion_empresa")
                            + "correo_electronico: "+rs.getObject("correo_electronico"));
                }
                rs.close();
            } catch (SQLException ex) {
                System.out.println("|----> Error en Empresa.consultarEmpresa \n"+ex);
            }
        } else{
            System.out.println("|----> Resultset es nulo");
        }
        st.closeSentencia();
        st.closeConexion();
    }
    
    public void ingresarEmpresa(EmpresaBean empresa){
        st=new SentenciaSQL();
        int resultado = st.ejecutarSql("insert into empresa (nombre_empresa, telefono,direccion_empresa,correo_electronico) values "
                                  + "('"+empresa.getNombre_empresa()+"',"+empresa.getTelefono().get(0)+","
                                  + "'"+empresa.getDireccion_empresa()+"','"+empresa.getCorreo_electronico()+"')");
        if (resultado == 1) {
            System.out.println("|----> La empresa ha sido registrada . . . . OK");
        } else if (resultado == 0) {
            System.out.println("|----> La empresa no ha sido registrada . . . . .");
        } else {
            System.out.println("|----> Se generó un error al intentar registrar la empresa . . . . FAIL");
        }
        st.closeSentencia();
        st.closeConexion();
    }
}
