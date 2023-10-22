package Clima;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Canton {
    private String nombreCanton;
    private Provincia provincia;
    private Map<Date, ClimaCanton> datosClima;
    
	public Canton(Provincia provincia, String nombreCanton) {
		  this.nombreCanton = nombreCanton;
		  this.provincia = provincia;
		  this.datosClima = new HashMap<>();
	}
	
	public String getNombreCanton() {
	        return nombreCanton;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}
	
	public ClimaCanton agregarDatoClima(Date fecha, ClimaCanton dato) {
		datosClima.put(fecha,  dato);
		return dato;
	}
	
	public Map<Date, ClimaCanton> getDatosClima() {
		return this.datosClima;
	}

}