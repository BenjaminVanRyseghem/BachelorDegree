
package telephonie;


public class PasDeConnexionException extends Exception {
	static final long serialVersionUID = 52348;

	public PasDeConnexionException(){
		System.out.println("No such connection");
	}
}
