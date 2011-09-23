package planningMaster;

/** Permet d'écrire du texte sous forme de chaîne. */
public interface EcritureTexte {

    /** Écrit la donnée passée en paramètre. */
    public void ecrire(String donnee);

    /* Termine l'écriture. */
    public void terminer();

}