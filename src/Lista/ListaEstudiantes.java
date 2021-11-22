/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Estudiante.Estudiante;
import Interfaz.InterfazLista;
import java.util.ArrayList;

/**
 *
 * @author luisb
 */
public class ListaEstudiantes implements InterfazLista {
    
    private ArrayList<Estudiante> estudiantes;
    
    public ListaEstudiantes() {
        this.estudiantes = new ArrayList<Estudiante>();
    }
}
