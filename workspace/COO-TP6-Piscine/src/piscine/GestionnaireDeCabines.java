package piscine;

import java.util.ArrayList;
import java.util.Collection;

import ressource.GestionnaireRessources;


public class GestionnaireDeCabines extends GestionnaireRessources<Cabine> {
	
	public GestionnaireDeCabines(Collection<Cabine> ressources) {
		super(ressources);
	}
	
	public GestionnaireDeCabines(int size){
		Collection<Cabine> list = new ArrayList<Cabine>();
		for (int i = 0; i < size ; i++){
			list.add(new Cabine());
		}
		this.setRessources(list);
	}

}
