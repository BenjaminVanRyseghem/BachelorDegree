package oie;
import java.util.List;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class StartingCell.
 */
public class StartingCell implements Cell {

	/** The players. */
	private List<Player> players = null;
	
	/** The game. */
	private final Game game;
	
	/* (non-Javadoc)
	 * @see oie.Cell#canBeLeft()
	 */
	@Override
	public boolean canBeLeft() {
		return true;
	}

	/* (non-Javadoc)
	 * @see oie.Cell#getIndex()
	 */
	@Override
	public int getIndex() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see oie.Cell#consequence(int)
	 */
	@Override
	public int consequence(int diceThrow) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see oie.Cell#isBusy()
	 */
	@Override
	public boolean isBusy() {
		return !this.getPlayers().isEmpty();
	}

	/* (non-Javadoc)
	 * @see oie.Cell#setPlayer(oie.Player)
	 */
	@Override
	public void setPlayer(Player player) {
		if(!this.getPlayers().contains(player)){
			this.getPlayers().add(player);
			player.setCell(this);
		}
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public List<Player> getPlayers(){
		if(this.players == null){
			this.players = new ArrayList<Player>();
			for(Player player : game.getThePlayers()){
				this.setPlayer(player);
			}
			System.out.println(players);
		}
		return this.players;
	}
	
	/* (non-Javadoc)
	 * @see oie.Cell#getPlayer()
	 */
	@Override
	public Player getPlayer() {
		if(this.getPlayers().size() == 0) return null;
		return players.get(0);
	}

	
	/**
	 * Instantiates a new starting cell.
	 *
	 * @param game the game
	 */
	public StartingCell(Game game){
		this.game = game;
	}
	
	/* (non-Javadoc)
	 * @see oie.Cell#removePlayer(oie.Player)
	 */
	public void removePlayer(Player player){
		if(!this.getPlayers().contains(player)){
			throw new RuntimeException();
		}
		this.getPlayers().remove(player);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "S";
	}
}
