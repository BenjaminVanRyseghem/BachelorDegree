package ressource;


/** La classe des utilisateurs de ressource.
 *
 * @param <R> le type de ressource utilisée
 */
public class RessourceUser<R extends Ressource> {
	
	/** La ressource utilisée */
	protected R ressource;
	/**
	 * @return la ressource actuellement utilisée, <t>null</t> si aucune
	 */
	public R getRessource() {
		return this.ressource;
	}	
	/** fixe la ressource utilisée
	 * @param ressource la ressource
	 */
	public void setRessource(R ressource) {
		this.ressource = ressource;
	}
	/**
	 * réinitialise la ressource utilisée (mise à <t>null</t>)
	 */
	public void resetRessource() {
		this.ressource = null;		
	}
}
