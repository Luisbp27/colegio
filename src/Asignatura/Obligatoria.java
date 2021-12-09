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
 *
 * @author luisb
 */
public class Obligatoria extends Asignatura {

    private int creditos;
    private String stringCurso;

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param creditos
     * @param curso
     */
    public Obligatoria(String nombre, int codigo, int creditos, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.creditos = creditos;
        this.stringCurso = curso.getNombre();
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
        return nombre + " Código: " + codigo + " Créditos: " + creditos;
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
        return stringCurso;
    }

    @Override
    public Estudiante getRefEstudiante(int i) {
        return lre.getObject(i);
    }

    @Override
    public void add(Estudiante e) {
        lre.addNodo(e);
    }

}
