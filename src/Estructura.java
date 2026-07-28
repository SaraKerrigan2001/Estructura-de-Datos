/**
 * Clase principal para demostrar el uso de estructuras de datos estáticas.
 * Muestra ejemplos de uso de ArreglosGeneral y EstructuraDatos.
 */
public class Estructura {
    
    /**
     * Método principal que ejecuta las demostraciones.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║  DEMOSTRACIÓN DE ESTRUCTURAS DE DATOS ESTÁTICAS   ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");
        
        // Demostración de ArreglosGeneral
        demostrarArreglosGeneral();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Demostración de EstructuraDatos
        demostrarEstructuraDatos();
        
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║         FIN DE LA DEMOSTRACIÓN                     ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }
    
    /**
     * Demuestra el uso de la clase ArreglosGeneral.
     */
    private static void demostrarArreglosGeneral() {
        System.out.println("┌─── DEMOSTRACIÓN: ArreglosGeneral ───┐\n");
        
        // Crear instancia con capacidad por defecto
        ArreglosGeneral lista = new ArreglosGeneral();
        
        System.out.println("1. Arreglo creado con capacidad: " + lista.getCapacidad());
        System.out.println("   Elementos iniciales: " + lista.getCantidadElementos());
        System.out.println("   ¿Está vacío? " + (lista.estaVacio() ? "Sí" : "No"));
        
        // Agregar nombres
        System.out.println("\n2. Agregando nombres al arreglo...");
        try {
            lista.agregarNombre("María González");
            lista.agregarNombre("Juan Pérez");
            lista.agregarNombre("Ana Rodríguez");
            System.out.println("   ✓ 3 nombres agregados exitosamente");
        } catch (IllegalArgumentException e) {
            System.out.println("   ❌ Error: " + e.getMessage());
        }
        
        // Mostrar estado
        System.out.println("\n3. Estado actual:");
        System.out.println("   Cantidad de elementos: " + lista.getCantidadElementos());
        System.out.println("   ¿Está lleno? " + (lista.estaLleno() ? "Sí" : "No"));
        
        // Imprimir contenido
        System.out.println("\n4. Contenido del arreglo:");
        lista.imprimirInfo();
        
        // Buscar un nombre
        System.out.println("\n5. Buscando 'Juan Pérez'...");
        int indice = lista.buscarNombre("Juan Pérez");
        if (indice != -1) {
            System.out.println("   ✓ Encontrado en la posición: " + indice);
        } else {
            System.out.println("   ❌ No encontrado");
        }
        
        // Intentar agregar cuando está lleno
        System.out.println("\n6. Intentando agregar cuando está lleno...");
        boolean agregado = lista.agregarNombre("Carlos López");
        if (!agregado) {
            System.out.println("   ✓ Correctamente rechazado (arreglo lleno)");
        }
    }
    
    /**
     * Demuestra el uso de la clase EstructuraDatos.
     */
    private static void demostrarEstructuraDatos() {
        System.out.println("┌─── DEMOSTRACIÓN: EstructuraDatos ───┐\n");
        
        // Crear instancia con capacidad personalizada
        EstructuraDatos datos = new EstructuraDatos(5);
        
        System.out.println("1. Estructura creada con capacidad: " + datos.getCapacidad());
        
        // Agregar datos en posiciones específicas
        System.out.println("\n2. Agregando datos usando setNombre()...");
        try {
            datos.setNombre(0, "Cliente A");
            datos.setNombre(1, "Cliente B");
            datos.setNombre(2, "Cliente C");
            System.out.println("   ✓ 3 datos agregados exitosamente");
        } catch (Exception e) {
            System.out.println("   ❌ Error: " + e.getMessage());
        }
        
        // Agregar datos usando agregarNombre()
        System.out.println("\n3. Agregando datos usando agregarNombre()...");
        try {
            datos.agregarNombre("Cliente D");
            datos.agregarNombre("Cliente E");
            System.out.println("   ✓ 2 datos más agregados");
        } catch (Exception e) {
            System.out.println("   ❌ Error: " + e.getMessage());
        }
        
        // Mostrar estado
        System.out.println("\n4. Estado actual:");
        System.out.println("   Cantidad de elementos: " + datos.getCantidadElementos());
        System.out.println("   ¿Está lleno? " + (datos.estaLleno() ? "Sí" : "No"));
        System.out.println("   ¿Está vacío? " + (datos.estaVacio() ? "Sí" : "No"));
        
        // Imprimir contenido
        System.out.println("\n5. Contenido de la estructura:");
        datos.imprimirDatos();
        
        // Obtener un elemento específico
        System.out.println("\n6. Obteniendo elemento en posición 2:");
        try {
            String elemento = datos.getNombre(2);
            System.out.println("   Elemento: " + elemento);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   ❌ Error: " + e.getMessage());
        }
        
        // Demostrar validación
        System.out.println("\n7. Probando validación de datos vacíos...");
        try {
            datos.agregarNombre("");
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Validación funcionando: " + e.getMessage());
        }
    }
}
