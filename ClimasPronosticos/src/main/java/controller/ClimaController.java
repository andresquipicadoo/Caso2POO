package controller;

import java.util.List;

import Clima.ClimaCanton;
import Clima.Region;

import java.util.ArrayList;

public class ClimaController {
	private List<ClimaCanton> cantones;
	private List<Region> regiones;

	public ClimaController() {
		// Inicializa las listas de cantones y regiones
		cantones = new ArrayList<>();
		regiones = new ArrayList<>();
	}

	// Método para agregar cantones a la lista de cantones
	public void agregarCanton(ClimaCanton canton) {
		cantones.add(canton);
	}

	// Método para agregar regiones a la lista de regiones
	public void agregarRegion(Region region) {
		regiones.add(region);
	}

	// Método para mostrar la información de los cantones y su clima
	public void mostrarInformacionCantones() {
		// Itera sobre la lista de cantones y muestra información
		for (ClimaCanton climaCanton : cantones) {
			System.out.println("Nombre del cantón: " + climaCanton.getCanton().getNombreCanton());
			System.out.println("Provincia: " + climaCanton.getCanton().getProvincia().getNombre());


			System.out.println("-----------------------------------");
		}
	}

	private void mostrarInformacionClima(ClimaCanton clima) {
		// TODO Auto-generated method stub

	}

	// Método para mostrar la información de las regiones y su clima
	public void mostrarInformacionRegiones() {
		// Itera sobre la lista de regiones y muestra información
		for (Region region : regiones) {
			System.out.println("Nombre de la región: " + region.getNombre());


			System.out.println("-----------------------------------");
		}
	}

}
