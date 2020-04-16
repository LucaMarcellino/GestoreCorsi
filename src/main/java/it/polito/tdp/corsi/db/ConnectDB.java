package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	private static String jdbcURL="jdbc:mysql://localhost/iscritticorsi";
	private static HikariDataSource ds;
	
	public static Connection getConnection() {
		if(ds==null) {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(jdbcURL);
			config.setUsername("root");
			config.setPassword("Giovanni96");
			
			config.addDataSourceProperty("cachePrepStmts", true);
			config.addDataSourceProperty("prepStmtChacheSize", 250);
			config.addDataSourceProperty("prepStmtChacheSqlLimit", "2048");
			
			ds = new HikariDataSource(config); 
		}
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("errore nel database");
			throw new RuntimeException(e);
		}
	}
}
