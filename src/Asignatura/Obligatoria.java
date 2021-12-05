/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Curso.Curso;
import Estudiante.Estudiante;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 *
 * @author luisb
 */
public class Obligatoria extends Asignatura {
    
    private int creditos;

    public Obligatoria(String nombre, int codigo, int creditos, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.creditos = creditos;
    }

    public int compareTo(Asignatura a) {
        int resultado = this.nombre.compareTo(a.nombre);
        
        if (resultado < 0) {
            return -1;
        } else {
            if (resultado == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        return nombre + " CÓDIGO: " + codigo + " Nº Créditos: " + creditos;
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
    
    @Override
    public Lista_Ref_Estudiantes getListaEstudiantes(){
        return this.lre;
    }
    @Override
    public int getSizeRef(){
        return lre.getSize();
    }
    /*en principio no vamos a modificar el nombre del curso en ningún momento
    
    public abstract void setStringCurso(String x);

    //MÉTODOS EXPUESTOS A CONTINUACIÓN LO HARÁN LAS RESPECTIVAS LISTAS REF EN PRINCIPIO
    
    public abstract Estudiante getRefEstudiante(int i);

   public abstract int getSizeRef(); cada lista tiene su getSize

    public abstract void add(Estudiante e);

    public abstract void remove(Estudiante e);
    */
    
}
