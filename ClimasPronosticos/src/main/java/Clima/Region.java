package Clima;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Region {

	private String nombre;
	
	private Map<Date, ClimaRegion> datosClima;


    public Region(String nombreRegion) {
        this.nombre = nombreRegion;
        this.datosClima = new HashMap<>();
    }

    public String getNombre() {
    	//Devuelve el nombre de la region.
        return nombre;
    }

	public ClimaRegion agregarDatoClima(Date fecha, ClimaRegion dato) {
		datosClima.put(fecha, dato);
		return dato;		
	}
	
	public Map<Date, ClimaRegion> getDatosClima() {
		return this.datosClima;
	}

}