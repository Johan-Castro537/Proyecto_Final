import Persona.estudiante.profesor.Estudiantes;
import excepciones.EstudianteNoEncontradoException;
import Persona.estudiante.profesor.Estudiante;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiantes gestorEstudiantes = new Estudiantes();

        int opcion = 0;

        while (opcion != 22) {
            System.out.println("\n==========================================");
            System.out.println("  PLANIFICACION ACADEMICA - UNIVERSIDAD   ");
            System.out.println("==========================================");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("=== SALIR ===");
            System.out.println("22. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    System.out.println("\nREGISTRO DE ESTUDIANTE");
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Semestre actual: ");
                    int semestre = Integer.parseInt(scanner.nextLine());

                    Estudiante nuevo = new Estudiante(id, nombre, email, semestre);
                    gestorEstudiantes.registrarEstudiante(nuevo);

                } else if (opcion == 2) {
                    System.out.println("\nBUSCAR ESTUDIANTE");
                    System.out.print("ID: ");
                    String id = scanner.nextLine();

                    Estudiante encontrado = gestorEstudiantes.buscarPorId(id);
                    System.out.println("Resultado encontrado:");
                    encontrado.mostrarInformacion();

                } else if (opcion == 3) {
                    gestorEstudiantes.listarTodos();

                } else if (opcion == 4) {
                    System.out.println("\nELIMINAR ESTUDIANTE");
                    System.out.print("ID del estudiante a eliminar: ");
                    String id = scanner.nextLine();

                    gestorEstudiantes.eliminarEstudiante(id);

                } else if (opcion == 22) {
                    System.out.println("\nSaliendo del sistema");
                } else {
                    System.out.println("\nOpcion no valida, intente de nuevo");
                }

            } catch (EstudianteNoEncontradoException e) {
                System.out.println("\nError: EstudianteNoEncontradoException");
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("\nError: debe ingresar un numero valido");
            }
        }

        scanner.close();
    }
}