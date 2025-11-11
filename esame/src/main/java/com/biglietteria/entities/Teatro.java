package com.biglietteria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teatri")
public class Teatro {
	
	@Id
	@Column(name = "cod_teatro")
	private String codTeatro;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Column(name = "citta")
	private String citta;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "posti")
	private int posti;

	public Teatro() {}

	public Teatro(String codTeatro, String nome, String indirizzo, String citta, String provincia, String telefono,
			int posti) {
		this.codTeatro = codTeatro;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.posti = posti;
	}

	public String getNome() {
		return nome;
	}

	public String getCodTeatro() {
		return codTeatro;
	}

	public void setCodTeatro(String codTeatro) {
		this.codTeatro = codTeatro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}
	
}
