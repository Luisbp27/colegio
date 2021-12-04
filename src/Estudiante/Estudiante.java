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
        lrea.setObject(asignatura);
    }
    
    public void remove(Asignatura asignatura) {
        lrea.removeObject(asignatura);
    }
    
    public Asignatura getRefAsignaturaEstudiante(int i) {
        return (Asignatura) lrea.getObject(i);
    }
    
    public int getSizeRef() {
        return lrea.getSize();
    }
    

    
     @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCodigo() {
        return dni;
    }

    @Override
    public void setNombre(String name) {
            this.nombre=name;
    }

    @Override
    public void setCodigo(int cod) {
        this.dni=cod;
    }

}
