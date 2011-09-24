package telephonie;

// TODO: Auto-generated Javadoc
/**
 * The Class CartePrePayee.
 * @author Benjamin Van Ryseghem
 * @version 1.0
 */
public class CartePrePayee implements ModeDePaiement {

	/** The balance. */
	private int balance = 0;
	
	/** The unit price. */
	private int unitPrice;
	
	/** The cb. */
	private CarteBancaire cb;
	
	/**
	 * Gets the unit price.
	 *
	 * @return the unit price
	 */
	protected int getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price.
	 *
	 * @param unitPrice the new unit price
	 */
	protected void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the cb.
	 *
	 * @return the cb
	 */
	protected CarteBancaire getCb() {
		return cb;
	}

	/**
	 * Sets the cb.
	 *
	 * @param cb the new cb
	 */
	protected void setCb(CarteBancaire cb) {
		this.cb = cb;
	}

	/**
	 * Instantiates a new pre payed card.
	 *
	 * @param cb the cb
	 */
	public CartePrePayee (CarteBancaire cb){
		unitPrice = this.defaultUnitPrice();
		cb.debiter(50, unitPrice);
		this.refund(50*unitPrice);
		this.cb = cb;
	}
	
	protected void refund(int addToBalance){
		this.setBalance(this.getBalance()+addToBalance);
		System.out.println("Fund added ("+ addToBalance +")");
	}
	
	/**
	 * Default unitPrice.
	 *
	 * @return the int
	 */
	protected int defaultUnitPrice(){
		return 15;
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
		return balance > 0;
	}

	/* (non-Javadoc)
	 * @see telephonie.ModeDePaiement#debiter(int, int)
	 */
	@Override
	public void debiter(int dureeComptabilisee, int tarifUnitaireApplique) {
		int toRemove = dureeComptabilisee * tarifUnitaireApplique;
		
		if (this.getBalance() >= toRemove){
			this.setBalance(this.getBalance() - toRemove);
			System.out.println(toRemove + " units removed from the pre payed card. "+this.getBalance()+" units left");
		}
		else { 
			
			System.out.println("pre payed card empty");
			System.out.println("valide :" + this.valide());
			toRemove = toRemove - this.getBalance();
			this.setBalance(0);
			System.out.println(toRemove + " have to be removed from my credit card");
			this.getCb().debiter(toRemove, 1);
		}
	}

}
