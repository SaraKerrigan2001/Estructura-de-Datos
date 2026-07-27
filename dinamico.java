package dinamico;

import cliente_modelo.cliente_modelo;
import java.util.ArrayList;
import java.util.List;

public class dinamico{
    // inicializando variables
    public List<cliente_modelo> obj_lista_clientes;
    
    // Crear el contructor
    public dinamico(){
        // creando los atributos
        this.obj_lista_clientes = new ArrayList<>();   
    }
    
    public void ver_info(){
        for (int i = 0; i < this.obj_lista_clientes.size(); i++) {
            this.obj_lista_clientes.get(i).ver_datos();
            
        }
    }
    public void ver_info2(){
        for(cliente_modelo cliente: this.obj_lista_clientes.size()){
            obj_clientes.ver_datos();
        }
    }    
    
    public void agregar_cliente(cliente_modelo obj_cliente_nuevo){
        this.obj_lista_clientes.add(obj_cliente_nuevo);
    }
}