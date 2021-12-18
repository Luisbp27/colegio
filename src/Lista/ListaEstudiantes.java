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

    /**
     * Método constructor de la clase
     *
     */
    public ListaEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    /**
     * Método que devuelve la longitud de la lista
     *
     * @return
     */
    @Override
    public int getSize() {
        return estudiantes.size();
    }

    /**
     * Método que devuelve el valor info del Estudiante con la posición pasada
     * por parámetro de la lista Estudiantes
     *
     * @param i
     * @return
     */
    @Override
    public String getInfo(int i) {
        return estudiantes.get(i).toString();
    }

    /**
     * Método que devuelve la posición en la lista del Estudiante pasado por
     * parámetro
     *
     * @param a
     * @return
     */
    public int getIndice(Estudiante a) {
        return estudiantes.indexOf(a);
    }
    
      public int getIndicePorNombre(String nombre){
        int i=0;
         while(!(estudiantes.get(i).getNombre().equals(nombre))){
             i++;
         }return i;
    }
    //METODOS DE GESTION DE LA LISTA
    /**
     * Método que elimina un Estudiante de la posición de la lista pasada por
     * parámetro
     *
     * @param i
     */
    @Override
    public void removeObject(int i) {
        estudiantes.remove(i);
    }

    /**
     * Método que elimina el Estudiante, pasado por parámetro, de la lista
     * Estudiante
     *
     * @param x
     */
    @Override
    public void removeObject(Object x) {
        estudiantes.remove(x);
    }

    /**
     * Método que elimina un Estudiante de la lista Estudiantes
     *
     * @param s
     */
    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (estudiantes.get(i).getNombre().equals(s)) {
                estudiantes.remove(i);
            }
        }
    }

    /**
     * Método que devuelve el Estudiante en la posición i de la lista
     * Estudiantes pasada por parámetro
     *
     * @param i
     * @return
     */
    public Estudiante getEstudiante(int i) {
        // Si la lista de estudiantes no está vacía
        System.out.println(estudiantes.get(i));
        if (estudiantes.get(i) != null) {
            System.out.println("hola 4");
            System.out.println(estudiantes.get(i));

            return estudiantes.get(i);
        } else {
            return null;
        }
    }

    /**
     * Método que ordena la lista de Estudiantes por sus nombres
     *
     */
    public void ordenarLista() {
        Collections.sort(estudiantes, (Estudiante e1, Estudiante e2) -> ((e1.getNombre()).compareTo((e2.getNombre()))));
    }

    /**
     * Método que devuelve la lista de Estudiantes en formato String
     *
     * @return
     */
    @Override
    public String getInfoTotal() {
        String infoTotal = "";

        for (int i = 0; i < this.getSize(); i++) {
            infoTotal += estudiantes.get(i).toString() + "\n";
        }

        return infoTotal;
    }

    /**
     * Método que devuelve el Estudiante en la posición i, de la lista de
     * Estudiantes, pasada por parámetro
     *
     * @param pos
     * @return
     */
    @Override
    public Object getObject(int pos) {
        return estudiantes.get(pos);
    }

    /**
     * Método que añade un Estudiante a la lista Estudiantes
     *
     * @param o
     */
    @Override
    public void setObject(Object o) {
        estudiantes.add((Estudiante) o);
    }

    /**
     * Método que añade un Estudiante a la lista de Estudiantes en la posición i
     * pasada por parámetro
     *
     * @param i
     * @param o
     */
    @Override
    public void setObject(int i, Object o) {
        estudiantes.set(i, (Estudiante) o);
    }
}
