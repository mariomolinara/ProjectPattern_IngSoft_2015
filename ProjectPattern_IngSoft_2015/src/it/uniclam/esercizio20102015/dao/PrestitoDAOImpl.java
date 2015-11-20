package it.uniclam.esercizio20102015.dao;

import it.uniclam.esercizio20102015.entity.Prestito;

public class PrestitoDAOImpl implements PrestitoDAO {

	private static PrestitoDAOImpl instance;
	
	private PrestitoDAOImpl(){}
	
	public static PrestitoDAOImpl getInstance(){
		if (instance == null){
			instance = new PrestitoDAOImpl();
		}
		return instance;
	}
	
	@Override
	public void insertPrestito(Prestito p) {
		// TODO Auto-generated method stub
		
	}

}
