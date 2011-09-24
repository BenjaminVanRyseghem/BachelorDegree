package planningMaster;

import java.io.IOException;

/** Permet d'écrire du texte sous forme de chaîne. */
public interface EcritureTexte {

    /** Écrit la donnée passée en paramètre. 
     * @throws IOException */
    public void ecrire(String donnee);

    /* Termine l'écriture. */
    public void terminer();

}