package Projet_Collecte_Sang.dao_Donnneur.modelDonneur;
import java.util.List;

public interface IDonneur {

    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlDonneur_Enregistrer(Donneur donneur);
    public int MdlDonneur_EnregistrerParRequete(String strSql,String valeur);
    
    // Read
    public List<Donneur> MdlDonneur_GetAll();

    public Donneur MdlDonneur_GetByID(int id);

    public List<Donneur> MdlDonneur_GetByChamps(String champs,String valeur);
    
    // Update
    public int MdlDonneur_Modifier(Donneur donneur);

    // Delete
    public int MdlDonneur_Supprimer(int id);

}
