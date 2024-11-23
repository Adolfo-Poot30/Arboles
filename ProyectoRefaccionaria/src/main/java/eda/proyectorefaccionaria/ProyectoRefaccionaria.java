package eda.proyectorefaccionaria;

//import bo.Camion;
//import bo.Servicios;
import igu.Ventana;
//import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProyectoRefaccionaria {

    public static void main(String[] args) throws ExecutionException {
        /*Servicios servicios = new Servicios();

        Camion camion = servicios.obtenerListaCompleta().get(0);

        System.out.println(camion.getNombre());
        System.out.println(camion.getPlacas());
        System.out.println(camion.getIdCamion());
        System.out.println(camion.getMarca());
        System.out.println(camion.getTotalAlmacenaje());
        
        List<Camion> lista;
        lista = servicios.obtenerListaPorMarca("Marca A");
        
        for(Camion c : lista){
            System.out.println(c.getNombre() + ", " + c.getMarca());
        }*/
        
        new Ventana().setVisible(true);
    }
}
