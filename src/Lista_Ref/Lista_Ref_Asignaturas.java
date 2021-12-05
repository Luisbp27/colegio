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

    public void add_nodo(Asignatura asignatura) {
        Nodo nuevo = new Nodo(asignatura, null);
        
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

    public void removeAsignatura(Asignatura asignatura) {
        if (primero != null) {
            if (primero.getInfo().equals(asignatura)) {
                Nodo nodeBorrado = primero;
                
                if (primero.getNodo() == null) {
                    primero = null;
                    nodeBorrado.setNodo(null);
                    Nodo index2 = vacia;
                    
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        
                        index2.setNodo(nodeBorrado);
                    } else {
                        vacia = nodeBorrado;
                    }
                } else {
                    primero = primero.getNodo();
                    nodeBorrado.setNodo(null);
                    Nodo index2 = vacia;
                    
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        
                        index2.setNodo(nodeBorrado);
                    } else {
                        vacia = nodeBorrado;
                    }
                }
            } else {
                boolean trobat = false;
                Nodo index = primero;
                
                while (!trobat && index.getNodo() != null) {
                    if (index.getNodo().getInfo().equals(asignatura)) {
                        trobat = true;
                    } else {
                        index = index.getNodo();
                    }
                }
                Nodo nodeBorrat = index.getNodo();
                if (trobat) {
                    index.setNodo(nodeBorrat.getNodo());
                    nodeBorrat.setNodo(null);
                    Nodo index2 = vacia;
                    
                    if (index2 != null) {
                        while (index2.getNodo() != null) {
                            index2 = index2.getNodo();
                        }
                        
                        index2.setNodo(nodeBorrat);
                    } else {
                        vacia = nodeBorrat;
                    }
                } else {
                    System.out.println("Element no trobat");
                }
            }
        } else {
            System.out.println("Llista buida\n");
        }
    }

    public Asignatura getInfoAsignatura() {
        return null;
    }

    public int getSize() {
        return 0;
    }

    @Override
    public String getInfo(int pos) {
        return null;
    }

    @Override
    public String getInfoTotal() {
        return null;
    }

    @Override
    public Object getObject(int pos) {
        return null;
    }

    @Override
    public void setObject(Object o) {
    }

    @Override
    public void setObject(int i, Object o) {
    }

    @Override
    public void removeObject(Object o) {
    }

    @Override
    public void removeObject(int i) {
    }
}
