package user;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import base.base;
import structure.temperature;
import structure.water;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Water_level {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Water_level window = new Water_level();
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
	public Water_level() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		lblNewLabel.setBounds(23, 10, 415, 390);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Water Level");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel_1.setBounds(46, 390, 395, 90);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Water Level Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base b1=new base();
				Connection con=b1.connection();
				water w1=new water(water.UpdateW(water.getWater_level()));	
				w1.UpdateJtableSensor(con);
				
			}
		});
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(66, 472, 357, 65);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\istockphoto-1168974939-170667a.jpg"));
		lblNewLabel_2.setBounds(433, 104, 465, 346);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Back to remote management ");
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						remotemanagement m1=new remotemanagement();
						m1.frame.setVisible(true);				
						frame.setVisible(false);
					}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBounds(23, 573, 225, 36);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 922, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			}
		}

