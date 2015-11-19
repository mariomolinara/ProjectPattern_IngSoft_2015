package it.uniclam.esercizio20102015.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.uniclam.esercizio20102015.entity.Amico;

public class AmicoDAOImpl implements AmicoDAO {

	private AmicoDAOImpl(){}
	
	private static AmicoDAO dao = null;
	
	public static AmicoDAO getInstance(){
		if (dao == null){
			dao = new AmicoDAOImpl();
		}
		return dao;
	}
	
	@Override
	public List<Amico> getAllAmici() throws DAOException {
		//ArrayList<Amico> lista = new ArrayList<Amico>();
		Amico chiaveRicerca = new Amico("", "", "", ""); // Cerca tutti gli elementi
		return getAmici(chiaveRicerca);
	}
	
	@Override
	public List<Amico> getAmici(Amico a) throws DAOException {
		ArrayList<Amico> lista = new ArrayList<Amico>();
		try{
			
			if (a == null || a.getCognome() == null 
					|| a.getNome() == null
					|| a.getEmail() == null
					|| a.getTelefono() == null){
				throw new DAOException("In getAmici: any field can be null");
			}
			
			Statement st = DAOSettings.getStatement();
			
			String sql = "select * from amici where cognome like '";
			sql += a.getCognome() + "%' and nome like '" + a.getNome();
			sql += "%' and telefono like '" + a.getTelefono() + "%'";
			sql += " and email like '" + a.getEmail() + "%'";

			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				lista.add(new Amico(rs.getString("nome"), 
						rs.getString("cognome"), 
						rs.getString("telefono"),
						rs.getString("email")));
			}
			DAOSettings.closeStatement(st);
			
		} catch (SQLException sq){
			throw new DAOException("In getAllAmici(): " + sq.getMessage());
		}
		return lista;
	}
	

	@Override
	public Amico getAmico(String email) throws DAOException {
		throw new DAOException("Not yet implemented");
	}

	@Override
	public void updateAmico(Amico a) throws DAOException {
		throw new DAOException("Not yet implemented");
	}

	@Override
	public void insertAmico(Amico a) throws DAOException {
		throw new DAOException("Not yet implemented");
	}

	@Override
	public void deleteAmico(Amico a) throws DAOException {
		throw new DAOException("Not yet implemented");
	}

}
