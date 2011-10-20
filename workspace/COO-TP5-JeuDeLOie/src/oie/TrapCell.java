package oie;

public class TrapCell extends MalusCell {

	
	
	@Override
	public boolean canBeLeft() {
		return false;
	}

	/**
	 */
	public TrapCell(Game game, int index){
		super(game, index);
	}
	
	@Override
	public void setPlayer(Player player) {
		super.setPlayer(player);
		System.out.println("you felt in the void. Wait another player to escape");
	}

	@Override
	public String toString() {
		return "D("+index+")";
	}
}
