package piscine;

import java.util.ArrayList;
import java.util.Collection;

import ressource.GestionnaireRessources;


public class GestionnaireDePaniers extends GestionnaireRessources<Panier> {
	
	public GestionnaireDePaniers(Collection<Panier> ressources) {
		super(ressources);
	}
	
	public GestionnaireDePaniers(int size){
		Collection<Panier> list = new ArrayList<Panier>();
		for (int i = 0; i < size ; i++){
			list.add(new Panier());
		}
		this.setRessources(list);
	}

}
