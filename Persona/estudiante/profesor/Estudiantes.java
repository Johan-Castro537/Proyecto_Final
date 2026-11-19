package Persona.estudiante.profesor;

import java.util.HashMap;

public class Estudiantes {

    private HashMap<String, Estudiante> mapaEstudiantes;

    public Estudiantes() {
        this.mapaEstudiantes = new HashMap<>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        if (mapaEstudiantes.containsKey(estudiante.getId())) {
            System.out.println("Ya existe un estudiante con el ID: " + estudiante.getId());
        } else {
            mapaEstudiantes.put(estudiante.getId(), estudiante);
            System.out.println("Estudiante registrado exitosamente.");
        }
    }

    public Estudiante buscarPorId(String id) throws excepciones.EstudianteNoEncontradoException {
        Estudiante encontrado = mapaEstudiantes.get(id);
        if (encontrado == null) {
            throw new excepciones.EstudianteNoEncontradoException("No existe estudiante con ID: " + id);
        }
        return encontrado;
    }

    public void listarTodos() {
        if (mapaEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\n--- LISTA DE ESTUDIANTES ---");
            for (Estudiante est : mapaEstudiantes.values()) {
                est.mostrarInformacion();
                System.out.println("----------------------------");
            }
        }
    }

    public Estudiante eliminarEstudiante(String id) throws excepciones.EstudianteNoEncontradoException {
        Estudiante eliminado = buscarPorId(id);
        mapaEstudiantes.remove(id);
        System.out.println("Estudiante eliminado exitosamente.");
        return eliminado;
    }
}