package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class CRUDDesarrollador {
    static Desarrollador[] desarrolladores=new Desarrollador[100];
   public static void iniciar(){

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
                    cantidadDesarrolladores=registrarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 2:
                    listarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 3:
                    buscarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 4:
                    actualizarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 5:
                    cantidadDesarrolladores = eliminarDesarrollador(desarrolladores, cantidadDesarrolladores);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
            }while (option!=0);
        }
        public static int registrarDesarrollador(Desarrollador[] desarrolladors,int cantidadDesarrolladores) {
            String id=JOptionPane.showInputDialog("Ingrese su codigo de ID: ");
            //Verificar que no haya un mismo cliente
            for (int i = 0; i < cantidadDesarrolladores; i++) {
                if (desarrolladors[i].getId().equals(id)) {
                    JOptionPane.showMessageDialog(null,"Ya existe un desarrollador con ese documento");
                    return cantidadDesarrolladores;
                }
            }
            String name=JOptionPane.showInputDialog("Ingrese su nombre: ");
            String nivel=JOptionPane.showInputDialog("Ingrese el nivel");
            String cantidadProyectoSilmutaneo=JOptionPane.showInputDialog("Ingrese proyectos silmutaneo");
            double tarifaDia=Double.parseDouble(JOptionPane.showInputDialog("La tarifa del dia"));
            Desarrollador nuevoDesarollador= new Desarrollador(id, name, nivel, cantidadProyectoSilmutaneo,tarifaDia);
            desarrolladors[cantidadDesarrolladores]=nuevoDesarollador;
            JOptionPane.showMessageDialog(null, "Desarrollador registrado correctamente.");
            cantidadDesarrolladores++;
            return cantidadDesarrolladores;
        }
    protected static void listarDesarrollador(Desarrollador[] desarrolladores, int cantidadDesarolladores) {

        if (cantidadDesarolladores == 0) {
            JOptionPane.showMessageDialog(null, "No hay desarrolladores registrados.");
            return;
        }

        String mensaje = "";

        for (int i = 0; i < desarrolladores.length; i++) {
            if (desarrolladores[i]!=null){
                mensaje += "Cliente "+(i+1)+"\n" +"Documento/Nit: " + desarrolladores[i].getId() + "\n"
                        +"Nombre/Razón social: " + desarrolladores[i].getName() + "\n"
                        +"Nivel: " + desarrolladores[i].getNivel() + "\n"
                        +"Cantidad de Proyectos Silmutaneos: " + desarrolladores[i].getCantidadProyectoSilmutaneo() + "\n"
                        +"Taria del dia: " + desarrolladores[i].getTarifaDia() + "\n"
                        +"------------------------\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void buscarDesarrollador(Desarrollador[] desarrolladores, int cantidadClientes){
        String documento=JOptionPane.showInputDialog("Ingrese el documento:");
        for (int i = 0; i <cantidadClientes; i++) {
            if (desarrolladores[i].getId().equals(documento)){
                String mensaje="ID: " + desarrolladores[i].getId() + "\n"
                        + "Nombre/Razón social: " + desarrolladores[i].getName() + "\n"
                        + "Nivel: " + desarrolladores[i].getNivel() + "\n"
                        + "Cantidad de Proyectos Silmutaneos: " + desarrolladores[i].getCantidadProyectoSilmutaneo() + "\n"
                        + "Taria del Dia: " + desarrolladores[i].getTarifaDia();
                JOptionPane.showMessageDialog(null, mensaje);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Desarrollador no encontrado");
    }
    public static void actualizarDesarrollador(Desarrollador[] desarrolladores, int cantidadDesarrolladores){
        String documento=JOptionPane.showInputDialog("Ingrese el documento/Nit:");
        for (int i = 0; i <cantidadDesarrolladores; i++) {
            if (desarrolladores[i].getId().equals(documento)){
                String nombre=JOptionPane.showInputDialog("Ingrese el nombre del desarrollador", desarrolladores[i].getName());
                String id=JOptionPane.showInputDialog("Ingrese el documento del desarrollador", desarrolladores[i].getId());
                String nivel=JOptionPane.showInputDialog("Ingrese el nivel:", desarrolladores[i].getNivel());
                String cantidadProyectoSilmutaneo=JOptionPane.showInputDialog("Ingrese la cantidad de Proyectos Silmutaneos:",desarrolladores[i].getCantidadProyectoSilmutaneo());
                double tarifaDia=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el pais de procedencia:",desarrolladores[i].getTarifaDia()));
                desarrolladores[i].setName(nombre);
                desarrolladores[i].setNivel(nivel);
                desarrolladores[i].setCantidadProyectoSilmutaneo(cantidadProyectoSilmutaneo);
                desarrolladores[i].setTarifaDia(tarifaDia);
                desarrolladores[i].setId(id);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }
    }
    public static int eliminarDesarrollador(Desarrollador[] desarrolladores, int cantidadDesarrolladores){
        String documento=JOptionPane.showInputDialog("Ingrese el documento del desarrollador:");
        for (int i = 0; i < cantidadDesarrolladores; i++) {
            if (desarrolladores[i].getId().equals(documento)){
                for (int j = i; j < cantidadDesarrolladores-1; j++) {
                    desarrolladores[j]=desarrolladores[j+1];
                }
                desarrolladores[cantidadDesarrolladores-1]=null;
                JOptionPane.showMessageDialog(null,"Desarrollador removido correctamente");
                return cantidadDesarrolladores-1;
            }
        }
        JOptionPane.showMessageDialog(null,"Desarrollador no encontrado");
        return cantidadDesarrolladores;
    }
}
