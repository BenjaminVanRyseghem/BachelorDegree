package ressource;

import java.util.ArrayList;
import java.util.Collection;


public class GestionnaireRessources<E extends Ressource> {

	/**
	 * @uml.property  name="ressources"
	 */
	private Collection<E> ressources;

	/**
	 * Getter of the property <tt>ressources</tt>
	 * @return  Returns the ressources.
	 * @uml.property  name="ressources"
	 */
	public Collection<E> getRessources() {
		return ressources;
	}

	/**
	 * Setter of the property <tt>ressources</tt>
	 * @param ressources  The ressources to set.
	 * @uml.property  name="ressources"
	 */
	public void setRessources(Collection<E> ressources) {
		this.ressources = ressources;
		if(this.ressources == null) return;
		for(E res : this.ressources){
			availableRessources.add(res);
		}
		
		
	}

	/**
	 * @uml.property  name="availableRessources"
	 */
	private ArrayList<E> availableRessources = new ArrayList<E>();

	/**
	 * Getter of the property <tt>availableRessources</tt>
	 * @return  Returns the availableRessources.
	 * @uml.property  name="availableRessources"
	 */
	public ArrayList<E> getAvailableRessources() {
		return availableRessources;
	}

	/**
	 * Setter of the property <tt>availableRessources</tt>
	 * @param availableRessources  The availableRessources to set.
	 * @uml.property  name="availableRessources"
	 */
	public void setAvailableRessources(ArrayList<E> availableRessources) {
		this.availableRessources = availableRessources;
	}

	
	public void libererRessource(E ressource) throws RessourceInvalideException{
		if(!this.getRessources().contains(ressource)) throw new RessourceInvalideException();
		this.availableRessources.add(ressource);
	}
		
		/**
		 * @throws NoSuchElementException 
		 */
		public E prendreRessource() throws NoSuchElementException{
			if(this.getAvailableRessources().isEmpty()) throw new NoSuchElementException(); 
			return this.getAvailableRessources().remove(0);
		}

			
			/**
			 */
	public GestionnaireRessources(Collection<E> ressources){
		this.setRessources(ressources);
	}

	public GestionnaireRessources(){
		this.setRessources(null);
	}


}
