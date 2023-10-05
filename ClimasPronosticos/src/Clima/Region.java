package Clima;

public class Region {

	private String nombre;
	private String clima;


    public Region(String nombreRegion, String climaRegion) {
        this.nombre = nombreRegion;
        this.clima = climaRegion;
    }

    public String getNombre() {
    	//Devuelve el nombre de la region.
        return nombre;
    }

    public String getClima() {
    	// Devuelvve el clima que presenta la region.
        return clima;
    }

	public static void add(climaRegion region) {
		// TODO Auto-generated method stub
		
	}
	

}