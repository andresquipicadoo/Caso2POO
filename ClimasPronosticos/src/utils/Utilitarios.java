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
}
