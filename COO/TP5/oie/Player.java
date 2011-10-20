package oie;
/** A player in the "jeu de l'oie" game */
public class Player {
    /** current cell of the player */
    protected Cell cell;
    /** name of the player*/
    protected String name;
    /** 
     * @param name the name of this player
     * @param cell the strating cell of this player
    */
    public Player (String name, Cell cell){
        this.name = name;
        this.cell = cell;
    }
    /** */
    public String toString() { return name; }
    /** returns the current cell of the player 
      *  @return the current cell of the player 
      */
    public Cell getCell() { 
       return this.cell ; 
    }
    /** changes the cell of the player 
     * @param newCell the new cell
    */
    public void setCell(Cell newCell) { 
       this.cell = newCell; 
    }    
    /** result of a 1d6 throw
     * @return random result of a 1d6 throw 
    */
    private int oneDiceThrow() {	
       return ((int) (Math.random()*10000) % 6)+ 1; 
    }
    /** result of a 2d6 throw 
      * @return random result of a 2d6 thow
    */ 	
    public int twoDicesThrow() {
        int result = oneDiceThrow() + oneDiceThrow();
        System.out.print(this.name+" throws "+result+",");	
        return result;
    }
}// Player
