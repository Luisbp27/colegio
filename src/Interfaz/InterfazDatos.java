package Interfaz;

/**
 *
 * @author luisb
 */
public interface InterfazDatos {
    //TODOS LOS DATOS TIENEN EN COMUN UN NOMBRE Y CÓDIGO

    //OPERACIONES BÁSICAS COMUNES
    public void setNombre(String nombre);

    public void setCodigo(int Codigo);

    public String getNombre();

    public int getCodigo();

    @Override
    public String toString();
}
