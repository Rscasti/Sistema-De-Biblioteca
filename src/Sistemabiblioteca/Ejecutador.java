package Sistemabiblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Ejecutador {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Administrador administrador = new Administrador(1,"Robert", "rscastillo2234@gmail.com");
        byte opcion = 0;

        do {
            System.out.println("::::::::::Bienvenido al sistema de biblioteca publica::::::::::");
            System.out.println("¿Por favor escoge una opción?");
            System.out.println("""
                    1. Registrar cliente:
                    2. Registar libro:
                    3. Registrar prestamo:
                    4. Salir del sistema:""");

            opcion = scanner.nextByte();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    ArrayList<Cliente> clientes = new ArrayList<>();
                    int idcontador = 1;
                    while (true) {
                        System.out.println("********** REGISTRAR CLIENTE **********");
                        int id = idcontador++;

                        System.out.println("Ingrese el nombre:");
                        String nombre = scanner.nextLine();

                        System.out.println("Ingrese el correo:");
                        String correo = scanner.nextLine();

                        clientes.add(new Cliente(id, nombre, correo));

                        System.out.println("Quiere registrar otro cliente:? Si/No");
                        String respuesta = scanner.nextLine().toLowerCase(Locale.ROOT);

                        if (!respuesta.equals("si")) {
                            break;
                        }
                    }
                    administrador.registrarCliente(clientes);
                    break;
                }
                case 2: {
                    ArrayList<Libro> libros = new ArrayList<>();
                    while (true) {
                        System.out.println("********** REGISTRO PARA LIBROS**********");

                        System.out.println("Ingrese el ISBN:");
                        String isbn = scanner.nextLine();

                        System.out.println("Ingrese el titulo del libro:");
                        String titulo = scanner.nextLine();

                        System.out.println("Ingrese el autor:");
                        String autor = scanner.nextLine();

                        System.out.println("¿Esta disponible:? Si/No");
                        boolean disponible = scanner.nextBoolean();
                        scanner.nextLine();

                        libros.add(new Libro(isbn, titulo, autor, disponible));

                        System.out.println("Quiere registrar otro libro:? Si/No");
                        String respuesta = scanner.nextLine().toLowerCase(Locale.ROOT);

                        if (!respuesta.equals("si")) {
                            break;
                        }
                    }
                    administrador.registrarLibro(libros);
                    break;
                }
                case 3: {
                    if (administrador.getClientes().isEmpty() || administrador.getLibros().isEmpty()) {
                        System.out.println("Debe registrar al menos un libro y un cliente antes de registrar un préstamo.");
                        break;
                    }

                    ArrayList<Prestamo> prestamos = new ArrayList<>();

                    while (true) {
                        // Mostrar libros disponibles
                        System.out.println("********** LIBROS DISPONIBLES **********");
                        ArrayList<Libro> librosDisponibles = new ArrayList<>();
                        for (Libro l : administrador.getLibros()) {
                            if (l.isDisponible()) {
                                librosDisponibles.add(l);
                                System.out.println((librosDisponibles.size()) + ". " + l.getTitulo() + " - " + l.getAutor());
                            }
                        }

                        if (librosDisponibles.isEmpty()) {
                            System.out.println("No hay libros disponibles actualmente.");
                            break;
                        }

                        System.out.print("Seleccione el número del libro: ");
                        int seleccionLibro = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        Libro libroSeleccionado = librosDisponibles.get(seleccionLibro - 1);

                        // Mostrar clientes disponibles
                        System.out.println("********** CLIENTES REGISTRADOS **********");
                        for (Cliente c : administrador.getClientes()) {
                            System.out.println("ID: " + c.getId() + " - " + c.getNombre());
                        }

                        System.out.print("Ingrese el ID del cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        Cliente clienteSeleccionado = administrador.buscarClientePorId(idCliente);

                        if (clienteSeleccionado == null) {
                            System.out.println("Cliente no encontrado.");
                            break;
                        }

                        LocalDate fechaInicio = LocalDate.now();
                        LocalDate fechaDevolucion = fechaInicio.plusDays(30);
                        String estado = "activo";

                        Prestamo prestamo = new Prestamo(fechaInicio, fechaDevolucion, estado, libroSeleccionado, clienteSeleccionado);
                        prestamos.add(prestamo);
                        administrador.realizarPrestamo(prestamo);

                        libroSeleccionado.setDisponible(false);

                        System.out.println("Préstamo registrado exitosamente.");
                        System.out.println("¿Desea registrar otro préstamo? Si/No");
                        String respuesta = scanner.nextLine().toLowerCase(Locale.ROOT);
                        if (!respuesta.equals("si")) {
                            break;
                        }
                        administrador.realizarPrestamo(prestamo);
                    }
                    break;
                }

                case 4: {
                    System.out.println("***** GRACIAS POR UTILIZAR NUESTRO SISTEMA, HASTA LUEGO *****");
                    break;
                }
            }
        }while (opcion != 4);

    }
}