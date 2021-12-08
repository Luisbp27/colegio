package Lista_Ref;

/**
 *
 * @author luisb
 */
public class Nodo {

    private Object info;
    private Nodo siguiente;

    /**
     * Método constructor de una lista de nodos vacía
     *
     */
    public Nodo() {
        this.siguiente = null;
    }

    /**
     * Método constructor de una lista de nodos con un primer nodo
     *
     * @param info
     */
    public Nodo(Object info) {
        this.info = info;
        this.siguiente = null;
    }

    /**
     * Constructor que inicializamos los atributos a Null
     *
     * @param info
     * @param n
     */
    public Nodo(Object info, Nodo n) {
        this.info = info;
        siguiente = n;
    }

    /**
     * Método que modifica el valor del atributo siguiente por el valor pasado
     * por parámetro
     *
     * @param apuntador
     */
    public void setNodo(Nodo apuntador) {
        this.siguiente = apuntador;
    }

    /**
     * Método que modifica el valor del atributo info por el valor pasado por
     * parámetro
     *
     * @param info
     */
    public void setInfo(Object info) {
        this.info = info;
    }

    /**
     * Método que devuelve el valor del atributo siguiente
     *
     * @return
     */
    public Nodo getNodo() {
        return this.siguiente;
    }

    /**
     * Método que devuelve el valor del atributo info
     *
     * @return
     */
    public Object getInfo() {
        return this.info;
    }

    /**
     * Método que comprueba si el nodo tiene o no contenido
     *
     * @return
     */
    public boolean isEmpty() {
        return this.info == null;
    }
}
