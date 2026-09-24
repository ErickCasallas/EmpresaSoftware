package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class Cliente {
    private String name;
    private String id;
    private String telefono;
    private String correo;
    private String paisProcedencia;

    public Cliente(String name, String id, String telefono, String correo, String paisProcedencia) {
        this.name = name;
        setId(id);
        setTelefono(telefono);
        this.correo = correo;
        this.paisProcedencia = paisProcedencia;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        boolean valido;
        do {
            valido = true;
            for (int i = 0; i < id.length(); i++) {
                char caracter = id.charAt(i);
                if (!Character.isDigit(caracter)) {
                    valido = false;
                    JOptionPane.showMessageDialog(null, "Numero telefono invalido");
                    id = JOptionPane.showInputDialog("Ingrese nuevamente el telefono (solo números):");
                    break;
                }
            }
        } while (!valido);
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
