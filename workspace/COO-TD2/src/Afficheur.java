import java.util.*;

public class Afficheur {
	protected FileFIFO<Character> ecran;
	protected String message="";
	protected int index=0;

	
	public Afficheur(int largeur){
		ecran = new FileFIFO<Character>(largeur, ' ');
	}
// fixe un nouveau message a afficher 
	public void setMessage(String message) {
		index = 0;
		this.message = message;
	}
// appele a chaque top d�horloge, decale le message vers la gauche de l�ecran 
	public void decale() {
		ecran.addElement(message.charAt(index));
		this.incrementIndex();
	}
	
	public void incrementIndex(){
		index = (index+1)%this.message.length();
	}
	
// renvoie ce qui apparait a l�ecran (ce qui est affiche) 
	public String toString(){
		return this.ecran.toString();
	}

	protected class FileFIFO<E> {
		List<E> internalList;
		int indiceTete;
		int longueur;

		public FileFIFO(int longueur, E defaultValue){
			this.longueur = longueur;
			this.raz(defaultValue);
		}
		public E addElement(E elt){
			E result;
			result = internalList.set(indiceTete,elt);
			this.incrementIndiceTete();
			return result;
		}
		
		public void raz(E defaultValue){
			for (int i=0;i<longueur;i++){
				internalList.set(i,defaultValue);
			}
		}
		
		public void incrementIndiceTete(){
			this.indiceTete = this.indiceTete + 1 % this.longueur;
		}
	}
}