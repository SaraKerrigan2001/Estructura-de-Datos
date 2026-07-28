import java.util.Scanner;
import java.util.List;

/**
 * Programa interactivo para gestionar una lista dinámica de clientes.
 * Permite agregar, buscar, eliminar y listar clientes mediante un menú.
 */
public class ListaEstructurasDinamicas {

    private static Scanner teclado;
    private static Dinamico listaClientes;

    /**
     * Método principal que inicia el programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        listaClientes = new Dinamico();
        
        boolean continuar = true;
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Sistema de Gestión de Clientes       ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorCedula();
                    break;
                case 4:
                    buscarClientesPorNombre();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    actualizarCliente();
                    break;
                case 7:
                    mostrarEstadisticas();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el sistema! Hasta pronto.");
                    break;
                default:
                    System.out.println("\n❌ Opción inválida. Por favor, intente de nuevo.");
            }
            
            if (continuar) {
                esperarEnter();
            }
        }
        
        teclado.close();
    }
    
    /**
     * Muestra el menú principal de opciones.
     */
    private static void mostrarMenu() {
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│           MENÚ PRINCIPAL               │");
        System.out.println("├────────────────────────────────────────┤");
        System.out.println("│ 1. Agregar nuevo cliente               │");
        System.out.println("│ 2. Listar todos los clientes           │");
        System.out.println("│ 3. Buscar cliente por cédula           │");
        System.out.println("│ 4. Buscar clientes por nombre          │");
        System.out.println("│ 5. Eliminar cliente                    │");
        System.out.println("│ 6. Actualizar datos de cliente         │");
        System.out.println("│ 7. Mostrar estadísticas                │");
        System.out.println("│ 0. Salir                               │");
        System.out.println("└────────────────────────────────────────┘");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Lee una opción numérica del usuario con validación.
     * 
     * @return La opción seleccionada
     */
    private static int leerOpcion() {
        try {
            int opcion = Integer.parseInt(teclado.nextLine().trim());
            return opcion;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Solicita al usuario ingresar datos de un nuevo cliente y lo agrega a la lista.
     */
    private static void agregarCliente() {
        System.out.println("\n┌─── AGREGAR NUEVO CLIENTE ───┐");
        
        String nombre = leerTextoNoVacio("Ingrese el nombre del cliente: ");
        String cedula = leerTextoNoVacio("Ingrese la cédula del cliente: ");
        
        try {
            ClienteModelo nuevoCliente = new ClienteModelo(nombre, cedula);
            listaClientes.agregarCliente(nuevoCliente);
            System.out.println("\n✓ Cliente agregado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("\n❌ Error: " + e.getMessage());
        }
    }
    
    /**
     * Muestra todos los clientes registrados en la lista.
     */
    private static void listarClientes() {
        System.out.println("\n┌─── LISTA DE CLIENTES ───┐");
        
        if (listaClientes.estaVacia()) {
            System.out.println("No hay clientes registrados.");
        } else {
            listaClientes.verInfo();
            System.out.println("\nTotal de clientes: " + listaClientes.cantidadClientes());
        }
    }
    
    /**
     * Busca y muestra un cliente por su número de cédula.
     */
    private static void buscarClientePorCedula() {
        System.out.println("\n┌─── BUSCAR CLIENTE POR CÉDULA ───┐");
        
        String cedula = leerTextoNoVacio("Ingrese la cédula a buscar: ");
        ClienteModelo cliente = listaClientes.buscarClientePorCedula(cedula);
        
        if (cliente != null) {
            System.out.println("\n✓ Cliente encontrado:");
            cliente.verDatos();
        } else {
            System.out.println("\n❌ No se encontró un cliente con esa cédula.");
        }
    }
    
    /**
     * Busca y muestra clientes cuyo nombre coincida con la búsqueda.
     */
    private static void buscarClientesPorNombre() {
        System.out.println("\n┌─── BUSCAR CLIENTES POR NOMBRE ───┐");
        
        String nombre = leerTextoNoVacio("Ingrese el nombre (o parte del nombre) a buscar: ");
        List<ClienteModelo> resultados = listaClientes.buscarClientesPorNombre(nombre);
        
        if (resultados.isEmpty()) {
            System.out.println("\n❌ No se encontraron clientes con ese nombre.");
        } else {
            System.out.println("\n✓ Se encontraron " + resultados.size() + " cliente(s):");
            int contador = 1;
            for (ClienteModelo cliente : resultados) {
                System.out.println("\nCliente #" + contador + ":");
                cliente.verDatos();
                System.out.println("---");
                contador++;
            }
        }
    }
    
    /**
     * Elimina un cliente de la lista por su cédula.
     */
    private static void eliminarCliente() {
        System.out.println("\n┌─── ELIMINAR CLIENTE ───┐");
        
        if (listaClientes.estaVacia()) {
            System.out.println("No hay clientes para eliminar.");
            return;
        }
        
        String cedula = leerTextoNoVacio("Ingrese la cédula del cliente a eliminar: ");
        ClienteModelo cliente = listaClientes.buscarClientePorCedula(cedula);
        
        if (cliente != null) {
            System.out.println("\nCliente a eliminar:");
            cliente.verDatos();
            System.out.print("\n¿Está seguro de eliminar este cliente? (S/N): ");
            String confirmacion = teclado.nextLine().trim().toLowerCase();
            
            if (confirmacion.equals("s") || confirmacion.equals("si")) {
                listaClientes.eliminarCliente(cedula);
                System.out.println("\n✓ Cliente eliminado exitosamente.");
            } else {
                System.out.println("\n❌ Operación cancelada.");
            }
        } else {
            System.out.println("\n❌ No se encontró un cliente con esa cédula.");
        }
    }
    
    /**
     * Actualiza los datos de un cliente existente.
     */
    private static void actualizarCliente() {
        System.out.println("\n┌─── ACTUALIZAR DATOS DE CLIENTE ───┐");
        
        if (listaClientes.estaVacia()) {
            System.out.println("No hay clientes para actualizar.");
            return;
        }
        
        String cedula = leerTextoNoVacio("Ingrese la cédula del cliente a actualizar: ");
        ClienteModelo cliente = listaClientes.buscarClientePorCedula(cedula);
        
        if (cliente != null) {
            System.out.println("\nCliente actual:");
            cliente.verDatos();
            
            System.out.println("\nIngrese los nuevos datos (deje en blanco para no cambiar):");
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = teclado.nextLine().trim();
            
            System.out.print("Nueva cédula: ");
            String nuevaCedula = teclado.nextLine().trim();
            
            if (nuevoNombre.isEmpty() && nuevaCedula.isEmpty()) {
                System.out.println("\n❌ No se realizaron cambios.");
            } else {
                boolean exito = listaClientes.actualizarCliente(
                    cedula, 
                    nuevoNombre.isEmpty() ? null : nuevoNombre,
                    nuevaCedula.isEmpty() ? null : nuevaCedula
                );
                
                if (exito) {
                    System.out.println("\n✓ Cliente actualizado exitosamente.");
                    System.out.println("\nNuevos datos:");
                    cliente.verDatos();
                }
            }
        } else {
            System.out.println("\n❌ No se encontró un cliente con esa cédula.");
        }
    }
    
    /**
     * Muestra estadísticas sobre la lista de clientes.
     */
    private static void mostrarEstadisticas() {
        System.out.println("\n┌─── ESTADÍSTICAS DEL SISTEMA ───┐");
        System.out.println("Total de clientes: " + listaClientes.cantidadClientes());
        System.out.println("Estado de la lista: " + (listaClientes.estaVacia() ? "Vacía" : "Con datos"));
    }
    
    /**
     * Lee un texto no vacío del usuario con validación.
     * 
     * @param mensaje El mensaje a mostrar al usuario
     * @return El texto ingresado
     */
    private static String leerTextoNoVacio(String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = teclado.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("❌ Este campo no puede estar vacío. Intente de nuevo.");
            }
        }
        return texto.trim();
    }
    
    /**
     * Espera a que el usuario presione Enter para continuar.
     */
    private static void esperarEnter() {
        System.out.print("\nPresione Enter para continuar...");
        teclado.nextLine();
    }
}
