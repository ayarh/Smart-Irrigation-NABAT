package structure;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
interface  agricultural_product {
	  void affiche();
	 void Updateproducts(Connection con);
	 
}

public class Product implements   agricultural_product  {

	private String type_plante ;
	private String type_sol ;
	private int humiditymax ;
	private int humiditymin ;
	public Product() {
		super();
		this.type_plante = " ";
		this.type_sol =" ";
		this.humiditymax = 5;
		this.humiditymin = 6;
	}
	public Product(String type_plante, String type_sol, int humiditymax, int humiditymin) {
		super();
		this.type_plante = type_plante;
		this.type_sol = type_sol;
		this.humiditymax = humiditymax;
		this.humiditymin = humiditymin;
	}
	public String getType_plante() {
		return type_plante;
	}
	public void setType_plante(String type_plante) {
		this.type_plante = type_plante;
	}
	public String getType_sol() {
		return type_sol;
	}
	public void setType_sol(String type_sol) {
		this.type_sol = type_sol;
	}
	public int getHumiditymax() {
		return humiditymax;
	}
	public void setHumiditymax(int humiditymax) {
		this.humiditymax = humiditymax;
	}
	public int getHumiditymin() {
		return humiditymin;
	}
	public void setHumiditymin(int humiditymin) {
		this.humiditymin = humiditymin;
	} 
	public void Updateproducts(Connection con) {
		try {        		      		     
		String sql="SELECT * FROM `product` ";
		Statement smt = con.createStatement();
		ResultSet res=smt.executeQuery(sql);
		//`temperature`, `Air_humidity`, `Soil_humidity`, `Water_level`, `time`
		 String columns[] = {"type_plante", "type_sol", "humiditymax", "humiditymin"};
	      String data[][] = new String[1000][6];
	    
	      int i = 0;
	      while (res.next()) {
	  
	        String type_plante = res.getString("type_plante");	 
	        String type_sol = res.getString("type_sol");	
	       String humiditymax = res.getString("humiditymax");
	       String humiditymin = res.getString("humiditymin");
	        data[i][0] = type_plante;	        
	        data[i][1] = type_sol;
	        data[i][2] = humiditymax;
	        data[i][3] = humiditymin;	        
	      
	   
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
	@Override
	public String toString() {
		return "Product [type_plante=" + type_plante + ", type_sol=" + type_sol + ", humiditymax=" + humiditymax
				+ ", humiditymin=" + humiditymin + "]";
	}
	
	public void affiche() {
		System.out.println(toString());
		
		
	}
	
	

}
class tomate extends Product{
	private String nom_produit_agricol;
	public tomate(String type_plante, String type_sol, int humiditymax, int humiditymin )
	{
		super(type_plante,  type_sol,  humiditymax,  humiditymin);
		
		
	}
	public void afficherTomate()
	{
		super.affiche();
		System.out.println(nom_produit_agricol);
		
		
	}
}
class avocat extends Product{
	private String nom_produit_agricol;
	public avocat(String type_plante, String type_sol, int humiditymax, int humiditymin )
	{
		super(type_plante,  type_sol,  humiditymax,  humiditymin);
		
		
	}
	public void afficherAvocat()
	{
		super.affiche();
		System.out.println(nom_produit_agricol);
		
		
	}
}
