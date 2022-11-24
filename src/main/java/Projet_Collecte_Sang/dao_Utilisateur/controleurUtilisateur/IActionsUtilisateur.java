package Projet_Collecte_Sang.dao_Utilisateur.controleurUtilisateur;

import java.util.List;

import Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur.*;

public interface IActionsUtilisateur {
    // Create
    public String CtrUtilisateur_Enregistrer(Utilisateur utilisateur);
    public int CtrUtilisateur_EnregistrerParRequete(String strSql,String valeur);
    
    // // Read
     public List<Utilisateur> CtrUtilisateur_GetAll();

     public Utilisateur CtrUtilisateur_GetById(int id);

    public List<Utilisateur> CtrUtilisateur_GetByChamps(String champs,String valeur);

    // // Update
    public int CtrUtilisateur_Modifier(Utilisateur utilisateur);

    // // Delete
     public int CtrUtilisateur_Enlever(int id); 
}
