package bo;

import java.util.ArrayList;
import java.util.List;

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para insertar un camión en el árbol
    public void insertar(Camion camion) {
        raiz = insertarRec(raiz, camion);
    }

    private Nodo insertarRec(Nodo raiz, Camion camion) {
        if (raiz == null) {
            raiz = new Nodo(camion);
            return raiz;
        }

        if (camion.getTotalAlmacenaje() < raiz.camion.getTotalAlmacenaje()) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, camion);
        } else if (camion.getTotalAlmacenaje() > raiz.camion.getTotalAlmacenaje()) {
            raiz.derecho = insertarRec(raiz.derecho, camion);
        }

        return raiz;
    }

    // Método para filtrar camiones por rango de almacenamiento
    public List<Camion> filtrarPorRango(double min, double max) {
        List<Camion> camionesFiltrados = new ArrayList<>();
        filtrarRecPorRango(raiz, min, max, camionesFiltrados);
        return camionesFiltrados;
    }

    private void filtrarRecPorRango(Nodo raiz, double min, double max, List<Camion> camionesFiltrados) {
        if (raiz != null) {
            // Si el camión cumple con el rango de almacenamiento, lo agregamos a la lista
            if (raiz.camion.getTotalAlmacenaje() >= min && raiz.camion.getTotalAlmacenaje() <= max) {
                camionesFiltrados.add(raiz.camion);
            }

            // Continuar filtrando en el subárbol izquierdo si el valor es mayor que el límite inferior
            if (min < raiz.camion.getTotalAlmacenaje()) {
                filtrarRecPorRango(raiz.izquierdo, min, max, camionesFiltrados);
            }

            // Continuar filtrando en el subárbol derecho si el valor es menor que el límite superior
            if (max > raiz.camion.getTotalAlmacenaje()) {
                filtrarRecPorRango(raiz.derecho, min, max, camionesFiltrados);
            }
        }
    }

    // Método para filtrar por nombre
    public List<Camion> filtrarPorNombre(String nombre) {
        List<Camion> camionesFiltrados = new ArrayList<>();
        filtrarRecPorNombre(raiz, nombre, camionesFiltrados);
        return camionesFiltrados;
    }

    private void filtrarRecPorNombre(Nodo raiz, String nombre, List<Camion> camionesFiltrados) {
        if (raiz != null) {
            // Comparamos por nombre
            if (raiz.camion.getNombre().equalsIgnoreCase(nombre)) {
                camionesFiltrados.add(raiz.camion);
            }

            // Continuar buscando en ambos subárboles
            filtrarRecPorNombre(raiz.izquierdo, nombre, camionesFiltrados);
            filtrarRecPorNombre(raiz.derecho, nombre, camionesFiltrados);
        }
    }

    // Método para filtrar por marca
    public List<Camion> filtrarPorMarca(String marca) {
        List<Camion> camionesFiltrados = new ArrayList<>();
        filtrarRecPorMarca(raiz, marca, camionesFiltrados);
        return camionesFiltrados;
    }

    private void filtrarRecPorMarca(Nodo raiz, String marca, List<Camion> camionesFiltrados) {
        if (raiz != null) {
            // Comparamos por marca
            if (raiz.camion.getMarca().equalsIgnoreCase(marca)) {
                camionesFiltrados.add(raiz.camion);
            }

            // Continuar buscando en ambos subárboles
            filtrarRecPorMarca(raiz.izquierdo, marca, camionesFiltrados);
            filtrarRecPorMarca(raiz.derecho, marca, camionesFiltrados);
        }
    }

    // Método para filtrar por placas
    public List<Camion> filtrarPorPlacas(String placas) {
        List<Camion> camionesFiltrados = new ArrayList<>();
        filtrarRecPorPlacas(raiz, placas, camionesFiltrados);
        return camionesFiltrados;
    }

    private void filtrarRecPorPlacas(Nodo raiz, String placas, List<Camion> camionesFiltrados) {
        if (raiz != null) {
            // Comparamos por placas
            if (raiz.camion.getPlacas().equalsIgnoreCase(placas)) {
                camionesFiltrados.add(raiz.camion);
            }

            // Continuar buscando en ambos subárboles
            filtrarRecPorPlacas(raiz.izquierdo, placas, camionesFiltrados);
            filtrarRecPorPlacas(raiz.derecho, placas, camionesFiltrados);
        }
    }
}
