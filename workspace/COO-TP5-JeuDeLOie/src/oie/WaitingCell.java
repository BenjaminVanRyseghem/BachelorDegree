package oie;


// TODO: Auto-generated Javadoc
/**
 * The Class WaitingCell.
 */
public class WaitingCell extends MalusCell {

	/* (non-Javadoc)
	 * @see oie.BasicCell#canBeLeft()
	 */
	@Override
	public boolean canBeLeft() {
		return (this.getGame().getTurn() == turnOfRelease);
	}
	
	/** The turns to wait. @uml.property  name="turnsToWait" */
	private int turnsToWait;
	
	/** The turn of release. */
	private int turnOfRelease = -1;

	/**
	 * Getter of the property <tt>turnsToWait</tt>.
	 *
	 * @return  Returns the turnsToWait.
	 * @uml.property  name="turnsToWait"
	 */
	public int getTurnsToWait() {
		return turnsToWait;
	}

	/**
	 * Setter of the property <tt>turnsToWait</tt>.
	 *
	 * @param turnsToWait  The turnsToWait to set.
	 * @uml.property  name="turnsToWait"
	 */
	public void setTurnsToWait(int turnsToWait) {
		this.turnsToWait = turnsToWait;
	}

	/* (non-Javadoc)
	 * @see oie.MalusCell#setPlayer(oie.Player)
	 */
	public void setPlayer(Player player){
		super.setPlayer(player);
		int currentTurn = this.getGame().getTurn();
		if(turnOfRelease <= currentTurn){
			turnOfRelease = currentTurn + this.getTurnsToWait()+1;
		}
		int leftTurns = this.turnOfRelease - this.getGame().getTurn() - 1;
		System.out.println("fall in a well. Wait "+leftTurns+" turns");
	}
		
	/**
	 * Instantiates a new waiting cell.
	 *
	 * @param game the game
	 * @param index the index
	 * @param turnsToWait the turns to wait
	 */
	public WaitingCell(Game game, int index, int turnsToWait){
		super(game, index);
		this. turnsToWait = turnsToWait;
	}
	
	/* (non-Javadoc)
	 * @see oie.BasicCell#removePlayer(oie.Player)
	 */
	@Override
	public void removePlayer(Player player){
		super.removePlayer(player);
	}
	
	/* (non-Javadoc)
	 * @see oie.BasicCell#toString()
	 */
	@Override
	public String toString() {
		return "W("+index+","+turnsToWait+","+turnOfRelease+")";
	}
}
