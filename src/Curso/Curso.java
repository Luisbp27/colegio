/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Asignatura.Asignatura;
import Interfaz.InterfazDatos;
import Lista.ListaAsignaturas;

/**
 *
 * @author luisb
 */
public abstract class Curso implements InterfazDatos {

    protected String nombre;
    protected int codigo;

    // Apuntador a la lista asignaturas del curso
    protected ListaAsignaturas lista_curso_asignatura;

    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;

        // Inicilamente lista y apuntador vacíos
        this.lista_curso_asignatura = new ListaAsignaturas();
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

    public abstract ListaAsignaturas getListaAsignaturas();

    public abstract void setListaAsignaturas(ListaAsignaturas listaAsignaturas);

    public abstract Asignatura getAsignaturaRef(int i);

    public abstract int getSizeRef();

    public abstract void add(Object x);

    public abstract void remove(Object x);
}
