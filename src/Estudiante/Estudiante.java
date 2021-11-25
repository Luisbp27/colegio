/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

import Interfaz.InterfazDatos;
import Lista_Ref.Lista_Ref_Estudiantes_Asignaturas;

/**
 *
 * @author luisb
 */
public class Estudiante implements InterfazDatos {
    
    private String nombre;
    private int dni;
    private Lista_Ref_Estudiantes_Asignaturas lrea;
    
    public Estudiante(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public void add() {
        
    }

    /**
     * Método que devuelve el valor del atributo nombre
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el valor del atributo dni
     * 
     * @return 
     */
    public int getDni() {
        return dni;
    }
}
