/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;

import Curso.Curso;
import Interfaz.InterfazLista;
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;

/**
 *
 * @author luisb
 */
public class ListaCursos1 implements InterfazLista {
    
    private ArrayList<Curso> cursos;
    
    public ListaCursos1() {
        this.cursos = new ArrayList<>();
    }
    
    //tamaño de la lista
    @Override
    public int getSize() {
        return cursos.size();
    }
    
    @Override
    public void setObject(Object curso) {
        cursos.add((Curso)curso);
    }

    @Override
    public void setObject(int i, Object curso) {
      cursos.add(i, (Curso)curso);
    }
    
    public void addObject(Object curso) {
              cursos.add((Curso)curso);
    }
    @Override
    public Curso getObject(int pos){
       return  cursos.get(pos);     
    }

    @Override 
    //probar si va bien, en principio solo funciona datos Object primitivos
    //no objetos 
    public void removeObject(Object o) {
       cursos.remove((Curso)o);
    }

    @Override 
    public void removeObject(int pos) {
        cursos.remove(pos);
    }
    
     @Override
    public String getInfo(int pos) {
       return  cursos.get(pos).toString();   
    }
    
    @Override
    public String getInfoTotal() {
        String s="";
        for(int i=0;i<getSize();i++){
            s+= getObject(i).toString()+"\n";
        }
        return s;
    }

    
    
}