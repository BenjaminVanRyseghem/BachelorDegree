import java.util.Observable;

/**
 * 
 * Model of the minesweeper
 * 
 * @author Benjamin Van Ryseghem
 * @version 1.0
 * 
 */
public class MineSweeper extends Observable {

	protected int width = 0;
	protected int height = 0;
	protected int currentBombs;
	protected int maxBombs;
	protected boolean gameIsFinished = false;
	protected int revealedCells = 0;
	protected int toBeRevealed = 0;
	protected boolean win = true; 
	
	Cell[][] cells;

	public MineSweeper(int height, int width, int maxBombs){
		this.initialize(height, width, maxBombs);
	}
	
	protected int getWidth() {
		return width;
	}

	protected int getHeight() {
		return height;
	}

	protected boolean isGameFinished() {
		return gameIsFinished;
	}

	protected Cell[][] getCells() {
		return cells;
	}

	protected void initialize(int height, int width, int maxBombs) {
		this.height = height;
		this.width = width;
		this.maxBombs = Math.min(width*height-1, maxBombs);;
		this.toBeRevealed = (height*width) - maxBombs;
		this.cells = new Cell[width][height];
		this.fillUpCells();
		this.currentBombs = this.maxBombs;
		revealedCells = 0;
		win = true;
		
	} 
	
	protected static int randomTo(int max){
		return (int)(max*Math.random());
	}
	
	protected void fillUpCells(){
		this.setUpBombs();
		this.fillWithEmptyCells();
	}
	
	protected void fillWithEmptyCells() {
		for (int y = 0; y < height ; y++){
			for (int x = 0 ; x < width ; x++){
				Cell cell = cells[x][y];
				if(cell == null){
					int nbOfBombs = this.numberOfSurroundingBombs(x, y);
					if ( nbOfBombs == 0){
						cells[x][y] = new IsolatedCell(x, y);
					}
					else{
						cells[x][y] = new EmptyCell(x, y, nbOfBombs);
					}
				}
			}
		}
	}
	
	protected int numberOfSurroundingBombs(int x, int y){
		int result = 0;
		for (int j = Math.max(y-1, 0); j <= Math.min(y+1, this.height-1); j++){
			for (int i = Math.max(x-1, 0); i <= Math.min(x+1, this.width-1); i++){
				Cell cell = cells[i][j];
				if (( cell != null ) && ( cell.isBomb() )){
					result ++;
				}
			}
		}
		return result;
	}

	protected void revealNeightboursFrom(int x,int y){
		for (int j = Math.max(y-1, 0); j <= Math.min(y+1, this.height-1); j++){
			for (int i = Math.max(x-1, 0); i <= Math.min(x+1, this.width-1); i++){
				Cell cell = cells[i][j];
				if (cell.isEmpty() && cell.isHidden()) {
					cell.reveal();
					revealedCells ++;
					if (cell.isIsolated()) revealNeightboursFrom(i, j);
				}
			}
		}
	}
	
	protected void setUpBombs() {
		int i = 0;
		while( i < maxBombs ){
			int x = MineSweeper.randomTo(this.width);
			int y = MineSweeper.randomTo(this.height);
			if (cells[x][y] == null){
				cells[x][y] = new BombCell(x, y);
				i ++;
			}
		}
	}
	
	protected void revealSilentlyEverything(){
		for (int y = 0; y < height ; y++){
			for (int x = 0 ; x < width ; x++){
				Cell cell = cells[x][y];
				cell.revealSilently();
			}
		}
	}
	
	
	public String toString(){
		String result = "";
		for (int y = 0; y < height ; y++){
			for (int x = 0 ; x < width ; x++){
				Cell cell = cells[x][y];
				if( cell == null ){
					result += "V";
				}
				else if( cell.isEmpty()){
					if (cell.isIsolated()){
						result += "I";
					}
					else{ 
						result += "E";
					}
				}
				else if(cell.isBomb()){
					result += "B";
				}
				else{ result += "T";}
			}
			result += "\n";
		}
		return result;
	}
	
	protected void clickOn(int x, int y, boolean isLeftClick, CellButton sender){
		Cell cell = cells[x][y];
		
		if(!cell.isHidden()) return ;
		
		if(isLeftClick){
			if(cell.isFlagged()){
				return ;
			}
			cell.reveal();
			revealedCells ++;
			if(cell.isBomb()){
				this.win = false;
				this.endTheGame();
			}
			else if(cell.isIsolated()){
					this.revealNeightboursFrom(x, y);			
			}
			
		}
		else{
			if(cell.isFlagged()){
				currentBombs++;
			}else{
				currentBombs--;
			}
			cell.toogleFlag();
		}
		if(this.isTheGameOver()){
			this.endTheGame();
		}
		this.setChanged();
		this.notifyObservers(sender);
	}
	
	
	protected void newGame(){
		this.gameIsFinished = false;
		this.initialize(height, width, maxBombs);
		this.setChanged();
		this.notifyObservers("New Game");
	}
	
	protected void endTheGame(){
		gameIsFinished = true;
		this.revealSilentlyEverything();
	}
	
	protected boolean isTheGameOver(){
		return (revealedCells == toBeRevealed);
	}
		
	protected void openInWorld(){
		new MineSweeperUI(this);
	}
	
	public static void main(String[] argz){
		MineSweeper ms = new MineSweeper (25, 25, 50);
		//System.out.println(ms);
		ms.openInWorld();
	}
	
	
}
