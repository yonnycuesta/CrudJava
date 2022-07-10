/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EmpleadoController;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import modelo.Empleado;

/**
 *
 * @author HOME
 */
public class EmpleadoView {

    public void mostrar() {

        Scanner sc = new Scanner(System.in);

        // Instancias a las otras clases
        Empleado emp = new Empleado(); // modelo
        EmpleadoController empc = new EmpleadoController(); // controlador

        // Lista de empleados
        List<Empleado> l = new LinkedList<Empleado>();

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int entrada; // opcion para guardar o no la entrada
        
        while (!salir) {
            System.out.println(">---MENÙ PRINCIPAL---<");
            System.out.println("1. Ingresar nuevo registro");
            System.out.println("2. Modificar un registro");
            System.out.println("3. Datos estadisticos");
            System.out.println("4. Consultar un registro");
            System.out.println("5. Imprimir todos los registros");
            System.out.println("6. Salir");

            System.out.println("Seleccione una de las opciones anteriores:");
            opcion = sc.nextInt();

       
            switch (opcion) {
                case 1:
                    System.out.println("<-- INGRESAR NUEVO REGISTRO -->");

                    System.out.println("Ingresar nombre:");
                    emp.setNombre(sc.next());
                    sc.nextLine();

                    System.out.println("Ingresar cedula:");
                    emp.setCedula(sc.next());
                    sc.nextLine();

                    System.out.println("Ingresar salario:");
                    emp.setSalario(sc.nextDouble());
                    sc.nextLine();

                    System.out.println("¿Es correcta la información que desea agregar, (1) para si y cualquier otro número para no?");
                    entrada = sc.nextInt();

                    if (entrada == 1) {
                        empc.insert(emp);
                        break;
                    } else {
                        break;
                    }

                case 2:
                    System.out.println("<-- MODIFICAR REGISTRO -->");

                    l = empc.index();
                    
                    for (Empleado emp1 : l){
                         System.out.format("%10s %10s %10s %10s %10s %15s %10s %13s",   emp1.getId(), emp1.getNombre(), emp1.getCedula(), emp1.getSalario(), emp1.getAporteSalud(), emp1.getAportePension(), emp1.getAporteArl(), emp1.getTotalDevengado());
                         System.out.println();
                    }

                    System.out.println("Ingrese el id del empleado a editar:");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Ingresar nombre:");
                    emp.setNombre(sc.next());
                    sc.nextLine();

                    System.out.println("Ingresar cedula:");
                    emp.setCedula(sc.next());
                    sc.nextLine();

                    System.out.println("Ingresar salario:");
                    emp.setSalario(sc.nextDouble());
                    sc.nextLine();

                    empc.update(emp);

                    break;
                case 3:
                    System.out.println("<-- DATOS ESTADISTICOS -->");
                    l = empc.menorSalario();
                   
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    System.out.println("Salario Menor:");
                    System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s", "ID", "NOMBRE", "CÉDULA", "SALARIO", "APORTE SALUD", "APORTE PENSIÓN", "APORTE ARL", "TOTAL DEVENGADO");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------------------------------------");
              
                    for (Empleado emp1 : l){
                        System.out.format("%10s %10s %10s %10s %10s %15s %10s %13s",   emp1.getId(), emp1.getNombre(), emp1.getCedula(), emp1.getSalario(), emp1.getAporteSalud(), emp1.getAportePension(), emp1.getAporteArl(), emp1.getTotalDevengado());
                        System.out.println();
                    }
                    
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    empc.totalSalario();
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    
                    break;
                case 4:
                    System.out.println("<-- CONSULTAR UN REGISTRO -->");
                    System.out.println("Ingrese la cédula del empleado");
                    emp = empc.indexOne(sc.next());
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s", "ID", "NOMBRE", "CÉDULA", "SALARIO", "APORTE SALUD", "APORTE PENSIÓN", "APORTE ARL", "TOTAL DEVENGADO");
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    System.out.format("%10s %10s %10s %10s %10s %15s %10s %13s", emp.getId(), emp.getNombre(), emp.getCedula(), emp.getSalario(), emp.getAporteSalud(), emp.getAportePension(), emp.getAporteArl(), emp.getTotalDevengado());
                  
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------------------------------");

                    break;
                case 5:
                    System.out.println("<-- MOSTRAR TODOS LOS REGISTROS -->");
                    l = empc.index();
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s", "ID", "NOMBRE", "CÉDULA", "SALARIO", "APORTE SALUD", "APORTE PENSIÓN", "APORTE ARL", "TOTAL DEVENGADO");
                    System.out.println();
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    
                    for (Empleado emp1 : l){
                         System.out.format("%10s %10s %10s %10s %10s %15s %10s %13s",   emp1.getId(), emp1.getNombre(), emp1.getCedula(), emp1.getSalario(), emp1.getAporteSalud(), emp1.getAportePension(), emp1.getAporteArl(), emp1.getTotalDevengado());
                         System.out.println();
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    break;
                    
                case 6:
                    System.out.println("¡Salida exitosa!.");
                    salir = true;
                    System.exit(0);
                default:
                    System.out.println("¡Puedes ingresar números entre 1 y 6!");
            }
            
        }

    }

}
