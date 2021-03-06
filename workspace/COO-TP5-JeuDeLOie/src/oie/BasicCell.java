package oie;

// TODO: Auto-generated Javadoc
/**
 * Interface for the cells of the "jeu de l'oie" game. <br/> Note that there can be only  one player by cell, the starting cell (index 0) excepted.
 */
public class BasicCell implements Cell {
	
	/** The index. */
	protected int index;
	
	/** The player. */
	protected Player player;
	
	/**
	 * Can be left.
	 *
	 * @return <tt>true</tt> if and only if the player in this cell can freely leaves the cell, else
	 * he must wait for another player to reach this cell or wait a given number of turns
	 */
	public boolean canBeLeft(){
		return true;
	}

	/**
	 * returns the index of this cell.
	 *
	 * @return the index
	 */
	public int getIndex(){
		return index;
	}

	/**
	 * returns the index of the cell really reached by a player when he reaches this cell.
	 *
	 * @param diceThrow the result of the dices when the player reaches this cell
	 * @return the index of the cell effectively reached when a player reaches this cell after the
	 * given throw of dices
	 */
	public int consequence(int diceThrow){
		return this.getIndex();
	}

	/**
	 * returns <tt>true</tt> iff a player is in this cell.
	 *
	 * @return true, if is busy
	 */
	public boolean isBusy(){
		return this.player != null;
	}

	/**
	 * sets a player in this cell.
	 *
	 * @param player the new player
	 * @uml.property  name="player"
	 */
	public void setPlayer(Player player){
		if (player == null) {
			this.player = null;
			return;
		}
		Cell originalCell = player.getCell();
		originalCell.removePlayer(player);
		if (this.isBusy()) {
			System.out.println(this.getPlayer()+ " sent back to "+originalCell);
			if(originalCell != this) originalCell.setPlayer(this.getPlayer());
		}
		this.player = player;
		this.player.setCell(this);
	}

	/**
	 * gets the player in this cell <tt>null</tt> if none.
	 *
	 * @return the player
	 * @uml.property  name="player"
	 * @uml.associationEnd
	 */
	public Player getPlayer(){
		return this.player;
	}

	
	/**
	 * Instantiates a new basic cell.
	 *
	 * @param game the game
	 * @param index the index
	 */
	public BasicCell(Game game, int index){
		this.index = index;
		this.game = game;
	}


	/** The game. @uml.property  name="game" */
	private Game game;

	/**
	 * Getter of the property <tt>game</tt>.
	 *
	 * @return  Returns the game.
	 * @uml.property  name="game"
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Setter of the property <tt>game</tt>.
	 *
	 * @param game  The game to set.
	 * @uml.property  name="game"
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/* (non-Javadoc)
	 * @see oie.Cell#removePlayer(oie.Player)
	 */
	public void removePlayer(Player player){
		if(this.player != player){
			System.out.println(this.getGame().asciiUI());
			throw new RuntimeException();
		}
		this.setPlayer(null);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "B("+index+")";
	}
}// Cell
