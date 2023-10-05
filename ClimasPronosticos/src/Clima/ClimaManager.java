package Clima;

import java.util.List;
import java.util.ArrayList;
public class ClimaManager {
	 private List<Cantones> cantones;
	    private List<Region> regiones;

	    public ClimaManager() {
	        // Inicializa las listas de cantones y regiones
	        cantones = new ArrayList<>();
	        regiones = new ArrayList<>();
	    }

	    // Método para agregar cantones a la lista de cantones
	    public void agregarCanton(Cantones canton) {
	        cantones.add(canton);
	    }

	    // Método para agregar regiones a la lista de regiones
	    public void agregarRegion(Region region) {
	        regiones.add(region);
	    }

	    // Método para mostrar la información de los cantones y su clima
	    public void mostrarInformacionCantones() {
	        // Itera sobre la lista de cantones y muestra información
	        for (Cantones canton : cantones) {
	            System.out.println("Nombre del cantón: " + canton.getNombreCanton());
	            System.out.println("Provincia: " + canton.getClimaCanton());

	            // Accede al clima del cantón
	            String clima=canton.getClimaCanton();
	           

	            System.out.println("-----------------------------------");
	        }
	    }

	    private void mostrarInformacionClima(climaCanton clima) {
			// TODO Auto-generated method stub
			
		}

		// Método para mostrar la información de las regiones y su clima
	    public void mostrarInformacionRegiones() {
	        // Itera sobre la lista de regiones y muestra información
	        for (Region region : regiones) {
	            System.out.println("Nombre de la región: " + region.getNombre());

	            // Accede al clima de la región
	            String clima = region.getClima();
	           

	            System.out.println("-----------------------------------");
	        }
	    }

	   
   
    
}
