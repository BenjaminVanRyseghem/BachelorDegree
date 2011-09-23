package telephonie;

import telephonie.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class OperateurTarifVariable.
 * @author Benjamin Van Ryseghem
 * @version 1.0
 */
public class OperateurTarifVariable implements Operateur {

	/** The max number of connections. */
	private int maxNumberOfConnections;
	
	/** The number of connections. */
	private int numberOfConnections = 0;
	
	

	/**
	 * Instantiates a new operator with variable prices.
	 *
	 * @param maxNumberOfConnections the max number of connections
	 */
	public OperateurTarifVariable(int maxNumberOfConnections){
		this.maxNumberOfConnections = maxNumberOfConnections;
	}
	
	/**
	 * Gets the max number of connections.
	 *
	 * @return the max number of connections
	 */
	protected int getMaxNumberOfConnections() {
		return maxNumberOfConnections;
	}

	/**
	 * Sets the max number of connections.
	 *
	 * @param maxNumberOfConnections the new max number of connections
	 */
	protected void setMaxNumberOfConnections(int maxNumberOfConnections) {
		this.maxNumberOfConnections = maxNumberOfConnections;
	}

	/**
	 * Gets the number of connections.
	 *
	 * @return the number of connections
	 */
	protected int getNumberOfConnections() {
		return numberOfConnections;
	}

	/**
	 * Sets the number of connections.
	 *
	 * @param numberOfConnections the new number of connections
	 */
	protected void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}
	
	/**
	 * Accept new connection.
	 *
	 * @return true, if successful
	 */
	protected boolean acceptNewConnection(){
		return numberOfConnections < maxNumberOfConnections;
	}
	
	/**
	 * Increment number of connections.
	 */
	protected void incrementNumberOfConnections(){
		this.setNumberOfConnections(this.getNumberOfConnections()+1);
	}


	/**
	 * Decrement number of connections.
	 */
	protected void decrementNumberOfConnections(){
		this.setNumberOfConnections(this.getNumberOfConnections()-1);
	}
	
	/* (non-Javadoc)
	 * @see telephonie.Operateur#seConnecter(telephonie.util.Date, telephonie.ModeDePaiement)
	 */
	@Override
	public Connexion seConnecter(Date debut, ModeDePaiement modeP)
			throws OperateurSatureException, ModeDePaiementInvalideException {		
		Connexion result;
		if (!modeP.valide()){
			throw new ModeDePaiementInvalideException();
		}
		if (!this.acceptNewConnection()){
			throw new OperateurSatureException();
		}
		result = new Connexion(this, debut, modeP);
		this.incrementNumberOfConnections();
		return result;
	}

	/* (non-Javadoc)
	 * @see telephonie.Operateur#seDeconnecter(telephonie.Connexion, telephonie.util.Date)
	 */
	@Override
	public void seDeconnecter(Connexion cnx, Date fin)
			throws PasDeConnexionException {
		if (cnx.getOperateur() != this){
			throw new PasDeConnexionException();
		}
		cnx.finConnexion(fin);
		this.decrementNumberOfConnections();
		cnx.mode().debiter(this.getDureeComptabilisee(cnx) , this.getTarifUnitaire(cnx));
	}
	
	/* (non-Javadoc)
	 * @see telephonie.Operateur#getDureeComptabilisee(telephonie.Connexion)
	 */
	@Override
	public int getDureeComptabilisee(Connexion cnx) {
		System.out.println("Minutes: "+cnx.dureeConnexion());
		return cnx.dureeConnexion();
	}

	/* (non-Javadoc)
	 * @see telephonie.Operateur#getTarifUnitaire(telephonie.Connexion)
	 */
	@Override
	public int getTarifUnitaire(Connexion cnx) {
		int heureConnexion = cnx.heureDebutConnexion();
		if(heureConnexion >= 20 || heureConnexion < 8){
			System.out.println("Tarif: 15");
			return 15;
		}
		if( (heureConnexion >= 8 & heureConnexion < 12) || (heureConnexion >= 14 & heureConnexion < 20) ){
			System.out.println("Tarif: 30");
			return 30;
		}
		System.out.println("Tarif: 45");
		return 45;
		
	}
}
