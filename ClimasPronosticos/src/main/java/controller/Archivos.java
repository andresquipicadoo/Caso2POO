package controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Clima.Canton;
import Clima.ClimaCanton;
import Clima.ClimaRegion;
import Clima.Provincia;
import Clima.Region;

public class Archivos {
	private static final String archivoCantones = "ClimaCantones.json"; 
	private static final String archivoRegiones = "ClimaRegiones.json";
	
	public static List<ClimaCanton>leerArchivoCantones(Path rutaBase) throws URISyntaxException {
		Path rutaArchivo = rutaBase.resolve(archivoCantones);
		File f = rutaArchivo.toFile();
		URI uri = null;
		if (f.exists()) {
			uri = f.toURI();
		}
		else {
			System.out.println(String.format("Archivo ClimaCantones.json no se encuentra en ruta %s. Se tratará de cargar del classpath como recurso", rutaBase.normalize().toString()));
			uri = Archivos.class.getResource("/" + archivoCantones).toURI();
		}
		return leerJsonCantones(uri);
	}
	
	public static List<ClimaRegion>leerArchivoRegiones(Path rutaBase) throws URISyntaxException {
		Path rutaArchivo = rutaBase.resolve(archivoRegiones);
		File f = rutaArchivo.toFile();
		URI uri = null;
		if (f.exists()) {
			uri = f.toURI();
		}
		else {
			System.out.println(String.format("Archivo ClimaRegiones.json no se encuentra en ruta %s. Se tratará de cargar del classpath como recurso", rutaBase.normalize().toString()));
			uri = Archivos.class.getResource("/" + archivoRegiones).toURI();
		}
		return leerJsonRegiones(uri);
	}

	
	public static List<ClimaCanton> leerJsonCantones(URI uri) {
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
	
	public static List<ClimaRegion> leerJsonRegiones(URI uri) {
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
