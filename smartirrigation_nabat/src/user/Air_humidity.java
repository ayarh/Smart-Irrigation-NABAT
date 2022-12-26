package user;
import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import base.base;
import structure.Air;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;



public class Air_humidity {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Air_humidity window = new Air_humidity();
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
	public Air_humidity() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Air Humidity ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblNewLabel_1.setBounds(46, 390, 395, 90);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Air Humidity Data ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				base b1=new base();
				Connection con=b1.connection();
				Air a1=new Air(Air.UpdateA(Air.getAir_humidity()));
				a1.UpdateJtableSensor(con);
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
		
		JButton btnNewButton_1 = new JButton("Back to remote management ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remotemanagement m1=new remotemanagement();
				m1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setForeground(new Color(245, 255, 250));
		btnNewButton_1.setBounds(10, 573, 259, 36);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 922, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

}
