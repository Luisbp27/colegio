package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 *
 * @author luisb
 */
public class Optativa extends Asignatura {

    /**
     * Método que contiene los posibles valores del enum Tipo
     *
     */
    public enum Tipo {
        TEÓRICA, PRÁCTICA;
    }

    private Tipo tipo;
    private String strCurso;

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param tipo
     * @param curso
     */
    public Optativa(String nombre, int codigo, Tipo tipo, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.tipo = tipo;
        this.strCurso = curso.getNombre();
    }

    @Override
    public String toString() {
        return nombre + " Código: " + codigo + " Tipo: " + tipo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public Lista_Ref_Estudiantes getListaEstudiantes() {
        return this.lre;
    }

    @Override
    public int getSizeRef() {
        return lre.getSize();
    }

    @Override
    public String getStringCurso() {
        return this.strCurso;
    }

    @Override
    public void add(Estudiante e) {
        lre.addNodo(e);
    }

    //MÉTODOS EXPUESTOS A CONTINUACIÓN LO HARÁN LAS RESPECTIVAS LISTAS REF EN PRINCIPIO
    @Override
    public Estudiante getRefEstudiante(int i) {
        return lre.getObject(i);
    }
}
