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
public class Bachiller extends Curso {

    private Año año;

    public enum Año {
        PRIMERO, SEGUNDO;
    }

    public Bachiller(String nombre, int codigo, Año año) {
        super(nombre, codigo);

        this.año = año;
    }

    @Override
    public String toString() {
        return "BACHILLER: " + codigo + " - " + nombre + " - " + año;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setNombre(String name) {
        this.nombre = name;
    }

    @Override
    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    @Override
    public ListaAsignaturas getListaAsignaturas() {
        return this.lista_curso_asignatura;
    }
    
    @Override
    public Asignatura getAsignaturaRef(int i) {
        return (Asignatura)lista_curso_asignatura.getObject(i);
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
