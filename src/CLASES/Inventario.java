package CLASES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario <T extends Objeto> {
    //El motivo para usar un Map en esta clase es que podemos guardarle cualquier objeto como clave y el valor una lista con todos los objetos de ese tipo que querramos.
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

    public String mostrar() {

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Class<?>, List<T>> entry : inventario.entrySet()) {
            Class<?> tipo = entry.getKey();
            List<T> objetos = entry.getValue();

            Map<Objeto, Integer> contador = new HashMap<>();
            for (Objeto obj : objetos) {
                contador.put(obj, contador.getOrDefault(obj, 0) + 1);
            }

            sb.append("\nTipo: " + tipo.getSimpleName() + "\n");
            for (Map.Entry<Objeto, Integer> item : contador.entrySet()) {
                sb.append(" - " + item.getKey().getNombre() + " | Cantidad: " + item.getValue()+"\n");
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

    public List<Objeto> obtenerObjetos() {

        List<Objeto> objetos = new ArrayList<>();

        for (List<T> lista : inventario.values()) {

            Map<Objeto, Integer> contador = new HashMap<>();

            for (T obj : lista) {
                contador.put(
                        obj,
                        contador.getOrDefault(obj, 0) + 1
                );
            }

            objetos.addAll(contador.keySet());
        }

        return objetos;
    }

}
