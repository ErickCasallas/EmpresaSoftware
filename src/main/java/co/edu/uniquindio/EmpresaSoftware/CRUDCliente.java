package co.edu.uniquindio.EmpresaSoftware;

import javax.swing.*;

public class CRUDCliente {
    static CRUDProyecto moduloProyecto=new CRUDProyecto();
    static Cliente[] clientes = new Cliente[100];
    public static void iniciar(){

        int cantidadClientes = 0;
        int opcion;

        do {

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Clientes\n\n"
                                    + "1. Registar cliente\n"
                                    + "2. Lista de clientes\n"
                                    + "3. Buscar cliente\n"
                                    + "4. Actualizar cliente\n"
                                    + "5. Eliminar cliente\n"
                                    + "6. Contratar Proyecto\n"
                                    + "7. Consultar Cliente\n"
                                    + "0. Salir del modulo\n\n"
                                    + "Seleccione una opción:"
                    )
            );

            switch (opcion) {

                case 1:
                    cantidadClientes=registarCliente(clientes, cantidadClientes);
                    break;

                case 2:
                    listarClientes(clientes, cantidadClientes);
                    break;

                case 3:
                    buscarCliente(clientes, cantidadClientes);
                    break;

                case 4:
                    actualizarCliente(clientes, cantidadClientes);
                    break;

                case 5:
                    cantidadClientes = eliminarCliente(clientes, cantidadClientes);
                    break;
                case 6:
                    contratarProyectoACliente(clientes, cantidadClientes);
                    break;
                case 7:
                    consultarCliente();
                case 0:
                    JOptionPane.showMessageDialog(null, "Regresando al menu");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static int registarCliente(Cliente[] clientes, int cantidadClientes) {
        String id = JOptionPane.showInputDialog("Ingrese el documento de identidad o NIT:");
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getId().equals(id)) {

                JOptionPane.showMessageDialog(null,
                        "Ya existe un cliente con ese documento/NIT.");

                return cantidadClientes;
            }
        }
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre completo o razón social:");
        long telefono = Long.parseLong(JOptionPane.showInputDialog("Ingrese el teléfono:"));
        String correo = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
        String pais = JOptionPane.showInputDialog("Ingrese el país de procedencia:");
        Cliente nuevoCliente = new Cliente(nombre, id, telefono, correo, pais);

        clientes[cantidadClientes] = nuevoCliente;

        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
        cantidadClientes ++;

        return cantidadClientes;
    }
    private static void listarClientes(Cliente[] clientes, int cantidadClientes) {

        if (cantidadClientes == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        String mensaje = "";

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i]!=null){
                mensaje += "Cliente "+(i+1)+"\n" +"Documento/Nit: " + clientes[i].getId() + "\n"
                +"Nombre/Razón social: " + clientes[i].getName() + "\n"
                +"Teléfono: " + clientes[i].getTelefono() + "\n"
                +"Correo: " + clientes[i].getCorreo() + "\n"
                +"País: " + clientes[i].getPaisProcedencia() + "\n"
                +"------------------------\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public static void buscarCliente(Cliente[] clientes, int cantidadClientes){
     String documento=JOptionPane.showInputDialog("Ingrese el documento:");
        for (int i = 0; i <cantidadClientes; i++) {
            if (clientes[i].getId().equals(documento)){
                String mensaje="ID: " + clientes[i].getId() + "\n"
                        + "Nombre/Razón social: " + clientes[i].getName() + "\n"
                        + "Documento/NIT: " + clientes[i].getId() + "\n"
                        + "Teléfono: " + clientes[i].getTelefono() + "\n"
                        + "Correo: " + clientes[i].getCorreo() + "\n"
                        + "País: " + clientes[i].getPaisProcedencia()+"\n"
                        + "Proyectos contratados: " + clientes[i].getCantidadProyectos() + "\n";
                JOptionPane.showMessageDialog(null, mensaje);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente no encontrado");
    }
    public static void actualizarCliente(Cliente[] clientes, int cantidadClientes){
     String documento=JOptionPane.showInputDialog("Ingrese el documento/Nit:");
        for (int i = 0; i <cantidadClientes; i++) {
            if (clientes[i].getId().equals(documento)){
                String nombre=JOptionPane.showInputDialog("Ingrese el nombre del cliente", clientes[i].getName());
                String id=JOptionPane.showInputDialog("Ingrese el documento/Nit",clientes[i].getId());
                long telefono=Long.parseLong(JOptionPane.showInputDialog("Ingrese el telefono:", clientes[i].getTelefono()));
                String correo=JOptionPane.showInputDialog("Ingrese el correo electronico:",clientes[i].getCorreo());
                String paisOrigen=JOptionPane.showInputDialog("Ingrese el pais de procedencia:",clientes[i].getPaisProcedencia());
                clientes[i].setId(id);
                clientes[i].setName(nombre);
                clientes[i].setTelefono(telefono);
                clientes[i].setCorreo(correo);
                clientes[i].setPaisProcedencia(paisOrigen);
                JOptionPane.showMessageDialog(null,"Registro actualizado");
            }
        }
    }
    public static int eliminarCliente(Cliente[] clientes, int cantidadClientes){
     String documento=JOptionPane.showInputDialog("Ingrese el documento/Nit del Cliente:");
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getId().equals(documento)){
                for (int j = i; j < cantidadClientes-1; j++) {
                    clientes[j]=clientes[j+1];
                }
                clientes[cantidadClientes-1]=null;
                JOptionPane.showMessageDialog(null,"Cliente removido correctamente");
                return cantidadClientes-1;
            }
        }
        JOptionPane.showMessageDialog(null,"Cliente no encontrado");
        return cantidadClientes;}
    public static void contratarProyectoACliente(Cliente[] clientes, int cantidadClientes) {
        if (cantidadClientes == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        String documento = JOptionPane.showInputDialog("Ingrese el documento/NIT del cliente:");
        Cliente clienteEncontrado = null;

        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i] != null && clientes[i].getId().equals(documento)) {
                clienteEncontrado = clientes[i];
                break;
            }
        }

        if (clienteEncontrado != null) {
            moduloProyecto.solicitarProyectoParaCliente(clienteEncontrado);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
    public static boolean numeroPerfecto(long numero){
        int suma=0;
        for (int i = 1; i < numero; i++) {
            if(numero%i==0){
                suma+=i;
            }
        }
        if (suma == numero && numero > 0) {
            return true;
        }return false;
    }
    public static void consultarCliente(){
        String id= JOptionPane.showInputDialog("Ingrese documento del cliente ")    ;
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i]!=null&&clientes[i].getId().equals(id)){
                if (numeroPerfecto(clientes[i].getTelefono())){
                        JOptionPane.showMessageDialog(null, "El numero si es perfecto");
                }
            }
        }
        JOptionPane.showMessageDialog(null,"El numero de telefono no es un numero perfecto");
    }
}
