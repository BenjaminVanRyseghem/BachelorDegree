import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Cell extends DefaultButtonModel {
	private static final long serialVersionUID = 1L;

	int x,y;
	CellButton button;
	boolean hidden = true;
	protected int getX() {
		return x;
	}
	
	protected void setButton(CellButton button){
		this.button = button;
	}

	protected int getY() {
		return y;
	}
	boolean flagged = false;
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean isBomb(){
		return false;
	}
	
	public boolean isEmpty(){
		return false;
	}
	
	public boolean isIsolated(){
		return false;
	}
	
	public boolean isHidden(){
		return hidden;
	}
	
	public boolean isFlagged(){
		return flagged;
	}
	
	protected void flag(){
		flagged = true;
	}
	
	protected void unflag(){
		flagged = false;
	}
	
	protected void toogleFlag(){
		flagged = !flagged;
		button.resetIcon();
	}
	
	protected Icon getIcon(){
		if (this.isFlagged()){
			return new ImageIcon(this.getClass().getResource(System.getProperty("file.separator")+"marked.gif"));
		}
		return new ImageIcon(this.getClass().getResource(System.getProperty("file.separator")+"unknown.gif"));
	}
		
	protected void reveal(){
		if(!this.flagged){
			hidden = false;
		}
		button.resetIcon();
	}
	protected void revealSilently(){
		flagged = false;
		hidden = false;
		button.resetIcon();
	}
}
