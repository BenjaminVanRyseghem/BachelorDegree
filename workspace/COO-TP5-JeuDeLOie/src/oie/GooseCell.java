package oie;


public class GooseCell extends BonusCell {

	@Override
	public int consequence(int diceThrow) {
		int newIndex = super.consequence(diceThrow)+diceThrow;
		System.out.print("got a goose, ");
		return this.getGame().getBoard().getCell(newIndex).consequence(diceThrow);
	}

		
	/**
	 */
	public GooseCell(Game game, int index){
		super(game, index);
	}
}
