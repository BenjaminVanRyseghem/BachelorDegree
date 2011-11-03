package oie;

// TODO: Auto-generated Javadoc
/**
 * The Class TrapCell.
 */
public class TrapCell extends MalusCell {

	
	
	/* (non-Javadoc)
	 * @see oie.BasicCell#canBeLeft()
	 */
	@Override
	public boolean canBeLeft() {
		return false;
	}

	/**
	 * Instantiates a new trap cell.
	 *
	 * @param game the game
	 * @param index the index
	 */
	public TrapCell(Game game, int index){
		super(game, index);
	}
	
	/* (non-Javadoc)
	 * @see oie.MalusCell#setPlayer(oie.Player)
	 */
	@Override
	public void setPlayer(Player player) {
		super.setPlayer(player);
		System.out.println("you felt in the void. Wait another player to escape");
	}

	/* (non-Javadoc)
	 * @see oie.BasicCell#toString()
	 */
	@Override
	public String toString() {
		return "D("+index+")";
	}
}
