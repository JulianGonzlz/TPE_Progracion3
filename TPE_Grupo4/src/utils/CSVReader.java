package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Camion;
import models.Paquete;

public class CSVReader {

    /**
     * Lee un archivo CSV y devuelve una lista de objetos Camion.
     * @param rutaArchivo Ruta del archivo CSV de camiones.
     * @return Lista de camiones parseada.
     */
    public List<Camion> leerCamiones(String rutaArchivo) {
        List<Camion> camiones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String primeraLinea = br.readLine();
            if (primeraLinea != null && !primeraLinea.trim().isEmpty()) {
                int cantidadRegistros = Integer.parseInt(primeraLinea.trim());
                System.out.println("Esperando leer " + cantidadRegistros + " camiones...");
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                if (datos.length >= 4) {
                    int idCamion = Integer.parseInt(datos[0].trim());
                    String patente = datos[1].trim();
                    boolean estaRefrigerado = datos[2].trim().equals("1"); 
                    double capacidadKg = Double.parseDouble(datos[3].trim());

                    Camion camion = new Camion(idCamion, patente, estaRefrigerado, capacidadKg);
                    camiones.add(camion);
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura/escritura al leer Camiones: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en archivo Camiones: " + e.getMessage());
        }

        return camiones;
    }

    /**
     * Lee un archivo CSV y devuelve una lista de objetos Paquete.
     * @param rutaArchivo Ruta del archivo CSV de paquetes.
     * @return Lista de paquetes parseada.
     */
    public List<Paquete> leerPaquetes(String rutaArchivo) {
        List<Paquete> paquetes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String primeraLinea = br.readLine();
            if (primeraLinea != null && !primeraLinea.trim().isEmpty()) {
                int cantidadRegistros = Integer.parseInt(primeraLinea.trim());
                System.out.println("Esperando leer " + cantidadRegistros + " paquetes...");
            }

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                
                if (datos.length >= 5) {
                    int idPaquete = Integer.parseInt(datos[0].trim());
                    String codigoPaquete = datos[1].trim();
                    double pesoKg = Double.parseDouble(datos[2].trim());
                    boolean contieneAlimentos = datos[3].trim().equals("1");
                    int nivelUrgencia = Integer.parseInt(datos[4].trim());

                    Paquete paquete = new Paquete(idPaquete, codigoPaquete, pesoKg, contieneAlimentos, nivelUrgencia);
                    paquetes.add(paquete);
                }
            }
        } catch (IOException e) {
            System.err.println("Error de lectura/escritura al leer Paquetes: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en archivo Paquetes: " + e.getMessage());
        }

        return paquetes;
    }
}
