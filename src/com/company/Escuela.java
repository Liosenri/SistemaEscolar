package com.company;

import javax.xml.stream.events.Comment;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface FuncionalidadEscuela {
    public void agregarAlumno();
    public void agregarGrupo();
    public void agregarMateria();
}

public class Escuela implements FuncionalidadEscuela {
    private ArrayList<String> materias = new ArrayList<String>();
    private ArrayList<Grupo> grupos = new ArrayList<Grupo>();

    String directorioRaiz = "/Users/luismedina/Desktop/SistemaEscolar/src/com/company";
    String materiasDirectory = directorioRaiz + "/materias.txt";
    String gruposDirectory = directorioRaiz + "/grupos.txt";
    String alumnosDirectory = directorioRaiz + "/alumnos.txt";

    public Escuela() {
        cargarMaterias();
        cargarGrupos();
        cargarAlumnos();
    }

    public void agregarAlumno(){
        Scanner sn = new Scanner(System.in);
        imprimirSubMenuGrupos();
        String opcionGrupo = sn.nextLine();
        Grupo grupoSeleccionado = seleccionarGrupo(opcionGrupo);
        if(grupoSeleccionado == null) {
            return;
        }
        System.out.println("Introduce el nombre del alumno");
        String nombreAlumno = sn.nextLine();
        System.out.println("Iintroduce la edad del alumno");
        String edadAlumno = sn.nextLine();
        System.out.println("Introduce el numero de control del alumno");
        String numeroControlAlumno = sn.nextLine();
        Alumno nuevoAlumno = new Alumno(numeroControlAlumno,nombreAlumno,edadAlumno);
        grupoSeleccionado.getAlumnos().add(nuevoAlumno);
    }

    public void agregarGrupo() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce el nombre del grupo");
        String nombreGrupo = sn.nextLine().toUpperCase();
        imprimirSubMenuMaterias();
        String opcionMateria = sn.nextLine().toUpperCase();
        String materiaGrupo = seleccionarMateria(opcionMateria);
        Grupo nuevoGrupo = new Grupo(nombreGrupo, materiaGrupo);
        grupos.add(nuevoGrupo);
        System.out.println("Grupo agregado con exito");
    }

    public void imprimirGrupos() {
        System.out.println(grupos);
    }

    public void imprimirMaterias() {
        System.out.println(materias);
    }

    public void agregarMateria() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Introduce el nombre de la materia");

        String nombreMateriaAgregar = sn.nextLine().toUpperCase();

        for (String materia : materias) {
            if (materia.equals(nombreMateriaAgregar)) { // verificamos si la materia ya fue agregada con anterioridad
                System.out.println("Esta materia ya existe en los registros");
                return;
            }
        }

        materias.add(nombreMateriaAgregar);
        System.out.println("Materia agregada con exito");
    }

    public void imprimirSubMenuGrupos() {
        System.out.println("Elige un grupo");
        for (int i = 0; i < grupos.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " " + grupos.get(i));
        }
        System.out.println("[0] Cancelar");
    }

    public void eliminarGrupo(){
        String idGrupoBorrar;
        Scanner sn = new Scanner(System.in);
        imprimirSubMenuGrupos();
        idGrupoBorrar = sn.nextLine();

        if (idGrupoBorrar.equals("0")) {
            return; // finalizamos la accion de borrado
        }

        if (esNumero(idGrupoBorrar)) {
            int indice = Integer.parseInt(idGrupoBorrar) - 1;
            if (indice < 0 || indice > grupos.size()) {
                System.out.println("Opcion invalida");
            } else {
                grupos.remove(indice);
            }
        } else {
            System.out.println("Opcion invalida");
        }
    }


    public void imprimirSubMenuMaterias() {
        System.out.println("Elige una materia");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + " " + materias.get(i));
        }
        System.out.println("[0] Cancelar");
    }

    public void eliminarMateria() {
        Scanner sn = new Scanner(System.in);
        imprimirSubMenuMaterias();
        String idMateriaBorrar = sn.nextLine();

        if (idMateriaBorrar.equals("0")) {
            return; // finalizamos la accion de borrado
        }

        if (esNumero(idMateriaBorrar)) {
            int indice = Integer.parseInt(idMateriaBorrar) - 1;
            if (indice < 0 || indice > materias.size()) {
                System.out.println("Opcion invalida");
            } else {
                materias.remove(indice);
            }
        } else {
            System.out.println("Opcion invalida");
        }
    }

    public String seleccionarMateria(String opcionMateria) {
        if (esNumero(opcionMateria)) {
            int indice = Integer.parseInt(opcionMateria) - 1;
            if (indice < 0 || indice > materias.size()) {
                System.out.println("Opcion invalida");
            } else {
                return materias.get(indice);
            }
        } else {
            System.out.println("Opcion invalida");
        }
        return null;
    }

    public Grupo seleccionarGrupo(String opcionGrupo) {
        if (esNumero(opcionGrupo)) {
            int indice = Integer.parseInt(opcionGrupo) - 1;
            if (indice < 0 || indice > grupos.size()) {
                System.out.println("Opcion invalida");
            } else {
                return grupos.get(indice);
            }
        } else {
            System.out.println("Opcion invalida");
        }
        return null;
    }

    public ArrayList<String> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    // Metodo que ayuda a saber si un string contiene solo numeros , fuente https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/
    private static boolean esNumero(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    public void guardarDatos() {
        try {
            File materiasFile = new File(materiasDirectory);
            FileOutputStream materiasFileStream = new FileOutputStream(materiasFile);
            ObjectOutputStream materiasOutput = new ObjectOutputStream(materiasFileStream);

            File gruposFile = new File(gruposDirectory);
            FileOutputStream gruposFileStream = new FileOutputStream(gruposFile);
            ObjectOutputStream gruposOutput = new ObjectOutputStream(gruposFileStream);

            File alumnosFile = new File(alumnosDirectory);
            FileOutputStream alumnosFileStream = new FileOutputStream(alumnosFile);
            ObjectOutputStream alumnosOutput = new ObjectOutputStream(alumnosFileStream);

            for (Grupo grupo : grupos) {
                gruposOutput.writeObject(grupo.getNombre() + "-" + grupo.getMateria());
                for (Alumno alumno: grupo.getAlumnos()) {
                    alumnosOutput.writeObject(grupo.getNombre() + "-" + alumno.getNumeroDeControl() + "-" + alumno.getNombre() + "-" + alumno.getEdad());
                }
            }

            for (String materia : materias) {
                materiasOutput.writeObject(materia);
            }

            gruposFileStream.close();
            alumnosFileStream.close();
            materiasFileStream.close();
        } catch (IOException e) {
            System.out.println("Error al agregar contacto");
        }
    }

    public void cargarMaterias() {
        System.out.println("Cargando Materias...");
        try {
            File materiasFile = new File(materiasDirectory);
            FileInputStream materiasFileStream = new FileInputStream(materiasFile);
            ObjectInputStream materiasInput = new ObjectInputStream(materiasFileStream);

            while (true) {
                String materia = materiasInput.readObject().toString();
                materias.add(materia);
            }
        } catch (IOException | ClassNotFoundException e) {
            if (e.toString().equals("java.io.EOFException")) {
                return;
            }
            System.out.println("Error al leer el directorio, " + e);
        }
    }

    public void cargarGrupos() { // cargara los grupos al momento de iniciar la aplicacion
        System.out.println("Cargando Grupos...");
        try {
            File gruposFile = new File(gruposDirectory);
            FileInputStream gruposFileStream = new FileInputStream(gruposFile);
            ObjectInputStream gruposInput = new ObjectInputStream(gruposFileStream);
            while (true) {
                String gruposString = gruposInput.readObject().toString();
                String[] splitGrupoString = gruposString.split("-");
                // splitGrupoString[0] = Nombre del grupo
                // splitGrupoString[1] = La materia del grupo
                Grupo grupo = new Grupo(splitGrupoString[0], splitGrupoString[1]);
                grupos.add(grupo);
            }
        } catch (IOException | ClassNotFoundException e) {
            if (e.toString().equals("java.io.EOFException")) {
                return;
            }
            System.out.println("Error al leer el directorio, " + e);
        }
    }

    public void cargarAlumnos() {
        System.out.println("Cargando alumnos");
        try {
            File alumnosFile = new File(alumnosDirectory);
            FileInputStream alumnosFileStream = new FileInputStream(alumnosFile);
            ObjectInputStream alumnosInput = new ObjectInputStream(alumnosFileStream);
            while (true) {
                String alumnoString = alumnosInput.readObject().toString();
                String[] splitAlumnoString = alumnoString.split("-");
                for (Grupo grupo : grupos) {
                    if(grupo.getNombre().equals(splitAlumnoString[0])) {
                        // splitAlumnoString[0] = Nombre del grupp
                        // splitAlumnoString[1] = Numero de control
                        // splitAlumnoString[2] = Nombre
                        // splitAlumnoString[0] = Edad
                        grupo.getAlumnos().add(new Alumno(splitAlumnoString[1],splitAlumnoString[2],splitAlumnoString[3]));
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            if (e.toString().equals("java.io.EOFException")) {
                return;
            }
            System.out.println("Error al leer el directorio, " + e);
        }
    }

}

