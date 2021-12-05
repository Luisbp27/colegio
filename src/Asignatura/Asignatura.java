package Asignatura;

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

    public Asignatura(String nombre, int codigo, String nombreCurso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.stringCurso = nombreCurso;

        this.lre = new Lista_Ref_Estudiantes();
    }

    @Override
    public abstract String toString();

    @Override
    public abstract String getNombre();

    @Override
    public abstract int getCodigo();

    @Override
    public abstract void setNombre(String name);

    @Override
    public abstract void setCodigo(int cod);

    public abstract Lista_Ref_Estudiantes getListaEstudiantes();
    
    public abstract int getSizeRef();
    /*
    //en principio no vamos a modificar el nombre del curso en ningún momento
    
    public abstract String getStringCurso();

    //MÉTODOS EXPUESTOS A CONTINUACIÓN LO HARÁN LAS RESPECTIVAS LISTAS REF EN PRINCIPIO
    
    public abstract Estudiante getRefEstudiante(int i);

    public abstract int getSizeRef(); //cada lista tiene su getSize

    public abstract void add(Estudiante e);

    public abstract void remove(Estudiante e);
     */
}
