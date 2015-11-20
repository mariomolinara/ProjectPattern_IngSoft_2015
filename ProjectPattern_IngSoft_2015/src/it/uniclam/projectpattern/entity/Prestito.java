package it.uniclam.projectpattern.entity;

import java.util.Date;

public class Prestito {

	private static int PUNTEGGIO_INIZIALE = 20;
	public static int SOGLIA_AMICO_CATTIVO = 0;
	
	private Date dataPrestito;
	private Date dataScadenza;
	private Date dataRestituzione;
	private String note;
	private int punteggio;
	private Amico affidatario;
	private Prodotto prodottoPrestato;
	
	
	
	
	public Prestito(Date dataPrestito, 
			Date dataScadenza, 
			Date dataRestituzione, 
			String note, 
			Amico affidatario,
			Prodotto prodottoPrestato) {
		super();
		this.dataPrestito = dataPrestito;
		this.dataScadenza = dataScadenza;
		this.dataRestituzione = dataRestituzione;
		this.note = note;
		this.affidatario = affidatario;
		this.prodottoPrestato = prodottoPrestato;
		this.punteggio = PUNTEGGIO_INIZIALE;
	}
	
	
	
	public Date getDataRestituzione() {
		return dataRestituzione;
	}
	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Amico getAffidatario() {
		return affidatario;
	}
	public void setAffidatario(Amico affidatario) {
		this.affidatario = affidatario;
	}
	public Prodotto getProdottoPrestato() {
		return prodottoPrestato;
	}
	public void setProdottoPrestato(Prodotto prodottoPrestato) {
		this.prodottoPrestato = prodottoPrestato;
	}
	public Date getDataPrestito() {
		return dataPrestito;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public int getPunteggio() {
		return punteggio;
	}
	
	
	
	
	
	
}
