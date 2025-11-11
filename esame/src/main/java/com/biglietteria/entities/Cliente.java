package com.biglietteria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clienti")
public class Cliente {
	
	@Id
	@Column(name = "cod_cliente")
	private Integer codCliente;
	//int: valore di default 0 (JPA crede che sia un valore dell'id e quindi già inserito)
	//integer: valore di default null
	
	@Column(name = "cognome")
	private String cognome;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	public Cliente() {}

	public Cliente(Integer codCliente, String cognome, String nome, String telefono, String email) {
		this.codCliente = codCliente;
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
