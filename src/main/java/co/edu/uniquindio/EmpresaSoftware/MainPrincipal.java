package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class MainPrincipal {
    static void main() {
        CRUDCliente moduloClientes=new CRUDCliente();
        CRUDProyecto moduloProyecto=new CRUDProyecto();
        CRUDServicio moduloServicios=new CRUDServicio();
        CRUDDesarrollador moduloDesarrollador=new CRUDDesarrollador();
        int option;

        do {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Clientes\n\n"
                                    + "1. Modulo Clientes\n"
                                    + "2. Modulo Proyecto\n"
                                    + "3. Modulo Servicio\n"
                                    + "4. Modulo Desarrolladores\n"
                                    + "0. Salir\n\n"
                                    + "Seleccione una opción:"
                    )
            );
            switch (option){
                case 1:
                moduloClientes.iniciar();
                break;
                case 2:
                    moduloProyecto.iniciar();
                    break;
                case 3:
                    moduloServicios.iniciar();
                    break;
                case 4:
                    moduloDesarrollador.iniciar();
                    break;
                case 0: JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
            }
        }while (option!=0);
    }
}
