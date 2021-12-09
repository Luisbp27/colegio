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
    // MÉTODOS QUE RETORNAN INFORMACIÓN DE UNA LISTA
    public int getSize();

    public String getInfo(int pos);

    public String getInfoTotal();

    public Object getObject(int pos);

    public void setObject(Object o);

    public void setObject(int i, Object o);

    public void removeObject(Object o);

    public void removeObject(int i);
}
