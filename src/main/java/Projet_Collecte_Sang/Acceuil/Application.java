package Projet_Collecte_Sang.Acceuil;

import Projet_Collecte_Sang.dao_Utilisateur.vueUtilisateur.FormulaireUser;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
 //       VueDonneur donneur = new VueDonneur();
   //     donneur.setVisible(true);

        FormulaireUser user = new FormulaireUser();
        user.action();
        user.setVisible(true);
	}
}