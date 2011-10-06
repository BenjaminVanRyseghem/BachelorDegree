import javax.swing.Icon;
import javax.swing.ImageIcon;


public class BombCell extends Cell {
	
	boolean explosed = false;
	private static final long serialVersionUID = 1L;

	public BombCell(int x, int y){
		super(x, y);
	}
	
	protected void reveal(){
		if(!this.flagged){
			explosed = true;
		}
	}
	
	protected Icon getIcon(){
		if(this.hasExplosed()){
			return new ImageIcon(this.getClass().getResource(System.getProperty("file.separator")+"wrong.gif"));
		}
		else if(!this.isHidden()){
			return new ImageIcon(this.getClass().getResource(System.getProperty("file.separator")+"mine.gif"));
		}
		return super.getIcon();
	}
	
	public boolean hasExplosed(){
		return explosed;
	}
	
	public boolean isBomb(){
		return true;
	}
}
