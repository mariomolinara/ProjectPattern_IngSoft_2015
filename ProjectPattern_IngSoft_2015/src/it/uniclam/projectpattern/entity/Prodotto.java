package it.uniclam.projectpattern.entity;

import java.net.URL;

public abstract class Prodotto {
	private String descrizione;
	private URL urlFoto;
	public String titolo;
	public String annoPubblicazione;
	public String genere;
	public String casa;
	public String[] autori;
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	public void setAnnoPubblicazione(String annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getCasa() {
		return casa;
	}
	public void setCasa(String casa) {
		this.casa = casa;
	}
	public String[] getAutori() {
		return autori;
	}
	public void setAutori(String[] autori) {
		this.autori = autori;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public URL getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(URL urlFoto) {
		this.urlFoto = urlFoto;
	}
	
}
