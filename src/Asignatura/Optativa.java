/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 * F
 *
 * @author luisb
 */
public class Optativa extends Asignatura {

    /**
     * Método que contiene los posibles valores del enum Tipo
     *
     */
    public enum Tipo {
        TEÓRICA, PRÁCTICA;
    }

    private Tipo tipo;
    private String strCurso;

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param tipo
     * @param curso
     */
    public Optativa(String nombre, int codigo, Tipo tipo, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.tipo = tipo;
        this.strCurso = curso.getNombre();
    }

    /**
     * Método que compara el nombre del Curso con el nombre de la Asignatura
     * pasada por parámetro
     *
     * @param a
     * @return
     */
    public int compareTo(Asignatura a) {
        int resultado = this.nombre.compareTo(a.nombre);

        if (resultado < 0) {
            return -1;
        } else {
            if (resultado == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return nombre + " Código: " + codigo + " Tipo: " + tipo;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public Lista_Ref_Estudiantes getListaEstudiantes() {
        return this.lre;
    }

    @Override
    public int getSizeRef() {
        return lre.getSize();
    }

    @Override
    public String getStringCurso() {
        return this.strCurso;
    }

    @Override
    public void add(Estudiante e) {
        lre.addNodo(e);
    }

    //MÉTODOS EXPUESTOS A CONTINUACIÓN LO HARÁN LAS RESPECTIVAS LISTAS REF EN PRINCIPIO
    @Override
    public Estudiante getRefEstudiante(int i) {
        return lre.getObject(i);
    }
}
