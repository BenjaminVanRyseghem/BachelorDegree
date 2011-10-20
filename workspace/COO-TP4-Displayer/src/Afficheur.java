import java.util.Observable;



public class Afficheur extends Observable{
	
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			Afficheur test = new Afficheur(5, "Benjamin", " ");
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
			System.out.println(test);
			test.decale();
				
		}
	
		/**
		 * @uml.property  name="ecran"
		 */
		private FileFIFO<String> ecran;
	
		/** 
		 * Getter of the property <tt>file</tt>
		 * @return  Returns the file.
		 * @uml.property  name="ecran"
		 */
		public FileFIFO<String> getEcran() {
			return ecran;
		}
		
		/**
		 * Setter of the property <tt>message</tt>
		 * @param message  The message to set.
		 * @uml.property  name="message"
		 */
		public void setMessage(String message){
			this.message = message;
			index = 0;
		}

		/**
		 * @uml.property  name="message"
		 */
		private String message;

		/**
		 * Getter of the property <tt>message</tt>
		 * @return  Returns the message.
		 * @uml.property  name="message"
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @uml.property  name="index"
		 */
		private int index = 0;

		/**
		 * Getter of the property <tt>index</tt>
		 * @return  Returns the index.
		 * @uml.property  name="index"
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * Setter of the property <tt>index</tt>
		 * @param index  The index to set.
		 * @uml.property  name="index"
		 */
		public void setIndex(int index) {
			this.index = index;
		}

			
		/**
		 */
		public Afficheur(int largeur, String message, String defaultValue){
			this.setMessage(message);
			ecran = new FileFIFO<String>(largeur, defaultValue);
		}

		
		/**
		 */
		public void decale(){
			ecran.ajoute(""+message.charAt(index));
			index = (index+1)%message.length();
			this.setChanged();
			this.notifyObservers();
		}

		
		/**
		 */
		public String toString(){
			return ecran.toString(); 
		}


		
}
