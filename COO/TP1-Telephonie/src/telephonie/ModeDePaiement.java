
package telephonie;


public interface ModeDePaiement {
   public boolean valide() ;
   public void debiter(int dureeComptabilisee , int tarifUnitaireApplique) ;
}
