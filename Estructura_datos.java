package Estructura_datos;

public class Estructura_datos{
    
  public static String[] lista_nombres;
  
  public Estructura_datos(){
    Estructura_datos.lista_nombres = new String[3];
  }

  public static void imprimir_datos(){
    for (int i = 0; i < Estructura_datos.lista_nombres.length; i++) {
        System.out.println("datos: " + Estructura_datos.lista_nombres[i]);
    }
  }
}