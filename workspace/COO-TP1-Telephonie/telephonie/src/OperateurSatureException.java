
package telephonie;


public class OperateurSatureException extends Exception {
	static final long serialVersionUID = 28764876;
	
	public OperateurSatureException(){
		System.out.println("Operator saturated");
	}
}
