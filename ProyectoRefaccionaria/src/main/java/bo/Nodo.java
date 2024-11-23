package bo;

class Nodo {
    Camion camion;
    Nodo izquierdo, derecho;

    public Nodo(Camion camion) {
        this.camion = camion;
        this.izquierdo = null;
        this.derecho = null;
    }
}