package Sistemabiblioteca;

import java.util.ArrayList;

public class Administrador extends Usuario {
    private ArrayList<Cliente> clientes;
    private ArrayList<Libro> libros;
    private ArrayList<Prestamo> prestamos;

    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
        this.clientes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void registrarCliente(ArrayList<Cliente> clientes) {
        for (Cliente c: clientes){
            this.clientes.add(c);
            System.out.println("Clientes registrados: ID: " + c.getId() + "\nNombre: " + c.getNombre() + "\nCorreo: " + c.getCorreo());
        }
    }

    public void registrarLibro(ArrayList<Libro> libros) {
        for (Libro l: libros){
            this.libros.add(l);
            System.out.println("Libros registrados: ISBN: " + l.getIsbn() + "\nTitulo: " + l.getTitulo() + "\nAutor"
                    +l.getAutor() + "Disponible" + l.isDisponible());
        }
    }

    public void realizarPrestamo(Usuario u, Libro libro ) {
    }
}