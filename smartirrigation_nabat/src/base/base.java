package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class base {
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
            return null; }
    }
	//authentification
	public  boolean checklogin(Connection con ,String mail , String mdp) {
		int rowc=0;
		try { 
			   Statement stmt = con.createStatement();
			   String sql =String.format("SELECT * FROM login WHERE Email='%s' and Password='%s'",mail,mdp);
			   ResultSet resultats = stmt.executeQuery(sql);
			   while(resultats.next()) {
				   rowc++;
			   }
			   if(rowc>0) {return true;}
			   else {return false;}
			   
			} catch (SQLException e) {
			   e.printStackTrace();
			   return false;
			}
	}
	//insertion produit
	public void product_insertion(Connection con,String type_plante,String Type_sol,int Hmax , int Hmin) {
	try {  
	       String sql2 = String.format("INSERT INTO `product`(`type_plante`, `type_sol`, `humiditymax`, `humiditymin`) VALUES ('%s','%s',%d,%d)", type_plante, Type_sol, Hmax , Hmin);
	      //  String sql2= "INSERT INTO create_account  VALUES (+Nom+,+Prénom+, +Login+, +Password+, +Email+)";
			Statement smt = con.createStatement();
			smt.executeUpdate(sql2);
	       //close connection
	        con.close();
	        }catch (SQLException e) {
				   e.printStackTrace();
				   }
	}
	
	public void UpdateJtableSensors(Connection con) {
		try {        		      		     
		String sql="SELECT * FROM `sensors` ";
		Statement smt = con.createStatement();
		ResultSet res=smt.executeQuery(sql);
		//`temperature`, `Air_humidity`, `Soil_humidity`, `Water_level`, `time`
		 String columns[] = {"ID","temperature","Air_humidity","Soil_humidity", "Water_level","time"};
	      String data[][] = new String[1000][6];
	    
	      int i = 0;
	      while (res.next()) {
	        String ID = res.getString("ID");
	        String temperature = res.getString("temperature");	 
	        String Air_humidity = res.getString("Air_humidity");	
	        String Soil_humidity = res.getString("Soil_humidity");
	        String Water_level = res.getString("Water_level");	 
	        String time= res.getString("time");	
	        data[i][0] = ID;	        
	        data[i][1] = temperature;
	        data[i][2] = Air_humidity;
	        data[i][3] = Soil_humidity;	        
	        data[i][4] = Water_level;
	        data[i][5] = time ;
	   
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
	     // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setVisible(true);
	    
	    
	  }

catch (Exception e) {
			e.printStackTrace();
			
		}

	}
	

	
	
	
}
		          

