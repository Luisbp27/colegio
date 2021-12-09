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
    private String dni;
    private Lista_Ref_Estudiantes_Asignaturas lrea;

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param dni
     */
    public Estudiante(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;

        this.lrea = new Lista_Ref_Estudiantes_Asignaturas();
    }

    /**
     * Método que añade una Asignatura, pasada por parámetro, a la lista de
     * referencias
     *
     * @param asignatura
     */
    public void addRefAsignatura(Asignatura asignatura) {
        lrea.addNodo(asignatura);
    }

    /**
     * Método que elimina una Asignatura, pasada por parámetro, de la lista de
     * referencias
     *
     * @param asignatura
     */
    public void removeRefAsingatura(Asignatura asignatura) {
        lrea.removeNodo(asignatura);
    }

    /**
     * Método que devuelve la referencia de la asignatura del Estudiante
     *
     * @param i
     * @return
     */
    public Asignatura getRefAsignaturaEstudiante(int i) {
        return (Asignatura) lrea.getInfoNodo(i);
    }

    /**
     * Método que devuelve la lista de Referencias Estudiante Asignatura
     *
     * @return
     */
    public Lista_Ref_Estudiantes_Asignaturas getListaRefEstudianteAsignatura() {
        return lrea;
    }

    /**
     * Método que devuelve la longitud de la lista de referencias del Estudiante
     *
     * @return
     */
    public int getSizeRef() {
        return lrea.getSize();
    }

    /**
     * Método que devuelve el valor del atributo nombre
     *
     * @return
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve el valor del atributo dni
     *
     * @return
     */
    public String getDni() {
        return dni;
    }

    /**
     * Método que modifica el contenido del atributo nombre, con el String
     * pasado por parámetro
     *
     * @param nombre
     */
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve en formato String el Estudiante
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " DNI: " + dni;
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
