package piscine;

import action.Scheduler;

public class Piscine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GestionnaireDePaniers paniers = new GestionnaireDePaniers(6) ;
	    GestionnaireDeCabines cabines = new GestionnaireDeCabines(3) ;
	    Scheduler s = new Scheduler() ;  
	    s.add(new Nageur("Jean" ,    paniers , cabines , 6  , 4  , 8)) ;
	    s.add(new Nageur("Paul" ,    paniers , cabines , 2  , 10 , 4)) ;
	    s.add(new Nageur("Bruno" ,   paniers , cabines , 10 , 18 , 10)) ;
	    s.add(new Nageur("Marcel" ,  paniers , cabines , 3  , 7  , 5)) ;
	    s.add(new Nageur("Anatole" , paniers , cabines , 18 , 3  , 3)) ;
	    s.add(new Nageur("Clement" , paniers , cabines , 3  , 6  , 10)) ;
	    s.add(new Nageur("Desire" ,  paniers , cabines , 6  , 5  , 7)) ;
	    while (! s.isOver()) s.step() ;
	}

}
