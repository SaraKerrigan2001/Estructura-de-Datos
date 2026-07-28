
package estructuradedatos;

public class Cliente_modelo {
    
    private String nombre;
    private String cedula;
    
    public Cliente_modelo(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public void ver_datos(){
        
        System.out.println("cedula: " + this.cedula);
        System.out.println("nombre: " + this.nombre);
    }
}
