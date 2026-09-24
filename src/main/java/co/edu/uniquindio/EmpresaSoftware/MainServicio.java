package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class MainServicio {
    static void main() {
        Servicio[] servicios=new Servicio[4];
        int cantidadServiciosContratados=0;
        asignarServicios(servicios);
        int option;
        do {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Servicios\n\n"
                                    + "1. Escoger servicio adicional\n"
                                    + "2. \n"
                                    + "3. Contratar servicio adiconal\n"
                                    + "4. Actualizar datos de desarrollador\n"
                                    + "5. Eliminar desarrollador\n"
                                    + "0. Salir\n\n"
                                    + "Seleccione una opción:"
                    )
            );
            switch (option){
                case 1:
                    cantidadServiciosContratados=escogerServicioAdicional(servicios, cantidadServiciosContratados);;

                    break;

                case 2:
                    ;
                    break;

                case 3:
                    //buscarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 4:
                    //actualizarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 5:
                    //cantidadDesarrolladores = eliminarDesarrollador(equipoTrabajo, cantidadDesarrolladores);
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
           }
        }while (option!=0);
    }
    public static void asignarServicios(Servicio[]servicios){
        Servicio soporteTenico= new Servicio(null,
                "Soporte tenico",
                "Es una asistencia especializada diseñada para resolver problemas, configurar equipos y mantener en óptimas condiciones",
                200000,
                false);
        Servicio capacitacionUsuario= new Servicio(null,
                "Capacitación de usuarios",
                " Es un servicio diseñado para enseñar a las personas a utilizar de manera correcta, eficiente y segura las herramientas tecnológicas",
                300000,
                false);
        Servicio  despliegueNube= new Servicio(null,
                "Despliegue en la nube",
                "Es el proceso de configurar, cargar y poner en funcionamiento aplicaciones, sitios web o bases de datos en servidores de internet",
                250000,
                false);
        Servicio  migraciónDatos= new Servicio(null,
                "Migración de datos",
                "Proceso de transferir información de manera segura y organizada desde un sistema, formato o servidor de almacenamiento hacia otro nuevo, asegurando que no se pierda nada en el camino.",
                250000,
                false);
        servicios[0]=soporteTenico;
        servicios[1]=capacitacionUsuario;
        servicios[2]=despliegueNube;
        servicios[3]=migraciónDatos;
    }
    public static void listarServicio(Servicio[] servicios,int index){
        String mensaje = "";

            if (servicios[index]!=null){
                mensaje += "Documento/Nit: " + servicios[index].getId() + "\n"
                        +"Nombre/Razón social: " + servicios[index].getName() + "\n"
                        +"Descripcion" + servicios[index].getDescripcion() + "\n"
                        +"Precio: " + servicios[index].getPrecio() + "\n"
                        +"Disponible: " + servicios[index].getDisponibilidad() + "\n"
                        +"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }
            if (servicios[index].getDisponibilidad()){
                JOptionPane.showInputDialog(mensaje);
            }else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
    }
    //Prueba de paneles personalizados de Santiago Paez y Erik Casallas
    public static int escogerServicioAdicional(Servicio[] servicios,int cantidadServiciosContratados){
        String[] nombreBotones=new String[4];
        for (int i = 0; i < servicios.length; i++) {
            nombreBotones[i]=servicios[i].getName();
        }
        int seleccion;
        int respuesta;
        do{
            seleccion = JOptionPane.showOptionDialog(null, "¿Que servicio adicional desea escoger", "Servicios", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nombreBotones, nombreBotones[0]);
            switch (seleccion) {
                case 0:
                    listarServicio(servicios,seleccion);
                    respuesta=JOptionPane.showConfirmDialog(null,"¿Desea agregar otro servicio adicional?",
                            "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        break;
                    }else if (respuesta == JOptionPane.NO_OPTION){
                        seleccion=4;
                    }
                    break;

                case 1:
                    listarServicio(servicios,seleccion);
                    respuesta=JOptionPane.showConfirmDialog(null,"¿Desea agregar otro servicio adicional?",
                            "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        break;
                    }else if (respuesta == JOptionPane.NO_OPTION){
                        seleccion=4;
                    }
                    break;

                case 2:
                    listarServicio(servicios,seleccion);
                    respuesta=JOptionPane.showConfirmDialog(null,"¿Desea agregar otro servicio adicional?",
                            "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        break;
                    }else if (respuesta == JOptionPane.NO_OPTION){
                        seleccion=4;
                    }
                    break;
                case 3:
                    listarServicio(servicios,seleccion);
                    respuesta=JOptionPane.showConfirmDialog(null,"¿Desea agregar otro servicio adicional?",
                            "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        break;
                    }else if (respuesta == JOptionPane.NO_OPTION){
                        seleccion=4;
                    };
                    break;
                case JOptionPane.CLOSED_OPTION:
                    JOptionPane.showMessageDialog(null,"El usuario cerró la ventana sin elegir.");
                    break;
            }
        }while (seleccion!=4);

        return cantidadServiciosContratados++;
    }
}
