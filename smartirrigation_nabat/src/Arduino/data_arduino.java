package Arduino;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;


import com.fazecast.jSerialComm.*;
public class data_arduino {
	SerialPort activePort;
	SerialPort[] ports = SerialPort.getCommPorts();
	
	public void showAllPort() {
		int i = 0;
		for(SerialPort port : ports) {
			System.out.print(i + ". " + port.getDescriptivePortName() + " ");
			System.out.println(port.getPortDescription());
			i++;
			}	
		}	
	  public Connection connection ()
      {
              Connection con ;
              try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              System.out.println("Driver O.K.");

              String url = "jdbc:mysql://localhost:3306/smart_irrigation"; //3306 le port , ecole de la base
              String user = "root";
              String passwd = "";

              con = DriverManager.getConnection(url, user, passwd);
              System.out.println("Connexion effective !");  
              return con ;
      }catch (Exception e) {
              e.printStackTrace();
              return null;
  }
      }
	  public void insertion1 (Connection con ,String temp)
      {
              try {
                     
                           String sql2="\"INSERT INTO `sensors`(`temperature`) VALUE ('temp')";
                           Statement smt2 = con.createStatement();  
                           int retour = smt2.executeUpdate(sql2);
                     
              }catch (Exception e) {
                      e.printStackTrace();
          }
      }
	  

	  	  

	public void setPort(int portIndex) {
		activePort = ports[portIndex];
		
		if (activePort.openPort())
			System.out.println(activePort.getPortDescription() + " port opened.");
		
		activePort.addDataListener(new SerialPortDataListener() {
			
			@Override
			public void serialEvent(SerialPortEvent event) {
				int size = event.getSerialPort().bytesAvailable();
				byte[] buffer = new byte[size];
				//byte[] arr=new byte[size-1];
				event.getSerialPort().readBytes(buffer, size);
			    String string = new String(buffer);
				//System.out.println(string);
				  try {
		        		
		        	    String[] words = string.split("::");//diviser data				       
				        Thread.sleep(3000);
				        Connection  connexion =connection();
		                String sql2="INSERT INTO `sensors`(`temperature`, `Air_humidity`, `Soil_humidity`, `Water_level`) VALUES ('"+words[0]+"','"+words[1]+"','"+words[2]+"','"+words[3]+"')";
		                Statement smt2 = connexion.createStatement();  
		                int retour = smt2.executeUpdate(sql2);
		         }catch (Exception e) {
		        	 e.printStackTrace();}
				}
							
			public int getListeningEvents() { 
				return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;  
				}
			});
		}
	
	public void start() {
		showAllPort();
		Scanner reader = new Scanner(System.in);
		System.out.print("Port? ");
		int p = reader.nextInt();
		setPort(p);
		reader.close();
		}
	
	public static void main(String[] args) {
		data_arduino mainClass = new data_arduino();
		mainClass.start();
		
	}

}
