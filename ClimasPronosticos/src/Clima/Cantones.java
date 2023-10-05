package Clima;

public class Cantones {
    private String nombreCanton;
    private String climaCanton;
    private Provincia provincia;
	public Cantones(Provincia prov,String nombreCanton,String climaCanton) {
	
		// TODO Auto-generated constructor stub
		  this.nombreCanton = nombreCanton;
		  this.climaCanton=climaCanton;
	}
	
	public String getNombreCanton() {
	        return nombreCanton;
	    }
	 public String getClimaCanton() {
		 return climaCanton;
		 
	 }
	 

}