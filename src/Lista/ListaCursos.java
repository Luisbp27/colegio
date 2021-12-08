/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public ListaCursos() {
        this.cursos = new ArrayList<>();
    }

    //Metodos GET
    public int getSize() {
        return cursos.size();
    }

    public int getIndexof(Object x) {
        return cursos.indexOf(x);
    }

    public void setAt(int i, Object x) {
        cursos.add(i, (Curso) x);
    }

    public Object[] getArray() {
        return cursos.toArray();
    }

    public String getInfo(int i) {
        String info;
        info = cursos.get(i).toString();
        return info;
    }

    //METODOS DE GESTION DE LA LISTA
    public void addObject(Object o) {
        cursos.add((Curso) o);

    }

    public void removeObject(Object x) {
        cursos.remove(x);
    }

    public void removeObject(int i) {
        cursos.remove(i);
    }

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

    @Override
    public String getInfoTotal() {
        String infoTotal = "";

        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += cursos.get(i).toString() + "\n";
        }

        return infoTotal;
    }

    @Override
    public Object getObject(int pos) {
        return cursos.get(pos);
    }

    @Override
    public void setObject(Object o) {
        cursos.add((Curso) o);
    }

    @Override
    public void setObject(int i, Object o) {
        cursos.add(i, (Curso) o);
    }
}
