package com.biglietteria.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spettacoli")
public class Spettacolo {
	
	@Id
	@Column(name = "cod_spettacolo")
	private String codSpettacolo;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "autore")
	private String autore;
	
	@Column(name = "regista")
	private String regista;
	
	@Column(name = "prezzo")
	private BigDecimal prezzo;
	
	@Column(name = "codTeatro")
	private String codTeatro;

	public Spettacolo() {}

	public Spettacolo(String codSpettacolo, String titolo, String autore, String regista, BigDecimal prezzo,
			String codTeatro) {
		this.codSpettacolo = codSpettacolo;
		this.titolo = titolo;
		this.autore = autore;
		this.regista = regista;
		this.prezzo = prezzo;
		this.codTeatro = codTeatro;
	}

	public String getCodSpettacolo() {
		return codSpettacolo;
	}

	public void setCodSpettacolo(String codSpettacolo) {
		this.codSpettacolo = codSpettacolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodTeatro() {
		return codTeatro;
	}

	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}

}
