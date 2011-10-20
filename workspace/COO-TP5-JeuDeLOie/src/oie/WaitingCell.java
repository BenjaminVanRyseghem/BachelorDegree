package oie;


public class WaitingCell extends MalusCell {

	@Override
	public boolean canBeLeft() {
		return (this.getGame().getTurn() == turnOfRelease);
	}
	
	/**
	 * @uml.property  name="turnsToWait"
	 */
	private int turnsToWait;
	private int turnOfRelease = -1;

	/**
	 * Getter of the property <tt>turnsToWait</tt>
	 * @return  Returns the turnsToWait.
	 * @uml.property  name="turnsToWait"
	 */
	public int getTurnsToWait() {
		return turnsToWait;
	}

	/**
	 * Setter of the property <tt>turnsToWait</tt>
	 * @param turnsToWait  The turnsToWait to set.
	 * @uml.property  name="turnsToWait"
	 */
	public void setTurnsToWait(int turnsToWait) {
		this.turnsToWait = turnsToWait;
	}

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
	 */
	public WaitingCell(Game game, int index, int turnsToWait){
		super(game, index);
		this. turnsToWait = turnsToWait;
	}
	
	@Override
	public void removePlayer(Player player){
		super.removePlayer(player);
	}
	
	@Override
	public String toString() {
		return "W("+index+","+turnsToWait+","+turnOfRelease+")";
	}
}
