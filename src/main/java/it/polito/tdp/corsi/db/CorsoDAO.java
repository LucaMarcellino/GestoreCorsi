package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import it.polito.tdp.corsi.model.Corso;


public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo(int pd){
		
		String sql= "SELECT * FROM corso WHERE pd=?";
		List<Corso> result= new ArrayList<Corso>();
		try {
			Connection conn = ConnectDB.getConnection();
	
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, pd);
			ResultSet res=st.executeQuery();
			while(res.next()) {
				result.add(new Corso(res.getString("codins"),res.getInt("crediti"),res.getString("nome"),res.getInt("pd")));
			}

			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public Map<Corso,Integer> getIscrittiByCorso(int pd){
		
		String sql= "SELECT corso.codins,corso.crediti,corso.nome,corso.pd,COUNT(*) FROM corso,iscrizione "
				+ "WHERE corso.codins=iscrizione.codins and pd=? GROUP BY corso.nome,corso.pd,corso.crediti";
		Map<Corso,Integer> result =new HashMap<Corso,Integer>();
		try {
			Connection conn = ConnectDB.getConnection();
	
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, pd);
			ResultSet res=st.executeQuery();
			while(res.next()) {
				result.put(new Corso(res.getString("codins"),res.getInt("crediti"),res.getString("nome"),res.getInt("pd")),res.getInt("COUNT(*)"));
			}

			st.close();
			conn.close();
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	
	
	}

}
