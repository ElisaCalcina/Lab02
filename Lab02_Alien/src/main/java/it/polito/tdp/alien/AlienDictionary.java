package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<WordEnhanced> dizionario;

	public AlienDictionary() {
		this.dizionario= new ArrayList<WordEnhanced>();
	}
	
	
	public void addWord(String alienWord, String translation) {
		WordEnhanced w= new WordEnhanced(alienWord, translation);
		
		if(dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(translation);
			return;
		}
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		WordEnhanced w= new WordEnhanced(alienWord);

		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		else {
			return null;
		}
	}
	
	

}
