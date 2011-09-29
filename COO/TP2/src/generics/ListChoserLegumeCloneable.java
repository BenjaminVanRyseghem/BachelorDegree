package generics;

import scanner.*;
import java.util.*;

public class ListChoserLegumeCloneable {

    
    // methode chose
    // elle est similaire a celles de ListChoser et ListChoserLegume
    // simplement elle ne fonctionne qu'avec des listes d'objets de type Legume 
    // qui de plus sont clonables.
    // quel changement apporter a la methode de ListChoser  ?
    
    
    public static void main(String[] args) {
	List<Carotte> lCarottes = new ArrayList<Carotte>();
	lCarottes.add(new Carotte(1));
	lCarottes.add(new Carotte(2));
	lCarottes.add(new Carotte(3));

	List<ChouxFleur> lChouxFleurs = new LinkedList<ChouxFleur>();
	lChouxFleurs.add(new ChouxFleur(1));
	lChouxFleurs.add(new ChouxFleur(2));
	lChouxFleurs.add(new ChouxFleur(3));

	ListChoserLegumeCloneable lclc = new ListChoserLegumeCloneable();

	Carotte choixCarotte = lclc.chose("quelle carotte ? ",lCarottes);
	System.out.println("vous avez choisi : "+choixCarotte);

	ChouxFleur choixChouxFleur = lclc.chose("quelle choux-fleur ? ",lChouxFleurs);
	System.out.println("vous avez choisi : "+choixChouxFleur);

	

	List<Rutabaga> lRutabagas = new ArrayList<Rutabaga>();
	lRutabagas.add(new Rutabaga(1));
	lRutabagas.add(new Rutabaga(2));
	lRutabagas.add(new Rutabaga(3));
	// NE COMPILE PAS :
	// Rutabaga choixRutabaga = lc.chose("quel rutabaga ? ",lRutabagas);

	List<Pomme> lPommes = new ArrayList<Pomme>();
	lPommes.add(new Pomme(1));
	// NE COMPILE PAS :  
	// Pomme choixPomme = lclc.chose("quelle pomme ? ",lPommes);

    }
}
