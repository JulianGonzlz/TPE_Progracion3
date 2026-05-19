package Services;

import models.Camion;
import models.Paquete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service {

    private HashMap<String, Paquete> paquetesCodigo;
    private ArrayList<Paquete> paquetes;

    private ArrayList<Paquete> alimentos;
    private ArrayList<Paquete> noAlimentos;

    public Service(String pathCamiones, String pathPaquetes) {

    }

    public Paquete servicio1(String codigoPaquete) {
        return paquetesCodigo.get(codigoPaquete);
    }

    /* complejidad temporal del servicio 1 = O(1)*/

    public List<Paquete> servicio2(boolean contieneAlimentos) {
        if (contieneAlimentos) {
            return alimentos;
        }
        return noAlimentos;
    }
    /* Complejidad temporal del servicio 2 = O(1) */

    public List<Paquete> servicio3(int urgenciaMinima, int
            urgenciaMaxima) {
        ArrayList<Paquete> resultado = new ArrayList<>();

        for(Paquete p : paquetes){

            int urgencia = p.getNivel_urgencia();

            if(urgencia >= urgenciaMinima &&
                    urgencia <= urgenciaMaxima){

                resultado.add(p);
            }
        }

        return resultado;
    }

    /* Complejidad temporal del servicio 3 = O(n) */
}
