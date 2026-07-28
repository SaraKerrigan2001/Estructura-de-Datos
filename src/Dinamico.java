
package estructuradedatos;

import java.util.ArrayList;
import java.util.List;

public class dinamico {
    
    public List<Cliente_modelo> listaclientes;
    public List<Cliente_modelo> obj_lista_cliente;
    String[] lista_nombre;
    
    public dinamico(){
        lista_nombre = new String[3];
        this.obj_lista_cliente = new ArrayList<>();
    }
    public void ver_info(){
        for(Cliente_modelo cliente: this.obj_lista_cliente){
            cliente.ver_datos();
        }
    }
    public void agregar_cliente(Cliente_modelo cliente){
        this.obj_lista_cliente.add(cliente);
    }
    public void eliminar_cliente(Cliente_modelo cliente){
        this.obj_lista_cliente.remove(cliente);
    }
    public boolean buscar_cliente(Cliente_modelo cliente){
        return this.obj_lista_cliente.contains(cliente);
    }
    public void actualizar_cliente(int posicion, Cliente_modelo cliente){
        this.obj_lista_cliente.set(posicion, cliente);
    }
    public void insertartodos_cliente(List<Cliente_modelo> clientes){
        this.obj_lista_cliente.addAll(clientes);
    }
    public void limpiar_cliente(){
        this.obj_lista_cliente.clear();
    }
    public int encontrar_cliente(Cliente_modelo cliente){
        return this.obj_lista_cliente.indexOf(cliente);
    }
    public int contar_cliente(){
        return this.obj_lista_cliente.size();
    }
    public boolean esta_vacia(){
        return this.obj_lista_cliente.isEmpty();
    }

    // Métodos estilo Collection / CRUD
    public void add(Cliente_modelo cliente){
        agregar_cliente(cliente);
    }

    public void add(int indice, Cliente_modelo cliente){
        this.obj_lista_cliente.add(indice, cliente);
    }

    public Cliente_modelo get(int indice){
        return this.obj_lista_cliente.get(indice);
    }

    public void set(int indice, Cliente_modelo cliente){
        this.obj_lista_cliente.set(indice, cliente);
    }

    public void remove(int indice){
        this.obj_lista_cliente.remove(indice);
    }

    public boolean remove(Cliente_modelo cliente){
        return this.obj_lista_cliente.remove(cliente);
    }

    public int size(){
        return this.obj_lista_cliente.size();
    }

    public boolean isEmpty(){
        return this.obj_lista_cliente.isEmpty();
    }

    public boolean contains(Cliente_modelo cliente){
        return this.obj_lista_cliente.contains(cliente);
    }

    public int indexOf(Cliente_modelo cliente){
        return this.obj_lista_cliente.indexOf(cliente);
    }

    public void clear(){
        this.obj_lista_cliente.clear();
    }

    public Cliente_modelo[] toArray(){
        return this.obj_lista_cliente.toArray(new Cliente_modelo[0]);
    }

}