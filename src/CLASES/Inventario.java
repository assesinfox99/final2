package CLASES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario <T extends Objeto> {
    //El motivo para usar un Map en esta clase es que podemos guardarle cualquier clase como clave y el valor una lista con todos los objetos de ese tipo que querramos.
    private Map<Class<?>, List<T>> inventario;

    public Inventario() {
            this.inventario = new HashMap<>();
    }

    public String agregar(T t) {
        if (t != null) {
            Class<?> tipo = t.getClass();
            inventario.putIfAbsent(tipo, new ArrayList<>());
            inventario.get(tipo).add(t);
            return "Agregado: " + t.getNombre();
        }else return "No se obtuvo ningun objeto. ";
    }

    public String mostrarMenu (){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        //Hacemos un array para guardar los tipos que tenemos.
        List<Class<?>> tiposDisponibles = new ArrayList<>();
        sb.append("--Inventario Disponible--\n");
        //Recorremos el inventario.
        for(Map.Entry<Class<?>, List<T>> entry : inventario.entrySet()) {
            //Revisamos que no este vacio.
            if (!entry.getValue().isEmpty()){
                //Agregamos el nombre de la clase que encontramos.
                sb.append(i + ". "  + entry.getKey().getSimpleName());
                tiposDisponibles.add(entry.getKey());
                i++;
            }
        }
        return sb.toString();

    }

        public void eliminar(T t) {
            Class<?> clase = t.getClass();

            if (inventario.containsKey(clase)) {
                List<T> lista = inventario.get(clase);
                lista.remove(t);
            }
        }

}
