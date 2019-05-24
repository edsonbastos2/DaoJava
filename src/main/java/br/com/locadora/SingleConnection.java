package br.com.locadora;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/locadora?useTimezone=true&serverTimezone=UTC";
	private static String password = "Admin";
	private static String user = "root";
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	
	public SingleConnection() {
		conectar();
	}
	
	public static void conectar() {
		
		try {
			
			if(connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectado com sucesso!");
			}
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
