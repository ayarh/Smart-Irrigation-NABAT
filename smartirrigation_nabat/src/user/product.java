package user;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import base.base;
import structure.Product;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class product {

	JFrame frame;
	private JTextField typeplante;
	private JTextField typesoil;
	private JTextField humiditymax;
	private JTextField humiditymin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product window = new product();
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
	public product() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		frame.setBackground(new Color(255, 255, 255));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 796, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\misting-systems-5ae71ee8eb3a0-1.jpg"));
		lblNewLabel.setBounds(0, -30, 436, 556);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Agricultural Product ");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setBounds(370, 10, 465, 77);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Soil type : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(469, 158, 156, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		typeplante = new JTextField();
		typeplante.setBounds(446, 121, 290, 28);
		frame.getContentPane().add(typeplante);
		typeplante.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Type of Plant : ");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(469, 79, 156, 35);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		typesoil = new JTextField();
		typesoil.setColumns(10);
		typesoil.setBounds(446, 195, 290, 28);
		frame.getContentPane().add(typesoil);
		
		JLabel lblNewLabel_2_2 = new JLabel(" Soil Maximum humidity : ");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(469, 230, 183, 35);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		humiditymax = new JTextField();
		humiditymax.setColumns(10);
		humiditymax.setBounds(446, 274, 290, 28);
		frame.getContentPane().add(humiditymax);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Soil Minimum humidity : ");
		lblNewLabel_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(469, 319, 169, 35);
		frame.getContentPane().add(lblNewLabel_2_2_1);
		
		humiditymin = new JTextField();
		humiditymin.setColumns(10);
		humiditymin.setBounds(446, 360, 290, 28);
		frame.getContentPane().add(humiditymin);
		
		JButton btnNewButton = new JButton("Create New Product ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String Typeplante = typeplante.getText();
					String Typesoil = typesoil.getText();
					int Humiditymax=Integer.parseInt(humiditymax.getText());
					int Humiditymin=Integer.parseInt(humiditymin.getText());
					base b1=new base();
					Connection con=b1.connection();
					b1.product_insertion(con,Typeplante,Typesoil,Humiditymax ,Humiditymin);
				    JOptionPane.showMessageDialog(null, "Product Added ");
			        typeplante.setText("");
					typesoil.setText("");
					humiditymax.setText("");
					humiditymin.setText("");     
					remotemanagement m1=new remotemanagement();
					m1.frame.setVisible(true);
					
					frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(446, 413, 156, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnRemoteManagement = new JButton("Remote Management ");
		btnRemoteManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remotemanagement m1=new remotemanagement();
				m1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnRemoteManagement.setForeground(new Color(240, 255, 240));
		btnRemoteManagement.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnRemoteManagement.setBackground(new Color(0, 128, 0));
		btnRemoteManagement.setBounds(612, 413, 156, 38);
		frame.getContentPane().add(btnRemoteManagement);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Createaccount c1=new Createaccount();
				c1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnLogOut.setForeground(new Color(240, 255, 240));
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnLogOut.setBackground(new Color(0, 128, 0));
		btnLogOut.setBounds(612, 461, 156, 38);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnViewProductDatabase = new JButton("View Database");
		btnViewProductDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base b1=new base();
				Connection con=b1.connection();
				Product p1=new Product();
				 p1.Updateproducts(con);
			}
		});
		btnViewProductDatabase.setForeground(new Color(240, 255, 240));
		btnViewProductDatabase.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnViewProductDatabase.setBackground(new Color(0, 128, 0));
		btnViewProductDatabase.setBounds(446, 461, 156, 38);
		frame.getContentPane().add(btnViewProductDatabase);
	}

	
}
