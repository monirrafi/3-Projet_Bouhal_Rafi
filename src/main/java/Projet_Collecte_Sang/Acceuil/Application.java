package Projet_Collecte_Sang.Acceuil;

import Projet_Collecte_Sang.dao_Donnneur.vueDonneur.VueDonneur;

public final class Application {
    private Application() {
    }

    public static void main(String[] args) {
        VueDonneur donneur = new VueDonneur();
        donneur.setVisible(true);
	}
}