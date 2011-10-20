

public class FileFIFO<E> {
	
		/**
		 * @uml.property  name="largeur"
		 */
		private final int largeur;
		private int headIndex = 0;
	
	
		/**
		 * Getter of the property <tt>largeur</tt>
		 * @return  Returns the largeur.
		 * @uml.property  name="largeur"
		 */
		public int getLargeur(){
			return largeur;
		}
			
		/**
		 */
		public void raz(E defaultValue){
			for (int i = 0; i<largeur; i++){
				elements[i] = defaultValue;
			}
		}
		
			
		/**
		 */
		public String toString(){
			String result = "";
			int i = headIndex;
			
			do{
				result += elements[i];
				i = (i + 1) % largeur;
			}
			while(i != headIndex);
			return result;
		}
		
		
		protected void incrementIndex(){
			headIndex = (headIndex + 1) % largeur;
		}
			
		/**
	 	*/
		public E ajoute(E newElement){
			E result = elements[headIndex];
			elements[headIndex] = newElement;
			this.incrementIndex();
			return result;
		}
	
	
		/**
		 * @uml.property  name="elements"
		 */
		private E[] elements;
	
		/** 
		 * Getter of the property <tt>element</tt>
		 * @return  Returns the element.
		 * @uml.property  name="elements"
		 */
		public E[] getElements() {
			return elements;
		}
		
		/**
		 */
		public FileFIFO(int largeur, E defaultValue){
			this.largeur = largeur;
			elements = ((E[])new Object[largeur]);
			this.raz(defaultValue);
		}
		
		public static void main(String[] args) {
			FileFIFO<String> file = new FileFIFO<String>(5,"X");
			System.out.println(file);
			file.ajoute("B");
			System.out.println(file);
			file.ajoute("e");
			System.out.println(file);
			file.ajoute("n");
			System.out.println(file);
			file.ajoute("j");
			System.out.println(file);
			file.ajoute("a");
			System.out.println(file);
			file.ajoute("m");
			System.out.println(file);
			file.ajoute("i");
			System.out.println(file);
			file.ajoute("n");
			System.out.println(file);
		}
}
