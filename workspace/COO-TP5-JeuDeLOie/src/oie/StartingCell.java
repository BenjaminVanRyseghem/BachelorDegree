package oie;
import java.util.List;
import java.util.ArrayList;

public class StartingCell implements Cell {

	private List<Player> players = null;
	private final Game game;
	
	@Override
	public boolean canBeLeft() {
		return true;
	}

	@Override
	public int getIndex() {
		return 0;
	}

	@Override
	public int consequence(int diceThrow) {
		return 0;
	}

	@Override
	public boolean isBusy() {
		return !this.getPlayers().isEmpty();
	}

	@Override
	public void setPlayer(Player player) {
		if(!this.getPlayers().contains(player)){
			this.getPlayers().add(player);
			player.setCell(this);
		}
	}

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
	
	@Override
	public Player getPlayer() {
		if(this.getPlayers().size() == 0) return null;
		return players.get(0);
	}

	
	/**
	 */
	public StartingCell(Game game){
		this.game = game;
	}
	
	public void removePlayer(Player player){
		if(!this.getPlayers().contains(player)){
			throw new RuntimeException();
		}
		this.getPlayers().remove(player);
	}
	
	@Override
	public String toString() {
		return "S";
	}
}
