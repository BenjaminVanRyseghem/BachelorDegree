
package telephonie;

import telephonie.util.Date;


public interface Operateur {
  /** crée une Connexion pour cet opérateur à la date indiqué, le mode
    * de paiement précisé sera utilisé
    * @param debut la date de début de la connexion
    * @param modeP le mode paiement qui sera utilisé pour cette connexion
    * @exception OperateurSatureException si le nombre limite de connexions simultanées
    *    pour cet opérateur est dépassé
    * @exception ModeDePaiementInvalideException si le mode de paiement associé
    *    n'est pas valide (<code>modeP.valide()</code> vaut <code>false</code>)
    */
  public Connexion seConnecter(Date debut, ModeDePaiement modeP) 
               throws OperateurSatureException, ModeDePaiementInvalideException ;
  /** déconnecte la connexion <code>cnx</code> à la date indiquée, le mode de paiement 
    *    indiqué à la création est débité
    * @param cnx la connexion à deconnecter 
    * @param fin la date de fin de cette connexion
    * @exception PasDeConnexionException si cet opérateur n'est pas l'opérateur de 
    *    la connexion <code>cnx</code>
    */
  public void seDeconnecter(Connexion cnx, Date fin) throws PasDeConnexionException ;
  /** fournit la durée comptabilisée pour la connexion considérée en
    * fonction de la politique tarifaire de l'opérateur
    * @param cnx la connexion dont on veut connaitre la duree
    * @return nombre entier de minutes comptabilisée pour la connexion, 
    */
  public int getDureeComptabilisee(Connexion cnx);
  /** fournit le tarif unitaire appliquée par l'opérateur pour chaque minute comptabilisée
    * @param cnx la connexion concernée
    * @return le tarif unitaire d'une minute compatabilisée pour la connexion fournie
    */
  public int getTarifUnitaire(Connexion cnx);
}
