package ressource;

import action.Action;


public class PrendreRessource<E extends Ressource> extends Action {

	private RessourceUser<E> user;
	private GestionnaireRessources<E> gestionnaire; 
	
	public PrendreRessource(String message, GestionnaireRessources<E> gestionnaire, RessourceUser<E> user){
		super(message);
		this.user = user;
		this.gestionnaire = gestionnaire;
	}
	
	private boolean isOver = false;
	
	@Override
	public void internalStep() {
		E ressource;
		try {
			ressource = gestionnaire.prendreRessource();
		} catch (NoSuchElementException e) {
			System.out.print(" ne peut pas prendre\n");
			return;
		}
		user.setRessource(ressource);
		isOver = true;
		System.out.print(""+this.getMessage());
	}

	@Override
	public boolean stopCondition() {
		return isOver;
	}

}
