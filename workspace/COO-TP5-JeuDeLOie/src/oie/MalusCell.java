package oie;


// TODO: Auto-generated Javadoc
/**
 * The Class MalusCell.
 */
public abstract class MalusCell extends BasicCell {
	
	/**
	 * Instantiates a new malus cell.
	 *
	 * @param game the game
	 * @param index the index
	 */
	public MalusCell(Game game, int index){
		super(game, index);
	}
	
	/* (non-Javadoc)
	 * @see oie.BasicCell#setPlayer(oie.Player)
	 */
	public void setPlayer(Player player){
		System.out.print("Malus: ");
		super.setPlayer(player);
	}
}
