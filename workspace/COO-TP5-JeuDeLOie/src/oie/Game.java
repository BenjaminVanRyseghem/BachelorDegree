package oie;

import java.util.List;
import java.util.ArrayList;

public class Game {


	/**
	 * @uml.property  name="board"
	 */
	private Board board;
	private int finalIndex = 63;

	/**
	 * Getter of the property <tt>board</tt>
	 * @return  Returns the board.
	 * @uml.property  name="board"
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Setter of the property <tt>board</tt>
	 * @param board  The board to set.
	 * @uml.property  name="board"
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * @uml.property  name="thePlayers"
	 */
	private List<Player> thePlayers = new ArrayList<Player>();

	/**
	 * Getter of the property <tt>thePlayers</tt>
	 * @return  Returns the thePlayers.
	 * @uml.property  name="thePlayers"
	 */
	public List<Player> getThePlayers() {
		return thePlayers;
	}

	/**
	 * Setter of the property <tt>thePlayers</tt>
	 * @param thePlayers  The thePlayers to set.
	 * @uml.property  name="thePlayers"
	 */
	public void setThePlayers(List<Player> thePlayers) {
		this.thePlayers = thePlayers;
	}

		
	/**
	 */
	public void addPlayer(Player player){
		this.thePlayers.add(player);
	}
	
	public void addPlayerByName(String name){
		this.thePlayers.add(new Player(name, this.getBoard().getStartingCell()));
	}
	
	
	private boolean gameIsOver(){
		for(Player player : thePlayers){
			if(player.cell.getIndex() == this.finalIndex) return true;
		}
		return false;
	}
		
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
	 */
	public void play(){
		while(!this.gameIsOver() && (turn < 100)){
			this.playATurn();
		}
		Cell[] cells = this.getBoard().getTheCells();
		System.out.println(cells[cells.length-1].getPlayer() + " won");
	}
	
		
	/**
	 */
	public Game(Board board){
		this.board = board;
		this.board.setGame(this);
		this.board.initBoard();
	}

	/**
	 * @uml.property  name="turn"
	 */
	private int turn = 0;

	/**
	 * Getter of the property <tt>turn</tt>
	 * @return  Returns the turn.
	 * @uml.property  name="turn"
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * Setter of the property <tt>turn</tt>
	 * @param turn  The turn to set.
	 * @uml.property  name="turn"
	 */
	public void setTurn(int turn) {
		this.turn = turn;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Players:\n";
		for (Player player : thePlayers){ result += player+"\n";}
		
		result += "Board:\n";
		result += this.board.toString();
		return result;
	}
	
	public String asciiUI(){
		return board.asciiUI();
	}
	
	public void update(){
		System.out.println(this.asciiUI());
	}
	
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
