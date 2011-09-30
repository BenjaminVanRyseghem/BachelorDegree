package scanner;

import java.util.*;
import java.util.regex.*;


public class TestScanner 
{
    private static Scanner scanner = new Scanner(System.in);

    /** permet la saisie d'un entier en 0 (inclus)  et n (exclu)
     * la demande saisie se repete tant qu'elle n'est pas correcte
     * @param la borne sup autorisee
     * @return la saisie (valide) realisee
     */
    public static int saisieEntier(int n)
	{
		int saisie = -1;
		//	scanner.skip(".*"); // "vide" le scanner
		while (saisie < 0 || saisie >= n) 
		{
			try {
				System.out.print("choix (0-"+(n-1)+") ");
				saisie = scanner.nextInt();
			} 
			catch (InputMismatchException e) 
			{
				// il faut ignorer ce qui n'est pas un entier
				scanner.skip(".*");
			} 
			catch (Exception e) { // bof
				e.printStackTrace();
			}
		}
		return saisie;
    }

    public static void main(String[] args) 
	{
		System.out.print("Saisie d'un entier entre 0 et 5 : ");
		int j = TestScanner.saisieEntier(6);
		System.out.println("vous avez saisi : "+j);
    }
}
