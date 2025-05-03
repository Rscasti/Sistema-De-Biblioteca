package Sistemabiblioteca;

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

            switch (opcion){
                case 1: {
                    ArrayList<Cliente> clientes = new ArrayList<>();
                    int idcontador = 1;
                    while (true){
                        System.out.println("********** REGISTRAR CLIENTE **********");
                        int id = idcontador++;

                        System.out.println("Ingrese el nombre:");
                        String nombre = scanner.nextLine();

                        System.out.println("Ingrese el correo:");
                        String correo = scanner.nextLine();

                        clientes.add(new Cliente(id, nombre, correo));

                        System.out.println("Quiere registrar otro cliente:? Si/No");
                        String respuesta = scanner.nextLine().toLowerCase(Locale.ROOT);

                        if (!respuesta.equals("si")){
                            break;
                        }
                    }
                    administrador.registrarCliente(clientes);
                    break;
                }
                case 2: {
                    ArrayList<Libro> libros = new ArrayList<>();
                    while (true){
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

                        if (!respuesta.equals("si")){
                            break;
                        }
                    }
                    administrador.registrarLibro(libros);
                    break;
                }
                case 3: {
                    System.out.println("HASTA LUEGO");
                    break;
                }
            }
        }while (opcion != 3);


    }
}