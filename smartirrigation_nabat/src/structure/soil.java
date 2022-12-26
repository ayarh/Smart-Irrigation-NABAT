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


public class soil extends smart_irrigation_indicators {
private static String Soil_humidity;

public soil(String soil_humidity) {
	super();
	Soil_humidity = soil_humidity;
}

public static String getSoil_humidity() {
	return Soil_humidity;
}

public void setSoil_humidity(String soil_humidity) {
	Soil_humidity = soil_humidity;
}
public void UpdateJtableSensor(Connection con) {
	try {         		      		     
	String sql="SELECT * FROM `sensors` ";
	Statement smt = con.createStatement();
	ResultSet res=smt.executeQuery(sql);
	//`temperature`, `Air_humidity`, `Soil_humidity`, `Water_level`, `time`
	 String columns[] = {"ID","Soil_humidity","time"};
      String data[][] = new String[10000][6];
    
      int i = 0;
      while (res.next()) {
        String ID = res.getString("ID");
        String Soil_humidity = res.getString("Soil_humidity");	 	 
        String time= res.getString("time");	
        data[i][0] = ID;	        
        data[i][1] = Soil_humidity;
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
	public static String UpdateS(String temp1) {
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
	        String Soil_humidity = res.getString("Soil_humidity");	 
	       
	       // System.out.println(temperature1);
	        
	    }
		}

	catch (Exception e) {
			e.printStackTrace();
			
		}
		return Soil_humidity;
	}


}


