/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Curso.Curso;

/**
 *
 * @author luisb
 */
public class Optativa extends Asignatura {
    
    public enum Tipo {
        TEÓRICA, PRÁCTICA;
    }
    
    private final int creditos = 3;

    public Optativa(String nombre, int codigo, Curso curso) {
        super(nombre, codigo, curso);
    }

    public int compareTo(Asignatura t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
