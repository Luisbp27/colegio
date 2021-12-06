/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Ref;

import Estudiante.Estudiante;

/**
 *
 * @author luisb
 */
public class Lista_Ref_Estudiantes {
    
    private Nodo cabecera;
    private Nodo vacia;
    
    /**
     * Método constructor de la clase
     * 
     */
    public Lista_Ref_Estudiantes() {
        cabecera = null;
    }
    
    /**
     * Método que añande un nodo al final de la lista
     * 
     * @param estudiante
     */
    public void addNodo(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante, null);

        if (cabecera != null) {
            Nodo index = cabecera;

            while (index.getNodo() != null) {
                index = index.getNodo();
            }

            index.setNodo(nuevo);
        } else {
            cabecera = nuevo;
        }
    }
    
    public void addObjectEstudiante(Nodo nodo) {
        Nodo aux = cabecera;
        
        while (aux.getNodo() != null) {
            aux = aux.getNodo();
        }
        
        aux.setNodo(nodo);
    }
    /**
     * Método que elimina el objeto pasado por parámetro de la lista
     * 
     * @param estudiante 
     */
    public void removeNodo(Estudiante estudiante) {
        if (cabecera != null) {
            if (cabecera.getInfo().equals(estudiante)) {
                Nodo nodoBorrado = cabecera;
                if (cabecera.getNodo() == null) {
                    cabecera = null;
                    nodoBorrado.setNodo(null);
                    Nodo index2 = vacia;
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        index2.setNodo(nodoBorrado);
                    } else {
                        vacia = nodoBorrado;
                    }
                } else {
                    cabecera = cabecera.getNodo();
                    nodoBorrado.setNodo(null);
                    Nodo index2 = vacia;
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        index2.setNodo(nodoBorrado);
                    } else {
                        vacia = nodoBorrado;
                    }
                }
            } else {
                boolean encontrado = false;
                Nodo index = cabecera;
                while (!encontrado && index.getNodo() != null) {
                    if (index.getNodo().getInfo().equals(estudiante)) {
                        encontrado = true;
                    } else {
                        index = index.getNodo();
                    }
                }
                Nodo nodoBorrado = index.getNodo();
                if (encontrado) {
                    index.setNodo(nodoBorrado.getNodo());
                    nodoBorrado.setNodo(null);
                    Nodo index2 = vacia;
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        index2.setNodo(nodoBorrado);
                    } else {
                        vacia = nodoBorrado;
                    }
                } else {
                    System.out.println("Elemento no encontrado");
                }
            }
        } else {
            System.out.println("Lista vacía\n");
        }
    }
    
    /**
     * Método que devuelve el valor info del objeto
     * 
     * @param i
     * @return 
     */
    public Object getInfo(int i) {
        Nodo aux = cabecera;
        int j = 0;
        
        if (aux != null){
            while(!aux.isEmpty() && j < i ){
                j++;
                if(aux.getNodo() != null) {
                    aux = aux.getNodo();
                }
            }
            
            return aux.getInfo();
        } else {
            return null;
        } 
    }
    
    /**
     * Método que visualiza la lista por pantalla
     * 
     */
    public void visualizarLista() {
        Nodo aux = cabecera;
        
        if (!aux.isEmpty()){
            System.out.println(aux.getInfo().toString());
            
            while(aux.getNodo() != null){
                aux = aux.getNodo();
                System.out.println(aux.getInfo().toString());
            }
        } else {
            System.out.println("Vacía");
        }
    }
    
    /**
     * Recorre todos los campos info de la lista de nodos y devuelve si es una 
     * referencia a asignatura o estudiante el objeto referenciado en String.
     * 
     * @return String de todos los objetos de la lista
     */
    public String getInfoTotal() {
        String s = "";
        Nodo aux = cabecera;
        
        if (!aux.isEmpty()){
            s += (aux.getInfo().toString()) + "\n";
            
            while(aux.getNodo() != null){
                aux = aux.getNodo();
                s += (aux.getInfo().toString()) + "\n";
            }
            
        } else {
            return s; //Vacía
        }return s;
    } 
    
    /**
     * Método que devuelve la longitud de la lista
     * 
     * @return 
     */
    public int getSize(){
        Nodo aux = cabecera;
        int i = 0;
        
        if(aux != null){
            while(aux.getNodo() != null){
                i++;
                aux = aux.getNodo();                
            } 
        }
        
        return i;    
    }    

    /**
     * Busca en la lista enlazada de referencias al objeto referencia a estudiante
     * en la posición i pasada por argumento y devuelve el campo info de un
     * objeto referencia estudiante, por tanto al estudiante.
     * 
     * Objeto referencia a estudiante -> Nodo Estudiante
     * Nodo estudiante campo info es el Estudiante.
     * 
     * @param i, indica la posición de un objeto referencia a estudiante(Nodo)
     * @return Nodo Estudiante-> Estudiante == (Estudiante)aux.getInfo();
     */
    public Estudiante getObject(int i) {
        Nodo aux = cabecera;
        int j = 0;
        
        if (aux != null){
            while(!aux.isEmpty() && j < i ){
                j++;
                if(aux.getNodo() != null) {
                    aux = aux.getNodo();
                }
            }
            
            return (Estudiante)aux.getInfo();
        } else {
            return null;
        } 
    }
}
