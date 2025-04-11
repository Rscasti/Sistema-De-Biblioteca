package Sistemabiblioteca;

import java.util.Date;

public class Prestamo {
    private Date fechaInicio;
    private Date fechaDevolución;
    private String estado; ("activo"/"entregad")
    private Libro libro;
    private Usuario usuario;
}