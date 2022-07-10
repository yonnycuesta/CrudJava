/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nominasempleados;

import conexion.Conexion;
import controlador.EmpleadoController;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import modelo.Empleado;
import vista.EmpleadoView;

/**
 *
 * @author HOME
 */
public class nominasEmpleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Conexion c = new Conexion();
        c.conectar();

        EmpleadoView emv = new EmpleadoView();
        emv.mostrar();
        
    }

}
