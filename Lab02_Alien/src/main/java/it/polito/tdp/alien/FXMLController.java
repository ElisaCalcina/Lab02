package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary alienDictionary= new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtTraduzione;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	this.txtTraduzione.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	//leggo input utente
    	String s=txtTesto.getText().toLowerCase();
    		if(s==null || s.length()==0) {
    			txtTraduzione.appendText("Devi inserire una o due parole! \n");
    		}
    	
    	//estraggo una parola
    	StringTokenizer st = new StringTokenizer(s, " ");
    	
    	String alienWord= st.nextToken();
    	
    	//se c'è più di una parola devo inserire parola aliena e traduzione nel dizionario
    	if(st.hasMoreTokens()) {
    		//estraggo la seconda parola
    		
    		String translation= st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtTraduzione.appendText("Devi inserire solo caratteri\n");
    			return;
    		}
    		
    		alienDictionary.addWord(alienWord, translation);
    		
    		txtTraduzione.appendText("La parola aliena è "+ alienWord + " e la sua traduzione è "+ translation +" ed è stata inserita nel vocabolario\n");
    	}
    	
    	//altrimenti, devo cercare la traduzione nel dizionario
    	else {
    		if(!alienWord.matches("[a-zA-Z]*")) {
    			txtTraduzione.appendText("Devi inserire solo caratteri\n");
    			return;
    		}
    		
    		String translation= alienDictionary.translateWord(alienWord);
    		
    		if(translation!=null) {
    			txtTraduzione.appendText("La traduzione della parola aliena è: "+ translation +"\n");
    		} else {
    			txtTraduzione.appendText("La traduzione della parola aliena non esiste nel dizionario\n");
    		}
    	}
    		
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduzione != null : "fx:id=\"txtTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
