package pizzaInnodbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 

public class Pizza_connect_end {
	
	static ArrayList<Pizza> pizzaListe = new ArrayList<Pizza>();	
	static Pizza pizza_tempo;
	public static void main(String[] args) {
		 
		System.out.println("********recup�ration des datas de la base mysql***");
		System.out.println( "/*********recup�ration des datas de la base mysql**/");
		//recup�ration des datas de la base mysql
		System.out.println("connection a mysql pizzaboxinnodb");
			
		String url = "jdbc:mysql://localhost:3309/pizzaboxinnodb";
		
		String login = "root";
		String passwd = "toto";
		
		Connection cn =null; 
		
		Statement st =null;
		ResultSet rs =null;
		
		try {
			// Etape 1 : Chargement du driver
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM pizza"   ;

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------recup data from mysql------------------------");
				System.out.println(rs.getString("DESIGNPIZZ"));
				System.out.println(rs.getFloat("TARIFPIZZ"));
				System.out.println(rs.getInt("NROPIZZ"));
				System.out.println(rs.getString("image1_chemin"));
				
				//	public Pizza(String nomPizza, double prixPizza, Integer numeroPizza, String cheminImage) {
			    pizza_tempo = new Pizza(rs.getString("DESIGNPIZZ"),rs.getFloat("TARIFPIZZ"),rs.getInt("NROPIZZ"),rs.getString("image1_chemin") );		
			    System.out.println(pizza_tempo);
			    pizzaListe.add(pizza_tempo);
			}
			 
			
		} catch (ClassNotFoundException e) {//si il y un probleme de driver
		 
			e.printStackTrace();
			
			
		} catch (SQLException e) {//si il y un probleme de sql
	 
			e.printStackTrace();
		}
		
	  /**********************************verification **************************************/
		 System.out.println( "/******************pizza tempo**************************************/");
		 System.out.println(pizza_tempo);
		 System.out.println( "/******************verification **************************************/");	
		for(Pizza unepizza : pizzaListe)  System.out.println(unepizza);
		
		
	}//fin du main 

}//fin de la classe
