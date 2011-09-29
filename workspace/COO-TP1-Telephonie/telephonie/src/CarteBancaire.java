package telephonie;


// TODO: Auto-generated Javadoc
/**
 * The Class CarteBancaire.
 * @author Benjamin Van Ryseghem
 * @version 1.0
 */
public class CarteBancaire implements ModeDePaiement {

	/** The balance. */
	private int balance;
	
	/**
	 * Instantiates a new credit card.
	 *
	 * @param balance the balance
	 */
	public CarteBancaire(int balance){
		this.balance = balance;
	}
	

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	protected int getBalance() {
		return balance;
	}


	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	protected void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	/* (non-Javadoc)
	 * @see telephonie.ModeDePaiement#valide()
	 */
	@Override
	public boolean valide() {
		return true;
	}

	/* (non-Javadoc)
	 * @see telephonie.ModeDePaiement#debiter(int, int)
	 */
	@Override
	public void debiter(int dureeComptabilisee, int tarifUnitaireApplique) {
		System.out.println((dureeComptabilisee * tarifUnitaireApplique) + " removed from my credit card");
		this.setBalance(this.getBalance() - (dureeComptabilisee * tarifUnitaireApplique));
		System.out.println("Balance: "+this.getBalance());
	}



}
