package Clima;

public class ClimaCanton {
	private String condClima;
	private int temnMaxima;
	private int tempMininima;
	private int humedad;
	private int lluvia;
	private String viento;
	private String faseLunar;
	private String porcentajeIndiceUV;
	private Canton canton;
	
	public ClimaCanton(String condClima, int temnMaxima,int tempMininima,int humedad,int lluvia,String viento,String faseLunar,String porcentajeIndiceUV,Canton canton) {
		
		this.condClima=condClima;
		this.faseLunar=faseLunar;
		this.setLluvia(lluvia);
		this.tempMininima=tempMininima;
		this.porcentajeIndiceUV=porcentajeIndiceUV;
		this.humedad=humedad;
		this.setViento(viento);
		this.temnMaxima=temnMaxima;
		this.tempMininima=tempMininima;
		this.canton=canton;
	}

	public String getCondClima() {
		return condClima;
	}

	public int getTemnMaxima() {
		return temnMaxima;
	}

	public int getTempMininima() {
		return tempMininima;
	}

	public int getHumedad() {
		return humedad;
	}

	public int getLluvia() {
		return lluvia;
	}

	public void setLluvia(int lluvia) {
		this.lluvia = lluvia;
	}

	public String getViento() {
		return viento;
	}

	public void setViento(String viento) {
		this.viento = viento;
	}

	public String getFaseLunar() {
		return faseLunar;
	}

	public String getPorcentajeIndiceUV() {
		return porcentajeIndiceUV;
	}

	public Canton getCanton() {
		return canton;
	}
	
	

}
