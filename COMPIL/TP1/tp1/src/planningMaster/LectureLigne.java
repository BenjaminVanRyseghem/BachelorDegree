package planningMaster;

import java.io.IOException;

public interface LectureLigne {
    
    /** Lit la prochaine ligne, la retourne sous forme String, ou null
     * s'il n'y a plus rien à lire. */
    public String lireLigne() throws IOException;

}