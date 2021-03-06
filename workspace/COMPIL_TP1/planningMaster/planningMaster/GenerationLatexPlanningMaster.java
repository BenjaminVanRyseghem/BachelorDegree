/* ***************************************
 * 
 * 	Benjamin Van Ryseghem
 * 
 * 
 * 
 ************************************** */




package planningMaster;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Generateur de planning format latex. */
public class GenerationLatexPlanningMaster {
    
	private static final String espace = "\\s+";
	private static final String espaces = "\\s*";
	private static final String mot = "\\S+";
	private static final String annee = "\\d{4}";
	private static final String jour = "([12]?\\d|30|31)";
	private static final String heure = "(\\d|1\\d|20|21|22|23|24)";
	private static final String minute = "([0-5]?\\d|60)";
	private static final String heureAndMinute = heure+"h"+minute;
	private static final String nom = "[A-z][a-z]*";
	private static final String phrase= mot+"("+mot+"|\\s|\\p{Punct})*";
	private static final String options = phrase + "(?:,"+espace+phrase+")*";
	
    // lit le planning ligne par ligne
    private LectureLigne lecteurDeLigne;
    // ecrit le planning Latex
    private EcritureTexte ecrivainLatex;
    protected String masterName, date, room;
    protected Pattern masterNamePattern, datePattern, roomPattern, descriptionPattern, emptyStringPattern, petitePausePattern, grandePausePattern;
    
    
    
    /* *************************************************
     * 
     * 				MOT CLES DU DSL
     * 
     ************************************************ */
    
    protected String masterString = "master";
    protected String dateString = "date";
    protected String salleString = "salle";
    protected String separatorString = ";";
    protected String petitePauseString = "petitePause";
    protected String grandePauseString = "grandePause";
    
    protected ArrayList<String> fileNames = new ArrayList<String>();
    
    
   

    /** Seule "l'entree" est fournie au generateur a la construction.
     * "La sortie" doit etre calculee par le generateur : il doit
     * determiner le nom du fichier Latex.
     */
    public GenerationLatexPlanningMaster(LectureLigne in) {
    	this.lecteurDeLigne = in;
		masterNamePattern = Pattern.compile(masterString+espace+"("+mot+")"+espaces);
		datePattern = Pattern.compile(dateString+espace+"("+jour+espace+mot+espace+annee+")"+espaces);
	    roomPattern = Pattern.compile(salleString+"\\s+([A-Z]\\d{2})");
	    descriptionPattern = Pattern.compile(espaces+"("+heureAndMinute+")-("+heureAndMinute+")"+espace+separatorString+espace+"(("+nom+espace+")+"+nom+")?"+espaces+separatorString+espace+"("+mot+"(\\s+\\p{L}+)*)?"+espaces+separatorString+espaces+"("+options+")?"+espaces);
	    emptyStringPattern = Pattern.compile(espaces);
	    petitePausePattern = Pattern.compile(espaces+petitePauseString+espaces);
	    grandePausePattern = Pattern.compile(espaces+grandePauseString+espaces);
    }

    /** Fixe l'objet ds lequel ecrire. */
    public void setOutput(EcritureTexte out) {
    	this.ecrivainLatex = out;
    }

    /** Retourne la prochaine ligne lue. */
    public String lireLigne() throws IOException {
		return this.lecteurDeLigne.lireLigne();
    }

    /** Ecrit la chaîne ds le latex genere. */
    public void ecrire(String s) {
    	this.ecrivainLatex.ecrire(s);
    }


    protected void extractInformationFrom(String ligne) throws ErreurFormatException{
    	Matcher matcher;
    	
    	matcher = emptyStringPattern.matcher(ligne);
    	if(matcher.matches()){
    		// line is full of spaces
    		return;	
    	}
    	matcher = masterNamePattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the master's name
    		this.setMasterName(matcher.group(1));
    		return;	
    	}
    	
    	matcher = datePattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the date of the presentation
    		this.setDate(matcher.group(1));
    		return;	
    	}
    	matcher = roomPattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the date of the presentation
    		this.setRoom(matcher.group(1));
    		return;	
    	}
    	
    	matcher = descriptionPattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the date of the presentation
    		if(this.ecrivainLatex != null){
    			this.ecrireLigneTableau(matcher.group(1), matcher.group(4), matcher.group(7), matcher.group(9) ,matcher.group(11));
        		return;
    		}
    		else{
	    		throw new ErreurFormatException("Error while parsing "+ligne+"\nThis line should appear only when the master name, the date and the room are already defined");
	    	}
    	}
    	
    	matcher = petitePausePattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the date of the presentation
    		if(this.ecrivainLatex != null){
    			this.ecrivainLatex.ecrire(ConstantesLatex.PETITE_PAUSE);
        		return;
    		}
    		else{
	    		throw new ErreurFormatException("Error while parsing "+ligne+"\nThis line should appear only when the master name, the date and the room are already defined");
	    	}
    	}
    	
    	matcher = grandePausePattern.matcher(ligne);
    	if(matcher.matches()){
    		// line which define the date of the presentation
    		if(this.ecrivainLatex != null){
    			this.ecrivainLatex.ecrire(ConstantesLatex.GRANDE_PAUSE);
        		return;
    		}
    		else{
	    		throw new ErreurFormatException("Error while parsing "+ligne+"\nThis line should appear only when the master name, the date and the room are already defined");
	    	}
    	}

		throw new ErreurFormatException("Error while parsing "+ligne+"\nThis line does't match any reg ex of the format");
    	
    }
        
    protected void setMasterName(String masterName) {
		if(this.masterName != null){
			//another file needed
			try {
				this.finDuFichier(false);
			} catch (ErreurFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.date=null;
			this.room=null;
		}
    	this.masterName = masterName;
		
		
	}

	protected void setDate(String date) {
		if(this.date != null){
			//another file needed
			try {
				this.finDuFichier(false);
			} catch (ErreurFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.masterName=null;
			this.room=null;
		}
		this.date = date;
	}

	protected void setRoom(String room) {
		if(this.room != null){
			//another file needed
			try {
				this.finDuFichier(false);
			} catch (ErreurFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.masterName=null;
			this.date=null;
		}
		this.room = room;
	}

	protected void ecrireLigneTableau(String begHour, String endHour, String name, String company, String topic){
  		String result = "	"+ begHour + "-" + endHour + ConstantesLatex.SEPARATEUR_CASE + (name==null?"":name) + ConstantesLatex.SEPARATEUR_CASE + (company==null?"":company) + ConstantesLatex.SEPARATEUR_CASE + (topic==null?"":topic) +ConstantesLatex.FIN_LIGNE_TABLEAU;
		this.ecrivainLatex.ecrire(result);    	
    }
    
    protected String buildFileName(){
    	return this.masterName+"_"+this.date.replace(' ', '_')+"_"+this.room+".tex";
    }
    
    protected String buildBeginOfDocument(){
    	String result = "";
    	result += ConstantesLatex.DEBUT_COMMANDE_MASTER+this.masterName+ConstantesLatex.FIN_COMMANDE;
    	result += ConstantesLatex.DEBUT_COMMANDE_DATE+this.date+ConstantesLatex.FIN_COMMANDE;
    	result += ConstantesLatex.DEBUT_COMMANDE_SALLE+this.room+ConstantesLatex.FIN_COMMANDE;
    	result += ConstantesLatex.DEFINITION_TITRE;
    	result += ConstantesLatex.DEBUT_TABLEAU;
    	return result;
    }
    
    protected void writeBeginOfDocument(){
    	if (this.ecrivainLatex != null){
    		this.ecrivainLatex.ecrire(ConstantesLatex.DEBUT_DOCUMENT);
    		this.ecrivainLatex.ecrire(this.buildBeginOfDocument());
    	}
    }
    
    
    /**  Genere le code Latex pour un planning. 
     * @param ligneLue la derniere ligne lue.
    */
    public void genererUnPlanning(String ligneLue) throws IOException, ErreurFormatException {
    	this.extractInformationFrom(ligneLue);
    	if ( this.ecrivainLatex == null && masterName != null && date != null && room != null ){
    		String fileName = this.buildFileName();
    		FileOutputStream stream = new FileOutputStream(fileName);
    		fileNames.add(fileName);
    		EcritureTexte output = new EcritureTexteFlot(stream);
    		this.setOutput(output);
    		this.writeBeginOfDocument();
    	}
    }
    
    
    protected void writeEndOfFile() throws ErreurFormatException{
    	if (this.ecrivainLatex != null){
    		String result = ConstantesLatex.FIN_TABLEAU;
    		result += ConstantesLatex.FIN_DOCUMENT;
    		this.ecrivainLatex.ecrire(result);
    	}
    	else{
    		throw new ErreurFormatException("End of file appears too soon");
    	}
    }
    
    public void finDuFichier(boolean endOfProcess) throws ErreurFormatException{
    	this.writeEndOfFile();
    	this.ecrivainLatex.terminer();
    	this.setOutput(null);
    	if(!endOfProcess){ return;}
		
    	// generate pdf files
		Runtime rt = Runtime.getRuntime();
		for (String name : fileNames){	
			try {
				rt.exec("/usr/texbin/pdflatex "+name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
    
    public static void main (String args[])throws IOException, ErreurFormatException{
    	
    	/*
    	master TIIR
    	date 8 septembre 2011
    	salle A40*/
    	System.out.println("  ".isEmpty());
    	
    	String ligne;
    	GenerationLatexPlanningMaster test = new GenerationLatexPlanningMaster (null);
    	ligne = "master TIIR";
    	test.genererUnPlanning(ligne);
    	ligne = "date 8 septembre 2011";
    	test.genererUnPlanning(ligne);
    	ligne = "salle A40";
    	test.genererUnPlanning(ligne);
    	ligne = "10h45-11h30 ; El Amrani Hassan ; Credit Cooperatif ; huis-close";
    	test.genererUnPlanning(ligne);
    	
/*		Pattern datePattern = Pattern.compile("([12]?\\d|30|31)");
    	Matcher matcher;
    	matcher = datePattern.matcher("|1");
    	System.out.println(matcher.matches());*/
    }
}