/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Asignatura.Asignatura;
import Interfaz.InterfazDatos;
import Lista.ListaCursos;

/**
 *
 * @author luisb
 */
public abstract class Curso implements InterfazDatos {
    
    protected String nombre;
    protected int codigo;
    protected ListaCursos lc;
    
    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.lc = new ListaCursos();
    }
    
    @Override
    public abstract String toString();
    
    public abstract String getNombre();
    
    public abstract int getCodigo();
    
    public abstract void setNombre(String name);
    
    public abstract void setCodigo(int cod);

    public abstract Asignatura getAsignaturaRef(int i);

    public abstract int getSizeRef();

    public abstract void add(Object x);

    public abstract void remove(Object x);
    
}
