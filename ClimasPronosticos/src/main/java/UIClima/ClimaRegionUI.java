package UIClima;

import Clima.Canton;
import Clima.ClimaCanton;
import Clima.ClimaRegion;
import Clima.Provincia;
import Clima.Region;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import UIClima.validarFecha;
import modelo.ContenedorModelo;
import utils.Utilitarios;

import javax.swing.JTextPane;

public class ClimaRegionUI extends JFrame {
	// una ventana para consultar el clima por fecha y por area
	// una ventana para ingresar los pronosticos del clima por area y las variables

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField fecha;

	private ContenedorModelo modelo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public ClimaRegionUI(ContenedorModelo modelo) {
		this.modelo = modelo;
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 901, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Clima por Regiones");
		lblNewLabel.setBounds(10, 0, 222, 55);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(290, 544, 284, 31);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresarAVentanaPrincipal();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		contentPane.add(btnNewButton);

		JTabbedPane Regiones = new JTabbedPane(JTabbedPane.TOP);
		Regiones.setBounds(0, 56, 877, 478);
		contentPane.add(Regiones);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		Regiones.addTab("Pacifico Norte", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Clima en el Pacifico Norte");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 286, 34);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-pacifico-norte.jpg")));
		lblNewLabel_2.setBounds(20, 55, 323, 362);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_10_6 = new JLabel("Digite una fecha");
		lblNewLabel_10_6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_6.setBounds(376, 137, 203, 22);
		panel.add(lblNewLabel_10_6);

		textField_6 = new JTextField();
		textField_6.setBounds(376, 169, 180, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);

		JTextPane txtPanePronosticoPN = new JTextPane();
		txtPanePronosticoPN.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoPN.setBounds(506, 217, 250, 200);
		panel.add(txtPanePronosticoPN);

		JButton btnNewButton_8 = new JButton("Consultar");
		btnNewButton_8.addActionListener(new ActionListener() {
			// Método para mostrar los datos del Pacífico Norte

			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_6, "Pacifico Norte", txtPanePronosticoPN);

			}
		});

		btnNewButton_8.setForeground(Color.BLACK);
		btnNewButton_8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_8.setBackground(new Color(0, 0, 205));
		btnNewButton_8.setBounds(562, 130, 138, 65);
		panel.add(btnNewButton_8);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		Regiones.addTab("Pacifico Central", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Clima en el Pacifico Central");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 10, 310, 34);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-pacifico-central.jpg")));
		lblNewLabel_2_1.setBounds(10, 48, 323, 362);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_10_1 = new JLabel("Digite una fecha");
		lblNewLabel_10_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_1.setBounds(376, 99, 203, 27);
		panel_2.add(lblNewLabel_10_1);

		textField_1 = new JTextField();
		textField_1.setBounds(374, 147, 180, 34);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JTextPane txtPanePronosticoPC = new JTextPane();
		txtPanePronosticoPC.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoPC.setBounds(506, 217, 250, 200);
		panel_2.add(txtPanePronosticoPC);

		JButton btnNewButton_9 = new JButton("Consultar");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_1, "Pacifico Central", txtPanePronosticoPC);
			}
		});
		btnNewButton_9.setBackground(new Color(0, 0, 255));
		btnNewButton_9.setForeground(Color.BLACK);
		btnNewButton_9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_9.setBounds(563, 111, 128, 70);
		panel_2.add(btnNewButton_9);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		Regiones.addTab("Pacifico Sur", null, panel_3, null);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Clima en el Pacifico Sur");
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(10, 10, 310, 34);
		panel_3.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-pacifico-sur.jpg")));
		lblNewLabel_2_2.setBounds(10, 49, 323, 362);
		panel_3.add(lblNewLabel_2_2);

		JLabel lblNewLabel_10_2 = new JLabel("Digite una fecha");
		lblNewLabel_10_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_2.setBounds(354, 119, 203, 26);
		panel_3.add(lblNewLabel_10_2);

		textField_2 = new JTextField();
		textField_2.setBounds(354, 158, 182, 31);
		panel_3.add(textField_2);
		textField_2.setColumns(10);

		JTextPane txtPanePronosticoPS = new JTextPane();
		txtPanePronosticoPS.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoPS.setBounds(506, 217, 250, 200);
		panel_3.add(txtPanePronosticoPS);

		JButton btnNewButton_10 = new JButton("Consultar");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_2, "Pacifico Sur", txtPanePronosticoPS);
			}
		});
		btnNewButton_10.setForeground(Color.BLACK);
		btnNewButton_10.setBackground(new Color(0, 0, 255));
		btnNewButton_10.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_10.setBounds(542, 130, 136, 63);
		panel_3.add(btnNewButton_10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		Regiones.addTab("Zona Norte", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Clima en la Zona Norte");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(10, 10, 310, 34);
		panel_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_2_2_1 = new JLabel("New label");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-zona-norte.jpg")));
		lblNewLabel_2_2_1.setBounds(10, 51, 323, 362);
		panel_1.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_10_3 = new JLabel("Digite una fecha");
		lblNewLabel_10_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_3.setBounds(360, 132, 203, 22);
		panel_1.add(lblNewLabel_10_3);

		textField_3 = new JTextField();
		textField_3.setBounds(360, 171, 180, 35);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JTextPane txtPanePronosticoZN = new JTextPane();
		txtPanePronosticoZN.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoZN.setBounds(506, 217, 250, 200);
		panel_1.add(txtPanePronosticoZN);

		JButton btnNewButton_11 = new JButton("Consultar");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_3, "Zona Norte", txtPanePronosticoZN);
			}
		});
		btnNewButton_11.setForeground(Color.BLACK);
		btnNewButton_11.setBackground(new Color(0, 0, 255));
		btnNewButton_11.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_11.setBounds(547, 139, 140, 67);
		panel_1.add(btnNewButton_11);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		Regiones.addTab("Valle Central", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1_1_2 = new JLabel("Clima en el Valle Central (GAM)");
		lblNewLabel_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(10, 10, 368, 34);
		panel_4.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_2_2_1_1 = new JLabel("New label");
		lblNewLabel_2_2_1_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-valle-central.jpg")));
		lblNewLabel_2_2_1_1.setBounds(10, 54, 323, 362);
		panel_4.add(lblNewLabel_2_2_1_1);

		JLabel lblNewLabel_10_4 = new JLabel("Digite una fecha");
		lblNewLabel_10_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_4.setBounds(383, 127, 203, 22);
		panel_4.add(lblNewLabel_10_4);

		textField_4 = new JTextField();
		textField_4.setBounds(385, 169, 180, 33);
		panel_4.add(textField_4);
		textField_4.setColumns(10);

		JTextPane txtPanePronosticoVC = new JTextPane();
		txtPanePronosticoVC.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoVC.setBounds(506, 217, 250, 200);
		panel_4.add(txtPanePronosticoVC);

		JButton btnNewButton_12 = new JButton("Consultar");
		btnNewButton_12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_4, "Valle Central", txtPanePronosticoVC);
			}
		});
		btnNewButton_12.setBackground(new Color(0, 0, 255));
		btnNewButton_12.setForeground(Color.BLACK);
		btnNewButton_12.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_12.setBounds(572, 134, 136, 68);
		panel_4.add(btnNewButton_12);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		Regiones.addTab("Caribe Norte", null, panel_5, null);
		panel_5.setLayout(null);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Clima en el Caribe Norte");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(10, 10, 368, 34);
		panel_5.add(lblNewLabel_1_1_2_1);

		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("New label");
		lblNewLabel_2_2_1_1_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-caribe.jpg")));
		lblNewLabel_2_2_1_1_1.setBounds(10, 45, 323, 362);
		panel_5.add(lblNewLabel_2_2_1_1_1);

		JLabel lblNewLabel_10_5 = new JLabel("Digite una fecha");
		lblNewLabel_10_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_5.setBounds(357, 120, 203, 25);
		panel_5.add(lblNewLabel_10_5);

		textField_5 = new JTextField();
		textField_5.setBounds(357, 155, 176, 31);
		panel_5.add(textField_5);
		textField_5.setColumns(10);

		JTextPane txtPanePronosticoCN = new JTextPane();
		txtPanePronosticoCN.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoCN.setBounds(506, 217, 250, 200);
		panel_5.add(txtPanePronosticoCN);

		JButton btnNewButton_13 = new JButton("Consultar");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField_5, "Caribe Norte", txtPanePronosticoCN);
			}
		});
		btnNewButton_13.setForeground(Color.BLACK);
		btnNewButton_13.setBackground(new Color(0, 0, 255));
		btnNewButton_13.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_13.setBounds(543, 130, 125, 56);
		panel_5.add(btnNewButton_13);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		Regiones.addTab("Caribe Sur", null, panel_6, null);
		panel_6.setLayout(null);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Clima en el Caribe Sur");
		lblNewLabel_1_1_2_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1_1_2_2.setBounds(10, 10, 368, 34);
		panel_6.add(lblNewLabel_1_1_2_2);

		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("New label");
		lblNewLabel_2_2_1_1_2.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/region-caribe.jpg")));
		lblNewLabel_2_2_1_1_2.setBounds(10, 44, 323, 362);
		panel_6.add(lblNewLabel_2_2_1_1_2);

		JLabel lblNewLabel_10 = new JLabel("Digite una fecha");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(343, 134, 203, 27);
		panel_6.add(lblNewLabel_10);

		textField = new JTextField();
		textField.setBounds(343, 171, 177, 34);
		panel_6.add(textField);
		textField.setColumns(10);

		JTextPane txtPanePronosticoCS = new JTextPane();
		txtPanePronosticoCS.setBackground(Color.LIGHT_GRAY);
		txtPanePronosticoCS.setBounds(506, 217, 250, 200);
		panel_6.add(txtPanePronosticoCS);

		JButton btnNewButton_14 = new JButton("Consultar");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarFechaYDesplegarClima(textField, "Caribe Sur", txtPanePronosticoCS);
			}
		});
		btnNewButton_14.setForeground(Color.BLACK);
		btnNewButton_14.setBackground(new Color(0, 0, 255));
		btnNewButton_14.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_14.setBounds(528, 136, 137, 69);
		panel_6.add(btnNewButton_14);
	}

	protected void validarYMostrarFecha() {
		// TODO Auto-generated method stub

	}

	private void regresarAVentanaPrincipal() {

		dispose();
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Este método valida que la fecha digitada por el usuario sea válida y
	 * despliega el clima para la región y fecha especificados. El método es
	 * reusable para todos los tabs que tienen las provincias
	 * 
	 * @param campoFecha el TextField que tiene el campo de la fecha
	 * @param provincia  la provincia para consultar y validar
	 * @param cbCanton   el ComboBox que tiene el cantón seleccionado por el usuario
	 * @param despliegue el TextPane donde se van a desplegar los datos de clima
	 */
	private void validarFechaYDesplegarClima(JTextField campoFecha, String region, JTextPane despliegue) {
		String strFecha = campoFecha.getText();
		StringBuilder sb = new StringBuilder();
		Date fecha = null;
		boolean ok = true;
		try {
			fecha = sdf.parse(strFecha);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,
					String.format("Fecha inválida: %s. Digite una fecha válida para desplegar el clima", strFecha));
			sb.append("Especifique una fecha!");
			ok = false;
		}
		if (ok) {
			// desplegar el clima
			Region reg = modelo.getRegiones().get(region);
			if (reg != null) {
				ClimaRegion climaRegion = reg.getDatosClima().get(fecha);
				if (climaRegion != null) {
					sb.append(String.format("<h4>Region: %s</h4><br>", region));
					sb.append(String.format("Condicion: %s<br>", climaRegion.getCondClima()));
					sb.append(String.format("Mínima: %s<br>", climaRegion.getTempMininima()));
					sb.append(String.format("Máxima: %s<br>", climaRegion.getTemnMaxima()));
					sb.append(String.format("Precipitación: %s mm.<br>", climaRegion.getLluvia()));
					sb.append(String.format("Humedad: %s %%<br>", climaRegion.getHumedad()));
					sb.append(String.format("Vel. Viento: %s<br>", climaRegion.getViento()));
					sb.append(String.format("Fase lunar: %s<br>", climaRegion.getFaseLunar()));
					sb.append(String.format("Indice UV: %s", climaRegion.getPorcentajeIndiceUV()));
				} else {
						sb.append(String.format("No hay datos de clima para la región %s en la fecha %s", region, strFecha));
				}
			} else {
				sb.append(String.format("No hay datos de clima para la región %s", region));
			}
		}
		despliegue.setContentType("text/html");
		despliegue.setText(sb.toString());
	}
}
