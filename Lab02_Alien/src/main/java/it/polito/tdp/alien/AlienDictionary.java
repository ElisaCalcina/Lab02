package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	List<Word> dizionario;

	public AlienDictionary() {
		this.dizionario= new ArrayList<Word>();
	}
	
	
	public void addWord(String alienWord, String translation) {
		Word w= new Word(alienWord, translation);
		
		if(dizionario.contains(w)) {
			dizionario.get(dizionario.indexOf(w)).setTranslation(translation);
			return;
		}
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord) {
		Word w= new Word(alienWord);

		if(dizionario.contains(w)) {
			return dizionario.get(dizionario.indexOf(w)).getTranslation();
		}
		else {
			return null;
		}
	}
	
	

}
