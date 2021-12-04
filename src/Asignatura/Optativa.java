/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;

/**
 *
 * @author luisb
 */
public class Optativa extends Asignatura {

    public enum Tipo {
        TEÓRICA, PRÁCTICA;
    }
    
    private static final int CREDITOS = 3;
    private Tipo tipo;

    public Optativa(String nombre, int codigo, Curso curso, Tipo tipo) {
        super(nombre, codigo, Optativa.CREDITOS, curso.getNombre());
        this.tipo=tipo;
    }

    public int compareTo(Asignatura t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
                return (nombre + " -> Perfil: "+ tipo +" Código: " + codigo + " Nº Créditos: " + CREDITOS);

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /*
    @Override
    public void setStringCurso(String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public String getStringCurso() {
        return this.stringCurso;
    }

    /*
     @Override
    public Estudiante getRefEstudiante(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    
    @Override
    public int getSizeRef() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Estudiante e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Estudiante e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    
    
    
}
