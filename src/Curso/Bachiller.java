/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Asignatura.Asignatura;

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
        return nombre;
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
    public Asignatura getAsignaturaRef(int i) {
        return lista_curso_asignatura;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
