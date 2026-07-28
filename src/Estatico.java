
package estructuradedatos;

public class Estatico {

    public static String[] lista_nombre;

    public Estatico() {

        Estatico.lista_nombre = new String[3];

    }

    public static void imprimir_datos() {

        for (int i = 0; i < Estatico.lista_nombre.length; i++) {
            System.out.println("Datos: " + Estatico.lista_nombre[i]);
        }
    }

}
