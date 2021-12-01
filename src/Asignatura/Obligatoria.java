/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;

/**
 *
 * @author luisb
 */
public class Obligatoria extends Asignatura {
    
    private static final int CREDITOS = 6;

    public Obligatoria(String nombre, int codigo, Curso curso) {
        super(nombre, codigo, curso);
    }

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
        return nombre + " CÓDIGO: " + codigo + " Nº Créditos: " + CREDITOS;
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
    public void setStringCurso(String x) {
        this.stringCurso = x;
    }

    @Override
    public String getStringCurso() {
        return stringCurso;
    }

    @Override
    public Estudiante getRefEstudiante(int i) {
        return (Estudiante)lre.getInfo(i);
    }

    @Override
    public int getSizeRef() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Estudiante e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Estudiante e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
