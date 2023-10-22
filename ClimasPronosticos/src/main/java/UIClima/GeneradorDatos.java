package UIClima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.Aleatorio;
import controller.Archivos;
import modelo.ContenedorModelo;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

public class GeneradorDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaDesde;
	private JTextField txtFechaHasta;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private ContenedorModelo modelo;

	/**
	 * Launch the application.
	 */
	
	private static HashMap<String, List<String>> mapaCostaRica = new HashMap<>();
	
	static {
		llenarMapaCostaRica();
	}
	

	private static void llenarMapaCostaRica() {
		mapaCostaRica.put("San Jose",
				Arrays.asList("Central", "Escazu", "Desamparados", "Puriscal", "Tarrazu", "Asseri", "Mora",
						"Goicoechea", "Santa Ana", "Alajuelita", "Vazquez de Coronado", "Acosta", "Tibas", "Moravia",
						"Montes de Oca", "Turrubares", "Dota", "Curridabat", "Perez Zeledon", "Leon Cortes"));
		mapaCostaRica.put("Alajuela", Arrays.asList("Alajuela", "San Ramon", "Grecia", "San Mateo", "Atenas", "Naranjo",
				"Palmares", "Poas", "Orotina", "San Carlos", "Zarcero", "Sarchi", "Upala", "Los Chiles", "Guatuso"));
		mapaCostaRica.put("Heredia", Arrays.asList("Heredia", "Barva", "Santo Domingo", "Santa Barbara", "San Rafael",
				"San Isidro", "Belen", "Flores", "San Pablo", "Sarapiqui"));
		mapaCostaRica.put("Cartago", Arrays.asList("Cartago", "Paraiso", "La Union", "Jimenez", "Turrialba", "Alvarado",
				"Oreamuno", "El Guarco"));
		mapaCostaRica.put("Guanacaste", Arrays.asList("Liberia", "Nicoya", "Santa Cruz", "Bagaces", "Carrillo", "Canas",
				"Abangares", "Tilaran", "Nandayure", "La Cruz", "Hojancha"));
		mapaCostaRica.put("Puntarenas", Arrays.asList("Puntarenas", "Esparza", "Buenos Aires", "Montes de Oro", "Osa",
				"Aguirre", "Golfito", "Coto Brus", "Corredores", "Garabito"));
		mapaCostaRica.put("Limon", Arrays.asList("Limon", "Pococi", "Siquirres", "Talamanca", "Matina", "Guacimo"));
	}
	
	private static String[] regionesCostaRica = {"Valle Central", "Pacifico Norte", "Pacifico Central", "Pacifico Sur", "Zona Norte", "Caribe Norte", "Caribe Sur"};

	/**
	 * Create the frame.
	 */
	public GeneradorDatos(ContenedorModelo modelo) {
		this.modelo = modelo;
		setTitle("Generar Datos Clima Aleatorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 110);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblNewLabel = new JLabel("Desde: ");
		contentPane.add(lblNewLabel);

		txtFechaDesde = new JTextField();
		contentPane.add(txtFechaDesde);
		txtFechaDesde.setColumns(10);

		lblNewLabel_1 = new JLabel("Hasta: ");
		contentPane.add(lblNewLabel_1);

		txtFechaHasta = new JTextField();
		contentPane.add(txtFechaHasta);
		txtFechaHasta.setColumns(10);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ejecutarGeneracion();
			}
		});
		contentPane.add(btnGenerar);
	}

	private static Date hoy() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	protected void ejecutarGeneracion() {
		String fechaDesdeStr = txtFechaDesde.getText();
		String fechaHastaStr = txtFechaHasta.getText();
		Date fechaDesde = null;
		Date fechaHasta = null;
		boolean ok = true;
		// validar fecha desde
		try {
			fechaDesde = sdf.parse(fechaDesdeStr);
		} catch (ParseException e) {
			ok = false;
			JOptionPane.showMessageDialog(null, "Fecha desde es inválida ...");
		}
		// validar fecha hasta
		try {
			fechaHasta = sdf.parse(fechaHastaStr);
		} catch (ParseException e) {
			ok = false;
			JOptionPane.showMessageDialog(null, "Fecha hasta es inválida ...");
		}
		if (fechaDesde != null && fechaHasta != null) {
			if (fechaHasta.compareTo(fechaDesde) < 0) {
				JOptionPane.showMessageDialog(null, "La fecha hasta debe ser mayor o igual a la fecha desde ...");
				ok = false;
			}
			Date hoy = hoy();
			if (fechaDesde.compareTo(hoy) > 0 || fechaHasta.compareTo(hoy) > 0) {
				JOptionPane.showMessageDialog(null, "La fecha desde y hasta no pueden ser en el futuro");
				ok = false;
			}
		}
		if (ok) {
			generarDatos(modelo.getRutaBase(), fechaDesde, fechaHasta);
		}
	}

	private void generarDatos(Path rutaBase, Date fechaDesde, Date fechaHasta) {
		Path archivoCantones = rutaBase.resolve(Archivos.archivoCantones);
		Path archivoRegiones = rutaBase.resolve(Archivos.archivoRegiones);
		File fCantones = archivoCantones.toFile();
		File fRegiones = archivoRegiones.toFile();
		try {
			generarJsonCantones(fCantones, fechaDesde, fechaHasta);
			JOptionPane.showMessageDialog(null, String.format("JSON de cantones generado exitosamente en: %s", fCantones.toString()));
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, String.format("No se pudo generar JSON de cantones. Error: %s", e.getMessage()));
		}
		try {
			generarJsonRegiones(fRegiones, fechaDesde, fechaHasta);
			JOptionPane.showMessageDialog(null, String.format("JSON de regiones generado exitosamente en: %s", fCantones.toString()));
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, String.format("No se pudo generar JSON de regiones. Error: %s", e.getMessage()));			
		}
	}

	private void generarJsonRegiones(File fRegiones, Date fechaDesde, Date fechaHasta) throws IOException {
		Calendar desde = Calendar.getInstance();
		desde.setTime(fechaDesde);
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		root.put("regiones", array);
		while (desde.getTime().compareTo(fechaHasta) <= 0) {
			for (String region : regionesCostaRica) {
				JSONObject obj = new JSONObject();
				// datos principales
				obj.put("fecha", sdf.format(desde.getTime()));
				obj.put("nombre", region);
				// datos de clima
				obj.put("clima", generarClimaAleatorio());
				obj.put("faseLunar", Aleatorio.obtenerFaseLunar());
				array.put(obj);
				
			}
			// aumentar un día
			desde.add(Calendar.DAY_OF_MONTH, 1);
		}
		Writer fw = new BufferedWriter(new FileWriter(fRegiones));
		root.write(fw);
		fw.close();
	}
	
	private JSONObject generarClimaAleatorio() {
		JSONObject clima = new JSONObject();
		clima.put("condicion", Aleatorio.obtenerCondicion());
		clima.put("temperaturaMaxima", Aleatorio.obtenerTemperaturaMaxima());
		clima.put("temperaturaMinima", Aleatorio.obtenerTemperaturaMinima());
		clima.put("precipitacion", Aleatorio.obtenerPrecipitacion());
		clima.put("humedad", Aleatorio.obtenerHumedad());
		clima.put("viento", String.format("%s km/h", Aleatorio.obtenerVelocidadViento()));
		clima.put("presionAtmosferica", String.format("%s hPa", Aleatorio.obtenerPresionAmosferica()));
		clima.put("IndiceUV", String.format("%s%%", Aleatorio.obtenerIndiceUV()));
		return clima;
	}

	private void generarJsonCantones(File fCantones, Date fechaDesde, Date fechaHasta) throws IOException {
		Calendar desde = Calendar.getInstance();
		desde.setTime(fechaDesde);
		JSONObject root = new JSONObject();
		JSONArray array = new JSONArray();
		root.put("cantones", array);
		while (desde.getTime().compareTo(fechaHasta) <= 0) {
			// ahora, se itera por el mapa de CR para generar un estado de tiempo por cada provincia y canton, de manera aleatoria
			for (String provincia : mapaCostaRica.keySet()) {
				for (String canton : mapaCostaRica.get(provincia)) {
					JSONObject obj = new JSONObject();
					// datos principales
					obj.put("fecha", sdf.format(desde.getTime()));
					obj.put("nombre", canton);
					obj.put("provincia", provincia);
					// datos de clima
					obj.put("clima", generarClimaAleatorio());
					obj.put("faseLunar", Aleatorio.obtenerFaseLunar());
					array.put(obj);
				}
			}
			// aumentar un día
			desde.add(Calendar.DAY_OF_MONTH, 1);
		}
		Writer fw = new BufferedWriter(new FileWriter(fCantones));
		root.write(fw);
		fw.close();
	}

}
