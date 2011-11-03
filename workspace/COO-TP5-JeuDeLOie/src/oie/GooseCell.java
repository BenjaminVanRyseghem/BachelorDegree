package oie;


// TODO: Auto-generated Javadoc
/**
 * The Class GooseCell.
 */
public class GooseCell extends BonusCell {

	/* (non-Javadoc)
	 * @see oie.BonusCell#consequence(int)
	 */
	@Override
	public int consequence(int diceThrow) {
		int newIndex = super.consequence(diceThrow)+diceThrow;
		System.out.print("got a goose, ");
		return this.getGame().getBoard().getCell(newIndex).consequence(diceThrow);
	}

		
	/**
	 * Instantiates a new goose cell.
	 *
	 * @param game the game
	 * @param index the index
	 */
	public GooseCell(Game game, int index){
		super(game, index);
	}
}
