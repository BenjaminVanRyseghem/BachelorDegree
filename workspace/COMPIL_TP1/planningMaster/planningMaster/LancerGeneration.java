package planningMaster;

import java.io.FileInputStream;

public class LancerGeneration {

    public static void main(String[] args) {

	try {
		String ligne;
	    FileInputStream input = new FileInputStream(args[0]);
	    LectureLigne entree = new LectureLigneFlot(input);
	    GenerationLatexPlanningMaster generation = new GenerationLatexPlanningMaster(entree);
	    while( (ligne = generation.lireLigne()) != null){
	    	generation.genererUnPlanning(ligne);
	    }
	    generation.finDuFichier(true);
	} catch (java.io.FileNotFoundException e) {
	    System.out.println("fichier introuvable");
	} catch (java.io.IOException e) {
	    System.out.println("erreur ES");
	} catch (ErreurFormatException e) {
	    System.out.println(e.getMessage());
	};
    }
}