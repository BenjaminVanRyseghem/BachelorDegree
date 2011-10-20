package oie;


public class ClassicBoard extends Board {

	public ClassicBoard(){
		super(63);
	}
	
	public void setGame(Game game){
		super.setGame(game);
		startingCell = new StartingCell(this.getGame());
	}
	
	@Override
	public void initBoard(){	
		Cell[] theCells = new Cell[this.getNbOfCells()+1];
		
		theCells[0] = this.startingCell;
		for (int i = 1; i < this.getNbOfCells()+1; i ++){
			theCells[i] = new BasicCell(this.getGame(), i);
		}
		int[] gooseTab = {9, 18, 27, 36, 45, 54};
		for (int i : gooseTab){
			theCells[i] = new GooseCell(this.getGame(), i);
		}
		int[] trapTab = {31, 52};
		for (int i : trapTab){
			theCells[i] = new TrapCell(this.getGame(), i);
		}
		theCells[19] = new WaitingCell(this.getGame(), 19,2);
		theCells[6] = new TeleportationCell(this.getGame(), 6,12);
		theCells[42] = new TeleportationCell(this.getGame(), 42,30);
		theCells[58] = new TeleportationCell(this.getGame(), 58,1);
		this.setTheCells(theCells);
	}

	/**
	 * @uml.property  name="startingCell"
	 */
	private StartingCell startingCell;

	/**
	 * Getter of the property <tt>startingCell</tt>
	 * @return  Returns the startingCell.
	 * @uml.property  name="startingCell"
	 */
	public StartingCell getStartingCell() {
		return startingCell;
	}
}
