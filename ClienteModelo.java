/**
 * Clase modelo que representa un cliente con nombre y cédula.
 * Proporciona métodos para acceder y modificar los datos del cliente.
 */
public class ClienteModelo {
    private String nombre;
    private String cedula;

    /**
     * Constructor que inicializa un cliente con nombre y cédula.
     * 
     * @param nombre El nombre del cliente
     * @param cedula La cédula del cliente
     * @throws IllegalArgumentException si algún parámetro es nulo o vacío
     */
    public ClienteModelo(String nombre, String cedula) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía");
        }
        this.nombre = nombre.trim();
        this.cedula = cedula.trim();
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nuevo nombre del cliente
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Obtiene la cédula del cliente.
     * 
     * @return La cédula del cliente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del cliente.
     * 
     * @param cedula La nueva cédula del cliente
     * @throws IllegalArgumentException si la cédula es nula o vacía
     */
    public void setCedula(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede ser nula o vacía");
        }
        this.cedula = cedula.trim();
    }

    /**
     * Muestra los datos del cliente en consola.
     */
    public void verDatos() {
        System.out.println("Cédula: " + this.cedula);
        System.out.println("Nombre: " + this.nombre);
    }

    /**
     * Retorna una representación en cadena del cliente.
     * 
     * @return String con el formato "Nombre: [nombre], Cédula: [cedula]"
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Cédula: " + cedula;
    }

    /**
     * Compara este cliente con otro objeto para verificar igualdad.
     * Dos clientes son iguales si tienen la misma cédula.
     * 
     * @param obj El objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ClienteModelo that = (ClienteModelo) obj;
        return cedula.equals(that.cedula);
    }

    /**
     * Genera un código hash basado en la cédula del cliente.
     * 
     * @return El código hash
     */
    @Override
    public int hashCode() {
        return cedula.hashCode();
    }
}
