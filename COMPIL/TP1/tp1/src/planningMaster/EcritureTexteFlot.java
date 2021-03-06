package planningMaster;

import java.io.PrintStream;
import java.io.OutputStream;

/** Écrit dans un flot de sortie. */
public class EcritureTexteFlot implements EcritureTexte {
    
    private PrintStream output;

    /** Pour créér un EcritureTexteFlot à partir d'un nom de fichier,
	passer en paramètre du constructeur un <tt>new
	java.io.FileOutputStream(mon_nom_fichier)</tt>.
    */
    public EcritureTexteFlot(OutputStream output) {
	this.output = new PrintStream(output);
    }

    /** Écrit dans le flot. */
    public void ecrire(String donnee) {
	this.output.print(donnee);
    }

    /** Ferme le flot. */
    public void terminer() {
	this.output.close();
    }
    
}