package co.edu.uniquindio.EmpresaSoftware;

public class Desarrolladores {
    private String id;
    private String equipoTrabajo;
    private String nivel;
    private String cantidadProyectoSilmutaneo;
    private double tarifaDia;

    public Desarrolladores(String id, String equipoTrabajo, String nivel, String cantidadProyectoSilmutaneo, double tarifaDia) {
        this.id = id;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.cantidadProyectoSilmutaneo = cantidadProyectoSilmutaneo;
        this.tarifaDia = tarifaDia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }

    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
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
}
