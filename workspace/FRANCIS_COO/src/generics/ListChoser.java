package generics;

import scanner.*;
import java.util.*;

public class ListChoser
{

    // Definir la methode chose, qui prend en premier parametre 
    // un message sous forme de chaine de caracteres et en second une liste.
    // Cette liste est typee mais sans restriction sur les types admis.
    // Cette methode propose de choisir un element de la liste en saisissant
    // sa position dans la liste.
    // L'element choisi est retourne par la methode, null si le choix 0 est fait.
    //
    // ...methode chose...
    // 
	public <E> E chose(String mes,List<E> list)
	{
		int numElem;
		System.out.println("0 = aucun");
		for (int i = 0; i< list.size();i++)
		{
			System.out.println(list.get(i).toString());
		}

		System.out.println(mes);
		numElem = TestScanner.saisieEntier(list.size()+1);
		
		if (numElem == 0)
		{
			return null;
		}
		else
		{
			return list.get(numElem-1);
		}
	}
    
    public static void main(String[] args) 
    {
		// JEU DE TEST

		List<Carotte> lCarottes = new ArrayList<Carotte>();
		lCarottes.add(new Carotte(1));
		lCarottes.add(new Carotte(2));
		lCarottes.add(new Carotte(3));

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
		//Pomme choixPomme2 = lc.chose("probleme ",lCarottes);
    }
}
