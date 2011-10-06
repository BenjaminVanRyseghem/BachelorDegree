package planningMaster.testeurs;

import planningMaster.analyseurs.*;

import java.io.*; 
import java_cup.runtime.Symbol;

/** Classe de test (fichiers de test positifs) pour l'analyseur
 * lexical Planning.
 * @author M. Nebut 08/07 revu 09/09
 */
public class TesteurPositifAnalyseurLexical {

    public static void main(String[] args) throws Exception {
	
	if (args.length != 1)
            System.out.println("Attention: un fichier est attendu.");
	new TesteurPositifAnalyseurLexical().run(args);

    }

    public void run(String[] args) throws Exception {
	Reader flotLecture = obtenirFlotDepuisFichierOuEntreeStandard(args);
	ScannerPlanning scanner = construireAnalyseurLexical(flotLecture);
	try {
	    avalerSymbolesFournisParScanner(scanner);
	    indiquerVerdictPositif();
	} catch (Exception e) {
	    indiquerVerdictNegatif(e);
	}
    }


    private Reader obtenirFlotDepuisFichierOuEntreeStandard 
	(String[] argsLigneCommande) 
	throws FileNotFoundException {

	return new FileReader(argsLigneCommande[0]);
    }

    private ScannerPlanning construireAnalyseurLexical(Reader flot) {
	return new ScannerPlanning(flot);		
    }    

    private void avalerSymbolesFournisParScanner(ScannerPlanning scanner) throws Exception {
	boolean finAnalyse = false;
	Symbol symboleCourant = null;
	do {
	    symboleCourant = obtenirProchainSymbole(scanner);
	    finAnalyse = (symboleCourant.sym == TypeSymboles.EOF);
	} while (! finAnalyse);
    }

    private Symbol obtenirProchainSymbole(ScannerPlanning scanner) throws Exception {
	return scanner.next_token();
    }

    private void indiquerVerdictPositif() {
	System.out.println("Test positif OK");
    }

    private void indiquerVerdictNegatif(Exception e) {
	System.out.println("Test positif KO");
	e.printStackTrace();
    }
        
}