package oie;


public abstract class MalusCell extends BasicCell {
	
	public MalusCell(Game game, int index){
		super(game, index);
	}
	
	public void setPlayer(Player player){
		System.out.print("Malus: ");
		super.setPlayer(player);
	}
}
