package user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import base.base;
import methodesjtable.methodes;
import structure.temperature;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

public class Temperature {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperature window = new Temperature();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		temperature Temperature = new temperature("26");
	}

	/**
	 * Create the application.
	 */
	
	public Temperature() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\32931-[Converti].jpg"));
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 897, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\depositphotos_87623740-stock-illustration-temperature-level-icon.jpg"));
		lblNewLabel.setBounds(436, 0, 623, 647);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Temperature");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel_1.setBounds(67, 383, 359, 65);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("View Temperature Data");
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			base b1=new base();
			Connection con=b1.connection();
			temperature t1=new temperature(temperature.UpdateT(temperature.getTemperature()));	
			t1.UpdateJtableSensor(con);			
			}
		});
		btnNewButton.setBounds(115, 458, 265, 65);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 479, 386, -213);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(641, 365, 1, 1);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		lblNewLabel_2.setBounds(10, 11, 442, 362);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(103, 270, 246, 66);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Back to remote management ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remotemanagement m1=new remotemanagement();
				m1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBackground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 580, 257, 35);
		frame.getContentPane().add(btnNewButton_1);
	}
}
