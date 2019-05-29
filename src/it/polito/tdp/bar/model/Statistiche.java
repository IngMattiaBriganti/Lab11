package it.polito.tdp.bar.model;

public class Statistiche {
	private int numTotaleClienti;
	private int numClientiSoddisfatti;
	private int numClientiinsoddisfatti;
	public Statistiche(int numTotaleClienti, int numClientiSoddisfatti, int numClientiinsoddisfatti) {
		super();
		this.numTotaleClienti = numTotaleClienti;
		this.numClientiSoddisfatti = numClientiSoddisfatti;
		this.numClientiinsoddisfatti = numClientiinsoddisfatti;
	}
	public int getNumTotaleClienti() {
		return numTotaleClienti;
	}
	public void setNumTotaleClienti(int numTotaleClienti) {
		this.numTotaleClienti = numTotaleClienti;
	}
	public int getNumClientiSoddisfatti() {
		return numClientiSoddisfatti;
	}
	public void setNumClientiSoddisfatti(int numClientiSoddisfatti) {
		this.numClientiSoddisfatti = numClientiSoddisfatti;
	}
	public int getNumClientiinsoddisfatti() {
		return numClientiinsoddisfatti;
	}
	public void setNumClientiinsoddisfatti(int numClientiinsoddisfatti) {
		this.numClientiinsoddisfatti = numClientiinsoddisfatti;
	}
	
}
