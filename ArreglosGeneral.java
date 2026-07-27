package ArreglosGeneral;

public class ArreglosGeneral{
    public String[] lista_nombres;

    public ArreglosGeneral(){
        this.lista_nombres = new String[3];
    }

    public void imprimir_info(){
        for (int i = 0; i < lista_nombres.length; i++) {
            System.out.println("Dato cliente:" + this.lista_nombres[i]);
        } 
    }

    public void imprimir_dos(){
        this.imprimir_info();
    }
}