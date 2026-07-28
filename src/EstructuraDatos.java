/**
 * Clase que maneja un arreglo de nombres utilizando métodos de instancia.
 * Esta clase demuestra el uso de arreglos con encapsulación adecuada.
 */
public class EstructuraDatos {
    
    private String[] listaNombres;
    private int cantidadElementos;
    private static final int CAPACIDAD_DEFAULT = 3;
    
    /**
     * Constructor que inicializa el arreglo con capacidad por defecto (3 elementos).
     */
    public EstructuraDatos() {
        this.listaNombres = new String[CAPACIDAD_DEFAULT];
        this.cantidadElementos = 0;
    }
    
    /**
     * Constructor que inicializa el arreglo con una capacidad específica.
     * 
     * @param capacidad La capacidad del arreglo
     * @throws IllegalArgumentException si la capacidad es menor o igual a 0
     */
    public EstructuraDatos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        this.listaNombres = new String[capacidad];
        this.cantidadElementos = 0;
    }
    
    /**
     * Agrega un nombre al arreglo en la siguiente posición disponible.
     * 
     * @param nombre El nombre a agregar
     * @return true si se agregó exitosamente, false si el arreglo está lleno
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public boolean agregarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        
        if (cantidadElementos >= listaNombres.length) {
            System.out.println("El arreglo está lleno. No se puede agregar más elementos.");
            return false;
        }
        
        listaNombres[cantidadElementos] = nombre.trim();
        cantidadElementos++;
        return true;
    }
    
    /**
     * Establece un nombre en una posición específica del arreglo.
     * 
     * @param indice La posición donde se establecerá el nombre
     * @param nombre El nombre a establecer
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public void setNombre(int indice, String nombre) {
        if (indice < 0 || indice >= listaNombres.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        
        listaNombres[indice] = nombre.trim();
        if (indice >= cantidadElementos) {
            cantidadElementos = indice + 1;
        }
    }
    
    /**
     * Obtiene el nombre en una posición específica.
     * 
     * @param indice La posición del nombre a obtener
     * @return El nombre en esa posición o null si no hay ninguno
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     */
    public String getNombre(int indice) {
        if (indice < 0 || indice >= listaNombres.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        return listaNombres[indice];
    }
    
    /**
     * Imprime todos los datos almacenados en el arreglo.
     * Muestra los elementos no nulos y marca los vacíos.
     */
    public void imprimirDatos() {
        if (cantidadElementos == 0) {
            System.out.println("No hay datos almacenados.");
            return;
        }
        
        System.out.println("=== Datos Almacenados ===");
        for (int i = 0; i < listaNombres.length; i++) {
            if (listaNombres[i] != null) {
                System.out.println("Datos [" + i + "]: " + listaNombres[i]);
            } else {
                System.out.println("Datos [" + i + "]: [vacío]");
            }
        }
    }
    
    /**
     * Obtiene la cantidad de elementos actualmente almacenados.
     * 
     * @return La cantidad de elementos no nulos
     */
    public int getCantidadElementos() {
        return cantidadElementos;
    }
    
    /**
     * Obtiene la capacidad total del arreglo.
     * 
     * @return El tamaño máximo del arreglo
     */
    public int getCapacidad() {
        return listaNombres.length;
    }
    
    /**
     * Verifica si el arreglo está lleno.
     * 
     * @return true si está lleno, false en caso contrario
     */
    public boolean estaLleno() {
        return cantidadElementos >= listaNombres.length;
    }
    
    /**
     * Verifica si el arreglo está vacío.
     * 
     * @return true si está vacío, false en caso contrario
     */
    public boolean estaVacio() {
        return cantidadElementos == 0;
    }
    
    /**
     * Limpia todos los elementos del arreglo.
     */
    public void limpiar() {
        for (int i = 0; i < listaNombres.length; i++) {
            listaNombres[i] = null;
        }
        cantidadElementos = 0;
        System.out.println("Arreglo limpiado.");
    }
}