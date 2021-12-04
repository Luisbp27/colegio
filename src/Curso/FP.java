/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Asignatura.Asignatura;
import Lista.ListaAsignaturas;



/**
 *
 * @author luisb
 */
public class FP extends Curso {

    private Especialidad especialidad;
    
    public enum Especialidad {
        INFORMÁTICA, MECÁNICA, ELECTRÓNICA;
    }
    
    public FP(String nombre, int codigo, Especialidad especialidad) {
        super(nombre, codigo);
        
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "FP: "+ codigo + " - " + nombre + " - " + especialidad;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setNombre(String name) {
            this.nombre=name;
    }

    @Override
    public void setCodigo(int cod) {
        this.codigo=cod;
    }
    
    @Override
    public ListaAsignaturas getListaAsignaturas() {
        return this.lista_curso_asignatura;
    }
    
    @Override
    public Asignatura getAsignaturaRef(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSizeRef() {
        return lista_curso_asignatura.getSize();
    }

    @Override
    public void add(Object x) {
        lista_curso_asignatura.add(x); 
    }

    @Override
    public void remove(Object x) {
        lista_curso_asignatura.removeAsignatura(x);
    }
    
    
}

