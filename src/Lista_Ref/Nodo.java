package Lista_Ref;

/**
 *
 * @author luisb
 */
public class Nodo {
    
    private int info;
    private Nodo siguiente;
    
    public Nodo() {
        this.siguiente = null;
    }
    
    public Nodo(int info) {
        this.info = info;
        this.siguiente = null;
    }
    
    public void setNodo(Nodo apuntador) {
        this.siguiente = apuntador;
    }
    
    public Nodo getNodo() {
        return this.siguiente;
    }
    
    public int getInfo() {
        return this.info;
    }
    
    public void setInfo(int info) {
        this.info = info;
    }
}
