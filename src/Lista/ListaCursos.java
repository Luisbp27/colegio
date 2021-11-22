/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Curso.Curso;
import Interfaz.InterfazLista;
import java.util.ArrayList;

/**
 *
 * @author luisb
 */
public class ListaCursos implements InterfazLista {
    
    private ArrayList<Curso> cursos;
    
    public ListaCursos() {
        this.cursos = new ArrayList<Curso>();
    }
}
