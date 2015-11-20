package it.uniclam.esercizio20102015;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniclam.esercizio20102015.dao.AmicoDAOImpl;
import it.uniclam.esercizio20102015.dao.DAOException;
import it.uniclam.esercizio20102015.dao.DAOSettings;
import it.uniclam.esercizio20102015.entity.Amico;




public class ServerMain {
	
	// "req_..." sono le richieste
	// "res_..." sono le risposte
	
	
	public static String OK = "Ok";

	public static String QUERY_AMICI = "req_query_amici";
	public static String INSERT_AMICI = "req_insert_amici";
	public static String DELETE_AMICI = "req_delete_amici";
	// TODO: altre voci per il protocollo

	public static String QUERY_PRODOTTI = "req_query_prodotti";
	// TODO: altre voci per il protocollo
	
	public static String QUERY_PRESTITI = "req_query_prestiti";
	// TODO: altre voci per il protocollo
	
	public static String LIST_AMICI = "res_list_amici";
	public static String LIST_PRODOTTI = "res_list_prodotti";
	// TODO: altre voci per il protocollo
	
	
	public static String 	HOST = "localhost";
	public static int 		PORT = 5555;

	
	public static void main(String[] args) throws Exception {
		
		//Class.forName("com.mysql.jdbc.Driver");
		ServerSocket ss = new ServerSocket(PORT);
		String response = null;
		while(true){
			response = "Error\n\n";
			System.out.println("Server in ascolto sulla porta 5555");
			Socket s = ss.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			
			String command = in.readLine();
			
			if (command.equals(QUERY_AMICI)){
				
				
				String cognome = in.readLine().replace("cognome:", "").replace("\n", "");
				String nome = in.readLine().replace("nome:", "").replace("\n", "");
				String telefono = in.readLine().replace("telefono:", "").replace("\n", "");
				String email = in.readLine().replace("email:", "").replace("\n", "");
	
				try{
	
					//List<Amico> lista = AmicoDAOImpl.getInstance().getAllAmici();
	
					Amico chiaveRicerca = new Amico(nome, cognome, telefono, email);
					List<Amico> lista = AmicoDAOImpl.getInstance().getAmici(chiaveRicerca);
					
					response = "Ok\n";
					
					for(Amico item: lista){
						response += item.getCognome() + ", ";
						response += item.getNome() + ", ";
						response += item.getTelefono() + ", ";
						response += item.getEmail() + "\n";
					}
	
					response += "\n";
					
					out.println(response);
					
					
				} catch (DAOException daoe){
					System.out.println("Exception in connection");
					out.println(response);
				}
				//String response = "OK\nc1, n1, t1\nc2, n2, t2\n\n";
				
				
				
				
				
				s.close();
			} else if (command.equals(INSERT_AMICI)){
				// TODO: Inserimento in database
			} else {
				// TODO: messaggio di protocollo non valido
			}
		}
		

	}

}
