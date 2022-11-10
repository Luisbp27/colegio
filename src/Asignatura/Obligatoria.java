package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 *
 * @author luisb
 */
public class Obligatoria extends Asignatura {

    private int creditos;
    private String stringCurso;

    /**
     * Método constructor de la clase
     *
     * @param nombre
     * @param codigo
     * @param creditos
     * @param curso
     */
    public Obligatoria(String nombre, int codigo, int creditos, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.creditos = creditos;
        this.stringCurso = curso.getNombre();
    }

    @Override
    public String toString() {
        return nombre + " Código: " + codigo + " Créditos: " + creditos;
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
        return stringCurso;
    }

    @Override
    public Estudiante getRefEstudiante(int i) {
        return lre.getObject(i);
    }

    @Override
    public void add(Estudiante e) {
        lre.addNodo(e);
    }

}
