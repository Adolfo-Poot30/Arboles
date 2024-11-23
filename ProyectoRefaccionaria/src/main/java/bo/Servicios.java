package bo;

import dao.ConsultaCamiones;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Servicios {

    private ConsultaCamiones consulta = new ConsultaCamiones();
    
    private List<Camion> listaCompleta;
    private ArbolBinario arbol = new ArbolBinario();

    public Servicios() throws ExecutionException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return consulta.obtenerCamiones();  // Obtenemos los camiones
        }).thenAccept(camiones -> {
            // Insertamos los camiones en el árbol y en la lista
            listaCompleta = camiones;
            for (Camion c : camiones) {
                arbol.insertar(c);
            }
        });

        // Esperamos que el proceso asíncrono termine
        try {
            future.get();  // Este `get()` bloquea el hilo hasta que la tarea se complete
        } catch (InterruptedException | ExecutionException e) {
            System.out.print(e);
        }
    }

    public List<Camion> obtenerListaCompleta() {
        return listaCompleta;
    }

    public List<Camion> obtenerListaPorNombre(String nombre) {
        return arbol.filtrarPorNombre(nombre);
    }

    public List<Camion> obtenerListaPorPlacas(String placa) {
        return arbol.filtrarPorPlacas(placa);
    }

    public List<Camion> obtenerListaPorTonelaje(double min, double max) {
        return arbol.filtrarPorRango(min, max);
    }

    public List<Camion> obtenerListaPorMarca(String marca) {
        return arbol.filtrarPorMarca(marca);
    }
}
