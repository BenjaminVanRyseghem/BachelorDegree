package planningMaster.testeurs;

import planningMaster.analyseurs.*;

import java.io.*; 
import java_cup.runtime.Symbol;

/** Classe de test (test positifs) pour 
 * l'analyseur syntaxique. 
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
	ScannerPlanning scanner = construireAnalyseurLexical(flotLecture);
	ParserPlanning parser = new ParserPlanning(scanner);
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

    private ScannerPlanning construireAnalyseurLexical(Reader flot) {
	return new ScannerPlanning(flot);		
    }    

    private void indiquerVerdictPositif() {
	System.out.println("Test positif OK");
    }

    private void indiquerVerdictNegatif(Exception e) {
	System.out.println("Test positif KO");
	e.printStackTrace();
    }


}