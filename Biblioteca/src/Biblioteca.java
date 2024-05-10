import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private static Scanner scanner = new Scanner(System.in);
    private List<Persona> usuarios = new ArrayList<>();
    private List<Libro> inventarioLibros = new ArrayList<>();

    public void cargarMaterial() {
        // Método para cargar materiales en la biblioteca
        System.out.println("Cargando materiales...");
        inventarioLibros.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"));
        inventarioLibros.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        inventarioLibros.add(new Libro("El principito", "Antoine de Saint-Exupéry"));
        // Agregar más libros aquí...
    }

    public void cargarPersona() {
        // Método para cargar personas en la biblioteca
        System.out.println("Registrando usuarios...");
        System.out.println("Por favor, ingrese su información:");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Número de celular: ");
        String celular = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();

        usuarios.add(new Persona(id, apellido, nombre, direccion, celular, correoElectronico));
    }

    public void mostrarInventario() {
        System.out.println("\nInventario de libros:");
        for (int i = 0; i < inventarioLibros.size(); i++) {
            System.out.println((i + 1) + ". " + inventarioLibros.get(i).getTitulo() + " - " + inventarioLibros.get(i).getAutor() + " - Disponible: " + inventarioLibros.get(i).isDisponible());
        }
    }

    public Libro seleccionarLibro() {
        System.out.print("Seleccione el número del libro: ");
        int opcionLibro = Integer.parseInt(scanner.nextLine());

        if (opcionLibro >= 1 && opcionLibro <= inventarioLibros.size()) {
            return inventarioLibros.get(opcionLibro - 1);
        } else {
            System.out.println("¡Opción inválida!");
            return null;
        }
    }

    public void gestionarPrestamo(Persona usuario) {
        System.out.println("\nSeleccione el libro que desea pedir prestado:");
        mostrarInventario();
        Libro libroPrestamo = seleccionarLibro();

        if (libroPrestamo != null) {
            if (!libroPrestamo.isDisponible()) {
                System.out.println("Lo siento, el libro '" + libroPrestamo.getTitulo() + "' ya está ocupado.");
            } else {
                libroPrestamo.setDisponible(false);
                System.out.println(usuario.nombre + " ha tomado prestado el libro '" + libroPrestamo.getTitulo() + "'");
            }
        }
    }

    public void gestionarReserva(Persona usuario) {
        System.out.println("\nSeleccione el libro que desea reservar:");
        mostrarInventario();
        Libro libroReserva = seleccionarLibro();

        if (libroReserva != null) {
            if (!libroReserva.isDisponible()) {
                System.out.println("Lo siento, el libro '" + libroReserva.getTitulo() + "' ya está ocupado.");
            } else {
                if (libroReserva.getPersonaReserva() == null) {
                    libroReserva.setPersonaReserva(usuario);
                    System.out.println(usuario.nombre + " ha reservado el libro '" + libroReserva.getTitulo() + "'");
                } else {
                    System.out.println("Lo siento, el libro '" + libroReserva.getTitulo() + "' ya ha sido reservado por otro usuario.");
                }
            }
        }
    }

    public void gestionarDevolucion(Persona usuario) {
        System.out.println("\nSeleccione el libro que desea devolver:");
        mostrarInventario();
        Libro libroDevolucion = seleccionarLibro();

        if (libroDevolucion != null) {
            if (libroDevolucion.isDisponible()) {
                System.out.println("Lo siento, el libro '" + libroDevolucion.getTitulo() + "' ya está disponible en la biblioteca.");
            } else {
                libroDevolucion.setDisponible(true);
                System.out.println(usuario.nombre + " ha devuelto el libro '" + libroDevolucion.getTitulo() + "'");
            }
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.cargarMaterial();
        biblioteca.cargarPersona();
        biblioteca.mostrarInventario();

        Persona usuario = biblioteca.usuarios.get(0); // Tomamos el primer usuario registrado

        boolean continuar = true;
        while (continuar) {
            // Ofrecer opciones al usuario
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Pedir prestado un libro");
            System.out.println("2. Reservar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    biblioteca.gestionarPrestamo(usuario);
                    break;
                case 2:
                    biblioteca.gestionarReserva(usuario);
                    break;
                case 3:
                    biblioteca.gestionarDevolucion(usuario);
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        System.out.println("¡Programa ejecutado exitosamente!");
    }
}
