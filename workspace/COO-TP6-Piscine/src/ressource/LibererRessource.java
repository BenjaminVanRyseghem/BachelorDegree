package ressource;

import action.Action;


public class LibererRessource<E extends Ressource> extends Action {

	private RessourceUser<E> user;
	private GestionnaireRessources<E> gestionnaire; 
	
	public LibererRessource(String message, GestionnaireRessources<E> gestionnaire, RessourceUser<E> user){
		super(message);
		this.user = user;
		this.gestionnaire = gestionnaire;
	}
	
	private boolean isOver = false;
	
	@Override
	public void internalStep() {
		try {
			gestionnaire.libererRessource(user.getRessource());
		} catch (RessourceInvalideException e) {
			System.out.print(" ne peut pas rendre\n");
			return;
		}
		isOver = true;
		System.out.print(""+this.getMessage());
	}

	@Override
	public boolean stopCondition() {
		return isOver;
	}

}
