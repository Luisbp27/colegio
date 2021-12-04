/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Asignatura.Asignatura;
import Interfaz.InterfazDatos;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista_Ref.Lista_Ref_Asignaturas;

/**
 *
 * @author luisb
 */
public abstract class Curso implements InterfazDatos {
    
    protected String nombre;
    protected int codigo;
    //protected ListaCursos lc; no se necesita no?
    //apuntador a la lista asignaturas del curso
    protected ListaAsignaturas lista_curso_asignatura;
    
    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        //inicilamente lista y apuntador vacíos
        this.lista_curso_asignatura=new ListaAsignaturas();
       // this.lc = new ListaCursos(); no se necesita no?
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public abstract String getNombre();
    
    @Override
    public abstract int getCodigo();
    
    @Override
    public abstract void setNombre(String name);
    
    @Override
    public abstract void setCodigo(int cod);

    public abstract Asignatura getAsignaturaRef(int i);

    public abstract int getSizeRef();

    public abstract void add(Object x);

    public abstract void remove(Object x);
    
}
