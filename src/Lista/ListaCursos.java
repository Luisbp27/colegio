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
public class ListaCursos implements InterfazLista {
    
    private ArrayList<Curso> cursos;
    
    public ListaCursos() {
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
    
    /*public void addObject(Object curso) {
              cursos.add((Curso)curso);
    }*/
    @Override
    public Curso getObject(int pos){
       return  cursos.get(pos);     
    }
    
     public Curso getObjectPorNombre(String nombre){
         int i=0;
         for(i=0;i<getSize();i++){
             if(getObject(i).getNombre().equals(nombre)){
                 return getObject(i);
             }
         }
         //en principio no sale del bucle sin encontrar coincidencia
         return getObject(i); 
     }
     
     public Curso getObjectPorCodigo(int codigo){
        int i=0;
         for(i=0;i<getSize();i++){
             if(getObject(i).getCodigo()==codigo){
                 return getObject(i);
             }
         }
         //en principio no sale del bucle sin encontrar coincidencia
         return getObject(i); 
     }
     
     //método que busca un elemento de la lista, sino está devuleve null;
      public Curso getObject(Object object){
        int i;
         for(i=0;i<getSize();i++){
             if(getObject(i).equals((Curso)object)){
                 return getObject(i);
             }
         }
         //en principio no sale del bucle sin encontrar coincidencia
         return null; 
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
    
     @Override //imprime todo el objeto nombre y código
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
    
    public int getIndexof(Object x) {
        return cursos.indexOf(x);
    }
    
     public Object[] getArray() {
        return cursos.toArray();
    }

    public void removeObject(String s) {
        for (int i = 0; i < this.getSize(); i++) {
            if (cursos.get(i).getNombre() == s) {
                cursos.remove(i);
            }
        }
    }
    
    //método que estaba antes
    /* public void removeObject(Object x) {
        cursos.remove(x);
    }
    */
    
}