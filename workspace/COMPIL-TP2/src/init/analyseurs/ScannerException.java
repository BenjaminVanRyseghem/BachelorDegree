package init.analyseurs;

public class ScannerException extends Exception {

    public ScannerException() {
	super("Pb pdt l'analyse lexicale ");
    }
    
    public ScannerException(String message) {
	super("Pb pdt l'analyse lexicale : " + message);
    }

}
