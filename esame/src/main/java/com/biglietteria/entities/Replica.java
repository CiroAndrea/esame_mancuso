package com.biglietteria.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "repliche")
public class Replica {
	
	@Id
	@Column(name = "cod_replica")
	private String codReplica;
	
	@Column(name = "cod_spettacolo")
	private String codSpettacolo;
	
	@Column(name = "data_replica")
	private Date dataReplica;

	public Replica() {}

	public Replica(String codReplica, String codSpettacolo, Date dataReplica) {
		this.codReplica = codReplica;
		this.codSpettacolo = codSpettacolo;
		this.dataReplica = dataReplica;
	}

	public String getCodReplica() {
		return codReplica;
	}

	public void setCodReplica(String codReplica) {
		this.codReplica = codReplica;
	}

	public String getCodSpettacolo() {
		return codSpettacolo;
	}

	public void setCodSpettacolo(String codSpettacolo) {
		this.codSpettacolo = codSpettacolo;
	}

	public Date getDataReplica() {
		return dataReplica;
	}

	public void setDataReplica(Date dataReplica) {
		this.dataReplica = dataReplica;
	}

}
