package Sistemabiblioteca;

import java.util.Date;

public class Prestamo {
    private Date fechaInicio;
    private Date fechaDevolución;
    private String estado;
    private Libro libro;
    private Usuario usuario;

    public Prestamo(Date fechaInicio, Date fechaDevolución, String estado, Libro libro, Usuario usuario) {
        this.fechaInicio = fechaInicio;
        this.fechaDevolución = fechaDevolución;
        this.estado = estado;
        this.libro = libro;
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaDevolución() {
        return fechaDevolución;
    }

    public String getEstado() {
        return estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}