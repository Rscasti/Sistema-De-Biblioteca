package Sistemabiblioteca;

import java.util.ArrayList;
import java.util.Date;

public class Ejecutador {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Andres Muñoz", "andresmuñoz@gmail.com"));
        clientes.add(new Cliente(1, "Luisa Rodriguez", "luisarodriguez@gmail.com"));
        clientes.add(new Cliente(3, "Andres Manuel", "andresmanuel@gmail.com"));

        Usuario usuario = new Usuario(1096216846, "Robert Castillo", "rscastillo2234@gmail.com");

        Administrador administrador = new Administrador(1096216846, "Robert Steven Castillo Pérez",
                "robert.castillope@unipaz.edu.co");
        Libro libro = new Libro("978-950-563-656", "La Divina Comedia", "Dante Alighieri", true);
        Prestamo prestamo = new Prestamo(new Date(), new Date(28/07/2025), "Activo", libro, usuario);
        Cliente cliente = new Cliente(37930303, "Luisa Morales", "luisamorales@gmail.com");

        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("::: Software de prestamo de libros en una biblioteca:::");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Id: " + usuario.getId()
        + "\nCliente: " + usuario.getNombre()
        + "\nCorreo: " + usuario.getCorreo());
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}