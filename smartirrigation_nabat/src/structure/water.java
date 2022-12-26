package structure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class water extends smart_irrigation_indicators{
	private static String Water_level;

	public water(String water_level) {
		super();
		Water_level = water_level;
	}

	public static String getWater_level() {
		return Water_level;
	}

	public void setWater_level(String water_level) {
		Water_level = water_level;
	}
	public void UpdateJtableSensor(Connection con) {
		try {		   		      		     
		String sql="SELECT * FROM `sensors` ";
		Statement smt = con.createStatement();
		ResultSet res=smt.executeQuery(sql);
		//`temperature`, `Air_humidity`, `Soil_humidity`, `Water_level`, `time`
		 String columns[] = {"ID","Water_level","time"};
	      String data[][] = new String[10000][6];
	    
	      int i = 0;
	      while (res.next()) {
	        String ID = res.getString("ID");
	        String Water_level = res.getString("Water_level");	 	 
	        String time= res.getString("time");	
	        data[i][0] = ID;	        
	        data[i][1] = Water_level;
	        data[i][2] = time ;
	   
	        i++;
	      }
	    
	      DefaultTableModel model = new DefaultTableModel(data, columns);
	      JTable table = new JTable(model);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      JScrollPane pane = new JScrollPane(table);
	      JFrame f = new JFrame("Remplir JTable a partir d'une BDD");
	      JPanel panel = new JPanel();
	      panel.add(pane);
	      f.getContentPane().add(panel);
	      f.setSize(500, 250);
	   //   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setVisible(true);
	    
	    
	  }

catch (Exception e) {
			e.printStackTrace();
			
		}	

	}
	public static String UpdateW(String temp1) {
		try {
		
			      Class.forName("com.mysql.cj.jdbc.Driver");
		      System.out.println("Driver O.K.");

		      String url = "jdbc:mysql://localhost:3306/smart_irrigation";//Ecole nom de la base de donnee
		      String user = "root";
		      String passwd = "";

		      Connection con = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");         
		      	     
		String sql="SELECT * FROM `sensors` ";
		Statement smt = con.createStatement();
		ResultSet res=smt.executeQuery(sql);	   
	 
	      while (res.next()) {       
	        String Water_level = res.getString("Water_level");	 
	       
	       // System.out.println(temperature1);
	        
	    }
		}

	catch (Exception e) {
			e.printStackTrace();
			
		}
		return Water_level;
	}
}
