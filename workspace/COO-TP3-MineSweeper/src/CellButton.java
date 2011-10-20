import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;


/**
 * @author  benjamin
 */
public class CellButton extends JLabel {

	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="cell"
	 * @uml.associationEnd  
	 */
	final Cell cell;
	
	
	public CellButton(final MineSweeperUI ui, final Cell cell){
		super(cell.getIcon());
		cell.setButton(this);
		this.cell = cell;
		Icon icon = cell.getIcon();
		Dimension buttonSize = new Dimension(icon.getIconWidth(),icon.getIconHeight());
		this.setSize( buttonSize );
		this.setMaximumSize(buttonSize);
		this.addMouseListener(new MouseAdapter(){
		
			public void mouseClicked(MouseEvent e){
				boolean leftClick = true;
				int modifiers = e.getModifiers();
				if ((modifiers & InputEvent.BUTTON1_MASK) != 0) {
					leftClick = true;
				}else if ((modifiers & InputEvent.BUTTON2_MASK) != 0) {
					
				}
				else if ((modifiers & InputEvent.BUTTON3_MASK) != 0) {
					leftClick = false;
				}
				ui.clickFrom(cell.getX(), cell.getY(), leftClick, CellButton.this);
			}
		});
	}
	
	protected void resetIcon(){
		this.setIcon(this.cell.getIcon());
	}
}
