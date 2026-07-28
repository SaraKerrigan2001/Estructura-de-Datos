import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista dinámica de clientes.
 * Proporciona operaciones para agregar, buscar, eliminar y visualizar clientes.
 */
public class Dinamico {
    private List<ClienteModelo> listaClientes;
    
    /**
     * Constructor que inicializa la lista de clientes vacía.
     */
    public Dinamico() {
        this.listaClientes = new ArrayList<>();   
    }
    
    /**
     * Muestra la información de todos los clientes usando un bucle tradicional.
     */
    public void verInfo() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        
        System.out.println("=== Lista de Clientes ===");
        for (int i = 0; i < this.listaClientes.size(); i++) {
            System.out.println("Cliente #" + (i + 1) + ":");
            this.listaClientes.get(i).verDatos();
            System.out.println("---");
        }
    }
    
    /**
     * Muestra la información de todos los clientes usando un bucle for-each.
     */
    public void verInfoForEach() {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        
        System.out.println("=== Lista de Clientes ===");
        int contador = 1;
        for (ClienteModelo cliente : this.listaClientes) {
            System.out.println("Cliente #" + contador + ":");
            cliente.verDatos();
            System.out.println("---");
            contador++;
        }
    }    
    
    /**
     * Agrega un nuevo cliente a la lista.
     * 
     * @param clienteNuevo El cliente a agregar
     * @throws IllegalArgumentException si el cliente es nulo o ya existe
     */
    public void agregarCliente(ClienteModelo clienteNuevo) {
        if (clienteNuevo == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        
        if (buscarClientePorCedula(clienteNuevo.getCedula()) != null) {
            throw new IllegalArgumentException("Ya existe un cliente con la cédula: " + clienteNuevo.getCedula());
        }
        
        this.listaClientes.add(clienteNuevo);
        System.out.println("Cliente agregado exitosamente.");
    }
    
    /**
     * Busca un cliente por su cédula.
     * 
     * @param cedula La cédula del cliente a buscar
     * @return El cliente encontrado o null si no existe
     */
    public ClienteModelo buscarClientePorCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return null;
        }
        
        for (ClienteModelo cliente : this.listaClientes) {
            if (cliente.getCedula().equalsIgnoreCase(cedula.trim())) {
                return cliente;
            }
        }
        return null;
    }
    
    /**
     * Busca clientes por nombre (búsqueda parcial).
     * 
     * @param nombre El nombre o parte del nombre a buscar
     * @return Lista de clientes que coinciden con la búsqueda
     */
    public List<ClienteModelo> buscarClientesPorNombre(String nombre) {
        List<ClienteModelo> resultados = new ArrayList<>();
        
        if (nombre == null || nombre.trim().isEmpty()) {
            return resultados;
        }
        
        String nombreBusqueda = nombre.trim().toLowerCase();
        for (ClienteModelo cliente : this.listaClientes) {
            if (cliente.getNombre().toLowerCase().contains(nombreBusqueda)) {
                resultados.add(cliente);
            }
        }
        return resultados;
    }
    
    /**
     * Elimina un cliente de la lista por su cédula.
     * 
     * @param cedula La cédula del cliente a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarCliente(String cedula) {
        ClienteModelo cliente = buscarClientePorCedula(cedula);
        if (cliente != null) {
            this.listaClientes.remove(cliente);
            System.out.println("Cliente eliminado exitosamente.");
            return true;
        }
        System.out.println("No se encontró un cliente con esa cédula.");
        return false;
    }
    
    /**
     * Actualiza los datos de un cliente existente.
     * 
     * @param cedula La cédula del cliente a actualizar
     * @param nuevoNombre El nuevo nombre (o null para no cambiar)
     * @param nuevaCedula La nueva cédula (o null para no cambiar)
     * @return true si se actualizó correctamente, false si no se encontró
     */
    public boolean actualizarCliente(String cedula, String nuevoNombre, String nuevaCedula) {
        ClienteModelo cliente = buscarClientePorCedula(cedula);
        if (cliente == null) {
            System.out.println("No se encontró un cliente con esa cédula.");
            return false;
        }
        
        try {
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                cliente.setNombre(nuevoNombre);
            }
            if (nuevaCedula != null && !nuevaCedula.trim().isEmpty() && !nuevaCedula.equals(cedula)) {
                // Verificar que la nueva cédula no exista
                if (buscarClientePorCedula(nuevaCedula) == null) {
                    cliente.setCedula(nuevaCedula);
                } else {
                    System.out.println("La nueva cédula ya está en uso.");
                    return false;
                }
            }
            System.out.println("Cliente actualizado exitosamente.");
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtiene la cantidad de clientes registrados.
     * 
     * @return El número de clientes en la lista
     */
    public int cantidadClientes() {
        return this.listaClientes.size();
    }
    
    /**
     * Obtiene la lista completa de clientes.
     * 
     * @return Una copia de la lista de clientes
     */
    public List<ClienteModelo> obtenerListaClientes() {
        return new ArrayList<>(this.listaClientes);
    }
    
    /**
     * Limpia todos los clientes de la lista.
     */
    public void limpiarLista() {
        this.listaClientes.clear();
        System.out.println("Lista de clientes vaciada.");
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si no hay clientes, false en caso contrario
     */
    public boolean estaVacia() {
        return this.listaClientes.isEmpty();
    }
}
