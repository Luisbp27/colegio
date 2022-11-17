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

    /**
     * Método constructor de la clase
     *
     */
    public Lista_Ref_Estudiantes_Asignaturas() {
        this.cabecera = null;
    }

    /**
     * Método que añade el nodo, pasado por parámetro, a la lista de nodos
     *
     * @param asignatura
     */
    public void addNodo(Asignatura asignatura) {
        Nodo nuevo = new Nodo(asignatura, null);

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

    /**
     * Método que elimina el nodo, pasado por parámetro, de la lista de nodos
     *
     * @param asignatura
     */
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
                }
            }
        } 
    }

    /**
     * Método que devuelve el valor info del nodo referente a la posición pasada
     * por parámetro de la lista de nodos
     *
     * @param i
     * @return
     */
    public Object getInfoNodo(int i) {
        Nodo aux = cabecera;
        int j = 0;

        if (aux != null) {
            while (!aux.isEmpty() && j < i) {
                j++;
                if (aux.getNodo() != null) {
                    aux = aux.getNodo();
                }
            }

            return aux.getInfo();
        } else {
            return null;
        }
    }

    /**
     * Método que visualiza la lista
     *
     */
    public void visualizarLista() {
        Nodo aux = cabecera;

        if (!aux.isEmpty()) {
            while (aux.getNodo() != null) {
                aux = aux.getNodo();
            }
        } 
    }

    /**
     * Método que devuelve la longitud de la lista
     *
     * @return
     */
    @Override
    public int getSize() {
        Nodo aux = cabecera;
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
