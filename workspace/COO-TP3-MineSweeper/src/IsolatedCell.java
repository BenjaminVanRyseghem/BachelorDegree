
public class IsolatedCell extends EmptyCell {
	
	private static final long serialVersionUID = 1L;

	public IsolatedCell(int x, int y){
		super(x, y, 0);
	}
	
	public boolean isIsolated(){
		return true;
	}
}
