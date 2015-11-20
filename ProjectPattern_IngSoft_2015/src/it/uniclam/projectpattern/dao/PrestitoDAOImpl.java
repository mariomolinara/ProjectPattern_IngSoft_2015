package it.uniclam.projectpattern.dao;

import it.uniclam.projectpattern.entity.Prestito;

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
