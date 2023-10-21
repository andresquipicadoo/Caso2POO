package Clima;

import java.util.HashMap;
import java.util.Map;

public class Provincia {
	
	private String nombre;
	
	private Map<String, Canton> cantones;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.cantones = new HashMap<>();
    }
    
    public Canton agregarCanton(Canton canton) {
    	this.cantones.put(canton.getNombreCanton(), canton);
    	return canton;
    }

    public String getNombre() {
        return nombre;
    } 
}
