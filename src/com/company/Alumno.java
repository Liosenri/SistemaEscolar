package com.company;

public class Alumno extends Persona {
    private String numeroDeControl;

    public Alumno(String numeroDeControl,String nombre, String edad) {
        super(nombre, edad);
        this.numeroDeControl = numeroDeControl;
    }

    public String getNumeroDeControl() {
        return numeroDeControl;
    }

    public void setNumeroDeControl(String numeroDeControl) {
        this.numeroDeControl = numeroDeControl;
    }

    @Override
    public String toString() {
        return "Nombre:" + getNombre() + " Edad:" + getEdad() + " Numero de control: " + numeroDeControl;
    }
}
