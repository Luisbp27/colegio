/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista_Ref;

import Estudiante.Estudiante;
import Interfaz.InterfazLista;

/**
 *
 * @author luisb
 */
public class Lista_Ref_Estudiantes implements InterfazLista {
    
    private Nodo cabecera;
    private Nodo vacia;
    
    public Lista_Ref_Estudiantes() {
        cabecera = null;
    }
    
    @Override
    public void setObject(Object nodo) {
        
        Nodo aux = cabecera;
        
        while (aux.getNodo() != null) {
            aux = aux.getNodo();
        }
        
        aux.setNodo((Nodo)nodo);
    }
    
    @Override
    public void removeObject(Object estudiante) {
        Estudiante es=(Estudiante)estudiante;
        if (cabecera != null) {
            if (cabecera.getInfo().equals(es)) {
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
                    if (index.getNodo().getInfo().equals(es)) {
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
    
    @Override
    public Object getObject(int i) {
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
    
    @Override
    public String getInfo(int pos) {
          Nodo aux = cabecera;
        int j = 0;
        
        if (aux != null){
            while(!aux.isEmpty() && j < pos ){
                j++;
                if(aux.getNodo() != null) {
                    aux = aux.getNodo();
                }
            }
            
            return aux.getInfo().toString();
        } else {
            return null;
        } 
    }
    
    @Override
    public String getInfoTotal() {
        String s="";
        Nodo aux = cabecera;
        
        if (!aux.isEmpty()){
            s+=(aux.getInfo().toString())+"\n";
            
            while(aux.getNodo() != null){
                aux = aux.getNodo();
                s+=(aux.getInfo().toString())+"\n";
            }
        } else {
            return s; //Vacía
        }return s;
    } 
    
    @Override
    public int getSize(){
        Nodo aux = cabecera;
        int i = 0;
        
        if(aux != null){
            //i++;
            while(aux.getNodo() != null){
                i++;
                aux = aux.getNodo();                
            } 
        }
        
        return i;    
    }   
    
     

    @Override
    public void setObject(int i, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObject(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
