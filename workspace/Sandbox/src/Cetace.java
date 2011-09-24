
public class Cetace extends Animal {
	
	
	static {
		
	}
	
	public int nbPattes = 2;
	/**
	 * @param args
	 */
	
	public boolean test(){
		return super.equals(this);
	}
	
	public static void main(String[] args) {
		Cetace t1 = new Cetace();
		Animal t2 = new Cetace();
		Animal t3 = new Animal();
		
		System.out.println("t1.getNbPattesChildren() = " + t1.getNbPattesChildren());
		System.out.println("t2.getNbPattes() = " + t2.getNbPattes());
		System.out.println("t1.nbPattes = " + t1.nbPattes);
		System.out.println("t2.nbPattes = " + t2.nbPattes);
		System.out.println("t3.getNbPattes() = " + t3.getNbPattes());
		
		System.out.println("t1.getSuperNbPattes() = " + t1.getSuperNbPattes());
		
		System.out.println("t1.getNbPattes() = " + t1.getNbPattes());
		System.out.println(t1.test());
	}
	
	public int getNbPattes() {
		return nbPattes;
	}
	
	public int getNbPattesChildren() {
		return nbPattes;
	}
	
	public int getSuperNbPattes() {
		return super.nbPattes;
	}
	
	public void setNbPattes(int nbPattes) {
		this.nbPattes = nbPattes;
	}
}
