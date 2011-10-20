package oie;


public class TeleportationCell extends BonusCell {

	
	
	public TeleportationCell(Game game, int index, int destinationIndex){
		super(game, index);
		this.destinationIndex = destinationIndex;
	}

	/**
	 * @uml.property  name="destinationIndex"
	 */
	private int destinationIndex;

	/**
	 * Getter of the property <tt>destinationIndex</tt>
	 * @return  Returns the destinationIndex.
	 * @uml.property  name="destinationIndex"
	 */
	public int getDestinationIndex() {
		return destinationIndex;
	}

	/**
	 * Setter of the property <tt>destinationIndex</tt>
	 * @param destinationIndex  The destinationIndex to set.
	 * @uml.property  name="destinationIndex"
	 */
	public void setDestinationIndex(int destinationIndex) {
		this.destinationIndex = destinationIndex;
	}

	
	/**
	 */
	public int consequence(int diceThrow){
		super.consequence(diceThrow);
		System.out.print("Teeeeeleportattttiiiiiooonnnnnn, ");
		return this.getGame().getBoard().getCell(this.getDestinationIndex()).consequence(diceThrow);
	}

	@Override
	public String toString() {
		return "T("+index+","+destinationIndex+")";
	}
}
