package Clima;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import utils.Utilitarios;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LeerJSONCantones {
    private static final String nombreArchivo = "ClimaCantones.json"; 
    
    public static List<ClimaCanton> leer() throws URISyntaxException {
    	return leerJson(Utilitarios.ubicarArchivo(nombreArchivo));
    	
    }

	public static List<ClimaCanton> leerJson(URI uri) {
	    List<ClimaCanton> cantones = new ArrayList<>();

	    try {
	        // Lee el contenido del archivo JSON
	    	JSONTokener tokener = new JSONTokener(uri.toURL().openStream());

	        // Convierte el JSON en un objeto JSON
	        JSONObject jsonObject = new JSONObject(tokener);

	        // Obtiene el arreglo de cantones
	        JSONArray cantonesArray = jsonObject.getJSONArray("cantones");

	        // Itera sobre cada elemento del arreglo de cantones
	        for (int i = 0; i < cantonesArray.length(); i++) {
	            JSONObject cantonObject = cantonesArray.getJSONObject(i);

	            // Procesa los datos del cantón
	            String nombreCanton = cantonObject.getString("nombre");
	            String nombreProvincia = cantonObject.getString("provincia");

	            // Obtiene el objeto de clima
	            JSONObject climaObject = cantonObject.getJSONObject("clima");
	            String condicionClima = climaObject.getString("condicion");
	            int temperaturaMaxima = climaObject.getInt("temperaturaMaxima");
	            int temperaturaMinima = climaObject.getInt("temperaturaMinima");
	            int precipitacion = climaObject.getInt("precipitacion");
	            int humedad = climaObject.getInt("humedad");
	            String viento = climaObject.getString("viento");
	            String presionAtmosferica = climaObject.getString("presionAtmosferica");
	            String porcentajeUV = climaObject.getString("IndiceUV");

	            // Obtiene otros datos como fase lunar y fecha
	            String faseLunar = cantonObject.getString("faseLunar");
	            String fecha = cantonObject.getString("fecha");
	            
	            // crear objeto provincia
	            Provincia provincia = new Provincia(nombreProvincia);
	            
	            // crear objeto canton
	            Canton canton = new Canton(provincia, nombreCanton);

	            // Crea un objeto Canton con todos los datos y agrégalo a la lista
	            ClimaCanton climaCanton = new ClimaCanton(condicionClima,temperaturaMaxima,temperaturaMinima, humedad,precipitacion,viento,faseLunar,porcentajeUV, canton);
	            cantones.add(climaCanton);
	           
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return cantones;
	}
}
