package Projet_Collecte_Sang.dao_Collecte.controleurCollecte;

import java.util.List;

import Projet_Collecte_Sang.dao_Collecte.modelCollecte.Collecte;

public interface IActionsCollecte {
    // Create
    public String CtrCollecte_Enregistrer(Collecte collecte);
    public int CtrCollecte_EnregistrerParRequete(String strSql,String valeur);
    
    // // Read
     public List<Collecte> CtrCollecte_GetAll();

     public Collecte CtrCollecte_GetById(int id);

    public List<Collecte> CtrCollecte_GetByChamps(String champs,String valeur);

    // // Update
    public int CtrCollecte_Modifier(Collecte collecte);

    // // Delete
     public int CtrCollecte_Enlever(int id); 
}
