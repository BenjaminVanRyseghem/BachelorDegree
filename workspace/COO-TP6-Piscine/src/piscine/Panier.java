package piscine;

import ressource.Ressource;



public class Panier implements Ressource {

	
	String description = "";
	
	@Override
	public String description() {
		return description;
	}

	public Panier(String description){
		this.description = description;
	}

		
		/**
		 */
		public Panier(){
		}

}
