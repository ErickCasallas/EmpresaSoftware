package co.edu.uniquindio.EmpresaSoftware;

public class Cliente {
    private String name;
    private String id;
    private int telefono;
    private String correo;
    private String paisProcedencia;
    private String[] serviciosAdicionales;

    public Cliente(String name, String id, int telefono, String correo, String paisProcedencia, String[] serviciosAdicionales) {
        this.name = name;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.paisProcedencia = paisProcedencia;
        this.serviciosAdicionales=serviciosAdicionales;
    }

    public String getName() {
        return name;
    }
    public void setName(String id) {
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }
}
