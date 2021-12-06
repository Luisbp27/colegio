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
public class Optativa extends Asignatura {

    @Override
    public void add(Estudiante e) {
        lre.addNodo(e);
    }

    public enum Tipo {
        TEÓRICA, PRÁCTICA;
    }
    
    private Tipo tipo;
    private int creditos;
    private String stringCurso;

    public Optativa(String nombre, int codigo, int creditos, Tipo tipo, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.creditos = creditos;
        this.tipo = tipo;
        this.stringCurso = curso.getNombre();
    }
    
    public Optativa(String nombre, int codigo, Tipo tipo, Curso curso) {
        super(nombre, codigo, curso.getNombre());
        this.tipo = tipo;
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
        return nombre + " CODIGO: " + codigo + " PERFIL: " + tipo;
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
    public Lista_Ref_Estudiantes getListaEstudiantes() {
        return this.lre;
    }
    
    @Override
    public int getSizeRef(){
        return lre.getSize();
    }
    
    public String getStringCurso() {
        return stringCurso;
    }
    
    //MÉTODOS EXPUESTOS A CONTINUACIÓN LO HARÁN LAS RESPECTIVAS LISTAS REF EN PRINCIPIO
    
    public Estudiante getRefEstudiante(int i) {
        return lre.getObject(i);
    }
}
