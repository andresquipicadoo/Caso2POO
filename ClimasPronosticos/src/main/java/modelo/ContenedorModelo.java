package modelo;

import java.util.HashMap;
import java.util.Map;

import Clima.Provincia;
import Clima.Region;

/**
 * Esta clase se encarga de ser el punto de entrada para buscar el clima por Provincia, Cantón y Fecha
 */
public class ContenedorModelo {
	private Map<String, Provincia> provincias;
	private Map<String, Region> regiones;

	public ContenedorModelo() {
		this.provincias = new HashMap<>();
		this.regiones = new HashMap<>();
	}
}
