package oie;

public abstract class Board {

	/**
	 * @uml.property  name="nbOfCells" readOnly="true"
	 */
	private final int nbOfCells;

	/**
	 * Getter of the property <tt>nbOfCells</tt>
	 * @return  Returns the nbOfCells.
	 * @uml.property  name="nbOfCells"
	 */
	public int getNbOfCells() {
		return nbOfCells;
	}
	
	/**
	 */
	public Board(int nbOfCells){
		this.nbOfCells = nbOfCells;
	}


	/**
	 * @uml.property  name="theCells"
	 */
	private Cell[] theCells;

	/**
	 * Getter of the property <tt>theCells</tt>
	 * @return  Returns the theCells.
	 * @uml.property  name="theCells"
	 */
	public Cell[] getTheCells() {
		return theCells;
	}


	/**
	 * Setter of the property <tt>theCells</tt>
	 * @param theCells  The theCells to set.
	 * @uml.property  name="theCells"
	 */
	public void setTheCells(Cell[] theCells) {
		this.theCells = theCells;
	}


	/**
	 */
	public abstract void initBoard();
	public abstract StartingCell getStartingCell();
	
	/**
	 */
	public Cell getCell(int numero){
		return this.getTheCells()[numero];
	}


	/**
	 * @uml.property  name="game"
	 */
	private Game game;

	/**
	 * Getter of the property <tt>game</tt>
	 * @return  Returns the game.
	 * @uml.property  name="game"
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Setter of the property <tt>game</tt>
	 * @param game  The game to set.
	 * @uml.property  name="game"
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (Cell cell : this.getTheCells()){ result += " -> "+ cell; }
		return result;
	}
	
	public String asciiUI(){
		String result = "";
		for (Cell cell : this.getTheCells()){
			if(cell.isBusy()){
				result += " " + cell.getPlayer() + " ";
			}
			else result += " _ "; }
		return result;
	}
}
