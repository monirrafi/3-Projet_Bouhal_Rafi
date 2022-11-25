package Projet_Collecte_Sang.Acceuil;

import Projet_Collecte_Sang.dao_Donnneur.vueDonneur.VueDonneur;
import Projet_Collecte_Sang.dao_Utilisateur.vueUtilisateur.FormulaireUser;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
/*       // Acceuil acceuil = new Acceuil();
       // acceuil.setVisible(true);
        VueDonneur donneur = new VueDonneur();
        donneur.setVisible(true);

       FormulaireUser user = new FormulaireUser();
        user.action();
        user.setVisible(true);
        ConnexionForm   frm = new ConnexionForm();
        frm.setVisible(true);*/
        VueDonneur donneur = new VueDonneur();
        donneur.setVisible(true);    
	}
}