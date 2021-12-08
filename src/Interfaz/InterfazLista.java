/*
Una interfaz proporciona todas las operaciones básicas sobre cualquier lista in_
dependientemente el tipo de elementos de esta. Es como una librería de operaciones
Especifican el comportamiento no la implementación, eso lo hará cada clase lista.
 */
package Interfaz;

/**
 *
 * @author luisb
 */
public interface InterfazLista {

    // MÉTODOS COMUNES A TODAS LAS LISTAS
    //(Se implementan en listas Nodo como en Arraylist a su manera)
    // MÉTODOS QUE RETORNAN INFORMACIÓN DE UNA LISTA
    /**
     * Método que devuelve el tamaño de la lista
     *
     * @return
     */
    public int getSize();

    /**
     * Método que devuelve la información de un elemento de la lista de una
     * posición pasada por parámetro
     *
     * @param pos
     * @return
     */
    public String getInfo(int pos);

    /**
     * Método que devuelve la información de todos los elementos de la lista
     *
     * @return
     */
    public String getInfoTotal();

    /**
     * Método para obtener un elemento i-ésimo de la lista según su posición
     *
     * @param pos
     * @return
     */
    public Object getObject(int pos);

    /**
     * Método para añadir un elemento a la lista
     *
     * @param o
     */
    public void setObject(Object o);

    /**
     * Método para añadir un objeto en una posición de la lista pasada por
     * parámetro
     *
     * @param i
     * @param o
     */
    public void setObject(int i, Object o);

    /**
     * Método que elimina un elemento de la lista
     *
     * @param o
     */
    public void removeObject(Object o);

    /**
     * Método que elimina un objeto de una posición de la lista pasada por
     * parámetro
     *
     * @param i
     */
    public void removeObject(int i);
}
