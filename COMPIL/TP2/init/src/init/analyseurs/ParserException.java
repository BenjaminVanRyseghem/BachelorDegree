package init.analyseurs;

public class ParserException extends Exception {

    public ParserException() {
	super("Pb pdt l'analyse syntaxique ");
    }
    
    public ParserException(String message) {
	super("Pb pdt l'analyse syntaxique : " + message);
    }

}
