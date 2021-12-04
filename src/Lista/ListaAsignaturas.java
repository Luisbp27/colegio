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
import java.util.Comparator;

/**
 *
 * @author luisb
 */
public class ListaAsignaturas implements InterfazLista {
    
    private ArrayList<Asignatura> asignaturas;
    
    public ListaAsignaturas() {
        this.asignaturas = new ArrayList<>();
    }
    //tamaño de la lista
    @Override
    public int getSize() {
        return asignaturas.size();
    }
    
    @Override
    public void setObject(Object asignatura) {
        asignaturas.add((Asignatura)asignatura);
    }

    @Override
    public void setObject(int i, Object asignatura) {
      asignaturas.add(i, (Asignatura)asignatura);
    }

    @Override
    public Asignatura getObject(int pos){
       return  asignaturas.get(pos);     
    }

    @Override 
    //probar si va bien, en principio solo funciona datos Object primitivos
    //no objetos 
    public void removeObject(Object o) {
       asignaturas.remove((Asignatura)o);
    }

    @Override 
    public void removeObject(int pos) {
        asignaturas.remove(pos);
    }
    
     @Override
    public String getInfo(int pos) {
       return  asignaturas.get(pos).toString();   
    }
    
    @Override
    public String getInfoTotal() {
        String s="";
        for(int i=0;i<getSize();i++){
            s+= getObject(i).toString()+"\n";
        }
        return s;
    }

    //ordena lista de menor a mayor
    public void ordenarLista() {
        Collections.sort(asignaturas, new Comparator<Asignatura>() {
            @Override
            public int compare(Asignatura a1, Asignatura a2) {
                return ((a1.getNombre()).compareTo((a2.getNombre()))); 
            }
        });
    }
    
    public int getIndice(Asignatura a){
        return asignaturas.indexOf(a);
    }

    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (asignaturas.get(i).getNombre() == s) {
                asignaturas.remove(i);
            }
        }
    }
}
