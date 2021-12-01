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
public class Lista_Ref_Asignaturas implements InterfazLista {
    
    private Nodo primero;
    private Nodo vacia;
    public Lista_Ref_Asignaturas() {
        this.primero = null;
    }
     public void add_nodo(Asignatura x) {
        
         Nodo nuevo = new Nodo(x, null);
        if (primero != null) {
               
            Nodo index = primero;
            while (index.getNodo() != null) {
                index = index.getNodo();
            }
            index.setNodo(nuevo);
            
        } else {
                 
            primero = nuevo;
           
        }

    }
    
    public void addAsignatura(Nodo asignatura) {
        
    }
    
    public void removeAsignatura() {
        
    }
    
    
    public Asignatura getInfoAsignatura() {
        return null;
    }
    
    public int getSize() {
        return 0;
    }

    @Override
    public String getInfo(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setObject(int i, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObject(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
