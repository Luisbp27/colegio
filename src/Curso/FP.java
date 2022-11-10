package Curso;

import Asignatura.Asignatura;
import Lista.ListaAsignaturas;

/**
 *
 * @author luisb
 */
public class FP extends Curso {

    private Especialidad especialidad;

    /**
     * Método que contiene los posibles valores del enum Especialidad
     *
     */
    public enum Especialidad {
        INFORMÁTICA, MECÁNICA, ELECTRÓNICA;
    }

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param especialidad
     */
    public FP(String nombre, int codigo, Especialidad especialidad) {
        super(nombre, codigo);
        this.especialidad = especialidad;
    }

    /**
     * Método que devuelve FP en un String
     *
     * @return
     */
    @Override
    public String toString() {
        return "FP: " + codigo + " - " + nombre + " - " + especialidad;
    }

    /**
     * Método que devuelve el atributo nombre
     *
     * @return
     */
    @Override
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que devuelve el atributo codigo
     *
     * @return
     */
    @Override
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método que modifica el atributo nombre, con el String pasado por
     * parámetro
     *
     * @param name
     */
    @Override
    public void setNombre(String name) {
        this.nombre = name;
    }

    /**
     * Método que modifica el atributo codigo, con el entero pasado por
     * parámetro
     *
     * @param cod
     */
    @Override
    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    /**
     * Método que devuelve el atributo listaCursoAsignatura
     *
     * @return
     */
    @Override
    public ListaAsignaturas getListaAsignaturas() {
        return this.lista_curso_asignatura;
    }

    /**
     * Método que devuelve la Asignatura de la posición i, pasada por parámetro,
     * de la lista de Asignaturas
     *
     * @param i
     * @return
     */
    @Override
    public Asignatura getAsignaturaRef(int i) {
        return (Asignatura) lista_curso_asignatura.getObject(i);
    }

    /**
     * Método que devuelve la longitud de la lista de Asignaturas del Curso
     *
     * @return
     */
    @Override
    public int getSizeRef() {
        return lista_curso_asignatura.getSize();
    }

    /**
     * Método que modifica el valor del atributo listaAsignaturas por la lista
     * pasada por parámetro
     *
     * @param listaAsignaturas
     */
    @Override
    public void setListaAsignaturas(ListaAsignaturas listaAsignaturas) {
        this.lista_curso_asignatura = listaAsignaturas;
    }
}
