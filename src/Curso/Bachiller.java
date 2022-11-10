package Curso;

import Asignatura.Asignatura;
import Lista.ListaAsignaturas;

/**
 *
 * @author luisb
 */
public class Bachiller extends Curso {

    private final Año año;

    /**
     * Método que contiene los posibles valores del enum Año
     *
     */
    public enum Año {
        PRIMERO, SEGUNDO;
    }

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param año
     */
    public Bachiller(String nombre, int codigo, Año año) {
        super(nombre, codigo);
        this.año = año;
    }

    /**
     * Método que devuelve el Curso en formato String
     *
     * @return
     */
    @Override
    public String toString() {
        return "BACHILLER: " + codigo + " - " + nombre + " - " + año;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setNombre(String name) {
        this.nombre = name;
    }

    @Override
    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    @Override
    public ListaAsignaturas getListaAsignaturas() {
        return this.lista_curso_asignatura;
    }

    @Override
    public Asignatura getAsignaturaRef(int i) {
        return (Asignatura) lista_curso_asignatura.getObject(i);
    }

    @Override
    public int getSizeRef() {
        return lista_curso_asignatura.getSize();
    }

    @Override
    public void setListaAsignaturas(ListaAsignaturas listaAsignaturas) {
        this.lista_curso_asignatura = listaAsignaturas;
    }
}
