package generics;

public class Pomme implements Fruit 
{
    private String name;
    private static final String DEFAULT = "Pomme";

    public Pomme (int i) 
    {
    	this.name = DEFAULT+"-"+i;
    }

    public String toString()
    { 
    	return this.name;
    }

}
