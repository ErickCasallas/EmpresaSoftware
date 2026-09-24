package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class MainServicio {
    static void main() {
        Servicio[] servicios=new Servicio[100];
        int cantidadServicios=0;
        int option;
        do {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Servicios\n\n"
                                    + "1. Contratar servicio adicionales\n"
                                    + "2. Lista de servicios\n"
                                    + "3. Buscar perfil de desarrollador\n"
                                    + "4. Actualizar datos de desarrollador\n"
                                    + "5. Eliminar desarrollador\n"
                                    + "0. Salir\n\n"
                                    + "Seleccione una opción:"
                    )
            );
            switch (option){
                case 1:
                    cantidadDesarrolladores=registrarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 2:
                    listarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 3:
                    buscarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 4:
                    actualizarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 5:
                    cantidadDesarrolladores = eliminarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }while (option!=0);
    }
}
