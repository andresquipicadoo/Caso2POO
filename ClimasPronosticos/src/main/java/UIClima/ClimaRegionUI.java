package UIClima;
import Clima.ClimaRegion;
import Clima.LeerJSONRegiones;
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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;
import UIClima.validarFecha;

public class ClimaRegionUI extends JFrame {
    //una ventana para consultar el clima por fecha y por area
   //una ventana para ingresar los pronosticos del clima por area y las variables
	

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

	private final Action action = new SwingAction();
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	
	public ClimaRegionUI() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
		JButton btnNewButton_8 = new JButton("Consultar");
		btnNewButton_8.addActionListener(new ActionListener() {
			// Método para mostrar los datos del Pacífico Norte
			
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
			    	JOptionPane.showMessageDialog(null, "Error, Fecha  inválida.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
		
			public void actionPerformed(ActionEvent e) {
				String fechaIngresada = textField_6.getText();

			    // Llama al método para validar y mostrar la fecha
			      validarYMostrarFechaIngresada(fechaIngresada);
			     
			    }
			
			
			
			
			
		});
		
	
		
		btnNewButton_8.setAction(action);
		btnNewButton_8.setForeground(new Color(255, 255, 255));
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
		btnNewButton_9.setBackground(new Color(0, 0, 255));
		btnNewButton_9.setForeground(new Color(255, 255, 255));
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
		
		JButton btnNewButton_10 = new JButton("Consultar");
		btnNewButton_10.addActionListener(new ActionListener() {
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
		btnNewButton_10.setForeground(new Color(255, 255, 255));
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
				String fechaIngresada = textField_3.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
			}
		});
		btnNewButton_11.setForeground(new Color(255, 255, 255));
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
		btnNewButton_12.setBackground(new Color(0, 0, 255));
		btnNewButton_12.setForeground(new Color(255, 255, 255));
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
		
		JButton btnNewButton_13 = new JButton("Consultar");
		btnNewButton_13.addActionListener(new ActionListener() {
			
			
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
		btnNewButton_13.setForeground(new Color(255, 255, 255));
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
				String fechaIngresada = textField.getText();

			    // Llama al método para validar y mostrar la fecha
			    validarYMostrarFechaIngresada(fechaIngresada);
				
			}
		});
		btnNewButton_14.setForeground(new Color(255, 255, 255));
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
