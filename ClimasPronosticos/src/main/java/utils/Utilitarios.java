package utils;

import java.net.URISyntaxException;

public class Utilitarios {
	public static java.net.URI ubicarArchivo(String nombre) throws URISyntaxException {
		java.io.File f = new java.io.File(nombre);
		if (f.exists()) {
			return f.toURI();
		}
		else {
			// Se le agrega un / para buscar el archivo como recurso dentro del JAR
			String resource = "/" + nombre;
			java.net.URL url = Utilitarios.class.getResource(resource);
			return url.toURI();
		}
	}
	
	/**
	 * Convierte un string con la primera letra mayúscula
	 * @param str
	 * @return el string con la primera letra convertida a mayúsculas
	 */
	public static String capitalizar(String str)
	{
	    if(str == null || str.isEmpty() || str.isBlank() || str.length() <= 1) return str;
	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
