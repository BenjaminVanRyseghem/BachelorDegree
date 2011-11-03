package piscine;

import ressource.Ressource;


public class Cabine implements Ressource {


	String description = "";
	
	@Override
	public String description() {
		return description;
	}

	public Cabine(String description){
		this.description = description;
	}

		
		/**
		 */
		public Cabine(){
		}

}
