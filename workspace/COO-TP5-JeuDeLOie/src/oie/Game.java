package oie;

import java.util.List;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {


	/** The board. @uml.property  name="board" */
	private Board board;
	
	/** The final index. */
	private int finalIndex = 63;

	/**
	 * Getter of the property <tt>board</tt>.
	 *
	 * @return  Returns the board.
	 * @uml.property  name="board"
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Setter of the property <tt>board</tt>.
	 *
	 * @param board  The board to set.
	 * @uml.property  name="board"
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/** The players. @uml.property  name="thePlayers" */
	private List<Player> thePlayers = new ArrayList<Player>();

	/**
	 * Getter of the property <tt>thePlayers</tt>.
	 *
	 * @return  Returns the thePlayers.
	 * @uml.property  name="thePlayers"
	 */
	public List<Player> getThePlayers() {
		return thePlayers;
	}

	/**
	 * Setter of the property <tt>thePlayers</tt>.
	 *
	 * @param thePlayers  The thePlayers to set.
	 * @uml.property  name="thePlayers"
	 */
	public void setThePlayers(List<Player> thePlayers) {
		this.thePlayers = thePlayers;
	}

		
	/**
	 * Adds the player.
	 *
	 * @param player the player
	 */
	public void addPlayer(Player player){
		this.thePlayers.add(player);
	}
	
	/**
	 * Adds the player by name.
	 *
	 * @param name the name
	 */
	public void addPlayerByName(String name){
		this.thePlayers.add(new Player(name, this.getBoard().getStartingCell()));
	}
	
	
	/**
	 * Game is over.
	 *
	 * @return true, if successful
	 */
	private boolean gameIsOver(){
		for(Player player : thePlayers){
			if(player.cell.getIndex() == this.finalIndex) return true;
		}
		return false;
	}
		
	/**
	 * Play a turn.
	 */
	private void playATurn(){
		turn ++;
		System.out.println("New turn: "+turn);
		int limit = this.getBoard().getNbOfCells();
		for(Player player : thePlayers){
			if(player.getCell().canBeLeft()){
				int diceThrow = player.twoDicesThrow();
				int originalIndex = player.getCell().getIndex();
				int tmpIndex = originalIndex+diceThrow;
				if(tmpIndex > limit){
					int diff = tmpIndex - limit;
					tmpIndex = limit - diff;
				}
				int newIndex = this.getBoard().getCell(tmpIndex).consequence(diceThrow);
				if(newIndex > limit){
					int diff = newIndex - limit;
					newIndex = limit - diff;
				}
				System.out.println("and arrives in "+newIndex);
				this.getBoard().getCell(newIndex).setPlayer(player);
			}
		}
		this.update();
	}
	
	/**
	 * Play.
	 */
	public void play(){
		while(!this.gameIsOver() && (turn < 100)){
			this.playATurn();
		}
		Cell[] cells = this.getBoard().getTheCells();
		System.out.println(cells[cells.length-1].getPlayer() + " won");
	}
	
		
	/**
	 * Instantiates a new game.
	 *
	 * @param board the board
	 */
	public Game(Board board){
		this.board = board;
		this.board.setGame(this);
		this.board.initBoard();
	}

	/** The turn. @uml.property  name="turn" */
	private int turn = 0;

	/**
	 * Getter of the property <tt>turn</tt>.
	 *
	 * @return  Returns the turn.
	 * @uml.property  name="turn"
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Setter of the property <tt>turn</tt>.
	 *
	 * @param turn  The turn to set.
	 * @uml.property  name="turn"
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Players:\n";
		for (Player player : thePlayers){ result += player+"\n";}
		
		result += "Board:\n";
		result += this.board.toString();
		return result;
	}
	
	/**
	 * Ascii ui.
	 *
	 * @return the string
	 */
	public String asciiUI(){
		return board.asciiUI();
	}
	
	/**
	 * Update.
	 */
	public void update(){
		System.out.println(this.asciiUI());
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Board board = new ClassicBoard();
		Game game = new Game(board);
		game.addPlayerByName("A");
		game.addPlayerByName("B");
		game.addPlayerByName("C");
		game.addPlayerByName("D");
		game.addPlayerByName("E");
		System.out.println(game.getThePlayers());
		System.out.println(game.asciiUI());
	//	game.playATurn();
		game.play();
	}
}
