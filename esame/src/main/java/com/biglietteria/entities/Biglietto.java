package com.biglietteria.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "biglietti")
public class Biglietto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_operazione")
	private int codOperazione;
	
	@Column(name = "cod_cliente")
	private int codCliente;
	
	@Column(name = "cod_replica")
	private String codReplica;
	
	@Column(name = "data_ora")
	private Date dataOra;
	
	@Column(name = "tipo_pagamento")
	private String tipoPagamento;
	
	@Column(name = "quantita")
	private int quantita;

	public Biglietto() {}

	public Biglietto(int codOperazione, int codCliente, String codReplica, Date dataOra, String tipoPagamento,
			int quantita) {
		this.codOperazione = codOperazione;
		this.codCliente = codCliente;
		this.codReplica = codReplica;
		this.dataOra = dataOra;
		this.tipoPagamento = tipoPagamento;
		this.quantita = quantita;
	}

	public int getCodOperazione() {
		return codOperazione;
	}

	public void setCodOperazione(int codOperazione) {
		this.codOperazione = codOperazione;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getCodReplica() {
		return codReplica;
	}

	public void setCodReplica(String codReplica) {
		this.codReplica = codReplica;
	}

	public Date getDataOra() {
		return dataOra;
	}

	public void setDataOra(Date dataOra) {
		this.dataOra = dataOra;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
