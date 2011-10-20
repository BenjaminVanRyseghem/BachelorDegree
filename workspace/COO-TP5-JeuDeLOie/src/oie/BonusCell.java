package oie;


public abstract class BonusCell extends BasicCell {
	public BonusCell(Game game, int index){
		super(game, index);
	}
	
	public int consequence(int diceRoll){
		System.out.print("\nBONUS: ");
		return super.consequence(diceRoll);
	}
}
