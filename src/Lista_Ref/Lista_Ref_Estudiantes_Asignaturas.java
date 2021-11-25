/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Ref;

import Interfaz.InterfazLista;

/**
 *
 * @author luisb
 */
public class Lista_Ref_Estudiantes_Asignaturas implements InterfazLista {
    
    private Nodo cabecera;
    
    public Lista_Ref_Estudiantes_Asignaturas() {
        this.cabecera = null;
    }
    
    public void crearLista(int[] datos) {
        for (int i = datos.length - 1; i > -1; i--) {
            Nodo nodo = new Nodo(datos[i]);
            
            nodo.setNodo(this.cabecera);
            // El nuevo nodo creado es siempre la cabecera de la lista i esta tiene
            // siempre el valor seg apuntando a null. Entonces en antiguo nodo 
            // apuntará a la antigua cabecera entrelazando los nodos
            this.cabecera = nodo;
        }
    }
    
    /**
     * Método que inserta un nodo al final de la lista
     * 
     * @param nodo 
     */
    public void addNodo(Nodo nodo) {
        Nodo aux = cabecera;
        
        while (aux.getNodo() != null) {
            aux = aux.getNodo();
        }
        
        aux.setNodo(nodo);
    }
    
    /**
     * Método que elimina un nodo en la posición n de la lista de nodos
     * 
     * @param n
     * @return 
     */
    public Nodo removeNodo(int n) {
        Nodo nodoApuntado;
        Nodo nodoApuntado2;
        Nodo aux = new Nodo();

        nodoApuntado = cabecera;
        nodoApuntado2 = cabecera;

        // Posicionamos nodoApuntado2 una posición anterior al nodo a eliminar
        while (nodoApuntado2.getNodo().getInfo() != n) {
            nodoApuntado2 = nodoApuntado2.getNodo();
            nodoApuntado = nodoApuntado.getNodo();
        }
        
        // Avanzamos una posición porque coincide con el campo info actual
        nodoApuntado = nodoApuntado.getNodo();

        if (nodoApuntado.getInfo() == n) {
            aux.setInfo(nodoApuntado.getInfo());
            aux.setNodo(null);

            nodoApuntado2.setNodo(nodoApuntado.getNodo());
        }
        
        return aux;
    }
}
