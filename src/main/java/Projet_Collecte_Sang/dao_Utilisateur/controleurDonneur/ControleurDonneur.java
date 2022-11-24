package Projet_Collecte_Sang.dao_Donnneur.controleurDonneur;

import java.util.List;

import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.DaoDonneur;
import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.Donneur;


public class ControleurDonneur implements IActionsDonneur {

    private static ControleurDonneur CtrDonneur_Instance = null;
    private static DaoDonneur Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurDonneur(){}

    public static synchronized ControleurDonneur getControleurDonneur() {
        try {
            if (CtrDonneur_Instance == null) {
                CtrDonneur_Instance = new ControleurDonneur();
                Dao_Instance = DaoDonneur.getLivreDao();
            }
            return CtrDonneur_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Donneur> CtrDonneur_GetAll() {
        return Dao_Instance.MdlDonneur_GetAll();
    }

    @Override
    public String CtrDonneur_Enregistrer(Donneur donneur) {
        String message = null;
        message = Dao_Instance.MdlDonneur_Enregistrer(donneur);
        return message;
    }


    @Override
    public Donneur CtrDonneur_GetById(int id) {
        return Dao_Instance.MdlDonneur_GetByID(id);
    }

    @Override
    public List<Donneur> CtrDonneur_GetByChamps(String champs, String valeur) {
        return Dao_Instance.MdlDonneur_GetByChamps(champs, valeur);
    }

    @Override
    public int CtrDonneur_Modifier(Donneur Donneur) {
        return Dao_Instance.MdlDonneur_Modifier(Donneur);
    }

    @Override
    public int CtrDonneur_Enlever(int id) {
        return Dao_Instance.MdlDonneur_Supprimer(id);
    }

    @Override
    public int CtrDonneur_EnregistrerParRequete(String strSql, String valeur) {
        return Dao_Instance.MdlDonneur_EnregistrerParRequete(strSql,valeur);
    }
    

}
