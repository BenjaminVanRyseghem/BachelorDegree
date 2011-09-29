package generics;

public class ChouxFleur implements Legume, Cloneable {
    private String name;
    private static final String DEFAULT = "ChouxFleur";

    public ChouxFleur (int i) {
	this.name = DEFAULT+"-"+i;
    }

    public String toString() { 
	return this.name;
    }

}
