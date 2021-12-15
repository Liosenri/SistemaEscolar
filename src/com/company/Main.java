package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Escuela tecnologico = new Escuela();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        String opcion;

        while (!salir) {
            System.out.println("**************************");
            System.out.println("* [1] Agregar Materia    *");
            System.out.println("* [2] Eliminar Materia   *");
            System.out.println("* [3] Imprimir Materias  *");
            System.out.println("* [4] Agregar Grupo      *");
            System.out.println("* [5] Eliminar Grupo     *");
            System.out.println("* [6] Imprimir Grupos    *");
            System.out.println("* [7] Agregar Alumno     *");
            System.out.println("* [S] Salir              *");
            System.out.println("* Seleccione una opcion: *");
            System.out.println("**************************");
            opcion = sn.nextLine().toUpperCase();

            switch (opcion) {
                case "1":
                    tecnologico.agregarMateria();
                    break;
                case "2":
                    tecnologico.eliminarMateria();
                    break;
                case "3":
                    tecnologico.imprimirMaterias();
                    break;
                case "4":
                    tecnologico.agregarGrupo();
                    break;
                case "5":
                    tecnologico.eliminarGrupo();
                    break;
                case "6":
                    tecnologico.imprimirGrupos();
                    break;
                case "7":
                    tecnologico.agregarAlumno();
                    break;
                case "S":
                    salir = true;
                    tecnologico.guardarDatos();
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
                    break;
            }
        }
    }
}
