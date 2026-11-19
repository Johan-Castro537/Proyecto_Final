package Persona.estudiante.profesor;

public class Profesor extends Persona {
    private String facultad;
    private double salario;

    public Profesor(String id, String nombre, String email, String facultad, double salario) {
        super(id, nombre, email);
        this.facultad = facultad;
        this.salario = salario;
    }

    public String getFacultad() {
        return facultad;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Facultad: " + getFacultad());
        System.out.println("Salario: $" + getSalario());
    }
}
