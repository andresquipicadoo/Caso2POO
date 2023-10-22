package modelo;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import Clima.Provincia;
import Clima.Region;

/**
 * Esta clase se encarga de ser el punto de entrada para buscar el clima por Provincia, Cantón y Fecha
 */
public class ContenedorModelo {
	Path rutaBase;
	private Map<String, Provincia> provincias;
	private Map<String, Region> regiones;

	public ContenedorModelo(Path rutaBase, Map<String, Provincia> provincias, Map<String, Region> regiones) {
		this.rutaBase = rutaBase;
		this.provincias = provincias;
		this.regiones = regiones;
	}

	public Map<String, Provincia> getProvincias() {
		return provincias;
	}

	public Map<String, Region> getRegiones() {
		return regiones;
	}
	
	public Path getRutaBase() {
		return rutaBase;
	}
}
