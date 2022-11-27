package Projet_Collecte_Sang.dao_Collecte.controleurCollecte;

import java.util.List;

import Projet_Collecte_Sang.dao_Collecte.modelCollecte.Collecte;
import Projet_Collecte_Sang.dao_Collecte.modelCollecte.DaoCollecte;


public class ControleurCollecte implements IActionsCollecte {

    private static ControleurCollecte CtrCollecte_Instance = null;
    private static DaoCollecte Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurCollecte(){}

    public static synchronized ControleurCollecte getControleurCollecte() {
        try {
            if (CtrCollecte_Instance == null) {
                CtrCollecte_Instance = new ControleurCollecte();
                Dao_Instance = DaoCollecte.getCollecteDao();
            }
            return CtrCollecte_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Collecte> CtrCollecte_GetAll() {
        return Dao_Instance.MdlCollecte_GetAll();
    }

    @Override
    public String CtrCollecte_Enregistrer(Collecte collecte) {
        String message = null;
        message = Dao_Instance.MdlCollecte_Enregistrer(collecte);
        return message;
    }


    @Override
    public Collecte CtrCollecte_GetById(int id) {
        return Dao_Instance.MdlCollecte_GetByID(id);
    }

    @Override
    public List<Collecte> CtrCollecte_GetByChamps(String champs, String valeur) {
        return Dao_Instance.MdlCollecte_GetByChamps(champs, valeur);
    }

    @Override
    public int CtrCollecte_Modifier(Collecte collecte) {
        return Dao_Instance.MdlCollecte_Modifier(collecte);
    }

    @Override
    public int CtrCollecte_Enlever(int id) {
        return Dao_Instance.MdlCollecte_Supprimer(id);
    }

    @Override
    public int CtrCollecte_EnregistrerParRequete(String strSql, String valeur) {
        return Dao_Instance.MdlCollecte_EnregistrerParRequete(strSql,valeur);
    }
    

}
