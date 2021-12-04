/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Estudiante.Estudiante;
import Interfaz.InterfazLista;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author luisb
 */
public class ListaEstudiantes implements InterfazLista {
    
    private ArrayList<Estudiante> estudiantes;
    
    public ListaEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }
    
     //tamaño de la lista
    @Override
    public int getSize() {
        return estudiantes.size();
    }
    
    @Override
    public void setObject(Object estudiante) {
        estudiantes.add((Estudiante)estudiante);
    }

    @Override
    public void setObject(int i, Object estudiante) {
      estudiantes.add(i, (Estudiante)estudiante);
    }

    @Override
    public Estudiante getObject(int pos){
       return  estudiantes.get(pos);     
    }

    @Override 
    //probar si va bien, en principio solo funciona datos Object primitivos
    //no objetos 
    public void removeObject(Object o) {
       estudiantes.remove((Estudiante)o);
    }

    @Override 
    public void removeObject(int pos) {
        estudiantes.remove(pos);
    }
    
     @Override
    public String getInfo(int pos) {
       return  estudiantes.get(pos).toString();   
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
        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante a1, Estudiante a2) {
                return ((a1.getNombre()).compareTo((a2.getNombre()))); 
            }
        });
    }
}
