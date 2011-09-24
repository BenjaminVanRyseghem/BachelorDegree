
package telephonie;


public class ModeDePaiementInvalideException extends Exception {
	static final long serialVersionUID = 12345678;

	public ModeDePaiementInvalideException(){
		System.out.println("Invalid Paiment Mode");
	}
}
