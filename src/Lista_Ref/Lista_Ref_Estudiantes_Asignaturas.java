/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Ref;

import Asignatura.Asignatura;
import Interfaz.InterfazLista;

/**
 *
 * @author luisb
 */
public class Lista_Ref_Estudiantes_Asignaturas implements InterfazLista {
    
    private Nodo cabecera;
    private Nodo vacia;
    
    public Lista_Ref_Estudiantes_Asignaturas() {
        this.cabecera = null;
    }
    
    public void addAsignatura(Asignatura asignatura) {
        Nodo nuevo = new Nodo(asignatura);
        
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
    
    public void removeNodo(Asignatura asignatura) {
        if (cabecera != null) {
            if (cabecera.getInfo().equals(asignatura)) {
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
                    if (index.getNodo().getInfo().equals(asignatura)) {
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
    
    public int getSize(){
        Nodo aux = cabecera;
        int i = 0;
        
        if(aux != null){
            i++;
            while(aux.getNodo() != null){
                i++;
                aux = aux.getNodo();                
            } 
        }
        
        return i;    
    }    
}
