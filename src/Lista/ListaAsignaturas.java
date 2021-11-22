/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Asignatura.Asignatura;
import Interfaz.InterfazLista;
import java.util.ArrayList;

/**
 *
 * @author luisb
 */
public class ListaAsignaturas implements InterfazLista {
    
    private ArrayList<Asignatura> asignaturas;
    
    public ListaAsignaturas() {
        this.asignaturas = new ArrayList<Asignatura>();
    }
}
