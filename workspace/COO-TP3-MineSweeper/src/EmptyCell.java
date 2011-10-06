import javax.swing.Icon;
import javax.swing.ImageIcon;


public class EmptyCell extends Cell {

	int numberOfCloseBombs;
	private static final long serialVersionUID = 1L;

	public EmptyCell(int x, int y, int numberOfCloseBombs){
		super(x, y);
		this.numberOfCloseBombs = numberOfCloseBombs;
	}
	
	protected Icon getIcon(){
		if (!this.isHidden()){
			return new ImageIcon(this.getClass().getResource(System.getProperty("file.separator")+"free"+numberOfCloseBombs+".gif"));	
		}
		return super.getIcon();
	}
	public boolean isEmpty(){
		return true;
	}
}
