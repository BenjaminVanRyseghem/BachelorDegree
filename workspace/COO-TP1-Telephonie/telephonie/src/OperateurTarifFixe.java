package telephonie;

import telephonie.util.Date;

// TODO: Auto-generated Javadoc
/**
 * An operator whose prices are fixed and the time calculation is linear.
 *
 * @author Benjamin Van Ryseghem
 * @version 1.0
 */
public class OperateurTarifFixe implements Operateur {
	
	/** maximum number of simultaneous connections allowed. */
	private int maxNumberOfConnections;
	
	/** number of current connections established. */
	private int numberOfConnections = 0;
	

	  /**
	 * Instantiate a new fixed-operator with a value of maximum connections.
	 * 
	 * @param maxNumberOfConnections
	 *            the max number of connections
	 */
	public OperateurTarifFixe(int maxNumberOfConnections){
		this.maxNumberOfConnections = maxNumberOfConnections;
	}
	

	
	/**
	 * Gets the maximum number of simultaneous connections allowed.
	 * 
	 * @return the maximum number of simultaneous connections allowed
	 */
	protected int getMaxNumberOfConnections() {
		return maxNumberOfConnections;
	}



	/**
	 * Sets the maximum number of simultaneous connections allowed.
	 * 
	 * @param maxNumberOfConnections
	 *            the new maximum number of simultaneous connections allowed
	 */
	protected void setMaxNumberOfConnections(int maxNumberOfConnections) {
		this.maxNumberOfConnections = maxNumberOfConnections;
	}



	/**
	 * Gets the number of current connections established.
	 * 
	 * @return the number of current connections established
	 */
	protected int getNumberOfConnections() {
		return numberOfConnections;
	}



	/**
	 * Sets the number of current connections established.
	 * 
	 * @param numberOfConnections
	 *            the new number of current connections established
	 */
	protected void setNumberOfConnections(int numberOfConnections) {
		this.numberOfConnections = numberOfConnections;
	}



	/**
	 * Answer if the operator can accept a new connection or not.
	 *
	 * @return true if you can accept  new connection, false either
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
		int dureeEnMinutes;
		dureeEnMinutes = cnx.dureeConnexion();
		if ( dureeEnMinutes <= 5){
			System.out.println("Minutes: "+ dureeEnMinutes);
			return dureeEnMinutes;
		}
		System.out.println("Minutes: "+ (int) Math.ceil( (double) dureeEnMinutes * 0.8 ));
		return (int) Math.ceil( (double) dureeEnMinutes * 0.8 ) ;
	}

	/* (non-Javadoc)
	 * @see telephonie.Operateur#getTarifUnitaire(telephonie.Connexion)
	 */
	@Override
	public int getTarifUnitaire(Connexion cnx) {
		/* value returned in cents */
		System.out.println("Tarif: 30");
		return 30;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
