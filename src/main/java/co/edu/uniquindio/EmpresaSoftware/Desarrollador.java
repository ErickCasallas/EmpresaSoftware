package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.util.Locale;

public class Desarrollador {
    private String id;
    private String name;
    private String nivel;
    private String cantidadProyectoSilmutaneo;
    private double tarifaDia;
    private Proyecto[] proyectos= new Proyecto[100];

    public Desarrollador(String id,String name, String nivel, String cantidadProyectoSilmutaneo, double tarifaDia) {
        this.name=name;
        setId(id);
        setNivel(nivel);
        this.cantidadProyectoSilmutaneo = cantidadProyectoSilmutaneo;
        this.tarifaDia = tarifaDia;
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
    public String getCantidadProyectoSilmutaneo() {
        return cantidadProyectoSilmutaneo;
    }
    public void setCantidadProyectoSilmutaneo(String cantidadProyectoSilmutaneo) {
        this.cantidadProyectoSilmutaneo = cantidadProyectoSilmutaneo;
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
}
