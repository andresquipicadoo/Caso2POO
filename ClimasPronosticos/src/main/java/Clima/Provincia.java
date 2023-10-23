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
    
    public Canton agregarCanton(String canton) {
    	if (this.cantones.containsKey(canton)) {
    		return this.cantones.get(canton);
    	}
    	Canton nuevo = new Canton(this, canton);
    	this.cantones.put(canton, nuevo);
    	return nuevo;
    }
    


    public String getNombre() {
        return nombre;
    }
    
    public Map<String, Canton> getCantones() {
    	return cantones;
    }
}
