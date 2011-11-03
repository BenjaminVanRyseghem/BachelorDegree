package oie;


// TODO: Auto-generated Javadoc
/**
 * The Class TeleportationCell.
 */
public class TeleportationCell extends BonusCell {

	
	
	/**
	 * Instantiates a new teleportation cell.
	 *
	 * @param game the game
	 * @param index the index
	 * @param destinationIndex the destination index
	 */
	public TeleportationCell(Game game, int index, int destinationIndex){
		super(game, index);
		this.destinationIndex = destinationIndex;
	}

	/** The destination index. @uml.property  name="destinationIndex" */
	private int destinationIndex;

	/**
	 * Getter of the property <tt>destinationIndex</tt>.
	 *
	 * @return  Returns the destinationIndex.
	 * @uml.property  name="destinationIndex"
	 */
	public int getDestinationIndex() {
		return destinationIndex;
	}

	/**
	 * Setter of the property <tt>destinationIndex</tt>.
	 *
	 * @param destinationIndex  The destinationIndex to set.
	 * @uml.property  name="destinationIndex"
	 */
	public void setDestinationIndex(int destinationIndex) {
		this.destinationIndex = destinationIndex;
	}

	
	/* (non-Javadoc)
	 * @see oie.BonusCell#consequence(int)
	 */
	public int consequence(int diceThrow){
		super.consequence(diceThrow);
		System.out.print("Teeeeeleportattttiiiiiooonnnnnn, ");
		return this.getGame().getBoard().getCell(this.getDestinationIndex()).consequence(diceThrow);
	}

	/* (non-Javadoc)
	 * @see oie.BasicCell#toString()
	 */
	@Override
	public String toString() {
		return "T("+index+","+destinationIndex+")";
	}
}
