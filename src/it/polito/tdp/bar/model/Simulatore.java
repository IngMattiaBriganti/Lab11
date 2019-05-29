package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import it.polito.tdp.bar.model.Evento.TipoEvento;

public class Simulatore {
	
	//coda eventi
	private PriorityQueue<Evento> queue;

	//Modello del mondo
	private List<Tavolo> tavoli;
	//parametri simulazione
	
	//statistiche da calcolare
	private int numTotaleClienti;
	private int numClientiSoddisfatti;
	private int numClientiinsoddisfatti;
	Random rand= new Random();
	
	public Simulatore() {
		
	}
	
	public void init() {
		queue=new PriorityQueue<>();
		tavoli=new LinkedList<Tavolo>();
		//variaible per schedulare arrivi
		LocalDateTime tempoPrima=LocalDateTime.now();
		
		//resetto statistiche
		numTotaleClienti=0;
		numClientiSoddisfatti=0;
		numClientiinsoddisfatti=0;
		
		for(int i=0;i<2000;i++) {
			LocalDateTime time = tempoPrima.plusMinutes(rand.nextInt(10)+1);
			Integer num_persone=rand.nextInt(10)+1;
			Duration durata=Duration.ofMinutes(rand.nextInt(60)+60);
			float tolleranza=rand.nextFloat();
			this.queue.add(new Evento(TipoEvento.ARRIVO_GRUPPO_CLIENTI, LocalDateTime.now(), num_persone, durata, tolleranza));
			tempoPrima=time;
		}
		
		//creo i tavoli
		tavoli.add(new Tavolo(1,10,false));
		tavoli.add(new Tavolo(2,10,false));

		tavoli.add(new Tavolo(3,8,false));
		tavoli.add(new Tavolo(4,8,false));
		tavoli.add(new Tavolo(5,8,false));
		tavoli.add(new Tavolo(6,8,false));

		tavoli.add(new Tavolo(7,6,false));
		tavoli.add(new Tavolo(8,6,false));
		tavoli.add(new Tavolo(9,6,false));
		tavoli.add(new Tavolo(10,6,false));

		tavoli.add(new Tavolo(11,4,false));
		tavoli.add(new Tavolo(12,4,false));
		tavoli.add(new Tavolo(13,4,false));
		tavoli.add(new Tavolo(14,4,false));
		tavoli.add(new Tavolo(15,4,false));

		
		
	}
	public Statistiche run() {
		while(!queue.isEmpty()) {
			Evento ev=queue.poll();
			
			switch (ev.getTipo()) {
			case ARRIVO_GRUPPO_CLIENTI:
				this.numTotaleClienti+=ev.getNum_persone();
				Tavolo min=null;
				Collections.sort(tavoli);
				for(Tavolo t:this.tavoli) {
					if(!t.isOccupato()) {
						if(t.getPosti()>ev.getNum_persone() && ev.getNum_persone()>0.5*t.getPosti()) {
							//lo salvo
							min=t;
						} 
					}
				}
				if(min!=null) { //ho trovato un tavolo
					
					this.queue.add(new Evento(TipoEvento.PARTENZA_GRUPPO_CLIENTI, ev.getTime().plusMinutes(ev.getDurata().toMinutes()), ev.getNum_persone(), ev.getDurata(), ev.getTolleranza(),min));
					min.setOccupato(true);
					this.numClientiSoddisfatti+=ev.getNum_persone();
			
				} else { //non ho trovato un tavolo
					
					if(rand.nextDouble()<ev.getTolleranza()) {//se ne vanno per intolleranza
						
								this.numClientiinsoddisfatti+=ev.getNum_persone();
								
							}else { //bancone
								
								this.numClientiSoddisfatti+=ev.getNum_persone();
							}
						}
					
				
				
				break;
			case PARTENZA_GRUPPO_CLIENTI:
				ev.getTavolo().setOccupato(false);
				break;

				
			}
		
							
		}
		return new Statistiche(this.numTotaleClienti,this.numClientiSoddisfatti,this.numClientiinsoddisfatti);
		
	}
	
	
}
