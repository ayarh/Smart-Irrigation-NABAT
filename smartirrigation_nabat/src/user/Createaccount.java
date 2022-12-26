package user;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import base.base;
public class Createaccount {

	JFrame frame;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Createaccount window = new Createaccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Createaccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		frame.setBackground(new Color(240, 255, 240));
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 841, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(552, 72, 253, 86);
		frame.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(552, 168, 219, 36);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(552, 214, 165, 86);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		password = new JPasswordField();
		password.setBounds(552, 310, 219, 36);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Log in ");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String Email = email.getText();
					String Password = password.getText();
					base b1=new base();
					Connection con=b1.connection();
					boolean b2=b1.checklogin( con ,Email , Password);
					if(!b2) {
						JOptionPane.showMessageDialog(null, "Your Email or Password is incorrect  ");
						
					}
					else {
						product p1= new product();
						p1.frame.setVisible(true);
						
						frame.setVisible(false);
					}
			}
					});
		btnNewButton.setBounds(557, 403, 213, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\logo2.png"));
		lblNewLabel.setBounds(21, 39, 453, 440);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 844, 29);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("Login page");
		lblLoginPage.setBounds(10, 10, 58, 15);
		lblLoginPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoginPage.setToolTipText("");
		panel.add(lblLoginPage);
		lblLoginPage.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLoginPage.setForeground(new Color(240, 255, 240));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 578, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(240, 255, 240));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnExit.setBackground(new Color(0, 100, 0));
		btnExit.setBounds(558, 449, 213, 36);
		frame.getContentPane().add(btnExit);
	}
}
