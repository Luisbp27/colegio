/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    //método para imprimir nombre y código de un elemento
    @Override
    public String toString();
    
    
    
}
