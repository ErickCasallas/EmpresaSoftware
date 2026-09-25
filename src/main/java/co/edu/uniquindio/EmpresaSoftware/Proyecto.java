package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private int diasDesarrollo;

    public Proyecto(String id, LocalDate fechaSolicitud, LocalDate fechaInicio, LocalDate fechaEntrega, String estado, String metodoPago, Servicio[] servicios) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        setEstado(estado);
        setMetodoPago(metodoPago);
        this.servicios=servicios;
        this.cantidadDesarrolladores=0;
        calcularDiasDesarrollo();

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
        calcularDiasDesarrollo();
    }
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        calcularDiasDesarrollo();
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
    public void calcularDiasDesarrollo() {
        if (fechaInicio != null && fechaEntrega != null) {
            diasDesarrollo = (int) ChronoUnit.DAYS.between(fechaInicio, fechaEntrega);
        } else {
            diasDesarrollo = 0;
        }
    }
    public int getDiasDesarrollo(){
            return diasDesarrollo;}

    public void setDiasDesarrollo(int diasDesarrollo) {
            this.diasDesarrollo = diasDesarrollo;
        }

    public double calcularTotal(){
        double sumaTarifasD = 0;
        if (this.desarrolladores!=null){
            for (int i = 0; i < this.desarrolladores.length;i++){
                if (this.desarrolladores[i]!=null){
                    sumaTarifasD += this.desarrolladores[i].getTarifaDia();
                }
            }
        }

        double costoDesarrolladores = sumaTarifasD * this.diasDesarrollo;

        double costoSericios = 0;

        if (this.servicios != null){
            for (int j = 0; j < this.servicios.length;j++){
                if (this.servicios[j]!=null){
                    costoSericios +=this.servicios[j].getPrecio();
                }
            }
        }
        return costoSericios + costoDesarrolladores;
    }
}

