package user;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import base.base;
import structure.soil;
import structure.temperature;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Soil_humidity {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Soil_humidity window = new Soil_humidity();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Soil_humidity() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\32931-[Converti].jpg"));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		lblNewLabel.setBounds(23, 10, 415, 390);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Soil Humidity");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel_1.setBounds(46, 390, 395, 90);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Soil Humidity Data ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base b1=new base();
				Connection con=b1.connection();
				soil s1=new soil(soil.UpdateS(soil.getSoil_humidity()));	
				s1.UpdateJtableSensor(con);	
				
						  
			}
		});
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(66, 472, 357, 65);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\pngtree-vector-humidity-icon-png-image_563408.jpg"));
		lblNewLabel_2.setBounds(530, 103, 357, 316);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("back to remote management ");
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						remotemanagement m1=new remotemanagement();
						m1.frame.setVisible(true);				
						frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBounds(25, 577, 256, 32);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 922, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
