/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Asignatura.Asignatura;
import Interfaz.InterfazLista;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author luisb
 */
public class ListaAsignaturas implements InterfazLista {
    
    private ArrayList<Asignatura> asignaturas;
    
    public ListaAsignaturas() {
        this.asignaturas = new ArrayList<>();
    }
    
    public int getSize() {
        return asignaturas.size();
    }
    
    public String getInfo(int i) {
        return asignaturas.get(i).toString();
    }
    
    public Asignatura getAsignatura(int i) {
        return asignaturas.get(i);
    }
    public int getIndice(Asignatura a){
        return asignaturas.indexOf(a);
    }

    public String getInfoLista() {
        String infoTotal = "";
        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += asignaturas.get(i).toString() + "\n";
        }
        return infoTotal;
    }

    //METODOS DE GESTION DE LA LISTA
    public void addObject(Object o) {
        asignaturas.add((Asignatura) o);

    }

    public void removeObject(int i) {
        asignaturas.remove(i);
    }

    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (asignaturas.get(i).getNombre() == s) {
                asignaturas.remove(i);
            }
        }
    }

    public void removeObject(Object x) {
        asignaturas.remove(x);
    }

    public void ordenarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
