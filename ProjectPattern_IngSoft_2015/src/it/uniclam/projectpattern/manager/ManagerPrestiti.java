package it.uniclam.projectpattern.manager;

import java.util.Date;

import it.uniclam.projectpattern.dao.DAOSettings;
import it.uniclam.projectpattern.dao.PrestitoDAOImpl;
import it.uniclam.projectpattern.entity.Amico;
import it.uniclam.projectpattern.entity.Prestito;
import it.uniclam.projectpattern.entity.Prodotto;

/**
 * @author mario
 *
 */
public class ManagerPrestiti {
	private static final long MILLIS_FOR_DAY = 1000 * 60 * 60 * 24;
	private static final long SCADENZA_DEFAULT = 30;
	/**
	 * 
	 * @param amico L'amico a cui ho prestato il prodotto (null non accettato)
	 * @param prodotto Il prodotto dato in prestito (null non accettato)
	 * @param dataScadenza Formato gg/mm/aaaa, null consentito (equivale ad una scadenza standard)
	 * @param dataPrestito Formato gg/mm/aaaa, null consentito (equivale a oggi)
	 * @param note Note legate al prestito (null consentito)
	 * @return
	 */
	public Prestito creaPrestito(Amico amico, 
			Prodotto prodotto, String dataScadenza, 
			String dataPrestito, String note)  {
		
		
		// dataScadenza > oggi
		Date oggi = new Date();
		
		Date dataScadenza_temp = null;
		Date dataPrestito_temp = null;
		
		if (dataPrestito == null){
			dataPrestito_temp = new Date();
		} else {
			dataPrestito_temp = new Date(dataPrestito);
		}
		
		if (dataScadenza == null){
			dataScadenza_temp = new Date(oggi.getTime() + SCADENZA_DEFAULT * MILLIS_FOR_DAY);
		} else {
			dataScadenza_temp = new Date(dataScadenza);
		}
		int diffInDays = (int)( (dataScadenza_temp.getTime() - oggi.getTime()) / MILLIS_FOR_DAY );

		
		if (diffInDays <= 0){
			//TODO: generare eccezione
			return null;
		}
		
		// controllo null su Amico e Prodotto
		if (amico == null || prodotto == null){
			//TODO: generare eccezione
			return null;
		}
		Prestito prestito = new Prestito(
				dataPrestito_temp, 
				dataScadenza_temp,
				null,
				note, amico, prodotto);
		
		// Salvataggio su database
		PrestitoDAOImpl.getInstance().insertPrestito(prestito);
		
		return prestito;
	}
}
