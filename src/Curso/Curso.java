/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Curso;

import Interfaz.InterfazDatos;

/**
 *
 * @author luisb
 */
public abstract class Curso implements InterfazDatos {
    
    protected String nombre;
    protected int codigo;
    
    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
}
