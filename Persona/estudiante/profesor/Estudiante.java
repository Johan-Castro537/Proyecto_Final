package Persona.estudiante.profesor;

import java.util.LinkedList;

public class Estudiante extends Persona {
    private int semestre;
    private Double[][] notas; // 10 semestres maximo, 20 materias por semestre
    private LinkedList<String> historialMaterias;

    public Estudiante(String id, String nombre, String email, int semestre) {
        super(id, nombre, email);
        this.semestre = semestre;
        this.notas = new Double[10][20];
        this.historialMaterias = new LinkedList<>();
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    public double calcularPromedioAcumulado() {
        double suma = 0;
        int cantidadNotas = 0;

        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] != null) {
                    suma = suma + notas[i][j];
                    cantidadNotas++;
                }
            }
        }

        if (cantidadNotas == 0) {
            return 0.0;
        }
        return suma / cantidadNotas;
    }

    @Override
    public void mostrarInformacion() {
        double promedio = calcularPromedioAcumulado();
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Semestre: " + semestre);
        if (promedio == 0.0) {
            System.out.println("Promedio acumulado: 0.0 (sin notas aun)");
        } else {
            System.out.printf("Promedio acumulado: %.2f%n", promedio);
        }
    }
}