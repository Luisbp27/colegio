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
    Lista_Ref_Asignaturas l_Ref_Asign = new Lista_Ref_Asignaturas();

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

    public int getIndice(Asignatura a) {
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
            if (asignaturas.get(i).getNombre().equals(s)) {
                asignaturas.remove(i);
            }
        }
    }

    // MÉTODOS RELACIONADOS CON LA LISTA DE REF_ASIG
    public void add(Object x) {
        l_Ref_Asign.addNodo((Asignatura) x);
    }

    public void removeAsignatura(Object x) {
        l_Ref_Asign.removeAsignatura((Asignatura) x);
    }

    public void removeObject(Object x) {
        asignaturas.remove(x);
    }
    
    public int getSizeRef() {
        return l_Ref_Asign.getSize();
    }

    /**
     * Método que ordena la lista de menor a mayor asignatura segun su nombre
     * 
     */
    public void ordenarLista() {
        Collections.sort(asignaturas, (Asignatura a1, Asignatura a2) -> ((a1.getNombre()).compareTo((a2.getNombre()))));
    }

    @Override
    public String getInfoTotal() {
        String s = "";
        for (int i = 0; i < getSize(); i++) {
            s += getObject(i).toString() + "\n";
        }
        return s;
    }

    @Override
    public Object getObject(int pos) {
        return  asignaturas.get(pos);  
    }

    @Override
    public void setObject(Object asignatura) {
        asignaturas.add((Asignatura) asignatura);
    }

    @Override
    public void setObject(int i, Object asignatura) {
        asignaturas.add(i, (Asignatura) asignatura);
    }
}
