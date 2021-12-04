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
    
    //---MÉTODOS COMUNES A TODAS LAS LISTAS---
    //(Se implementan en listas Nodo como en Arraylist a su manera)
    
    //---MÉTODOS QUE RETORNAN INFORMACIÓN DE UNA LISTA---
    //método que devuelve el tamaño de la lista
    public int getSize();
    //método que devuelve LA INFORMACIÓN de un elemento/objeto de la lista en una
    //posición concreta
    public String getInfo(int pos);
    //método que devuelve LA INFORMACIÓN de todos los elementos de la lista
    public String getInfoTotal();
    //método pra obtener un elemento i-ésimo de la lista según su posición
    public Object getObject(int pos);
    //método para añadir un el elemento a la lista (nombre y código)
    public void setObject(Object o); //o addObject
    //método para añadir un objeto en una posición concreta
    public void setObject(int i, Object o);
    //método que elimna un elemento de la lista.
    public void removeObject(Object o);
    //método para eliminar un objeto en una posición concreta
    public void removeObject(int i);
    
    
    
}
