package piscine;

import ressource.LibererRessource;
import ressource.PrendreRessource;
import ressource.RessourceUser;
import action.Scenario;
import action.Waiting;

public class Nageur extends Scenario{
	
	private RessourceUser<Panier> userPanier = new RessourceUser<Panier>();
	private RessourceUser<Cabine> userCabine = new RessourceUser<Cabine>();
	
	public Nageur( String nom, GestionnaireDePaniers gestionnaireDePaniers,GestionnaireDeCabines gestionnaireDeCabines, int undressingTime, int swimmingTime, int dressingTime){
		this.setMessage(nom);
		this.add(new PrendreRessource<Panier>(" - prend Panier\n", gestionnaireDePaniers, userPanier));
		this.add(new PrendreRessource<Cabine>(" - prend Cabine\n", gestionnaireDeCabines, userCabine));
		this.add(new Waiting(" - se deshabille", undressingTime));
		this.add(new LibererRessource<Cabine>(" - rend Cabine\n", gestionnaireDeCabines, userCabine));
		this.add(new Waiting(" - nage", swimmingTime));
		this.add(new PrendreRessource<Cabine>(" - prend Cabine\n", gestionnaireDeCabines, userCabine));
		this.add(new Waiting(" - se rhabille", dressingTime));
		this.add(new LibererRessource<Cabine>(" - rend Cabine\n", gestionnaireDeCabines, userCabine));
		this.add(new LibererRessource<Panier>(" - rend Panier\n", gestionnaireDePaniers, userPanier));
	}

}
