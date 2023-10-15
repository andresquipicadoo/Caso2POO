package controller;

import java.awt.EventQueue;
import java.nio.file.Path;
import java.nio.file.Paths;

import UIClima.MenuPrincipal;

public class ClimaController {
	private Path rutaBase;
	
	public ClimaController(Path rutaBase) {
		this.rutaBase = rutaBase;
	}
	
	public static boolean esRutaValida(String ruta) {
		try {
			Paths.get(ruta);
			return true;
		}
		catch (java.nio.file.InvalidPathException ex) {
			return false;
		}
	}
	
	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		System.out.println("Pronosticos de Clima v1.0");
		System.out.println("(c) 2023, Andres Quiros P.");
		ClimaController controller = null;
		if (args.length > 0) {
			String ruta = args[0];
			System.out.println(String.format("Tratando de ubicar ruta para archivos con argumento: %s", ruta));
			if (esRutaValida(ruta)) {
				System.out.println(String.format("Ruta %s existe. Se usará para tratar de cargar archivos ...", ruta));
				controller = new ClimaController(Paths.get(ruta));
			}
			else {
				System.out.println(String.format("Ruta %s no existe.", ruta));
			}			
		}
		if (controller == null) {
			System.out.println(String.format("Se usará %s para tratar de cargar archivos ...", Paths.get(".").normalize().toString()));
			controller = new ClimaController(Paths.get("."));
		}
		controller.iniciar();
	}
}
