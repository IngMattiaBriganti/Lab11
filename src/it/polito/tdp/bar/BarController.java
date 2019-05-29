package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import it.polito.tdp.bar.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnSimula;

	private Model model;

    @FXML
    void doSimula(ActionEvent event) {
    	Statistiche s=model.simula();
    	this.txtResult.appendText("risultati simulazione:\n totale clienti: "+s.getNumTotaleClienti()+"\n totale soddisfatti: "+s.getNumClientiSoddisfatti()+
    			"\n totale insoddisfatti: "+s.getNumClientiinsoddisfatti()+"\n fine\n");
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;		
	}
}
