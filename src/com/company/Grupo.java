package com.company;

import java.util.ArrayList;

public class Grupo {
    private ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
    private String nombre, materia;

    public Grupo(String nombre, String materia) {
        this.nombre = nombre;
        this.materia = materia;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Grupo :" + nombre + "-" + materia + " alumnos : " + alumnos + '\'';
    }
}
