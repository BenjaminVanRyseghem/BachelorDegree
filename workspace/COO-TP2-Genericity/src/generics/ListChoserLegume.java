package generics;



import java.util.*;

import scanner.TestScanner;

public class ListChoserLegume{

    // methode chose
    // elle est similaire a celle de ListChoser simplement elle ne fonctionne
    // qu'avec des listes d'objets de type Legume (cf. interface Legume)
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
	
	protected <E extends Legume> E chose(String title, List<E> list){
		
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
    // 
	
    public static void main(String[] args) {
	List<Carotte> lCarottes = new ArrayList<Carotte>();
	lCarottes.add(new Carotte(1));
	lCarottes.add(new Carotte(2));
	lCarottes.add(new Carotte(3));

	List<Pomme> lPommes = new ArrayList<Pomme>();
	lPommes.add(new Pomme(1));
	lPommes.add(new Pomme(2));
	lPommes.add(new Pomme(3));
	
	ListChoserLegume lcl = new ListChoserLegume();

	// NE COMPILE PAS :  
	Carotte choixCarotte = lcl.chose("quelle carotte ? ",lCarottes);
	System.out.println("vous avez choisi : "+choixCarotte);

	// NE COMPILE PAS :  
	// Pomme choixPomme = lcl.chose("quelle pomme ? ",lPommes);
	

    }
}
