/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiante;

import Asignatura.Asignatura;
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
        
        this.lrea = new Lista_Ref_Estudiantes_Asignaturas();
    }
    
    public void addAsignatura(Asignatura asignatura) {
        lrea.addAsignatura(asignatura);
    }
    
    public void remove(Asignatura asignatura) {
        lrea.removeNodo(asignatura);
    }
    
    public Asignatura getRefAsignaturaEstudiante(int i) {
        return (Asignatura) lrea.getInfo(i);
    }
    
    public int getSizeRef() {
        return lrea.getSize();
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

    @Override
    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodigo(int Codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
