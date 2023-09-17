package UIClima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

public class ClimaProvinciaUI extends JFrame {
	//una ventana para consultar el clima por fecha y por area

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\650px-Provincias_de_San_José__Costa_Rica_Mapa__1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(437, 97, 341, 13);
		panel.add(lblNewLabel_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Dia");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(435, 130, 151, 34);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Noche");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(611, 130, 173, 34);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Digite una fecha");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(437, 170, 203, 22);
		panel.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setBounds(437, 202, 180, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
		lblNewLabel_11.setBounds(764, 10, 117, 87);
		panel.add(lblNewLabel_11);
		
		JButton btnNewButton_8 = new JButton("Consultar");
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(0, 0, 255));
		btnNewButton_8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_8.setBounds(437, 258, 180, 44);
		panel.add(btnNewButton_8);
		
		JLabel lblNewLabel_4_6 = new JLabel("San José");
		lblNewLabel_4_6.setFont(new Font("Arial Black", Font.PLAIN, 17));
		lblNewLabel_4_6.setBounds(137, 16, 145, 38);
		panel.add(lblNewLabel_4_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Alajuela", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBackground(new Color(51, 204, 255));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\425px-Provincias_de_Alajuela__Costa_Rica_Mapa_1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1.setBounds(459, 124, 341, 13);
		panel_1.add(lblNewLabel_9_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Dia");
		rdbtnNewRadioButton_2.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(459, 158, 167, 35);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Noche");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_3.setBounds(644, 158, 140, 35);
		panel_1.add(rdbtnNewRadioButton_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(459, 234, 196, 35);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_11_1 = new JLabel("New label");
		lblNewLabel_11_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
		lblNewLabel_11_1.setBounds(734, 10, 116, 87);
		panel_1.add(lblNewLabel_11_1);
		
		JButton btnNewButton_9 = new JButton("Consultar");
		btnNewButton_9.setForeground(new Color(255, 255, 255));
		btnNewButton_9.setBackground(new Color(0, 0, 255));
		btnNewButton_9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_9.setBounds(459, 279, 196, 35);
		panel_1.add(btnNewButton_9);
		
		JLabel lblNewLabel_10_1 = new JLabel("Digite una fecha");
		lblNewLabel_10_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_1.setBounds(459, 199, 203, 22);
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
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\500px-Provincias_de_Cartago__Costa_Rica_Mapa_2_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1_2_1 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1_2_1.setBounds(387, 89, 341, 13);
		panel_2.add(lblNewLabel_9_1_2_1);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("Dia");
		rdbtnNewRadioButton_12.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_12.setBounds(387, 118, 156, 32);
		panel_2.add(rdbtnNewRadioButton_12);
		
		JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("Noche");
		rdbtnNewRadioButton_13.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_13.setBounds(552, 118, 156, 32);
		panel_2.add(rdbtnNewRadioButton_13);
		
		JLabel lblNewLabel_10_3_1 = new JLabel("Digite una fecha");
		lblNewLabel_10_3_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_3_1.setBounds(387, 156, 203, 26);
		panel_2.add(lblNewLabel_10_3_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(385, 192, 178, 32);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Consultar");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(0, 0, 255));
		btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_4.setBounds(387, 236, 176, 32);
		panel_2.add(btnNewButton_4);
		
		JLabel lblNewLabel_11_1_1 = new JLabel("New label");
		lblNewLabel_11_1_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
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
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\320px-Provincias_de_Heredia__Costa_Rica_Mapa__1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1_2 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1_2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1_2.setBounds(270, 99, 341, 13);
		panel_3.add(lblNewLabel_9_1_2);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("Dia");
		rdbtnNewRadioButton_10.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_10.setBounds(276, 128, 146, 30);
		panel_3.add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("Noche");
		rdbtnNewRadioButton_11.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_11.setBounds(439, 128, 154, 30);
		panel_3.add(rdbtnNewRadioButton_11);
		
		JLabel lblNewLabel_10_3 = new JLabel("Digite una fecha");
		lblNewLabel_10_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_3.setBounds(270, 172, 203, 22);
		panel_3.add(lblNewLabel_10_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(269, 212, 177, 30);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_11_3 = new JLabel("New label");
		lblNewLabel_11_3.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
		lblNewLabel_11_3.setBounds(745, 10, 116, 87);
		panel_3.add(lblNewLabel_11_3);
		
		JButton btnNewButton_11 = new JButton("Consultar");
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(0, 0, 255));
		btnNewButton_11.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_11.setBounds(270, 255, 176, 37);
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
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\550px-Provincias_de_Puntarenas__Costa_Rica_Mapa_1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1_3 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1_3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1_3.setBounds(456, 87, 341, 13);
		panel_4.add(lblNewLabel_9_1_3);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Dia");
		rdbtnNewRadioButton_8.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_8.setBounds(456, 118, 158, 34);
		panel_4.add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("Noche");
		rdbtnNewRadioButton_9.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_9.setBounds(628, 118, 145, 34);
		panel_4.add(rdbtnNewRadioButton_9);
		
		JLabel lblNewLabel_10_4 = new JLabel("Digite una fecha");
		lblNewLabel_10_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_4.setBounds(456, 158, 203, 23);
		panel_4.add(lblNewLabel_10_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(456, 184, 187, 29);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_12 = new JButton("Consultar");
		btnNewButton_12.setForeground(new Color(255, 255, 255));
		btnNewButton_12.setBackground(new Color(0, 0, 255));
		btnNewButton_12.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_12.setBounds(456, 235, 187, 34);
		panel_4.add(btnNewButton_12);
		
		JLabel lblNewLabel_11_1_2 = new JLabel("New label");
		lblNewLabel_11_1_2.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
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
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\450px-Provincias_de_Guanacaste__Costa_Rica_Mapa_1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1_4 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1_4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1_4.setBounds(391, 101, 341, 13);
		panel_5.add(lblNewLabel_9_1_4);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Dia");
		rdbtnNewRadioButton_6.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_6.setBounds(391, 120, 155, 33);
		panel_5.add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Noche");
		rdbtnNewRadioButton_7.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_7.setBounds(556, 120, 155, 33);
		panel_5.add(rdbtnNewRadioButton_7);
		
		JLabel lblNewLabel_10_5 = new JLabel("Digite una fecha");
		lblNewLabel_10_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_5.setBounds(391, 159, 203, 24);
		panel_5.add(lblNewLabel_10_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(391, 193, 182, 26);
		panel_5.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_13 = new JButton("Consultar");
		btnNewButton_13.setBackground(new Color(0, 0, 255));
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_13.setBounds(391, 229, 182, 41);
		panel_5.add(btnNewButton_13);
		
		JLabel lblNewLabel_11_1_3 = new JLabel("New label");
		lblNewLabel_11_1_3.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
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
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\450px-Provincias_de_Limón__Costa_Rica_Mapa_1_-removebg-preview.png"));
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
		
		JLabel lblNewLabel_9_1_5 = new JLabel("Periodo en que desea conocer el clima");
		lblNewLabel_9_1_5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_9_1_5.setBounds(333, 94, 341, 13);
		panel_6.add(lblNewLabel_9_1_5);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Dia");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_4.setBounds(334, 125, 158, 31);
		panel_6.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Noche");
		rdbtnNewRadioButton_5.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnNewRadioButton_5.setBounds(508, 125, 145, 31);
		panel_6.add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_10_6 = new JLabel("Digite una fecha");
		lblNewLabel_10_6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_6.setBounds(331, 162, 203, 22);
		panel_6.add(lblNewLabel_10_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(334, 204, 158, 31);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_11_6 = new JLabel("New label");
		lblNewLabel_11_6.setIcon(new ImageIcon("C:\\Users\\aquir\\Downloads\\sunny_sun_cloud_weather_cloudy_icon_194237(1).png"));
		lblNewLabel_11_6.setBounds(745, 18, 115, 87);
		panel_6.add(lblNewLabel_11_6);
		
		JButton btnNewButton_14 = new JButton("Consultar");
		btnNewButton_14.setBackground(new Color(0, 0, 255));
		btnNewButton_14.setForeground(new Color(255, 255, 255));
		btnNewButton_14.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_14.setBounds(334, 341, 158, 38);
		panel_6.add(btnNewButton_14);
		
		JLabel lblNewLabel_10_6_1 = new JLabel("Consultar fenomeno natural");
		lblNewLabel_10_6_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel_10_6_1.setBounds(336, 247, 334, 22);
		panel_6.add(lblNewLabel_10_6_1);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBackground(new Color(255, 255, 255));
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"Onda Tropical", "Tormenta Tropical", "Depresion Tropical", "Huracan Cat 1", "Huracan Cat 2", "Huracan Cat 3", "Huracan Cat 4", "Huracan Cat 5", "Tromba"}));
		comboBox_7.setToolTipText("");
		comboBox_7.setBounds(336, 279, 234, 38);
		panel_6.add(comboBox_7);
		
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
