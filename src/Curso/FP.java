/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;



/**
 *
 * @author luisb
 */
public class FP extends Curso {
    
    public enum Especialidad {
        INFORMÁTICA, MECÁNICA, ELECTRÓNICA;
    }
    
    public FP(String nombre, int codigo) {
        super(nombre, codigo);
    }  
}

