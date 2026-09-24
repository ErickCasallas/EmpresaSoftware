package co.edu.uniquindio.EmpresaSoftware;

public class Desarrollador {
    private String id;
    private String name;
    private String nivel;
    private String cantidadProyectoSilmutaneo;
    private double tarifaDia;

    public Desarrollador(String id,String name, String nivel, String cantidadProyectoSilmutaneo, double tarifaDia) {
        this.name=name;
        this.id = id;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
