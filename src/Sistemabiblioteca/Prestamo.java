package Sistemabiblioteca;

import java.time.LocalDate;
import java.util.Date;

public class Prestamo {
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;
    private String estado;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(LocalDate fechaInicio, LocalDate fechaDevolucion, String estado, Libro libro, Usuario usuario) {
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
        this.libro = libro;
        this.usuario = usuario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolución() {
        return fechaDevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getCliente() {
        return usuario;
    }

}