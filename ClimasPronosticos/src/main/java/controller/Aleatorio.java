package controller;


/**
 * Esta clase se utiliza para generar datos
 */
public class Aleatorio {
	public static String [] condiciones = {"Soleado", "Parcialmente Nublado", "Lluvioso"};
	public static String [] fasesLunares = {"Luna Nueva", "Cuarto Creciente", "Luna Llena", "Cuarto Menguante"};
	
	public static int enteroAleatorio(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static String obtenerCondicion() {
		return condiciones[enteroAleatorio(0, condiciones.length - 1)];
	}
	
	public static String obtenerFaseLunar() {
		return fasesLunares[enteroAleatorio(0, fasesLunares.length - 1)];
	}
	
	public static int obtenerTemperaturaMinima() {
		return enteroAleatorio(12, 20);
	}
	
	public static int obtenerTemperaturaMaxima() {
		return enteroAleatorio(21, 35);
	}
	
	public static int obtenerPrecipitacion() {
		return enteroAleatorio(200, 400);
	}
	
	public static int obtenerHumedad() {
		return enteroAleatorio(20, 60);
	}
	
	public static int obtenerVelocidadViento() {
		return enteroAleatorio(10, 40);
	}
	
	public static int obtenerPresionAmosferica() {
		return enteroAleatorio(980, 1030);
	}
	
	public static int obtenerIndiceUV() {
		return enteroAleatorio(0, 6);
	}
}
