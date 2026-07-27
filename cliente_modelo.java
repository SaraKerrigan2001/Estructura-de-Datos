package cliente_modelo;

public class cliente_modelo {
    private String nombre;
    private String cedula;

    public cliente_modelo(String ing_nombre, String inf_cedula){
        this.nombre = ing_nombre;
        this.cedula = inf_cedula;
    }

    public void ver_datos(){
        System.out.println("cedula: "+ this.cedula);
        System.out.println("nombre: "+ this.nombre);
    }
}