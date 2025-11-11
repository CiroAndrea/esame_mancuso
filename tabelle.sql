create database if not exists `biglietteria`;
use `biglietteria`;



create table if not exists `clienti`(
	`cod_cliente` int not null primary key auto_increment,
    `cognome` varchar(20),
    `nome` varchar(20),
    `telefono` varchar(14),
    `email` varchar(30)
);

create table if not exists `teatri`(
	`cod_teatro` varchar(4) not null primary key,
    `nome` varchar(30),
    `indirizzo` varchar(30),
    `citta` varchar(25),
    `provincia` varchar(2),
    `telefono` varchar(14),
    `posti` int not null
);

create table if not exists `spettacoli`(
	`cod_spettacolo` varchar(4) not null primary key,
	`titolo` varchar(40),
	`autore` varchar(25),
	`regista` varchar(25),
	`prezzo` decimal(4,2),
	`cod_teatro` varchar(4),
		constraint `fk_spettacoli_teatri`
        foreign key(`cod_teatro`)
        references `teatri`(`cod_teatro`)
        on delete cascade
        on update cascade
);

create table if not exists `repliche`(
	`cod_replica` varchar(4) not null primary key,
	`cod_spettacolo` varchar(4) not null,
	`data_replica` date,
    constraint `fk_repliche_spettacoli`
        foreign key(`cod_spettacolo`)
        references `spettacoli`(`cod_spettacolo`)
        on delete cascade
        on update cascade
);

create table if not exists `biglietti`(
	`cod_operazione` varchar(4) not null primary key,
	`cod_cliente` int auto_increment,
	`cod_replica` varchar(4),
	`data_ora` date,
	`tipo_pagamento` varchar(20),
	`quantita` int,
    constraint `fk_biglietti_clienti`
        foreign key(`cod_cliente`)
        references `clienti`(`cod_cliente`)
        on delete cascade
        on update cascade,
	constraint `fk_biglietti_repliche`
        foreign key(`cod_replica`)
        references `repliche`(`cod_replica`)
        on delete cascade
        on update cascade
);