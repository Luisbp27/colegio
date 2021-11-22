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
public class Obligatoria extends Asignatura {
    
    private final int creditos = 6;

    public Obligatoria(String nombre, int codigo, Curso curso) {
        super(nombre, codigo, curso);
    }

    public int compareTo(Asignatura t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
