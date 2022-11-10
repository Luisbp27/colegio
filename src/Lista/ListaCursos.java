package Lista;

import Curso.Curso;
import Interfaz.InterfazLista;
import java.util.ArrayList;

/**
 *
 * @author luisb
 */
public class ListaCursos implements InterfazLista {

    private ArrayList<Curso> cursos;

    /**
     * Método constructor de la clase
     *
     */
    public ListaCursos() {
        this.cursos = new ArrayList<>();
    }

    /**
     * Método que devuelve la longitud de la lista
     *
     * @return
     */
    @Override
    public int getSize() {
        return cursos.size();
    }

    /**
     * Método que devuelve la posicion del Curso, pasado por parámetro, de la
     * lista Cursos
     *
     * @param x
     * @return
     */
    public int getIndexof(Object x) {
        return cursos.indexOf(x);
    }

    /**
     * Método que devuelve la lista de Cursos en formato array
     *
     * @return
     */
    public Object[] getArray() {
        return cursos.toArray();
    }

    /**
     * Método que devuelve en formato String en valor del Curso con posición i,
     * pasada por parámetro, de la lista de Cursos
     *
     * @param i
     * @return
     */
    @Override
    public String getInfo(int i) {
        String info;
        info = cursos.get(i).toString();

        return info;
    }

    //METODOS DE GESTION DE LA LISTA
    /**
     * Método que añade un Curso a la lista de Cursos
     *
     * @param o
     */
    public void addObject(Object o) {
        cursos.add((Curso) o);
    }

    /**
     * Método que elimina el Curso pasado por parámetro de la lista de Cursos
     *
     * @param x
     */
    @Override
    public void removeObject(Object x) {
        cursos.remove(x);
    }

    /**
     * Método que elimina el Curso de la posición i, pasada por parámetro, de la
     * lista de Cursos
     *
     * @param i
     */
    @Override
    public void removeObject(int i) {
        cursos.remove(i);
    }

    /**
     * Método que devuelve el Curso de la posición i, pasada por parámetro, de
     * la lista de Cursos
     *
     * @param i
     * @return
     */
    public Curso getCurso(int i) {
        return cursos.get(i);
    }

    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (cursos.get(i).getNombre() == s) {
                cursos.remove(i);
            }
        }
    }

    /**
     * Método que devuelve el String de la lista de Cursos
     *
     * @return
     */
    @Override
    public String getInfoTotal() {
        String infoTotal = "";

        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += cursos.get(i).toString() + "\n";
        }

        return infoTotal;
    }

    /**
     * Método que devuelve el Curso de la posición pasada por parámetro, de la
     * lista de Cursos
     *
     * @param pos
     * @return
     */
    @Override
    public Object getObject(int pos) {
        return cursos.get(pos);
    }

    /**
     * Método que añade un Curso a la lista de Cursos
     *
     * @param o
     */
    @Override
    public void setObject(Object o) {
        cursos.add((Curso) o);
    }

    /**
     * Método que añade un Curso en la posición i, pasada por parámetro, a la
     * lista de Cursos
     *
     * @param i
     * @param o
     */
    @Override
    public void setObject(int i, Object o) {
        cursos.add(i, (Curso) o);
    }
}
