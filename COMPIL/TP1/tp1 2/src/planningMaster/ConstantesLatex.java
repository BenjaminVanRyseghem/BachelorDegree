package planningMaster;

public class ConstantesLatex {

    public static final String DEBUT_DOCUMENT = 
	"\\documentclass{article}\n"+
	"\\usepackage[frenchb]{babel}\n"+
	"\\usepackage[utf8]{inputenc}\n"+
	"\\usepackage[landscape]{geometry}\n\n";

    public static final  String FIN_DOCUMENT = "\\end{document}";

    public static final  String DEBUT_TABLEAU = "\\hspace*{-3cm}\\begin{tabular}[t]{|l|l|l|l|}\\hline\n";
    public static final  String FIN_TABLEAU = "\\end{tabular}\n";
    public static final  String SEPARATEUR_CASE = "&";
    public static final  String FIN_LIGNE_TABLEAU = "\\\\ \\hline\n";

    public static final String DEFINITION_TITRE = "\\title{\\huge Soutenances des master2}\n" 
	+ "\\author{\\Huge \\lemaster}\n" 
	+ "\\date{\\huge \\ladate - \\lasalle}\n\n" 
	+ "\\begin{document}\n\n"
	+ "\\maketitle\n"
	+ "\\pagestyle{empty}\n"
	+ "\\Large\n\n";

    public static final String DEBUT_COMMANDE_MASTER = "\\newcommand{\\lemaster}{";
    public static final String DEBUT_COMMANDE_DATE = "\\newcommand{\\ladate}{";
    public static final String DEBUT_COMMANDE_SALLE = "\\newcommand{\\lasalle}{";
    public static final String FIN_COMMANDE = "}\n";
    public static final String PETITE_PAUSE = "\\hline\n";
    public static final String GRANDE_PAUSE = "\\end{tabular}\n\n"
	+ "\\bigskip\n"
	+ "\\hspace*{-3cm}\\begin{tabular}[t]{|l|l|l|l|}\n" 
	+ "\\hline\n";
}