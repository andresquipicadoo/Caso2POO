package controller;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import Clima.Canton;
import Clima.ClimaCanton;
import Clima.ClimaRegion;
import Clima.Provincia;
import Clima.Region;

public class Archivos {
	public static final String archivoCantones = "ClimaCantones.json"; 
	public static final String archivoRegiones = "ClimaRegiones.json";
	
	public static Map<String, Provincia> leerArchivoCantones(Path rutaBase) throws URISyntaxException {
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
	
	public static Map<String, Region> leerArchivoRegiones(Path rutaBase) throws URISyntaxException {
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

	
	public static Map<String, Provincia> leerJsonCantones(URI uri) {
	    Map<String, Provincia> provincias = new HashMap<>();
	   
	    try {
	        // Lee el contenido del archivo JSON
	    	JSONTokener tokener = new JSONTokener(uri.toURL().openStream());

	        // Convierte el JSON en un objeto JSON
	        JSONObject jsonObject = new JSONObject(tokener);

	        // Obtiene el arreglo de cantones
	        JSONArray cantonesArray = jsonObject.getJSONArray("cantones");

	        // Itera sobre cada elemento del arreglo de cantones
	        for (int i = 0; i < cantonesArray.length(); i++) {
	        	// obtener los objetos que contienen los datos principales
	            JSONObject cantonObject = cantonesArray.getJSONObject(i);
	            // Obtiene el objeto de clima
	            JSONObject climaObject = cantonObject.getJSONObject("clima");

	            // Procesa los datos de provincia y canton
	            // verificamos si la provincia ya se proceso
	            Provincia provincia = null;
	            String nombreProvincia = cantonObject.getString("provincia").toLowerCase();
	            if (provincias.containsKey(nombreProvincia)) {
	            	provincia = provincias.get(nombreProvincia);
	            }
	            else {
	            	provincia = new Provincia(nombreProvincia);
	            	provincias.put(nombreProvincia, provincia);
	            }
	            String nombreCanton = cantonObject.getString("nombre");
	            Canton canton = provincia.agregarCanton(nombreCanton);
	            // fecha del dato de clima
	            String fechaString = cantonObject.getString("fecha");
	            Date fecha = null;
	            try {
	            	fecha = procesarFecha(fechaString);
	            }
	            catch (ParseException pe) {
	            	System.out.println(String.format("Error procesando fecha %s, no se agregará el dato correspondiente para cantón %s, provincia %s.", fechaString, nombreCanton, nombreProvincia));
	            }
	            if (fecha != null) {
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
		           
		            // Crea un objeto ClimaCanton con todos los datos del clima para el canton
		            ClimaCanton climaCanton = new ClimaCanton(condicionClima,temperaturaMaxima,temperaturaMinima, humedad,precipitacion,viento,faseLunar,porcentajeUV, canton);
		            // se agrega el dato de clima al cantón para la fecha indicada
		            canton.agregarDatoClima(fecha, climaCanton);
	            }
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return provincias;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private static Date procesarFecha(String fechaString) throws ParseException {
		// convierte la fecha de string a Date, para mejor manipulación
		// supone un formato de DD/MM/YYYY
		return sdf.parse(fechaString);
	}

	public static Map<String, Region> leerJsonRegiones(URI uri) {
		Map<String, Region> regiones = new HashMap<>();

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
				// Crea objeto region
				Region region = new Region(nombreRegion);
				// procesar la fecha del dato de clima
				String fechaString = jsonRegion.getString("fecha");
	            Date fecha = null;
	            try {
	            	fecha = procesarFecha(fechaString);
	            }
	            catch (ParseException pe) {
	            	System.out.println(String.format("Error procesando fecha %s, no se agregará el dato correspondiente para región %s", fechaString, nombreRegion));
	            }
	            if (fecha != null) {
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
					

					ClimaRegion climaRegion = new ClimaRegion(condicionClima, temperaturaMaxima, temperaturaMinima, humedad,
							precipitacion, viento, faseLunar, porcentajeUV, region);
					region.agregarDatoClima(fecha, climaRegion);
					regiones.put(nombreRegion, region);
	            }

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return regiones;
	}


}
