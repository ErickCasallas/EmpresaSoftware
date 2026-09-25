package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.util.Locale;

public class Desarrollador{
    private String id;
    private String name;
    private String nivel;
    private int cantidadProyectoSilmutaneo;
    private int proyectosActuales;
    private String equipoTrabajo;
    private double tarifaDia;
    private boolean disponible;


    public Desarrollador(String id,String name, String nivel, String equipoTrabajo, double tarifaDia) {
        this.name=name;
        setId(id);
        setNivel(nivel);
        setEquipoTrabajo(equipoTrabajo);
        this.tarifaDia = tarifaDia;
        this.disponible=true;
    }
    public int getProyectosActuales() {
        return proyectosActuales;
    }

    public int getCantidadProyectoSilmutaneo() {
        return cantidadProyectoSilmutaneo;
    }

    public void setCantidadProyectoSilmutaneo(int cantidadProyectoSilmutaneo) {
        this.cantidadProyectoSilmutaneo = cantidadProyectoSilmutaneo;
    }

    // Método para incrementar el contador de proyectos y verificar la disponibilidad
    public void incrementarProyectos() {
        this.proyectosActuales++;
        if (this.proyectosActuales >= this.cantidadProyectoSilmutaneo) {
            this.disponible = false; // Se marca como no disponible al llegar o superar el límite
        }
    }

    // Método opcional por si se libera de un proyecto
    public void decrementarProyectos() {
        if (this.proyectosActuales > 0) {
            this.proyectosActuales--;
        }
        if (this.proyectosActuales < this.cantidadProyectoSilmutaneo) {
            this.disponible = true;
        }
    }
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        boolean valido;
        do {
            valido = true;
            for (int i = 0; i < id.length(); i++) {
                char caracter = id.charAt(i);
                if (!Character.isDigit(caracter)) {
                    valido = false;
                    JOptionPane.showMessageDialog(null, "ID invalido");
                    id = JOptionPane.showInputDialog("Ingrese nuevamente el ID (solo números):");
                    break;
                }
            }
        } while (!valido);
        this.id = id;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        boolean valido;
        do {
            switch (nivel.toLowerCase()) {
                case "junior":
                    valido = false;
                    break;
                case "semisenior":
                    valido = false;
                    break;
                case "senior":
                    valido = false;
                    break;
                default:
                    valido = true;
                    JOptionPane.showMessageDialog(null,"Nivel Invalido");
                    nivel = JOptionPane.showInputDialog("Ingrese nuevamente el nivel (Junior - Semisenior - Senior):");
                    break;
            }
        } while (valido);
        this.nivel = nivel;
    }
    public double getTarifaDia() {
        return tarifaDia;
    }
    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        boolean valido;
        do {
            switch (equipoTrabajo.toLowerCase()) {
                case "fronted":
                    valido = false;
                    break;
                case "backend":
                    valido = false;
                    break;
                case "movile Devs":
                    valido = false;
                    break;
                case "devops":
                    valido = false;
                    break;
                case "qa":
                    valido = false;
                    break;
                default:
                    valido = true;
                    JOptionPane.showMessageDialog(null,"Equipo de trabajo invalido");
                    equipoTrabajo = JOptionPane.showInputDialog("Ingrese nuevamente el equipo de trabajo (Fronted - Backend - Mobile Devs - DevOps - QA):");
                    break;
            }
        } while (valido);
        this.equipoTrabajo = equipoTrabajo;
    }
}
