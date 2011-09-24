package planningMaster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/** Lit les lignes dans un flot d'entrée. */
public class LectureLigneFlot implements LectureLigne {

    private BufferedReader inputStream;

    public LectureLigneFlot(InputStream in) {
	this.inputStream = new BufferedReader(new InputStreamReader(in));	
    }

    public String lireLigne() throws IOException {
    	return this.inputStream.readLine();
    }
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
    	FileInputStream input = new FileInputStream("/Users/benjamin/Scholarship/COMPIL/TP1/tp1/test/exemple.dsl");
    	LectureLigneFlot lecteur = new LectureLigneFlot(input);
    	System.out.println(lecteur.lireLigne());
    	System.out.println(lecteur.lireLigne());
    	System.out.println(lecteur.lireLigne());
    }
}