
public class Latence extends Afficheur {

	protected int tempsDeLatence = 0;
	protected char separator = ' ';
	
	
	public Latence (int l , int tempsDeLatence){
		super(l);
		this.tempsDeLatence = tempsDeLatence;
	}
	
	public void decale() {
		
		if (this.index < this.message.length()){
			this.ecran.addElement(message.charAt(index));
			index ++;
		}
		else{
			if(this.index < this.message.length()+this.tempsDeLatence){
				this.ecran.addElement(this.separator);
				index++;
			}
			else{
				index = 0;
			}
		}
	}
}
