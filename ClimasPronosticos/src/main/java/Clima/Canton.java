package Clima;

public class Canton {
    private String nombreCanton;
    private Provincia provincia;
	public Canton(Provincia provincia, String nombreCanton) {
		  this.nombreCanton = nombreCanton;
		  this.provincia = provincia;
	}
	
	public String getNombreCanton() {
	        return nombreCanton;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}

}