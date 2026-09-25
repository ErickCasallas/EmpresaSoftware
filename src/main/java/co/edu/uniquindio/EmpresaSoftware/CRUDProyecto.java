package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CRUDProyecto {
    static CRUDDesarrollador moduloDesarrollador = new CRUDDesarrollador();
    static CRUDServicio moduloServicio = new CRUDServicio();
    static Desarrollador[] listDesarrolladores = new Desarrollador[100];
    static Proyecto[] listProyectos = new Proyecto[100];


    public static void iniciar() {
        int option = 0;
        do {
            option = Integer.parseInt
                    (JOptionPane.showInputDialog("Menu de los proyectos:"
                            + "\n Seleccione una opcion:"
                            + "\n 1. Registrar proyecto:"
                            + "\n 2. Mostrar proyectos:"
                            + "\n 3. Buscar proyecto:"
                            + "\n 4. Actualizar proyecto: "
                            + "\n 5. Cancelar Proyecto:"
                            + "\n 6. Agregar servicios adicionales"
                            + "\n 7. Agregar desarrollador al proyecto"
                            + "\n 8. Mostrar desarrolladores"
                            + "\n 9. Mostrar costo total"
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

                case 4:
                    actualizarProyecto();
                    break;

                case 5:
                    eliminarProyecto();
                    break;
                case 6:
                    agregarServicioAdicional();
                    break;
                case 7:
                    agregarDesarrollador();
                    break;
                case 8:
                    mostrarDesarrolladoresProyecto();
                    break;
                case 9:
                    solicitarIdCosto();
                    break;
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
                fechaSolicitud = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
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
                fechaInicio = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
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
                fechaEntrega = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }
        }

        String estado = JOptionPane.showInputDialog("Ingrese el estado del proyecto (Pendiente - Confirmado - En curso - Finalizado - Cancelado): ");

        String metodoPago = JOptionPane.showInputDialog("Ingrese el metodo de pago (Tarjeta - Efectivo - Transferencia):");

        Proyecto proyecto = new Proyecto(id, fechaSolicitud, fechaInicio,
                fechaEntrega, estado, metodoPago, new Servicio[4]);

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

    public static void solicitarIdProyecto() {
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
                        + "\nMetodo de pago: " + listProyectos[i].getMetodoPago()
                        + "\n---------------------------\n";

            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void actualizarProyecto() {
        String idProyectoActualizar = JOptionPane.showInputDialog("Ingrese el id del proyecto que deseaActualizar");
        int index = encontrarIndexProyecto(idProyectoActualizar);

        if (index != -1) {
            actualizarDatosProyecto(index);
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no fue encontrado: ");
        }
    }

    private static void actualizarDatosProyecto(int indexProyecto) {

        LocalDate fechaSolicitud = null;
        while (fechaSolicitud == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha actualizada de la solicitud (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
                fechaSolicitud = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }

        }
        listProyectos[indexProyecto].setFechaSolicitud(fechaSolicitud);

        LocalDate fechaInicio = null;
        while (fechaInicio == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha actualizada de inicio (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
                fechaInicio = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }
        }
        listProyectos[indexProyecto].setFechaInicio(fechaInicio);

        LocalDate fechaEntrega = null;
        while (fechaEntrega == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha actualizada de entrega (AAAA-MM-DD):");
                if (input == null) {
                    return;
                }
                fechaEntrega = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erroneo");
            }
        }
        listProyectos[indexProyecto].setFechaEntrega(fechaEntrega);
        String estado = JOptionPane.showInputDialog("Ingrese el estado del proyecto actualizado (Pendiente - Confirmado - En curso - Finalizado - Cancelado):");
        listProyectos[indexProyecto].setEstado(estado);
        String metodoPago = JOptionPane.showInputDialog("Ingrese el metodo de pago actualizado (Tarjeta - Efectivo - Transferencia):");
        listProyectos[indexProyecto].setMetodoPago(metodoPago);
    }

    private static void eliminarProyecto() {
        String idProyectoBorrar = JOptionPane.showInputDialog("Ingrese el id del proyecto que desea eliminar:");
        int index = encontrarIndexProyecto(idProyectoBorrar);

        if (index != -1) {
            listProyectos[index] = null;
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no fue encontrado.");
        }
    }

    private static void agregarServicioAdicional() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del proyecto");
        for (int i = 0; i < listProyectos.length; i++) {
            if (listProyectos[i] != null && listProyectos[i].getId().equals(id)) {
                moduloServicio.iniciar(listProyectos[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "ID invalido");
    }

    private static void agregarDesarrollador() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del proyecto");
        for (int i = 0; i < listProyectos.length; i++) {
            if (listProyectos[i] != null && listProyectos[i].getId().equals(id)) {
                moduloDesarrollador.asignarDesarrolladorProyecto(listProyectos[i]);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "ID invalido");
    }

    public static void solicitarProyectoParaCliente(Cliente cliente) {
        // 1. Crear el proyecto pidiendo los datos
        String id = JOptionPane.showInputDialog("Ingrese el id del proyecto:");

        LocalDate fechaSolicitud = null;
        while (fechaSolicitud == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de la solicitud (AAAA-MM-DD):");
                if (input == null) return;
                fechaSolicitud = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erróneo");
            }
        }

        LocalDate fechaInicio = null;
        while (fechaInicio == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de inicio (AAAA-MM-DD):");
                if (input == null) return;
                fechaInicio = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erróneo");
            }
        }

        LocalDate fechaEntrega = null;
        while (fechaEntrega == null) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese la fecha de entrega (AAAA-MM-DD):");
                if (input == null) return;
                fechaEntrega = LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato erróneo");
            }
        }

        String estado = JOptionPane.showInputDialog("Ingrese el estado del proyecto");
        String metodoPago = JOptionPane.showInputDialog("Ingrese el método de pago");

        Proyecto proyecto = new Proyecto(id, fechaSolicitud, fechaInicio,
                fechaEntrega, estado, metodoPago, new Servicio[4]);

        // 2. Registrar en la lista general de proyectos
        boolean registrado = registrarProyecto(proyecto.getId(), proyecto);

        if (registrado) {
            // 3. Asociar el proyecto directamente al cliente
            cliente.agregarProyecto(proyecto);
            JOptionPane.showMessageDialog(null, "Proyecto asignado con éxito a " + cliente.getName());
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el proyecto (ID duplicado o lista llena).");
        }
    }

    public static void mostrarDesarrolladoresProyecto() {
        String idProyecto = JOptionPane.showInputDialog("Ingrese el ID del proyecto:");
        int index = encontrarIndexProyecto(idProyecto);

        if (index != -1) {
            Proyecto proyecto = listProyectos[index];

            if (proyecto.getCantidadDesarrolladores() == 0) {
                JOptionPane.showMessageDialog(null, "El proyecto no tiene desarrolladores asignados.");
                return;
            }

            String mensaje = "Desarrolladores asignados al proyecto " + proyecto.getId() + "\n";
            Desarrollador[] desarrollador = proyecto.getDesarrolladores();
            for (int i = 0; i < proyecto.getCantidadDesarrolladores(); i++) {
                if (desarrollador[i] != null) {
                    mensaje += (i + 1) + ". ID: " + desarrollador[i].getId()
                            + "Nombre: " + desarrollador[i].getName() + "\n"
                            + "Nivel: " + desarrollador[i].getNivel() + "\n"
                            + "Equipo de trabajo " + desarrollador[i].getEquipoTrabajo() + "\n"
                            + "Tarifa Día: $" + desarrollador[i].getTarifaDia() + "\n"
                            + "---------------------------------------------------\n";
                }
            }

            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "El proyecto no fue encontrado.");
        }
    }

    private static void solicitarIdCosto() {
        String idBuscado = JOptionPane.showInputDialog("Ingrese el id del proyecto");
        if (idBuscado != null && !idBuscado.equals("")) {
            int index = encontrarIndexProyecto(idBuscado);

            if (index != -1) {
                double total = listProyectos[index].calcularTotal();
                JOptionPane.showMessageDialog(null, "EL costo total del proyecto:  " + idBuscado + "es: $  " + total);
            } else {
                JOptionPane.showMessageDialog(null, "Proyecto no encontrado");
            }
            
        }

    }
}



