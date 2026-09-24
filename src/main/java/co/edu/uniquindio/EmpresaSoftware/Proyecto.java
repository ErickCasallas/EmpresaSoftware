package co.edu.uniquindio.EmpresaSoftware;

import java.time.LocalDate;

public class Proyecto {
    private String id;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String estado;
    private String metodoPago;
    private Servicio[] servicios= new Servicio[4];

    public Proyecto(String id, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega, String estado, String metodoPago, Servicio[] servicios) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.servicios=servicios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public void setServicios(Servicio[] servicios) {
        this.servicios = servicios;
    }

    public void agregarServicio(Servicio servicio) {

        for (int i = 0; i < servicios.length; i++) {

            if (servicios[i] == null) {
                servicios[i] = servicio;
                return;
            }
        }
    }
}
