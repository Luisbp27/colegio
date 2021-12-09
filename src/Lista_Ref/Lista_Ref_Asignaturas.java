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

    /**
     * Método constructor de la clase
     *
     */
    public Lista_Ref_Asignaturas() {
        this.primero = null;
    }

    /**
     * Método que añade un nodo al final de la lista de nodos Asignatura
     *
     * @param asignatura
     */
    public void addNodoAsignatura(Asignatura asignatura) {
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

    /**
     * Método que elimina un nodo, pasado por parámetro, de la lista de nodos
     * Asignatura
     *
     * @param asignatura
     */
    public void removeNodoAsignatura(Asignatura asignatura) {
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

    /**
     * Método que devuelve la longitud de la lista de nodos Asignatura
     *
     * @return
     */
    @Override
    public int getSize() {
        Nodo aux = primero;
        int i = 0;

        while (aux != null) {
            i++;
            aux = aux.getNodo();
        }

        return i;
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
