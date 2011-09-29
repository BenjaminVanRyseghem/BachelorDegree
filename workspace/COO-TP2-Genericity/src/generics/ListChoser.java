package generics;


import scanner.*;

import java.util.*;

public class ListChoser {

    // Definir la methode chose, qui prend en premier parametre 
    // un message sous forme de chaine de caracteres et en second une liste.
    // Cette liste est typee mais sans restriction sur les types admis.
    // Cette methode propose de choisir un element de la liste en saisissant
    // sa position dans la liste.
    // L'element choisi est retourne par la methode, null si le choix 0 est fait.
    //

	protected static String trim(String string, int length, char with){
		if (string.length() >= length ) return string;
		String result = string;
		for(int i = string.length(); i< length; i++){
			result = with+result;
		}
		return result;
	}
	
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
	
	protected <E> E chose(String title, List<E> list){
		
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
	// JEU DE TEST

	List<Carotte> lCarottes = new ArrayList<Carotte>();
	lCarottes.add(new Carotte(1));
	lCarottes.add(new Carotte(2));
	lCarottes.add(new Carotte(3));
//	lCarottes.add(new Carotte(4));
//	lCarottes.add(new Carotte(5));
//	lCarottes.add(new Carotte(6));
//	lCarottes.add(new Carotte(7));
//	lCarottes.add(new Carotte(8));
//	lCarottes.add(new Carotte(9));
//	lCarottes.add(new Carotte(10));
	
	List<Pomme> lPommes = new ArrayList<Pomme>();
	lPommes.add(new Pomme(1));
	lPommes.add(new Pomme(2));
	lPommes.add(new Pomme(3));

	ListChoser lc = new ListChoser();

	Carotte choixCarotte = lc.chose("quelle carotte ? ",lCarottes);
	System.out.println("vous avez choisi : "+choixCarotte);

	Pomme choixPomme = lc.chose("quelle pomme ? ",lPommes);
	System.out.println("vous avez choisi : "+choixPomme);

	// NE COMPILE PAS 
	// Pomme choixPomme2 = lc.chose("probleme ",lCarottes);
    	
    }
}
