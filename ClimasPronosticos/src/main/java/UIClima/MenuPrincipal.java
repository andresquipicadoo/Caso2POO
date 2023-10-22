package UIClima;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clima.Canton;
import Clima.ClimaCanton;
import Clima.ClimaRegion;
import modelo.ContenedorModelo;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ContenedorModelo modelo;


	/**
	 * Create the frame.
	 */
	public MenuPrincipal(ContenedorModelo modelo) {
		this.modelo = modelo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(109, 189, -9, 60);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Menu principal");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 38));
		lblNewLabel.setBounds(195, 20, 359, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Clima por Regiones");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClimaRegionUI climas=new ClimaRegionUI();
				climas.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.setBounds(350, 85, 242, 69);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clima por Provincias");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClimaProvinciaUI clima=new ClimaProvinciaUI(modelo);
				clima.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton_1.setBounds(64, 85, 229, 69);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 26));
		btnNewButton_2.setBounds(207, 189, 242, 60);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/fondo.jpeg")));
		lblNewLabel_1.setBounds(10, 10, 702, 389);
		contentPane.add(lblNewLabel_1);
	}

}
