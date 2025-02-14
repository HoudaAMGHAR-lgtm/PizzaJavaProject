package pizzaInnodbConnect;
import pizzaInnodbConnect.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 

public class Client_connect {
	
	static ArrayList<Client> clientListe = new ArrayList<Client>();	
	static Client client_tempo;
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

			String sql = "SELECT * FROM client"   ;

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------recup data from mysql------------------------");
				
				System.out.println(rs.getInt("NROCLIE"));
				System.out.println(rs.getString("NOMCLIE"));
				System.out.println(rs.getString("PRENOMCLIE"));
				System.out.println(rs.getString("ADRESSECLIE"));
				System.out.println(rs.getString("VILLECLIE"));
				System.out.println(rs.getString("CODEPOSTALCLIE"));
				System.out.println(rs.getString("TITRECLIE"));
				System.out.println(rs.getString("NROTELCLIE"));
				
				//	public Pizza(String nomPizza, double prixPizza, Integer numeroPizza, String cheminImage) {
			    client_tempo = new Client(rs.getInt("NROCLIE"),rs.getString("NOMCLIE"),rs.getString("PRENOMCLIE"),rs.getString("ADRESSECLIE"),rs.getString("VILLECLIE"), rs.getString("CODEPOSTALCLIE"), rs.getString("TITRECLIE"), rs.getString("NROTELCLIE") );		
			    System.out.println(client_tempo);
			    clientListe.add(client_tempo);
			}
			 
			
		} catch (ClassNotFoundException e) {//si il y un probleme de driver
		 
			e.printStackTrace();
			
			
		} catch (SQLException e) {//si il y un probleme de sql
	 
			e.printStackTrace();
		}
		
	  /**********************************verification **************************************/
		 System.out.println( "/******************pizza tempo**************************************/");
		 System.out.println(client_tempo);
		 System.out.println( "/******************verification **************************************/");	
		for(Client unclient : clientListe)  System.out.println(unclient);
		
		
	}//fin du main 

}//fin de la classe