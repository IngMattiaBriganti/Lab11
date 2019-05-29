package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Evento implements Comparable<Evento>{

	public enum TipoEvento{
		ARRIVO_GRUPPO_CLIENTI,
		PARTENZA_GRUPPO_CLIENTI,
	}
	private LocalDateTime time;
	private TipoEvento tipo ; // tipologia

	private Integer num_persone;
	private Duration durata;
	private float tolleranza;
	private Tavolo tavolo;
	
	//costruttore eventi di liberazione tavoli
	public Evento(TipoEvento tipo, LocalDateTime time, Integer num_persone, Duration durata, float tolleranza, Tavolo tavolo) {
		super();
		this.time = time;
		this.tipo=tipo;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tavolo = tavolo;
	}
	//cistruttore eventi arrivo persone
	public Evento(TipoEvento tipo, LocalDateTime time, Integer num_persone, Duration durata, float tolleranza) {
		super();
		this.time = time;
		this.num_persone = num_persone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tipo=tipo;

	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Integer getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(Integer num_persone) {
		this.num_persone = num_persone;
	}
	public Duration getDurata() {
		return durata;
	}
	public void setDurata(Duration durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return this.time.compareTo(o.time);
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	
	
}
