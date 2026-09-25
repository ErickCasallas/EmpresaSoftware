package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.time.LocalDate;

public class Proyecto {
    private String id;
    private LocalDate fechaSolicitud;
    private LocalDate fechaInicio;
    private LocalDate fechaEntrega;
    private String estado;
    private String metodoPago;
    private Servicio[] servicios= new Servicio[4];
    private Desarrollador[] desarrolladores=new Desarrollador[100];
    int cantidadDesarrolladores;

    public Proyecto(String id, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega, String estado, String metodoPago, Servicio[] servicios) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        setEstado(estado);
        setMetodoPago(metodoPago);
        this.servicios=servicios;
        this.cantidadDesarrolladores=0;
    }
    public Desarrollador[] getDesarrolladores(){
        return this.desarrolladores;
    }
    public int getCantidadDesarrolladores() {
        return cantidadDesarrolladores;
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
        boolean valido;
        do {
            switch (estado.toLowerCase()) {
                case "pendiente":
                    valido = false;
                    break;
                case "confirmado":
                    valido = false;
                    break;
                case "en curso":
                    valido = false;
                    break;
                case "entregado":
                    valido = false;
                    break;
                case "cancelado":
                    valido = false;
                    break;
                default:
                    valido = true;
                    JOptionPane.showMessageDialog(null,"Estado del proyecto invalido");
                    estado = JOptionPane.showInputDialog("Ingrese nuevamente el estado del proyecto (Pendiente - Confirmado - En curso - Finalizado - Cancelado): ");
                    break;
            }
        } while (valido);
        this.estado = estado;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        boolean valido;
        do {
            switch (metodoPago.toLowerCase()) {
                case "tarjeta":
                    valido = false;
                    break;
                case "efectivo":
                    valido = false;
                    break;
                case "transferencia":
                    valido = false;
                    break;
                default:
                    valido = true;
                    JOptionPane.showMessageDialog(null,"Metodo de pago invalido");
                    metodoPago = JOptionPane.showInputDialog("Ingrese nuevamente el metodo de pago (Tarjeta - Efectivo - Transferencia): ");
                    break;
            }
        } while (valido);
        this.metodoPago = metodoPago;
    }
    public Servicio[] getServicios() {
        return servicios;
    }
    public void agregarServicio(Servicio servicio) {

        for (int i = 0; i < servicios.length; i++) {
            if (servicios[i] == null) {
                servicios[i] = servicio;
                return;
            }
        }
    }
    public void agregarDesarrollador(Desarrollador desarrollador){
        for (int i = 0; i < desarrolladores.length; i++) {
            if (desarrolladores[i]==null){
                desarrolladores[i]= desarrollador;
                cantidadDesarrolladores++;
                return;
            }
        }
    }
}
