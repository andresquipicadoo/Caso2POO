package Clima;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerJSONRegiones {
    private static final String nombreArchivo = "climaRegiones.json"; // Define el nombre del archivo aquí
    
    public static List<Region> leer() throws URISyntaxException {
    	URL resource = LeerJSONRegiones.class.getResource(nombreArchivo);
    	return leerJSON(resource.toURI());	
    }

    public static List<Region> leerJSON(URI uri) {
        List<Region> regiones = new ArrayList<>();

        try {
            // Lee el contenido del archivo JSON
            String contenidoJSON = new String(Files.readAllBytes(Path.of(uri)));

            // Convierte el contenido a un objeto JSON
            JSONArray jsonArray = new JSONArray(contenidoJSON);

            // Itera a través de los elementos del arreglo JSON
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonRegion = jsonArray.getJSONObject(i);

                // Extrae los datos de la región
                String nombre = jsonRegion.getString("nombre");
                JSONObject jsonClima = jsonRegion.getJSONObject("clima");
                String condicionClima = jsonClima.getString("condicion");
                int temperaturaMaxima = jsonClima.getInt("temperaturaMaxima");
                int temperaturaMinima = jsonClima.getInt("temperaturaMinima");
                int precipitacion = jsonClima.getInt("precipitacion");
                int humedad = jsonClima.getInt("humedad");
                String viento = jsonClima.getString("viento");
                String presionAtmosferica = jsonClima.getString("presionAtmosferica");
                String faseLunar = jsonRegion.getString("faseLunar");
                String fecha = jsonRegion.getString("fecha");
                String porcentajeUV=jsonRegion.getString("IndiceUV");

               climaRegion region=new climaRegion(condicionClima,temperaturaMaxima,temperaturaMinima, humedad,precipitacion,viento,faseLunar,porcentajeUV, null);
               Region.add(region);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return regiones;
    }
	

}
