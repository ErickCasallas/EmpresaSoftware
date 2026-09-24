package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class CRUDServicio {
    static Servicio[] servicios=new Servicio[4];
    static Servicio[] serviciosContratados=new Servicio[4];
    public static void iniciar(){

        int cantidadServiciosContratados=0;
        asignarServicios(servicios);
        int option;
        do {
            option = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Servicios\n\n"
                                    + "1. Contratar servicio adicional\n"
                                    + "2. Servicios contratados\n"
                                    + "3. Remover servicio adicional\n"
                                    + "0. Salir\n\n"
                                    + "Seleccione una opción:"
                    )
            );
            switch (option){
                case 1:
                    cantidadServiciosContratados=escogerServicioAdicional(servicios, cantidadServiciosContratados, serviciosContratados);
                    break;

                case 2:
                    listarServiciosContrados(serviciosContratados);
                    break;

                case 3:
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
        Servicio  migracionDatos= new Servicio(null,
                "Migración de datos",
                "Proceso de transferir información de manera segura y organizada desde un sistema, formato o servidor de almacenamiento hacia otro nuevo, asegurando que no se pierda nada en el camino.",
                250000,
                false);
        servicios[0]=soporteTenico;
        servicios[1]=capacitacionUsuario;
        servicios[2]=despliegueNube;
        servicios[3]=migracionDatos;
    }
    public static void listarServiciosContrados(Servicio[] serviciosContratados){

        String mensaje = "";
        for (Servicio serviciosContratado : serviciosContratados) {
            if (serviciosContratado != null) {
                mensaje += "Documento: " + serviciosContratado.getId() + "\n"
                        + "Nombre: " + serviciosContratado.getName() + "\n"
                        + "Descripcion: " + serviciosContratado.getDescripcion() + "\n"
                        + "Precio: " + serviciosContratado.getPrecio() + "\n"
                        + "Disponibilidad: " + serviciosContratado.getDisponibilidad() + "\n"
                        + "------------------------\n";
            }
        }
            JOptionPane.showMessageDialog(null,mensaje);
    }
    public static int listarServicio(Servicio[] servicios,int index){
        String mensaje = "";
            if (servicios[index]!=null&&servicios[index].getDisponibilidad()){
                mensaje += "ID: " + servicios[index].getId() + "\n"
                        +"Nombre: " + servicios[index].getName() + "\n"
                        +"Descripcion" + servicios[index].getDescripcion() + "\n"
                        +"Precio: " + servicios[index].getPrecio() + "\n"
                        +"Disponible: " + servicios[index].getDisponibilidad() + "\n"
                        +"0. Volver          "+"1.Contratar Servicio Adicional"+"\n"
                        +"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
            }else if (servicios[index]!=null&&!servicios[index].getDisponibilidad()){
                mensaje += "ID: " + servicios[index].getId() + "\n"
                        +"Nombre: " + servicios[index].getName() + "\n"
                        +"Descripcion" + servicios[index].getDescripcion() + "\n"
                        +"Precio: " + servicios[index].getPrecio() + "\n"
                        +"Disponible: " + servicios[index].getDisponibilidad() + "\n"
                        +"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";

            }
            int seleccion=0;
            if (servicios[index].getDisponibilidad()){
                seleccion=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            }else {
                JOptionPane.showMessageDialog(null, mensaje);
            }
        return seleccion;
    }
    //Prueba de paneles personalizados de Santiago Paez y Erik Casallas
    public static int escogerServicioAdicional(Servicio[] servicios,int cantidadServiciosContratados,Servicio[] serviciosContratados){
        String[] nombreBotones=new String[4];
        for (int i = 0; i < servicios.length; i++) {
            nombreBotones[i]=servicios[i].getName();
        }
        int seleccion;
        int respuesta;
        int a;
        do{
            seleccion = JOptionPane.showOptionDialog(null, "¿Que servicio adicional desea escoger", "Servicios", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nombreBotones, nombreBotones[0]);
            switch (seleccion) {
                case 0:
                    a = listarServicio(servicios, seleccion);
                    if (a == 1) {
                        for (int i = 0; i < serviciosContratados.length; i++) {
                            if (serviciosContratados[i] == null) {
                                serviciosContratados[i] = servicios[seleccion];
                                break;
                            }
                        }
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro servicio adicional?",
                                "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {

                            break;
                        } else if (respuesta == JOptionPane.NO_OPTION) {
                            seleccion = 4;
                        }
                    }
                    if (a == 0) {
                        seleccion = 4;
                    }
                    break;

                case 1:
                    a = listarServicio(servicios, seleccion);
                    if (a == 1) {
                        for (int i = 0; i < serviciosContratados.length; i++) {
                            if (serviciosContratados[i] == null) {
                                serviciosContratados[i] = servicios[seleccion];
                                break;
                            }
                        }
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro servicio adicional?",
                                "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            break;
                        } else if (respuesta == JOptionPane.NO_OPTION) {
                            seleccion = 4;
                        }
                    }
                    if (a == 0) {
                        seleccion = 4;
                    }

                    break;
                case 3:
                    a = listarServicio(servicios, seleccion);
                    if (a == 1) {
                        for (int i = 0; i < serviciosContratados.length; i++) {
                            if (serviciosContratados[i] == null) {
                                serviciosContratados[i] = servicios[seleccion];
                                break;
                            }
                        }
                        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro servicio adicional?",
                                "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION) {
                            break;
                        } else if (respuesta == JOptionPane.NO_OPTION) {
                            seleccion = 4;
                        }
                    }
                    if (a == 0) {
                        seleccion = 4;
                    }
            }
        }while (seleccion!=4);
        for (Servicio serviciosContratado : serviciosContratados) {
            if (serviciosContratado != null) {
                cantidadServiciosContratados++;
            }
        }
        return cantidadServiciosContratados;
    }
}