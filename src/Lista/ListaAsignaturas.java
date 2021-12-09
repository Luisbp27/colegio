/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Asignatura.Asignatura;
import Interfaz.InterfazLista;
import Lista_Ref.Lista_Ref_Asignaturas;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author luisb
 */
public class ListaAsignaturas implements InterfazLista {

    private ArrayList<Asignatura> asignaturas;
    private Lista_Ref_Asignaturas l_Ref_Asign = new Lista_Ref_Asignaturas();

    /**
     * Método constructor de la lista
     *
     */
    public ListaAsignaturas() {
        this.asignaturas = new ArrayList<>();
    }

    /**
     * Método que devuelve la longitud de la lista Asignaturas
     *
     * @return
     */
    @Override
    public int getSize() {
        return asignaturas.size();
    }

    /**
     * Método que devuelve el valor info de la Asignatura con posición i, pasada
     * por parámetro, de la lista de Asignaturas
     *
     * @param i
     * @return
     */
    @Override
    public String getInfo(int i) {
        return asignaturas.get(i).toString();
    }

    /**
     * Método que devuelve la Asignatura de la posición i, pasada por parámetro,
     * de la lista de Asignaturas
     *
     * @param i
     * @return
     */
    public Asignatura getAsignatura(int i) {
        return asignaturas.get(i);
    }

    /**
     * Método que devuelve la posición en la lista de Asignaturas de la
     * Asignatura pasada por parámetro
     *
     * @param a
     * @return
     */
    public int getIndice(Asignatura a) {
        return asignaturas.indexOf(a);
    }

    /**
     * Método que devuelve el String de la lista de Asignaturas
     *
     * @return
     */
    public String getInfoLista() {
        String infoTotal = "";

        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += asignaturas.get(i).toString() + "\n";
        }

        return infoTotal;
    }

    //METODOS DE GESTION DE LA LISTA
    /**
     * Método que añade una Asignatura a la lista de Asignaturas
     *
     * @param o
     */
    public void addObject(Object o) {
        asignaturas.add((Asignatura) o);
    }

    /**
     * Método que elimina una Asignatura de la posición i, pasada por parámetro,
     * de la lista de Asignaturas
     *
     * @param i
     */
    @Override
    public void removeObject(int i) {
        asignaturas.remove(i);
    }

    /**
     * Método que elimina la Asignatura, mediante su nombre pasado parámetro, de
     * la lista de Asignaturas
     *
     * @param s
     */
    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (asignaturas.get(i).getNombre().equals(s)) {
                asignaturas.remove(i);
            }
        }
    }

    // MÉTODOS RELACIONADOS CON LA LISTA DE REF_ASIG
    /**
     * Método que añade una Asignatura a la lista de referencias
     *
     * @param x
     */
    public void add(Object x) {
        l_Ref_Asign.addNodoAsignatura((Asignatura) x);
    }

    /**
     * Método que elimina una Asginatura de la lista de referencias
     *
     * @param x
     */
    public void removeRefAsignatura(Object x) {
        l_Ref_Asign.removeNodoAsignatura((Asignatura) x);
    }

    /**
     * Método que devuelve la longitud de la lista de referencias
     *
     * @return
     */
    public int getSizeRef() {
        return l_Ref_Asign.getSize();
    }

    /**
     * Método que elimina una Asignatura de la lista de Asignaturas
     *
     * @param x
     */
    @Override
    public void removeObject(Object x) {
        asignaturas.remove(x);
    }

    /**
     * Método que ordena la lista de Asignaturas según su nombre
     *
     */
    public void ordenarLista() {
        Collections.sort(asignaturas, (Asignatura a1, Asignatura a2) -> ((a1.getNombre()).compareTo((a2.getNombre()))));
    }

    /**
     * Método que devuelve el String de la lista de Asignaturas
     *
     * @return
     */
    @Override
    public String getInfoTotal() {
        String s = "";

        for (int i = 0; i < getSize(); i++) {
            s += getObject(i).toString() + "\n";
        }

        return s;
    }

    /**
     * Método que devuelve la Asignatura de la posición pos, pasada por
     * parámetro, de la lista de Asignaturas
     *
     * @param pos
     * @return
     */
    @Override
    public Object getObject(int pos) {
        return asignaturas.get(pos);
    }

    /**
     * Método que añade una Asignatura, pasada por parámetro, a la lista de
     * Asignaturas
     *
     * @param asignatura
     */
    @Override
    public void setObject(Object asignatura) {
        asignaturas.add((Asignatura) asignatura);
    }

    /**
     * Método que añade una Asignatura en la posición i, pasada por parámetro, a
     * la lista de Asignaturas
     *
     * @param i
     * @param asignatura
     */
    @Override
    public void setObject(int i, Object asignatura) {
        asignaturas.add(i, (Asignatura) asignatura);
    }
}
