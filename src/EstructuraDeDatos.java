
package estructuradedatos;

import java.util.Scanner;

public class EstructuraDeDatos {

    public static void main(String[] args) {
        
        System.out.println("------ARREGLOS DINAMICOS------");
        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("escriba el nombre:");
        String nombre = obj_teclado.next();
        System.out.println("escriba la cedula:");
        String cedula = obj_teclado.next();

        Cliente_modelo obj_cliente = new Cliente_modelo(nombre, cedula);
        
        dinamico obj_lista = new dinamico();
        
        obj_lista.agregar_cliente(obj_cliente);
        obj_lista.ver_info();

        // Ejemplos con métodos estilo Collection/CRUD
        Cliente_modelo cliente2 = new Cliente_modelo("Ana", "987654321");
        obj_lista.add(cliente2); // add(elemento)
        obj_lista.add(0, new Cliente_modelo("Luis", "123123123")); // add(indice, elemento)

        System.out.println("Cliente en índice 1:");
        obj_lista.get(1).ver_datos(); // get(indice)

        obj_lista.set(1, new Cliente_modelo("María", "555555555")); // set(indice, elemento)
        System.out.println("Después de set en índice 1:");
        obj_lista.get(1).ver_datos();

        System.out.println("Tamaño actual de la lista: " + obj_lista.size()); // size()
        System.out.println("¿La lista está vacía?: " + obj_lista.isEmpty()); // isEmpty()

        System.out.println("Contiene a Ana?: " + obj_lista.contains(cliente2)); // contains(elemento)
        System.out.println("Índice de Ana: " + obj_lista.indexOf(cliente2)); // indexOf(elemento)

        Cliente_modelo[] arregloClientes = obj_lista.toArray(); // toArray()
        System.out.println("Convertido a array con tamaño: " + arregloClientes.length);

        System.out.println("Eliminar cliente en índice 2...");
        obj_lista.remove(2); // remove(indice)
        System.out.println("Tamaño después de remove(indice): " + obj_lista.size());

        System.out.println("Buscar cliente");
        System.out.println("Escriba la cedula");
        cedula = obj_teclado.next();
        
        // --- AQUÍ COLOCAMOS EL CÓDIGO DE BÚSQUEDA ---
        if(obj_lista.buscar_cliente(obj_cliente)){
            System.out.println("¡El cliente sí existe en la lista!");
        } else {
            System.out.println("El cliente no fue encontrado.");
        }
        // --------------------------------------------

        // 1. Contar cuántos clientes hay en la lista
        int totalClientes = obj_lista.contar_cliente();
        System.out.println("Total de clientes en la lista: " + totalClientes);

        // 2. Comprobar si la lista está vacía
        boolean vacia = obj_lista.esta_vacia();
        System.out.println("¿La lista está vacía?: " + vacia);

        // 3. Encontrar la posición (índice) de un cliente específico en la lista
        int posicion = obj_lista.encontrar_cliente(obj_cliente);
        System.out.println("El cliente recién agregado está en la posición: " + posicion);

        // 4. Eliminar a un cliente
        System.out.println("Eliminando el cliente...");
        obj_lista.eliminar_cliente(obj_cliente);
        System.out.println("Total de clientes después de eliminar: " + obj_lista.contar_cliente());

        // 5. Limpiar toda la lista
        obj_lista.limpiar_cliente();

        

        
        
    }
    
}
