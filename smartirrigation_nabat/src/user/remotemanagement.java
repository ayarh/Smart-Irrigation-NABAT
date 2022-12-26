package user;
import java.awt.EventQueue;
import panamahitek.Arduino.PanamaHitek_Arduino;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import base.base;

import java.util.logging.Level;
//import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import java.util.logging.Logger;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import panamahitek.Arduino.*;
import gnu.io.*;
public class remotemanagement {
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remotemanagement window = new remotemanagement();
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
	public remotemanagement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("View Soil Humidity");
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setBounds(553, 350, 281, 49);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Soil_humidity s1=new Soil_humidity();
				s1.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(btnNewButton);
		
		JButton temperature = new JButton("View Temperature");
		temperature.setForeground(new Color(255, 255, 240));
		temperature.setBackground(new Color(50, 205, 50));
		temperature.setBounds(553, 206, 281, 49);
		temperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperature t1=new Temperature();
				t1.frame.setVisible(true);
				
				frame.setVisible(false);
					
			}
		});
		temperature.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(temperature);
		
		JButton btnViewWaterLevel = new JButton("View Air Humidity");
		btnViewWaterLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Air_humidity a1= new Air_humidity();
				a1.frame.setVisible(true);
				
				frame.setVisible(false);
				
			}
		});
		btnViewWaterLevel.setForeground(new Color(255, 255, 255));
		btnViewWaterLevel.setBackground(new Color(0, 100, 0));
		btnViewWaterLevel.setBounds(553, 277, 281, 49);
		btnViewWaterLevel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(btnViewWaterLevel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 900, 37);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Smart Irrigation Nabat");
		lblNewLabel_1.setBounds(10, 15, 100, 12);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		
		JLabel lblNewLabel = new JLabel("Remote Management");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBounds(175, 65, 544, 109);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\32931-[Converti].jpg"));
		lblNewLabel_3.setBounds(42, 118, 472, 541);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnViewWaterLevel_1 = new JButton("View Water Level");
		btnViewWaterLevel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Water_level w1=new Water_level();
				w1.frame.setVisible(true);
				
				frame.setVisible(false);
			}
		});
		btnViewWaterLevel_1.setForeground(new Color(255, 255, 240));
		btnViewWaterLevel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewWaterLevel_1.setBackground(new Color(0, 100, 0));
		btnViewWaterLevel_1.setBounds(553, 420, 281, 49);
		frame.getContentPane().add(btnViewWaterLevel_1);
		
		JButton btnNewButton_1 = new JButton("Back to Add Product ");
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product  p1=new product();
				p1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBounds(10, 641, 178, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Createaccount c1=new Createaccount();
				c1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setForeground(new Color(245, 255, 250));
		btnNewButton_2.setBackground(new Color(0, 100, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(198, 641, 178, 26);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnViewWaterLevel_1_1 = new JButton("Automatic Pump Control");
		btnViewWaterLevel_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pompe j = new pompe();
				//this is the Frame that you are selecting port
				j.Connect_Frame();
				//this is the Frame where the button for the led exist
				j.Frame();

				
				
							}
		});
		btnViewWaterLevel_1_1.setForeground(new Color(255, 255, 240));
		btnViewWaterLevel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewWaterLevel_1_1.setBackground(new Color(0, 100, 0));
		btnViewWaterLevel_1_1.setBounds(553, 574, 281, 49);
		frame.getContentPane().add(btnViewWaterLevel_1_1);
		
		JButton btnViewAllData = new JButton("View All Data");
		btnViewAllData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base b1=new base();
				Connection con=b1.connection();
				b1.UpdateJtableSensors(con);				
			}
		});
		btnViewAllData.setForeground(new Color(255, 255, 240));
		btnViewAllData.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnViewAllData.setBackground(new Color(50, 205, 50));
		btnViewAllData.setBounds(553, 496, 281, 49);
		frame.getContentPane().add(btnViewAllData);
		frame.setBounds(100, 100, 914, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}

