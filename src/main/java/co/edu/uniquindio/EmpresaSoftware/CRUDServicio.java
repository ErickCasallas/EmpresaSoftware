package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class CRUDServicio {
    static Servicio[] servicios=new Servicio[4];
    public static void iniciar(Proyecto proyecto){
        asignarServicios(servicios,proyecto);
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
                    escogerServicioAdicional(servicios, proyecto);
                    break;

                case 2:
                    listarServiciosContratados(proyecto);
                    break;

                case 3:
                    removerServicio(proyecto);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
           }
        }while (option!=0);
    }
    private static void listarServiciosContratados(Proyecto proyecto) {
        String mensaje = "Servicios contratados por el proyecto " + proyecto.getId() + ":\n\n";

        Servicio[] serviciosContratados = proyecto.getServicios();

        boolean tieneServicios = false;

        for (int i = 0; i < serviciosContratados.length; i++) {
            if (serviciosContratados[i] != null) {
                tieneServicios = true;
                mensaje += "ID: " + serviciosContratados[i].getId() + "\n"
                        + "Nombre: " + serviciosContratados[i].getName() + "\n"
                        + "Descripcion: " + serviciosContratados[i].getDescripcion() + "\n"
                        + "Precio: " + serviciosContratados[i].getPrecio() + "\n"
                        + "------------------------\n";
            }
        }

        if (!tieneServicios) {
            mensaje += "El proyecto no tiene servicios contratados.";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
    private static void asignarServicios(Servicio[]servicios, Proyecto proyecto){
        Servicio soporteTenico= new Servicio(proyecto.getId(),
                "Soporte tenico",
                "Es una asistencia especializada diseñada para resolver problemas, configurar equipos y mantener en óptimas condiciones",
                200000,
                true);
        Servicio capacitacionUsuario= new Servicio(proyecto.getId(),
                "Capacitación de usuarios",
                " Es un servicio diseñado para enseñar a las personas a utilizar de manera correcta, eficiente y segura las herramientas tecnológicas",
                300000,
                true);
        Servicio  despliegueNube= new Servicio(proyecto.getId(),
                "Despliegue en la nube",
                "Es el proceso de configurar, cargar y poner en funcionamiento aplicaciones, sitios web o bases de datos en servidores de internet",
                250000,
                true);
        Servicio  migracionDatos= new Servicio(proyecto.getId(),
                "Migración de datos",
                "Proceso de transferir información de manera segura y organizada desde un sistema, formato o servidor de almacenamiento hacia otro nuevo, asegurando que no se pierda nada en el camino.",
                250000,
                true);
        servicios[0]=soporteTenico;
        servicios[1]=capacitacionUsuario;
        servicios[2]=despliegueNube;
        servicios[3]=migracionDatos;
    }
    private static void listarServicios(Servicio[] servicios) {

        String mensaje = "";

        for (int i = 0; i < servicios.length; i++) {

            if (servicios[i] != null) {

                mensaje += "ID: " + servicios[i].getId() + "\n"
                        + "Nombre: " + servicios[i].getName() + "\n"
                        + "Descripcion: " + servicios[i].getDescripcion() + "\n"
                        + "Precio: " + servicios[i].getPrecio() + "\n"
                        + "Disponibilidad: " + servicios[i].getDisponibilidad() + "\n"
                        + "------------------------\n";
            }
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
    private static int listarServicio(Servicio[] servicios,int index){
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
    //Prueba de paneles personalizados de Santiago Paez y Erik Casallas 1.0
    //Simplicacion de codio 2.0
    private static void escogerServicioAdicional(Servicio[] servicios, Proyecto proyecto){

        String[] nombreBotones = new String[4];

        for (int i = 0; i < servicios.length; i++) {
            nombreBotones[i] = servicios[i].getName();
        }

        int seleccion;
        int respuesta;
        int a;

        do {

            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "¿Que servicio adicional desea escoger",
                    "Servicios",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    nombreBotones,
                    nombreBotones[0]
            );

            if (seleccion == -1) {
                seleccion = 4;
                continue;
            }

            a = listarServicio(servicios, seleccion);

            if (a == 1) {

                proyecto.agregarServicio(servicios[seleccion]);

                respuesta = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea agregar otro servicio adicional?",
                        "Confirmación",
                        JOptionPane.YES_NO_CANCEL_OPTION
                );

                if (respuesta == JOptionPane.YES_OPTION) {

                    // vuelve a mostrar los servicios

                } else {

                    seleccion = 4;
                }

            } else if (a == 0) {

                seleccion = 4;
            }

        } while (seleccion != 4);
    }
    private static void removerServicio(Proyecto proyecto){
        Servicio[] serviciosContratados= proyecto.getServicios();
        int cantidadServicios=0;
        for (int i = 0; i < serviciosContratados.length; i++) {
            if (serviciosContratados[i] != null) {
                cantidadServicios++;
            }
        }
        if (cantidadServicios==0){
            JOptionPane.showMessageDialog(null, "El proyecto no tiene servicios contratados");
            return;
        }
        String[] nombreBotones = new String[cantidadServicios];
        int contador=0;
        for (int i = 0; i < serviciosContratados.length; i++) {
            if (serviciosContratados[i]!=null) {
                nombreBotones[contador] = serviciosContratados[i].getName();
                contador++;
            }
        }
        int seleccion=JOptionPane.showOptionDialog(null, "¿Que servicio adicional desea remover?", "Remover servicio", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, nombreBotones,nombreBotones[0]);
        if (seleccion==-1){
            return;
        }
        int posicion=-1;
        contador=0;
        for (int i = 0; i < serviciosContratados.length; i++) {

            if (serviciosContratados[i] != null) {

                if (contador == seleccion){
                    posicion = i;
                    break;
                }
                contador++;
            }
        }
        if (posicion!=-1) {
            int respuesta = JOptionPane.showConfirmDialog(
                    null,
                    "¿Desea remover el servicio "
                            + serviciosContratados[posicion].getName()
                            + "?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                serviciosContratados[posicion] = null;

                JOptionPane.showMessageDialog(null,
                        "Servicio removido correctamente.");
            }
        }
    }
}