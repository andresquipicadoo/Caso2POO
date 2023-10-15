package UIClima;

import java.awt.event.ActionListener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import UIClima.validarFecha;
import Clima.ClimaCanton;
public class ClimaProvinciaUI extends JFrame {
	//una ventana para consultar el clima por fecha y por area

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField fecha;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ClimaProvinciaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 619);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Clima por Provincias");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 263, 42);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 52, 907, 476);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("San Jose", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/sanjose.png")));
		lblNewLabel_3.setBounds(10, 53, 384, 366);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_8 = new JLabel("Seleccione un Canton");
		lblNewLabel_8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(437, 10, 234, 44);
		panel.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"San Jose", "San Pedro", "Perez Zeledon", "Tibas", "Escazu"}));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(432, 53, 197, 34);
		panel.add(comboBox);
		
		JLabel lblNewLabel_10 = new JLabel("Digite una fecha");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(442, 97, 203, 22);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11.setBounds(764, 10, 117, 87);
		panel.add(lblNewLabel_11);
		
		JButton btnNewButton_8 = new JButton("Consultar");
		btnNewButton_8.addActionListener(new ActionListener() {
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = fecha.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			
			}
		
			});
		 
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(0, 0, 255));
		btnNewButton_8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_8.setBounds(437, 182, 180, 44);
		panel.add(btnNewButton_8);
		
		JLabel lblNewLabel_4_6 = new JLabel("San José");
		lblNewLabel_4_6.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_6.setBounds(137, 16, 145, 38);
		panel.add(lblNewLabel_4_6);
		
		fecha = new JTextField();
		fecha.setBounds(437, 129, 168, 34);
		panel.add(fecha);
		fecha.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Alajuela", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(new Color(51, 204, 255));
		lblNewLabel_2.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/alajuela.png")));
		lblNewLabel_2.setBounds(26, 46, 360, 366);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(685, 175, 0, 0);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_8_1 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1.setBounds(459, 30, 234, 44);
		panel_1.add(lblNewLabel_8_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Alajuela", "San Carlos", "Grecia", "Upala", "Orotina"}));
		comboBox_1.setBounds(459, 79, 196, 35);
		panel_1.add(comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(459, 163, 196, 35);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_11_1 = new JLabel("New label");
		lblNewLabel_11_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_1.setBounds(734, 10, 116, 87);
		panel_1.add(lblNewLabel_11_1);
		
		JButton btnNewButton_9 = new JButton("Consultar");
		btnNewButton_9.addActionListener(new ActionListener() {
			
			
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			public void actionPerformed(ActionEvent e) {
				
				String fechaIngresada = textField_1.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
				
				
			}
		});
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(0, 0, 255));
		btnNewButton_9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_9.setBounds(459, 210, 196, 35);
		panel_1.add(btnNewButton_9);
		
		JLabel lblNewLabel_10_1 = new JLabel("Digite una fecha");
		lblNewLabel_10_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_1.setBounds(459, 129, 203, 22);
		panel_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_4_5 = new JLabel("Alajuela");
		lblNewLabel_4_5.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_5.setBounds(135, 10, 145, 38);
		panel_1.add(lblNewLabel_4_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Cartago", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/cartago.png")));
		lblNewLabel_3_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3_1.setBounds(13, 46, 364, 366);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_8_1_2_1 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1_2_1.setBounds(387, 10, 234, 44);
		panel_2.add(lblNewLabel_8_1_2_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(255, 255, 255));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Cartago", "Paraiso", "Turrialba", "La Union", "Oreamuno"}));
		comboBox_2.setBounds(387, 49, 190, 32);
		panel_2.add(comboBox_2);
		
		JLabel lblNewLabel_10_3_1 = new JLabel("Digite una fecha");
		lblNewLabel_10_3_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_3_1.setBounds(387, 91, 203, 26);
		panel_2.add(lblNewLabel_10_3_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(387, 122, 178, 32);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Consultar");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			
			
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_6.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 255));
		btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_4.setBounds(387, 170, 176, 32);
		panel_2.add(btnNewButton_4);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("New label");
		lblNewLabel_11_1_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_1_1.setBounds(776, 10, 116, 87);
		panel_2.add(lblNewLabel_11_1_1);
		
		JLabel lblNewLabel_4_4 = new JLabel("Cartago");
		lblNewLabel_4_4.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_4.setBounds(146, 12, 145, 38);
		panel_2.add(lblNewLabel_4_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Heredia", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/heredia.png")));
		lblNewLabel_1.setBounds(22, 49, 211, 381);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_8_1_2 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1_2.setBounds(276, 10, 234, 44);
		panel_3.add(lblNewLabel_8_1_2);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBackground(new Color(255, 255, 255));
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Heredia", "San Rafael", "Belen", "Sarapiqui", "Barva"}));
		comboBox_6.setBounds(270, 49, 192, 37);
		panel_3.add(comboBox_6);
		
		JLabel lblNewLabel_10_3 = new JLabel("Digite una fecha");
		lblNewLabel_10_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_3.setBounds(276, 96, 203, 22);
		panel_3.add(lblNewLabel_10_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(276, 128, 177, 30);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11_3 = new JLabel("New label");
		lblNewLabel_11_3.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_3.setBounds(745, 10, 116, 87);
		panel_3.add(lblNewLabel_11_3);
		
		JButton btnNewButton_11 = new JButton("Consultar");
		btnNewButton_11.addActionListener(new ActionListener() {
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_5.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			}
		});
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(0, 0, 255));
		btnNewButton_11.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_11.setBounds(276, 173, 176, 37);
		panel_3.add(btnNewButton_11);
		
		JLabel lblNewLabel_4_3 = new JLabel("Heredia");
		lblNewLabel_4_3.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_3.setBounds(40, 10, 145, 38);
		panel_3.add(lblNewLabel_4_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Puntarenas", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBackground(new Color(102, 204, 255));
		lblNewLabel_5.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/puntarenas.png")));
		lblNewLabel_5.setBounds(10, 58, 398, 381);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_8_1_3 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1_3.setBounds(456, 10, 234, 44);
		panel_4.add(lblNewLabel_8_1_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBackground(new Color(255, 255, 255));
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Puntarenas", "Garabito", "Quepos", "Coto Brus", "Golfito"}));
		comboBox_5.setBounds(456, 48, 187, 29);
		panel_4.add(comboBox_5);
		
		JLabel lblNewLabel_10_4 = new JLabel("Digite una fecha");
		lblNewLabel_10_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_4.setBounds(454, 87, 203, 23);
		panel_4.add(lblNewLabel_10_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(456, 120, 187, 29);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("Consultar");
		btnNewButton_12.addActionListener(new ActionListener() {
			
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_4.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			}
		});
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(0, 0, 255));
		btnNewButton_12.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_12.setBounds(456, 168, 187, 34);
		panel_4.add(btnNewButton_12);
		
		JLabel lblNewLabel_11_1_2 = new JLabel("New label");
		lblNewLabel_11_1_2.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_1_2.setBounds(776, -9, 116, 87);
		panel_4.add(lblNewLabel_11_1_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("Puntarenas");
		lblNewLabel_4_2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(129, 10, 145, 38);
		panel_4.add(lblNewLabel_4_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("Guanacaste", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/guanacaste.png")));
		lblNewLabel_6.setBounds(10, 51, 334, 391);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8_1_4 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1_4.setBounds(391, 10, 234, 44);
		panel_5.add(lblNewLabel_8_1_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(new Color(255, 255, 255));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Liberia", "Santa Cruz ", "La Cruz", "Nicoya", "Abangares"}));
		comboBox_4.setBounds(391, 51, 182, 33);
		panel_5.add(comboBox_4);
		
		JLabel lblNewLabel_10_5 = new JLabel("Digite una fecha");
		lblNewLabel_10_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_5.setBounds(391, 82, 203, 24);
		panel_5.add(lblNewLabel_10_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(391, 116, 234, 44);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		
		JButton btnNewButton_13 = new JButton("Consultar");
		btnNewButton_13.addActionListener(new ActionListener() {
			private void mostrarDatosClimaticos(String fecha) {
			    // TODO: Debes implementar la lógica para mostrar los datos climáticos
			    // basados en la fecha proporcionada (fecha).

			    // Asumiendo que tienes el JSON de datos climáticos en una variable llamada "datosClimaticosJSON":
			    String datosClimaticosJSON = "Tu JSON de datos climáticos aquí";

			    // Analizar el JSON (puedes usar una librería como JSON-Java)
			    try {
			        // Supongamos que tienes una lista de regiones en el JSON bajo la clave "regiones"
			        JSONArray regionesArray = new JSONArray(datosClimaticosJSON);

			        // Iterar sobre las regiones para encontrar el Pacífico Norte
			        for (int i = 0; i < regionesArray.length(); i++) {
			            JSONObject regionObj = regionesArray.getJSONObject(i);

			            // Verificar si la región actual es el Pacífico Norte
			            if (regionObj.getString("nombre").equals("Pacifico Norte")) {
			                // Mostrar los datos climáticos para el Pacífico Norte
			                JSONObject climaObj = regionObj.getJSONObject("clima");
			                String condicionClima = climaObj.getString("condicion");
			                int tempMaxima = climaObj.getInt("temperaturaMaxima");
			                int tempMinima = climaObj.getInt("temperaturaMinima");
			                int precipitacion = climaObj.getInt("precipitacion");
			                int humedad = climaObj.getInt("humedad");
			                String viento = climaObj.getString("viento");
			                String presionAtmosferica = climaObj.getString("presionAtmosferica");
			                String indiceUV = climaObj.getString("IndiceUV");

			                // Mostrar los datos climáticos para el Pacífico Norte
			                String mensaje = "Datos climáticos para el Pacífico Norte el " + fecha + ":\n" +
			                        "Condición climática: " + condicionClima + "\n" +
			                        "Temperatura Máxima: " + tempMaxima + "°C\n" +
			                        "Temperatura Mínima: " + tempMinima + "°C\n" +
			                        "Precipitación: " + precipitacion + " mm\n" +
			                        "Humedad: " + humedad + "%\n" +
			                        "Viento: " + viento + "\n" +
			                        "Presión Atmosférica: " + presionAtmosferica + "\n" +
			                        "Índice UV: " + indiceUV;

			                JOptionPane.showMessageDialog(null, mensaje, "Datos Climáticos - Pacífico Norte", JOptionPane.INFORMATION_MESSAGE);
			                return; // Salir de la función después de mostrar los datos del Pacífico Norte
			            }
			        }

			        // Si no se encontraron datos para el Pacífico Norte
			        JOptionPane.showMessageDialog(null, "No se encontraron datos climáticos para el Pacífico Norte en la fecha " + fecha, "Advertencia", JOptionPane.WARNING_MESSAGE);
			    } catch (JSONException e) {
			        e.printStackTrace();
			        // Manejar excepciones en caso de problemas con el JSON
			        JOptionPane.showMessageDialog(null, "Error al procesar los datos climáticos.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_3.getText();
				String fecha = textField_3.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			    mostrarDatosClimaticos(fecha);
			}
		});
		btnNewButton_13.setBackground(new Color(0, 0, 255));
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_13.setBounds(391, 189, 182, 41);
		panel_5.add(btnNewButton_13);
		
		JLabel lblNewLabel_11_1_3 = new JLabel("New label");
		lblNewLabel_11_1_3.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_1_3.setBounds(776, 10, 116, 87);
		panel_5.add(lblNewLabel_11_1_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("Guanacaste");
		lblNewLabel_4_1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_1.setBounds(85, 12, 145, 38);
		panel_5.add(lblNewLabel_4_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Limon", null, panel_6, null);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/limon.png")));
		lblNewLabel_7.setBounds(10, 40, 302, 391);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8_1_5 = new JLabel("Seleccione un Canton");
		lblNewLabel_8_1_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_8_1_5.setBounds(336, 0, 234, 44);
		panel_6.add(lblNewLabel_8_1_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Limon", "Talamanca", "Matina", "Siquirres", "Pococi"}));
		comboBox_3.setBounds(336, 46, 187, 31);
		panel_6.add(comboBox_3);
		
		JLabel lblNewLabel_10_6 = new JLabel("Digite una fecha");
		lblNewLabel_10_6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_6.setBounds(336, 87, 203, 22);
		panel_6.add(lblNewLabel_10_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(336, 131, 158, 31);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11_6 = new JLabel("New label");
		lblNewLabel_11_6.setIcon(new ImageIcon(ClimaProvinciaUI.class.getResource("/soleado.png")));
		lblNewLabel_11_6.setBounds(745, 18, 115, 87);
		panel_6.add(lblNewLabel_11_6);
		
		JButton btnNewButton_14 = new JButton("Consultar");
		btnNewButton_14.addActionListener(new ActionListener() {
			
			
			
			
			
			private void validarYMostrarFechaIngresada(String fechaIngresada) {
				 // Paso 1: Verifica si la fecha ingresada está vacía
			    if (fechaIngresada.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Por favor, ingrese una fecha.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        return; // Sale del método si no se ingresó una fecha
			    }

			    // Paso 2: Crea una instancia de la clase validarFecha
			    validarFecha validador = new validarFecha(fechaIngresada);

			    // Paso 3: Verifica si la fecha ingresada es válida
			    boolean esFechaValida = validador.validarFecha();

			    // Paso 4: Puedes usar la variable esFechaValida para realizar acciones
			    // en función de si la fecha es válida o no
			    if (esFechaValida) {
			        // La fecha es válida, muestra un mensaje de éxito
			        JOptionPane.showMessageDialog(null, "Fecha válida.");
			    } else {
			        // La fecha no es válida, muestra un mensaje de error
			    	JOptionPane.showMessageDialog(null, "Error, Fecha inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_2.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			}
		});
		btnNewButton_14.setBackground(new Color(0, 0, 255));
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_14.setBounds(524, 125, 158, 38);
		panel_6.add(btnNewButton_14);
		
		JLabel lblNewLabel_4 = new JLabel("Limón");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(122, 2, 145, 38);
		panel_6.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 regresarsAVentanaPrincipal();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.setBounds(378, 538, 234, 38);
		contentPane.add(btnNewButton);
	}
	 private void regresarsAVentanaPrincipal() {
	        
	        dispose();
	    }
}
