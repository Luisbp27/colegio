package Curso;

import Asignatura.Asignatura;
import Interfaz.InterfazDatos;
import Lista.ListaAsignaturas;

/**
 *
 * @author luisb
 */
public abstract class Curso implements InterfazDatos {

    protected String nombre;
    protected int codigo;

    protected ListaAsignaturas lista_curso_asignatura;

    /**
     * Método constructor de la clase
     * 
     * @param nombre
     * @param codigo 
     */
    public Curso(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;

        this.lista_curso_asignatura = new ListaAsignaturas();
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

    public abstract ListaAsignaturas getListaAsignaturas();

    public abstract void setListaAsignaturas(ListaAsignaturas listaAsignaturas);

    public abstract Asignatura getAsignaturaRef(int i);

    public abstract int getSizeRef();
    
}
