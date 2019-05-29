package it.polito.tdp.bar.model;

public class Model {
	Simulatore sim=new Simulatore();

	public Statistiche simula() {
		// TODO Auto-generated method stub
		sim.init();
		return sim.run();
	}

}
