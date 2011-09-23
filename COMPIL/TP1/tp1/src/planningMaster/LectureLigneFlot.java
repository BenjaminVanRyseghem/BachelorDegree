package planningMaster;

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
}