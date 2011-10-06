package init.testeurs;

import init.analyseurs.*;

import java.io.*; 
import java_cup.runtime.Symbol;

/** Classe de test (test negatifs) pour 
 * l'analyseur syntaxique Init. 
 * @author M. Nebut 08/07 revu 09/09
 */
public class TesteurNegatifAnalyseurSyntaxique {

    public static void main(String[] args) throws Exception {	
	if (args.length != 1)
            System.out.println("Attention: un fichier est attendu.");
	new TesteurNegatifAnalyseurSyntaxique().run(args);
    }
    
    public void run(String[] args) throws Exception {
	Reader flotLecture = obtenirFlotDepuisFichierOuEntreeStandard(args);
	ScannerInit scanner = construireAnalyseurLexical(flotLecture);
	ParserInit parser = new ParserInit(scanner);
	try {
	    parser.parse();
	    indiquerVerdictNegatif();
	} catch (ParserException e) {
	    indiquerVerdictPositif();
	}
    }

    private Reader obtenirFlotDepuisFichierOuEntreeStandard (String[] argsLigneCommande) 
	throws FileNotFoundException {

	if (argsLigneCommande.length == 0)
	    return new InputStreamReader(System.in);
	return new FileReader(argsLigneCommande[0]);
    }

    private ScannerInit construireAnalyseurLexical(Reader flot) {
	return new ScannerInit(flot);		
    }    

       private void indiquerVerdictPositif() {
	System.out.println("Test negatif OK");
    }

    private void indiquerVerdictNegatif() {
	System.out.println("Test negatif KO, flot d'entrée accepté");
    }
}