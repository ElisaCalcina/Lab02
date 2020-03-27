package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String>translations;
	
	public WordEnhanced(String alienWord) {
		translations= new ArrayList<String>();
		this.alienWord=alienWord;
	}
	
	public WordEnhanced(String alienWord, String translation) {
		super();
		this.translations= new ArrayList<String>();
		this.alienWord = alienWord;
		translations.add(translation);
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public String getTranslation() {
		String result="";
		for(String s: translations) {
			result+=s+"\n";
		}
		return result;
	}


	public void setTranslation(String translation) {
		if(!translations.contains(translation)) {
			translations.add(translation);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	

}
