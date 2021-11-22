package Asignatura;

import Curso.Curso;
import Interfaz.InterfazDatos;

/**
 *
 * @author luisb
 */
public abstract class Asignatura implements InterfazDatos {
    
    protected String nombre;
    protected int codigo;
    
    private Curso curso;
    
    public Asignatura(String nombre, int codigo, Curso curso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
    }
}
