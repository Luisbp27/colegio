package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;
import Interfaz.InterfazDatos;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 *
 * @author luisb
 */
public abstract class Asignatura implements InterfazDatos {
    
    protected String nombre;
    protected int codigo; 
    protected String stringCurso;
    protected Lista_Ref_Estudiantes lre;
    
    public Asignatura(String nombre, int codigo, Curso curso) {
        this.nombre = nombre;
        this.codigo = codigo;
        
        this.lre = new Lista_Ref_Estudiantes();
    }
    
    @Override
    public abstract String toString();
    
    public abstract String getNombre();
    
    public abstract int getCodigo();

    public abstract void setNombre(String name);
    
    public abstract void setCodigo(int cod);

    public abstract void setCurso(String x);

    public abstract String getCurso();
    
    public abstract Estudiante getRefEstudiante(int i);

    public abstract int getSizeRef();

    public abstract void add(Estudiante e);

    public abstract void remove(Estudiante e);
}
