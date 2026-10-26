package CLASES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {

    private Map<Class<?>, List<Objeto>> inventario;

    public Inventario() {
            this.inventario = new HashMap<>();
    }

    public String agregar(Objeto objeto) {
        if (objeto != null) {
            Class<?> tipo = objeto.getClass();
            inventario.putIfAbsent(tipo, new ArrayList<>());
            inventario.get(tipo).add(objeto);
            return "Agregado: " + objeto.getNombre();
        }else return "No se obtuvo ningun objeto. ";
    }

    public void mostrar() {
        //System.out.println("Inventario:");

        for (Map.Entry<Class<?>, List<Objeto>> entry : inventario.entrySet()) {
            Class<?> tipo = entry.getKey();
            List<Objeto> objetos = entry.getValue();

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

        public void eliminar(Objeto objeto) {
            Class<?> clase = objeto.getClass();

            if (inventario.containsKey(clase)) {
                List<Objeto> lista = inventario.get(clase);
                lista.remove(objeto);
            }
        }

}
