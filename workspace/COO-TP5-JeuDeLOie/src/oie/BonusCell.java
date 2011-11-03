package oie;


// TODO: Auto-generated Javadoc
/**
 * The abstract Class BonusCell.
 */
public abstract class BonusCell extends BasicCell {
	
	/**
	 * Instantiates a new bonus cell.
	 *
	 * @param game the game
	 * @param index the index
	 */
	public BonusCell(Game game, int index){
		super(game, index);
	}
	
	/* (non-Javadoc)
	 * @see oie.BasicCell#consequence(int)
	 */
	public int consequence(int diceRoll){
		System.out.print("\nBONUS: ");
		return super.consequence(diceRoll);
	}
}
