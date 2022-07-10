/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author HOME
 */
public class Empleado {
    
    // Variables
    public int id;
    public String nombre, cedula;
    public double salario, aporteSalud, aportePension, aporteArl, totalDevengado;
    
    // Aportes a Seguridad Social
    private double ivaSalud = 0.085; // 8.5%
    private double ivaPension = 0.12; // 12%
    private double ivaArl = 0.00522; // 0.52%
    // Métodos 
     public Empleado() {
        
    }
    // Método constructor
    public Empleado(int id, String nombre, String cedula, double salario, double aporteSalud, double aportePension, double aporteArl, double totalDevengado)
    {
      this.id = id;
      this.nombre = nombre;
      this.cedula = cedula;
      this.salario = salario;
      this.aporteSalud = aporteSalud;
      this.aportePension = aportePension;
      this.aporteArl = aporteArl;
      this.totalDevengado = totalDevengado;
    }
    
    // Getter y Setter
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAporteSalud() {
        
        double aporte = salario * ivaSalud;
        return Math.round(aporteSalud = aporte);
    }

    public void setAporteSalud(double aporteSalud) {
        this.aporteSalud = aporteSalud;
    }

    public double getAportePension() {
        double aporte = salario * ivaPension;
        return Math.round(aportePension = aporte);
    }

    public void setAportePension(double aportePension) {
        this.aportePension = aportePension;
    }

    public double getAporteArl() {
        double aporte = salario * ivaArl;
        return Math.round(aporteArl = aporte);
    }

    public void setAporteArl(double aporteArl) {
        this.aporteArl = aporteArl;
    }

    public double getTotalDevengado() {
        
        double total = getAporteSalud() + getAportePension() + getAporteArl();
        double subtotal = salario - total;
        return Math.round(totalDevengado = subtotal);
    }

    public void setTotalDevengado(double totalDevengado) {
        this.totalDevengado = totalDevengado;
    }
    
}
