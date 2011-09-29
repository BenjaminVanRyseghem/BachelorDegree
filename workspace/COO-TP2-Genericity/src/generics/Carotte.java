package generics;


public class Carotte implements Legume, Cloneable {
    private String name;
    private static final String DEFAULT = "Carotte";

    public Carotte (int i) {
	this.name = DEFAULT+"-"+i;
    }

    public String toString() { 
	return this.name;
    }

}
