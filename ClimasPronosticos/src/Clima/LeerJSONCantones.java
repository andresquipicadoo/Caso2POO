package Clima;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeerJSONCantones {
    private static final String nombreArchivo = "climaProvinciasCantones.json"; // Define el nombre del archivo aquí
    
    public static List<Cantones> leer() throws URISyntaxException {
    	URL resource = LeerJSONCantones.class.getResource(nombreArchivo);
    	return leerJson(resource.toURI());
    	
    }

	public static List<Cantones> leerJson(URI uri) {
	    List<Cantones> cantones = new ArrayList<>();

	    try {
	        // Lee el contenido del archivo JSON
	        String json = new String(Files.readAllBytes(Path.of(uri)));

	        // Convierte el JSON en un objeto JSON
	        JSONObject jsonObject = new JSONObject(json);

	        // Obtiene el arreglo de cantones
	        JSONArray cantonesArray = jsonObject.getJSONArray("cantones");

	        // Itera sobre cada elemento del arreglo de cantones
	        for (int i = 0; i < cantonesArray.length(); i++) {
	            JSONObject cantonObject = cantonesArray.getJSONObject(i);

	            // Procesa los datos del cantón
	            String nombre = cantonObject.getString("nombre");
	            String provincia = cantonObject.getString("provincia");

	            // Obtiene el objeto de clima
	            JSONObject climaObject = cantonObject.getJSONObject("clima");
	            String condicionClima = climaObject.getString("condicion");
	            int temperaturaMaxima = climaObject.getInt("temperaturaMaxima");
	            int temperaturaMinima = climaObject.getInt("temperaturaMinima");
	            int precipitacion = climaObject.getInt("precipitacion");
	            int humedad = climaObject.getInt("humedad");
	            String viento = climaObject.getString("viento");
	            String presionAtmosferica = climaObject.getString("presionAtmosferica");

	            // Obtiene otros datos como fase lunar y fecha
	            String faseLunar = cantonObject.getString("faseLunar");
	            String fecha = cantonObject.getString("fecha");
                String porcentajeUV=cantonObject.getString("IndiceUV");

	            // Crea un objeto Canton con todos los datos y agrégalo a la lista
	            climaCanton canton = new climaCanton(condicionClima,temperaturaMaxima,temperaturaMinima, humedad,precipitacion,viento,faseLunar,porcentajeUV, null);
	           
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return cantones;
	}
}
