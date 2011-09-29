package generics;

import scanner.*;

import java.util.*;

public class ListChoserLegumeCloneable {

    
    // methode chose
    // elle est similaire a celles de ListChoser et ListChoserLegume
    // simplement elle ne fonctionne qu'avec des listes d'objets de type Legume 
    // qui de plus sont clonables.
    // quel changement apporter a la methode de ListChoser  ?
    
	protected <E> void displayList(List<E> list){
		int index = 0;
		int size = (list.size()/10)+1;
		
		System.out.print(ListChoser.trim( "0", size, '0'));
		System.out.println("  --  none");
		index ++;
		
		for(E elt : list){
			System.out.print(ListChoser.trim( ""+index, size, '0'));
			System.out.print("  --  ");
			System.out.println(elt.toString());
			index ++;
		}
	}
	
	protected int collectAnswer(int max){
		return TestScanner.saisieEntier(max);
	}
	
	protected <E extends Legume & Cloneable> E chose(String title, List<E> list){
		
		int index;
		// First the title
		System.out.println(title);
		// Then the whole list
		this.displayList(list);
		// And then I wait for answer
		index = this.collectAnswer(list.size()+1);
		
		// FInally I return the value
		if (index == 0) return null;
		return list.get(index - 1);
	}
    
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
