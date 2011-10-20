import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 * @author  benjamin
 */
public class Cell extends DefaultButtonModel {
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="x"
	 */
	int x;

	/**
	 * @uml.property  name="y"
	 */
	int y;
	/**
	 * @uml.property  name="button"
	 * @uml.associationEnd  
	 */
	CellButton button;
	/**
	 * @uml.property  name="hidden"
	 */
	boolean hidden = true;
	/**
	 * @return
	 * @uml.property  name="x"
	 */
	protected int getX() {
		return x;
	}
	
	/**
	 * @param button
	 * @uml.property  name="button"
	 */
	protected void setButton(CellButton button){
		this.button = button;
	}

	/**
	 * @return
	 * @uml.property  name="y"
	 */
	protected int getY() {
		return y;
	}
	/**
	 * @uml.property  name="flagged"
	 */
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
	
	/**
	 * @return
	 * @uml.property  name="hidden"
	 */
	public boolean isHidden(){
		return hidden;
	}
	
	/**
	 * @return
	 * @uml.property  name="flagged"
	 */
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
