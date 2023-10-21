package controller;

import java.awt.EventQueue;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import Clima.Provincia;
import Clima.Region;
import UIClima.MenuPrincipal;

public class ClimaController {
	private Path rutaBase;
	
	public ClimaController(Path rutaBase) {
		this.rutaBase = rutaBase;
	}
	
	public static boolean esRutaValida(String ruta) {
		try {
			Paths.get(ruta);
			return true;
		}
		catch (java.nio.file.InvalidPathException ex) {
			return false;
		}
	}
	
	public void iniciar() {
		Map<String, Provincia> datosProvincias = null;
		Map<String, Region> datosRegiones = null;
		
		try {
			datosProvincias = Archivos.leerArchivoCantones(rutaBase);
			datosRegiones = Archivos.leerArchivoRegiones(rutaBase);
		} 
		catch (URISyntaxException e) {
			System.out.println("No se pudieron cargar los datos de regiones y cantones.");
		}
		
		if (datosProvincias != null && datosRegiones != null) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						MenuPrincipal frame = new MenuPrincipal();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("Pronosticos de Clima v1.0");
		System.out.println("(c) 2023, Andres Quiros P.");
		ClimaController controller = null;
		if (args.length > 0) {
			String ruta = args[0];
			System.out.println(String.format("Tratando de ubicar ruta para archivos con argumento: %s", ruta));
			if (esRutaValida(ruta)) {
				System.out.println(String.format("Ruta %s existe. Se usará para tratar de cargar archivos ...", ruta));
				controller = new ClimaController(Paths.get(ruta));
			}
			else {
				System.out.println(String.format("Ruta %s no existe.", ruta));
			}			
		}
		else {
			System.out.println("No se especificó ruta para carga de archivos de datos.");
		}
		if (controller == null) {
			// se trata de usar el directorio base del usuario para los archivos de datos si no se ha especificado nada
			String homeDir = System.getProperty("user.home");
			System.out.println(String.format("Se usará %s para tratar de cargar archivos ...", Paths.get(homeDir).normalize().toString()));
			controller = new ClimaController(Paths.get(homeDir));
		}
		controller.iniciar();
	}
}
