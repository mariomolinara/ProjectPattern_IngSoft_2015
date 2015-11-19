package it.uniclam.esercizio20102015.dao;

import java.util.List;

import it.uniclam.esercizio20102015.entity.Amico;

public interface AmicoDAO {

	public List<Amico> getAllAmici() throws DAOException;
	public Amico getAmico(String email) throws DAOException;
	public List<Amico> getAmici(Amico a) throws DAOException;
	public void updateAmico(Amico a) throws DAOException;
	public void insertAmico(Amico a) throws DAOException;
	public void deleteAmico(Amico a) throws DAOException;
}
