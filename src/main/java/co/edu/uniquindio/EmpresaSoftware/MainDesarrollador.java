package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class MainDesarrollador {
    static void main() {
        Desarrollador[] equipoTrabajo=new Desarrollador[100];
        int cantidadDesarrolladores=0;
        int option;
        do {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Desarrolladores\n\n"
                                    + "1. Contratar desarrollador\n"
                                    + "2. Lista de desarrolladores\n"
                                    + "3. Buscar perfil de desarrollador\n"
                                    + "4. Actualizar datos de desarrollador\n"
                                    + "5. Eliminar desarrollador\n"
                                    + "0. Salir\n\n"
                                    + "Seleccione una opción:"
                    )
            );
            switch (option){
                case 1:
                    //cantidadDesarrolladores=registarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 2:
                    //listarClientes(desarrolladores, cantidadDesarrolladores);
                    break;

                case 3:
                    //buscarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 4:
                    //actualizarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 5:
                    //cantidadDesarrolladores = eliminarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
            }while (option!=0);
        }
        public static int registrarDesarrollador(Desarrollador[] equipoTrabajo,int cantidadDesarrolladores) {
            String documento = JOptionPane.showInputDialog("Ingrese el documento de identidad");
            //Verificar que no haya un mismo cliente
            for (int i = 0; i < cantidadDesarrolladores; i++) {
                if (equipoTrabajo[i].getId().equals(documento)) {
                    JOptionPane.showMessageDialog(null,"Ya existe un desarrollador con ese documento");
                    return cantidadDesarrolladores;
                }
            }
            String id=JOptionPane.showInputDialog("Ingrese su codigo de ID: ");
            String name=JOptionPane.showInputDialog("Ingrese su nombre: ");
            String nivel=JOptionPane.showInputDialog("Ingrese ");
            String cantidadProyectoSilmutaneo=JOptionPane.showInputDialog("Ingrese su codigo de ID: ");
            String tarifaDia=JOptionPane.showInputDialog("Ingrese su codigo de ID: ");
            return 1;
        }
}
