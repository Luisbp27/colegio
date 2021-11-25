package Lista_Ref;

/**
 *
 * @author luisb
 */
public class Nodo {
    
    private int info;
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
    public Nodo(int info) {
        this.info = info;
        this.siguiente = null;
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
    public void setInfo(int info) {
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
    public int getInfo() {
        return this.info;
    }
}
