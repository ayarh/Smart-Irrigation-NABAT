package user;
import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.*;
import com.fazecast.jSerialComm.*;
import java.io.PrintWriter;
import java.awt.Toolkit;
import java.awt.Font;

class pompe{
	JFrame frame;
	public static void main(String[] args){
		//Creating object to call non sting methods
		pompe j = new pompe();
		//this is the Frame that you are selecting port
		j.Connect_Frame();
		//this is the Frame where the button for the led exist
		j.Frame();
		
		}

	//Creating a SerialPort called port to use it in all other methods
	public SerialPort port;
	
	//this is the Frame where the button for the led exist
	public void Frame(){
		JFrame window = new JFrame();
		JButton led_1 = new JButton("Run On/Off pump");
		led_1.setForeground(new Color(240, 255, 240));
		led_1.setBackground(new Color(0, 100, 0));
		led_1.setBounds(599, 350, 235, 49);
		JButton exit = new JButton("EXIT");
		exit.setForeground(new Color(240, 255, 240));
		exit.setBackground(new Color(0, 100, 0));
		exit.setBounds(599, 350, 235, 49);
		exit.setFocusable(false);
		exit.setFocusable(false);
		window.getContentPane().setLayout(new FlowLayout());
		window.getContentPane().add(led_1);
		window.getContentPane().add(exit);
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		exit.addActionListener(new Exit());
		led_1.addActionListener(new Led_1());
	}
	//this is the Frame that you are selecting port
	public void Connect_Frame(){
		JFrame arduino = new JFrame();
		arduino.setBackground(new Color(255, 255, 255));
		arduino.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\32931-[Converti].jpg"));
		arduino.getContentPane().setBackground(new Color(255, 255, 255));
		JComboBox<String> portList = new JComboBox<String>();
		portList.setForeground(new Color(245, 255, 250));
		portList.setBackground(new Color(0, 100, 0));
		portList.setBounds(680, 77, 92, 35);
		JButton connectButton = new JButton("Connect");
		connectButton.setForeground(new Color(245, 255, 250));
		connectButton.setBackground(new Color(0, 100, 0));
		connectButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		connectButton.setBounds(793, 77, 166, 35);
		connectButton.setFocusable(false);
		arduino.getContentPane().setLayout(null);
		arduino.getContentPane().add(portList);
		arduino.getContentPane().add(connectButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\smartfarm\\_gO6tePwDnI.jfif"));
		lblNewLabel.setBounds(33, 110, 949, 459);
		arduino.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connect  your Arduino");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(34, 139, 34));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(670, 36, 312, 35);
		arduino.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back to remote management ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remotemanagement m1=new remotemanagement();
				m1.frame.setVisible(true);				
				frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(245, 255, 250));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(22, 580, 215, 31);
		arduino.getContentPane().add(btnNewButton);
		arduino.setSize(996,648);
		arduino.setResizable(false);
		arduino.setVisible(true);
		//adding ports to the list
		SerialPort[] portNames = SerialPort.getCommPorts();
		for(int i = 0; i < portNames.length; i++)
			portList.addItem(portNames[i].getSystemPortName());
		//the action of the button (maybe hard to understand but needs to stay in the Connect_Frame()
		connectButton.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent arg0) {
				if(connectButton.getText().equals("Connect")) {
					// attempt to connect to the serial port
					port = SerialPort.getCommPort(portList.getSelectedItem().toString());
					port.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
					if(port.openPort()) {
						connectButton.setText("Disconnect");
						portList.setEnabled(false);
					}
				} 
				else {
					// disconnect from the serial port
					port.closePort();
					portList.setEnabled(true);
					connectButton.setText("Connect");
				}
			}
		});
	}
	//Here is the actios of the button from the Frame() (you can add more)
	public class Exit implements ActionListener{
		public void actionPerformed(ActionEvent a){
			System.exit(0);   
		}
   	}
	public int led_1_state = 0;
	
	public class Led_1 implements ActionListener{
		public void actionPerformed(ActionEvent a){
			PrintWriter output = new PrintWriter(port.getOutputStream());
			if (led_1_state == 0){
				output.print("1");
				output.flush();
				System.out.println("led_1: on");
				led_1_state = 1;
			}
			else {
				output.print("0");
				output.flush();
				System.out.println("led_1: off");
				led_1_state = 0;
			}
		}
   	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

