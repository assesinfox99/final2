package CLASES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario <T extends Objeto> {

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

    public void mostrar() {
        //System.out.println("Inventario:");

        for (Map.Entry<Class<?>, List<T>> entry : inventario.entrySet()) {
            Class<?> tipo = entry.getKey();
            List<T> objetos = entry.getValue();

            Map<Objeto, Integer> contador = new HashMap<>();
            for (Objeto obj : objetos) {
                contador.put(obj, contador.getOrDefault(obj, 0) + 1);
            }

            System.out.println("Tipo: " + tipo.getSimpleName());
            for (Map.Entry<Objeto, Integer> item : contador.entrySet()) {
                System.out.println(" - " + item.getKey().getNombre() + " | Cantidad: " + item.getValue());
            }
            }
        }

        public void eliminar(T t) {
            Class<?> clase = t.getClass();

            if (inventario.containsKey(clase)) {
                List<T> lista = inventario.get(clase);
                lista.remove(t);
            }
        }

}
