
package telephonie;

import java.util.Random;

import telephonie.util.Date;


public class Simulation {
 
   /**
    * 
    */
   public static void main(String[] args) {
      System.out.println("********** CREATIONS DES OPERATEURS et MODES DE PAIEMENT **********");
      Operateur fixe = new OperateurTarifFixe(3);
      Operateur variable = new OperateurTarifVariable(4);
      
      CarteBancaire carteBancaire = new CarteBancaire(10000);
      CartePrePayee cartePrepayee = new CartePrePayee(carteBancaire);           
      
      System.out.println("\n********** CREATIONS DES CONNEXIONS **********");
      Connexion[] connexionsFixe = new Connexion[5];
      Connexion[] connexionsVariable = new Connexion[5];

      Date d;
      int minutes;
      int heures;
      Random rand = new Random();
      // création des connexions sur l'opérateur fixe (date de début aléatoire)
      for (int i = 0; i < connexionsFixe.length; i++) {
         heures = rand.nextInt(24);
         minutes = rand.nextInt(60);
         d = new Date(1,heures,minutes);
         try {
            connexionsFixe[i] = fixe.seConnecter(d,carteBancaire);
         } catch (OperateurSatureException e) {
            System.out.println("  EXCEPTION operateur fixe sature");
            //e.printStackTrace();
         } catch (ModeDePaiementInvalideException e) {
            System.out.println("   mode de paiement invalide");
            //e.printStackTrace();
         }
      }

      // création des connexions sur l'opérateur variable (date de début aléatoire)
      for (int i = 0; i < connexionsVariable.length; i++) {
         heures = rand.nextInt(24);
         minutes = rand.nextInt(60);
         d = new Date(1,heures,minutes);
         try {
            connexionsVariable[i] = variable.seConnecter(d,cartePrepayee);
         } catch (OperateurSatureException e) {
            System.out.println("  EXCEPTION operateur variable sature");
            //e.printStackTrace();
         } catch (ModeDePaiementInvalideException e) {
            System.out.println("  mode de paiement invalide");
            //e.printStackTrace();
         }
      }
      

      System.out.println("\n********** UNE DECONNEXION VALIDE SUR CHAQUE OPERATEUR**********");
      // déconnexion des premières connexions ([0]) de chaque opérateur après une durée aléatoire en minutes
      // op fixe
      minutes = rand.nextInt(20)+1;
      try {
         fixe.seDeconnecter(connexionsFixe[0],connexionsFixe[0].dateDebutConnexion().addMinutes(minutes));
      } catch (PasDeConnexionException e) {
         // ne se produira pas
         e.printStackTrace();
      }

      // op variable
      minutes = rand.nextInt(20)+1;
      try {
         variable.seDeconnecter(connexionsVariable[0],connexionsVariable[0].dateDebutConnexion().addMinutes(minutes));
      } catch (PasDeConnexionException e) {
         // ne se produira pas
         e.printStackTrace();
      }
      
      System.out.println("\n********** 'RE'CREATIION D'UNE CONNEXION POUR CHAQUE OPERATEUR**********");
      // création de 2 nouvelles "premières connexions"
      try {
         d = new Date(1,rand.nextInt(24),rand.nextInt(60));
         connexionsFixe[0] = fixe.seConnecter(d,carteBancaire);
         d = new Date(1,rand.nextInt(24),rand.nextInt(60));
         connexionsVariable[0] = variable.seConnecter(d,carteBancaire);
      } catch (OperateurSatureException e) {
         System.out.println("   operateur sature");
         //e.printStackTrace();
      } catch (ModeDePaiementInvalideException e) {
         System.out.println("   mode de paiement invalide");
         //e.printStackTrace();
      }
      
      System.out.println("\n********** UNE DECONNEXION 'ILLEGALE' SUR CHAQUE OPERATEUR**********");
      // test déconnexion "illégale"
      try {
         fixe.seDeconnecter(connexionsVariable[0],connexionsVariable[0].dateDebutConnexion().addMinutes(minutes));
      } catch (PasDeConnexionException e) {
         System.out.println("  EXCEPTION : deconnexion d'une variable de fixe");
         //e.printStackTrace();
      }
      try {
         variable.seDeconnecter(connexionsFixe[0],connexionsFixe[0].dateDebutConnexion().addMinutes(minutes));
      } catch (PasDeConnexionException e) {
         System.out.println("  EXCEPTION : deconnexion d'une fixe de variable");
         //e.printStackTrace();
      }
      
      System.out.println("\n********** TOUTES LES  DECONNEXIONS VALIDES POUR CHAQUE OPERATEUR**********");
      // on réalise toutes les déconnexions possibles
     //    op fixe	
      for (int i = 0; connexionsFixe[i] != null && i < connexionsFixe.length; i++) {
         minutes = rand.nextInt(20)+1;
         try {
            fixe.seDeconnecter(connexionsFixe[i],connexionsFixe[i].dateDebutConnexion().addMinutes(minutes));
         } catch (PasDeConnexionException e) {
            // ne se produira pas
            e.printStackTrace();
         }
      }// op variable: plusieurs tests permettront de mettre en évidence la gestion de l'épuisement des cartes prépayées
      for (int i = 0; connexionsVariable[i] != null && i < connexionsVariable.length; i++) {
         minutes = rand.nextInt(15)+10; // +10 pour dépasser le plus souvent possible les "50mn" de base sur pré-payée
         try {
            variable.seDeconnecter(connexionsVariable[i],connexionsVariable[i].dateDebutConnexion().addMinutes(minutes));
         } catch (PasDeConnexionException e) {
            // ne se produira pas
            e.printStackTrace();
         }
         
      }
      System.out.println("Fixe free slots: "+ (((OperateurTarifFixe)fixe).getMaxNumberOfConnections()-((OperateurTarifFixe)fixe).getNumberOfConnections()));
      for (int i = 0; i < connexionsFixe.length; i++) {
          heures = rand.nextInt(24);
          minutes = rand.nextInt(60);
          d = new Date(1,heures,minutes);
          try {
             connexionsFixe[i] = fixe.seConnecter(d,cartePrepayee);
          } catch (OperateurSatureException e) {
             System.out.println("  EXCEPTION operateur fixe sature");
             //e.printStackTrace();
          } catch (ModeDePaiementInvalideException e) {
             System.out.println("   mode de paiement invalide");
             //e.printStackTrace();
          }
       }
   }
}
