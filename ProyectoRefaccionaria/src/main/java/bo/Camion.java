package bo;

public class Camion {
    private int idCamion;
    private String nombre;
    private double totalAlmacenaje;
    private String placas;
    private String marca;

    // Constructores de la clase
    public Camion(){
        
    }
    public Camion(int idCamion, String nombre, double totalAlmacenaje, String placas, String marca) {
        this.idCamion = idCamion;
        this.nombre = nombre;
        this.totalAlmacenaje = totalAlmacenaje;
        this.placas = placas;
        this.marca = marca;
    }


    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalAlmacenaje() {
        return totalAlmacenaje;
    }

    public void setTotalAlmacenaje(double totalAlmacenaje) {
        this.totalAlmacenaje = totalAlmacenaje;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
