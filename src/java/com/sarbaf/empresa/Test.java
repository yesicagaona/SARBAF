/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.empresa;

import java.math.BigInteger;
import java.util.ArrayList;

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
        EmpresaBean empresabean=new EmpresaBean();
        Empresa empresa=new Empresa();
        
        empresabean.setNombre_empresa("EmpresaX");
        empresabean.setTelefono("3135501450");
        empresabean.setCorreo_electronico("empresax@corpo.com.co");
        empresabean.setDireccion_empresa("B/Cunduy");
        
//        empresa.consultarEmpresa(empresabean);
        empresa.ingresarEmpresa(empresabean);
    }
}
