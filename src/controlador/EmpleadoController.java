/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import modelo.Empleado;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author HOME
 */
public class EmpleadoController {

    // Métodos
    // Método insertar un registro
    public boolean insert(Empleado emp) {

        boolean flag = false;
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO `nominas`.`empleados`(`nombre`, `cedula`, `salario`, `aporteSalud`, `aportePension`, `aporteArl`, `totalDevengado`) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);

            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getCedula());
            ps.setDouble(3, emp.getSalario());
            ps.setDouble(4, emp.getAporteSalud());
            ps.setDouble(5, emp.getAportePension());
            ps.setDouble(6, emp.getAporteArl());
            ps.setDouble(7, emp.getTotalDevengado());
            
            
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Insertado");
            } else {
                System.out.println("No se a podido insertar");
                flag = false;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return flag;
    }

    // Mostrar un registro
    public Empleado indexOne(String cedula) {

        Empleado emp = new Empleado();
        String sql = ("SELECT * FROM empleados WHERE cedula = ?");

        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cedula"),
                        rs.getDouble("salario"),
                        rs.getDouble("aporteSalud"),
                        rs.getDouble("aportePension"),
                        rs.getDouble("aporteArl"),
                        rs.getDouble("totalDevengado")
                );
            }
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return emp;
    }

    public List<Empleado> index() {

        List<Empleado> lista = new LinkedList<Empleado>();
        String sql = ("SELECT * FROM empleados");
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Empleado emp;
 
            while(rs.next()){
                 emp = new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("cedula"), rs.getDouble("salario"), rs.getDouble("aporteSalud"), rs.getDouble("aportePension"), rs.getDouble("aporteArl"), rs.getDouble("totalDevengado"));
                lista.add(emp);
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
        return lista;
    }

    // Método actualizar registro
    public boolean update(Empleado emp) {

        boolean flag = false;
        Conexion conexion = new Conexion();

        String sql = ("UPDATE empleados SET nombre = ?, cedula = ?, salario = ?, aporteSalud = ?, aportePension = ?, aporteArl = ?, totalDevengado = ? WHERE id = ?");

        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);

            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getCedula());
            ps.setDouble(3, emp.getSalario());
            ps.setDouble(4, emp.getAporteSalud());
            ps.setDouble(5, emp.getAportePension());
            ps.setDouble(6, emp.getAporteArl());
            ps.setDouble(7, emp.getTotalDevengado());
            ps.setInt(8, emp.getId());

            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("Actualizado");
            } else {
                System.out.println("No se a podido actualizar");
            }
            conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return flag;
    }

    //  Salario menor
    public List<Empleado> menorSalario() {

        List<Empleado> lista = new LinkedList<Empleado>();
        String sql = ("SELECT * FROM empleados WHERE salario = (SELECT MIN(salario) FROM empleados)");

        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Empleado emp;

            if(rs.next()){
                 emp = new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("cedula"), rs.getDouble("salario"), rs.getDouble("aporteSalud"), rs.getDouble("aportePension"), rs.getDouble("aporteArl"), rs.getDouble("totalDevengado"));
                lista.add(emp);
            }else{
                System.out.println("Error al obtener la información. ");
            }
            
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return lista;
    }
    
    // Salario total
    
    public void totalSalario(){
        
       
        String sql = ("SELECT SUM(salario) as salario FROM empleados");
        
        try{
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             
            if(rs.next()){
                System.out.println("Valor Total en Salarios: $" + rs.getDouble("salario"));
            }else{
                System.out.println("Error al consultar el valor total en salarios");
            }
            
        }catch(SQLException e){
            System.out.println("Error : " + e);
        }
      
    }
}
