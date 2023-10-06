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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerJSONRegiones {
	private static final String nombreArchivo = "ClimaRegiones.json"; // Define el nombre del archivo aquí

	public static List<ClimaRegion> leer() throws URISyntaxException {
		return leerJSON(Utilitarios.ubicarArchivo(nombreArchivo));
	}

	public static List<ClimaRegion> leerJSON(URI uri) {
		List<ClimaRegion> regiones = new ArrayList<>();

		try {
	        // Lee el contenido del archivo JSON
	    	JSONTokener tokener = new JSONTokener(uri.toURL().openStream());

	        // Convierte el JSON en un objeto JSON
	        JSONObject jsonObject = new JSONObject(tokener);
	        
	        // Lee el arreglo principal de regiones
	        // Obtiene el arreglo de cantones
	        JSONArray regionesArray = jsonObject.getJSONArray("regiones");


			// Itera a través de los elementos del arreglo JSON
			for (int i = 0; i < regionesArray.length(); i++) {
				JSONObject jsonRegion = regionesArray.getJSONObject(i);

				// Extrae los datos de la región
				String nombreRegion = jsonRegion.getString("nombre");
				JSONObject jsonClima = jsonRegion.getJSONObject("clima");
				String condicionClima = jsonClima.getString("condicion");
				int temperaturaMaxima = jsonClima.getInt("temperaturaMaxima");
				int temperaturaMinima = jsonClima.getInt("temperaturaMinima");
				int precipitacion = jsonClima.getInt("precipitacion");
				int humedad = jsonClima.getInt("humedad");
				String viento = jsonClima.getString("viento");
				String presionAtmosferica = jsonClima.getString("presionAtmosferica");
				String porcentajeUV = jsonClima.getString("IndiceUV");
				String faseLunar = jsonRegion.getString("faseLunar");
				String fecha = jsonRegion.getString("fecha");
				
				// Crea objeto region
				Region region = new Region(nombreRegion);

				ClimaRegion climaRegion = new ClimaRegion(condicionClima, temperaturaMaxima, temperaturaMinima, humedad,
						precipitacion, viento, faseLunar, porcentajeUV, region);
				regiones.add(climaRegion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return regiones;
	}

}
