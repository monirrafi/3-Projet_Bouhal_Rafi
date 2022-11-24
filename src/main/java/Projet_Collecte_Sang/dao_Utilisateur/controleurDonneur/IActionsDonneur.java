package Projet_Collecte_Sang.dao_Donnneur.controleurDonneur;

import java.util.List;

import Projet_Collecte_Sang.dao_Donnneur.modelDonneur.*;

public interface IActionsDonneur {
    // Create
    public String CtrDonneur_Enregistrer(Donneur Donneur);
    public int CtrDonneur_EnregistrerParRequete(String strSql,String valeur);
    
    // // Read
     public List<Donneur> CtrDonneur_GetAll();

     public Donneur CtrDonneur_GetById(int id);

    public List<Donneur> CtrDonneur_GetByChamps(String champs,String valeur);

    // // Update
    public int CtrDonneur_Modifier(Donneur Donneur);

    // // Delete
     public int CtrDonneur_Enlever(int id); 
}
