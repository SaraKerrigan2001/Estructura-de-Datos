package lista_esctruturas_dinamicas;

import estructura_datos.dinamico;
import cliente_modelo.cliente_modelo;
import java.util.Scanner;

public class Lista_esctruturas_dinamicas{

    public static void main(String[] args) {
        //Todo lo dinamico
        dinamico obj_lista = new dinamico();

        Scanner obj_teclado = new Scanner(System.in);
        System.out.println("Escriba el nombre: ");
        String nombre_cliente = obj_teclado.nextLine();
        System.out.println("Escriba la cedula: ");
        String cedula_cliente = obj_teclado.nextLine();

        cliente_modelo obj_cliente = new cliente_modelo(nombre_cliente, cedula_cliente);
        obj_lista.agregar_cliente(obj_cliente);
        obj_lista.ver_info();
        
        obj_teclado.close();
    }

}