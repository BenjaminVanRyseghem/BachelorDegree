package init.testeurs;

import init.analyseurs.*;

import java.io.*; 
import java_cup.runtime.Symbol;

/** Classe de test (test positifs) pour 
 * l'analyseur syntaxique Init. 
 * @author M. Nebut 08/07 revu 09/09
 */
public class TesteurPositifAnalyseurSyntaxique {

    public static void main(String[] args) throws Exception {	
	if (args.length != 1)
            System.out.println("Attention: un fichier est attendu.");
	new TesteurPositifAnalyseurSyntaxique().run(args);
    }

    public void run(String[] args) throws Exception {
	Reader flotLecture = obtenirFlotDepuisFichierOuEntreeStandard(args);
	ScannerInit scanner = construireAnalyseurLexical(flotLecture);
	ParserInit parser = new ParserInit(scanner);
	try {
	    parser.parse();
	    indiquerVerdictPositif();
	} catch (Exception e) {
	    indiquerVerdictNegatif(e);
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
	System.out.println("Test positif OK");
    }

    private void indiquerVerdictNegatif(Exception e) {
	System.out.println("Test positif KO");
	e.printStackTrace();
    }


}