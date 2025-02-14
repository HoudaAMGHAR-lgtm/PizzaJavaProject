package pizzaInnodbConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 

public class Livreur_connect {
	
	static ArrayList<Livreur> livreurListe = new ArrayList<Livreur>();	
	static Livreur livreur_tempo;
	public static void main(String[] args) {
		 
		System.out.println("********recup�ration des datas de la base mysql***");
		System.out.println( "/*********recup�ration des datas de la base mysql**/");
		
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

			String sql = "SELECT * FROM livreur"   ;

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------recup data from mysql------------------------");
				
				System.out.println(rs.getInt("NROLIVR"));
				System.out.println(rs.getString("NOMLIVR"));
				System.out.println(rs.getString("PRENOMLIVR"));
				System.out.println(rs.getDate("DATEEMBAUCHLIVR"));
				
				
				//	public Pizza(String nomPizza, double prixPizza, Integer numeroPizza, String cheminImage) {
			    livreur_tempo = new Livreur(rs.getInt("NROLIVR"),rs.getString("NOMLIVR"),rs.getString("PRENOMLIVR"),rs.getDate("DATEEMBAUCHLIVR"));		
			    System.out.println(livreur_tempo);
			    livreurListe.add(livreur_tempo);
			}
			 
			
		} catch (ClassNotFoundException e) {//si il y un probleme de driver
		 
			e.printStackTrace();
			
			
		} catch (SQLException e) {//si il y un probleme de sql
	 
			e.printStackTrace();
		}
		
	  /**********************************verification **************************************/
		 System.out.println( "/******************pizza tempo**************************************/");
		 System.out.println(livreur_tempo);
		 System.out.println( "/******************verification **************************************/");	
		for(Livreur unlivreur : livreurListe)  System.out.println(unlivreur);
		
		
	}//fin du main 

}//fin de la classe