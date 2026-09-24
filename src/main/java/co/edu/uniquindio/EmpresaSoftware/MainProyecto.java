package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class MainProyecto {
    static Proyecto[] listProyectos = new Proyecto[10];


    static void main() {

        int option = 0;
        do {
            option = Integer.parseInt
                    (JOptionPane.showInputDialog("Menu de los proyectos:"
                            + "\n Seleccione una opcion:"
                            + "\n 1. Registrar proyecto:"
                            + "\n 2. Mostrar proyectos:"
                            + "\n 3. Mostrar proyecto por id:"
                            + "\n 4. Actualizar proyecto: "
                            + "\n 5. Cancelar Proyecto:"
                            + "\n 0. Salir del sistema:"));

            switch (option) {

                case 1:
                    solicitarProyecto();
                    break;

                case 2:
                    mostrarListaProyectos();
                    break;

                case 3:
                    solicitarIdProyecto();
                    break;

//                case 4:
//                    actualizarProyecto();
//                    break;
//
//                case 5:
//                    eliminarMascota();
//                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "El programa finalizo.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida:");
                    break;
            }

        } while (option != 0);
    }

    public static void solicitarProyecto() {
        String id = JOptionPane.showInputDialog("Ingrese el id del proyecto:");

        LocalDate fechaSolicitud = null;
        while (fechaSolicitud == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de la solicitud (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
            }
            catch(DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Formato erroneo");
                }

        }


        LocalDate fechaInicio = null;
        while (fechaInicio == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de inicio (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
            }
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }
        }


        LocalDate fechaEntrega = null;
        while (fechaEntrega == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de entrega (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
            }
            catch(DateTimeParseException e){
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }

        }

        String estado = JOptionPane.showInputDialog("Ingrese el estado del proyecto");
        String metodoPago = JOptionPane.showInputDialog("Ingrese el metodo de pago");

        Proyecto proyecto = new Proyecto(id, fechaSolicitud, fechaInicio,
                fechaEntrega, estado, metodoPago);

        boolean resultado = registrarProyecto(proyecto.getId(), proyecto);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registro");
        }
    }

    public static boolean registrarProyecto(String idProyecto, Proyecto proyecto) {

        if (encontrarIndexProyecto(idProyecto) == -1) {
            for (int i = 0; i < listProyectos.length; i++) {
                if (listProyectos[i] == null) {
                    listProyectos[i] = proyecto;
                    return true;
                }
            }
        }
        return false;
    }

    public static int encontrarIndexProyecto(String idProyecto) {
        for (int i = 0; i < listProyectos.length; i++) {
            if (listProyectos[i] != null && listProyectos[i].getId().equals(idProyecto)) {
                return i;
            }
        }
        return -1;
    }

    private static void solicitarIdProyecto() {
        String idProyectoVer = JOptionPane.showInputDialog("Ingrese el id del proyecto que desea ver:");

        String resultado = mostrarProyectos(idProyectoVer);

        JOptionPane.showMessageDialog(null, resultado);
    }

    private static String mostrarProyectos(String idProyectoVer) {
        String mensaje = "";
        int index = encontrarIndexProyecto(idProyectoVer);

        if (index != -1) {
            Proyecto proyectoEncontrado = listProyectos[index];

            mensaje = "Proyecto encontrado: "
                    + "\nFecha de solicitud: " + proyectoEncontrado.getFechaSolicitud()
                    + "\nFecha de inicio: " + proyectoEncontrado.getFechaInicio()
                    + "\nFecha de entrega: " + proyectoEncontrado.getFechaEntrega()
                    + "\nEstado del proyecto: " + proyectoEncontrado.getEstado()
                    + "\nMetodo de pago: " + proyectoEncontrado.getMetodoPago();

        } else {
            mensaje = "El proyecto no se encuentra en la lista.";
        }
        return mensaje;
    }

    private static void mostrarListaProyectos() {
        String mensaje = "Lista de proyectos:\n";
        for (int i = 0; i < listProyectos.length; i++) {
            if (listProyectos[i] != null) {
                mensaje += "\nFecha de solicitud: " + listProyectos[i].getFechaSolicitud()
                        + "\nFecha de inicio: " + listProyectos[i].getFechaInicio()
                        + "\nFecha de entrega: " + listProyectos[i].getFechaEntrega()
                        + "\nEstado del proyecto: " + listProyectos[i].getEstado()
                        + "\nMetodo de pago: " + listProyectos[i].getMetodoPago();
            }

        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}



