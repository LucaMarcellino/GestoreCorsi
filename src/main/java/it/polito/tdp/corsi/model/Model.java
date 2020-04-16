package it.polito.tdp.corsi.model;

import java.util.*;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {


	public List<Corso> getCorsiByPeriodo(int pd) {
		CorsoDAO dao=new CorsoDAO();
		return dao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodoModel(int pd){
		CorsoDAO dao=new CorsoDAO();
		return dao.getIscrittiByCorso(pd);
		
	}

}
