package planningMaster;

import java.io.IOException;

/** Generateur de planning format latex. */
public class GenerationLatexPlanningMaster {
    
    // lit le planning ligne par ligne
    private LectureLigne lecteurDeLigne;
    // ecrit le planning Latex
    private EcritureTexte ecrivainLatex;

    /** Seule "l'entree" est fournie au generateur a la construction.
     * "La sortie" doit etre calculee par le generateur : il doit
     * determiner le nom du fichier Latex.
     */
    public GenerationLatexPlanningMaster(LectureLigne in) {
	this.lecteurDeLigne = in;
    }

    /** Fixe l'objet ds lequel ecrire. */
    public void setOutput(EcritureTexte out) {
	this.ecrivainLatex = out;
    }

    /** Retourne la prochaine ligne lue. */
    public String lireLigne() throws IOException {
	return this.lecteurDeLigne.lireLigne();
    }

    /** Ecrit la chaîne ds le latex genere. */
    public void ecrire(String s) {
	this.ecrivainLatex.ecrire(s);
    }


    /**  Genere le code Latex pour un planning. 
     * @param ligneLue la derniere ligne lue.
    */
    public void genererUnPlanning(String ligneLue) throws IOException, ErreurFormatException {
    // A COMPLETER
    }

}
