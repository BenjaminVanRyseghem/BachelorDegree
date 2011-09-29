
package telephonie.util;

import java.util.Calendar;

/**
 * @author <a href="mailto:routier@lifl.fr">routier </a>
 * 
 * 
 */
public class Date {

   private int heures;
   private int minutes;
   private int jour; 
   
   public Date(int d, int h, int m) {
      this.jour = d;
      this.heures = h;
      this.minutes = m;
   }

   /** la vraie version */
   public static Date getDateCourante() {
      return new Date(Calendar.DAY_OF_YEAR, Calendar.HOUR_OF_DAY, Calendar.MINUTE);
   }

   public int getHeures() {
      return this.heures;
   }

   public int getMinutes() {
      return this.minutes;
   }
   
   /**
    * le jour dans l'année pour cette date (le premier jour vaut 1)
    * @return the day
    */
   public int getDay() {
      return this.jour;
   }

   /** "this-d" en mn entières (arrondi au sup).
    * On suppose qu'il n'y a jamais plus d'un jour d'écart entre les 2 dates (càd diff inférierure à 24h).
    * @param d
    * @return the difference in minutes between the beginning of the connection and its end 
    */
   public int differenceEnMinutes(Date d) {
      int result = 0;
      if (d.jour != this.jour) {
         result = new Date(d.jour, 23, 60).differenceEnMinutes(d);
         result = result + this.minutes + this.heures*60;
      }
      else if (d.heures != this.heures) {
         result = this.minutes + (60 - d.minutes);
         result = result + (this.heures - d.heures -1) * 60;
      } else {
         result = this.minutes - d.minutes;
      }
      return result;
   }

   /**
    * @return Returns the jour.
    */
   public int getJour() {
      return jour;
   }
   
   /** retourne la date obtenue en ajoutant <t>nbMinutes</t> à cette date (this)
    *
    * @param nbMinutes le nombre de minutes ajoutées (on suppose que ce nb de mn correspond à moins de 24h)
    * @return la date obtenue en ajoutant <t>nbMinutes</t> à cette date (this)
    */  
   public Date addMinutes(int nbMinutes) {
      int mn = (this.minutes + nbMinutes)%60;
      int h = this.heures + (this.minutes + nbMinutes) / 60;
      int j = this.jour; 
      if (h>23) {
         j = j+1;  // rappel : on suppose que l'on n'ajoute pas plus de 24h
         h = h % 24;
      } 
      return new Date(j, h, mn);     
   }
   
   public String toString() {
      return this.jour+", "+this.heures+"h "+this.minutes+"mn ";
   }
}
