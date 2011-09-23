
package telephonie;

import telephonie.util.Date;


public class Connexion {

   private ModeDePaiement mode;
   private Operateur operateur;
   private Date dateDebut;
   private Date dateFin;
 
   public Connexion(Operateur op, Date debut, ModeDePaiement m) { 
      this.operateur  = op;
      this.mode = m;
      this.dateDebut = debut;
   }
   
   public int heureDebutConnexion() { 
      return this.dateDebut.getHeures();
   }
   public Date dateDebutConnexion() { 
      return this.dateDebut;
   }
   public Date dateFinConnexion() { 
      return this.dateFin;
   }
   /**
    * The duration of the connection in minutes
    * @return the duration in minutes
    */
   public int dureeConnexion() { 
      return this.dateFin.differenceEnMinutes(this.dateDebut);
   }             
   
   public void finConnexion(Date dateFin) {
      this.dateFin = dateFin;
   }
   
   public ModeDePaiement mode() { 
      return this.mode;
   }	
   
   public Operateur getOperateur() {
      return this.operateur;
   }


}
