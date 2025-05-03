package Sistemabiblioteca;

public class Administrador extends Usuario {
    public Administrador(int id, String nombre, String correo) {
        super(id, nombre, correo);
    }

    public void registrarCliente(Cliente c) {
    }

    public void registrarLibro(Libro libro) {
    }

    public void realizarPrestamo(Usuario u, Libro libro ) {
    }
}