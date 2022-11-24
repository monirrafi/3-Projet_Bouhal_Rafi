package Projet_Collecte_Sang.dao_Utilisateur.controleurUtilisateur;

import java.util.List;

import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.DaoUtilisateur;
import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.Utilisateur;


public class ControleurUtilisateur implements IActionsUtilisateur {

    private static ControleurUtilisateur CtrUtilisateur_Instance = null;
    private static DaoUtilisateur Dao_Instance = null;
    // Singleton du contrôleur
    // getControleurFilm() est devenu une zonne critique.
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion
    private ControleurUtilisateur(){}

    public static synchronized ControleurUtilisateur getControleurUtilisateur() {
        try {
            if (CtrUtilisateur_Instance == null) {
                CtrUtilisateur_Instance = new ControleurUtilisateur();
                Dao_Instance = DaoUtilisateur.getLivreDao();
            }
            return CtrUtilisateur_Instance;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Utilisateur> CtrUtilisateur_GetAll() {
        return Dao_Instance.MdlUtilisateur_GetAll();
    }

    @Override
    public String CtrUtilisateur_Enregistrer(Utilisateur Utilisateur) {
        String message = null;
        message = Dao_Instance.MdlUtilisateur_Enregistrer(Utilisateur);
        return message;
    }


    @Override
    public Utilisateur CtrUtilisateur_GetById(int id) {
        return Dao_Instance.MdlUtilisateur_GetByID(id);
    }

    @Override
    public List<Utilisateur> CtrUtilisateur_GetByChamps(String champs, String valeur) {
        return Dao_Instance.MdlUtilisateur_GetByChamps(champs, valeur);
    }

    @Override
    public int CtrUtilisateur_Modifier(Utilisateur Utilisateur) {
        return Dao_Instance.MdlUtilisateur_Modifier(Utilisateur);
    }

    @Override
    public int CtrUtilisateur_Enlever(int id) {
        return Dao_Instance.MdlUtilisateur_Supprimer(id);
    }

    @Override
    public int CtrUtilisateur_EnregistrerParRequete(String strSql, String valeur) {
        return Dao_Instance.MdlUtilisateur_EnregistrerParRequete(strSql,valeur);
    }
    

}
