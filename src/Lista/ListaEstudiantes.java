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

/**
 *
 * @author luisb
 */
public class ListaEstudiantes implements InterfazLista {
    
    private ArrayList<Estudiante> estudiantes;
    
    public ListaEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }
    
    public int getSize() {
        return estudiantes.size();
    }
    
    public String getInfo(int i) {
        return estudiantes.get(i).toString();
    }
    
    public String getInfoLista() {
        String infoTotal = "";
        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += estudiantes.get(i).toString() + "\n";
        }
        return infoTotal;
    }
    public int getIndice(Estudiante a){
        return estudiantes.indexOf(a);
    }
    
    //METODOS DE GESTION DE LA LISTA
    public void addObject(Object o) {
        estudiantes.add((Estudiante) o);
    }

    public void removeObject(int i) {
        estudiantes.remove(i);

    }

    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (estudiantes.get(i).getNombre() == s) {
                estudiantes.remove(i);
            }
        }
    }

    public void removeObject(Object x) {
        estudiantes.remove(x);
    }
    
    public Estudiante getEstudiante(int i) {
        if(estudiantes.get(i) != null) {
            return estudiantes.get(i);
        } else {
            return null;
        }
    }

    public void ordenarLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
