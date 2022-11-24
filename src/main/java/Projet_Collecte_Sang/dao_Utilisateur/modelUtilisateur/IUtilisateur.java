package Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur;
import java.util.List;

public interface IUtilisateur {

    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlUtilisateur_Enregistrer(Utilisateur utilisateur);
    public int MdlUtilisateur_EnregistrerParRequete(String strSql,String valeur);
    
    // Read
    public List<Utilisateur> MdlUtilisateur_GetAll();

    public Utilisateur MdlUtilisateur_GetByID(int id);

    public List<Utilisateur> MdlUtilisateur_GetByChamps(String champs,String valeur);
    
    // Update
    public int MdlUtilisateur_Modifier(Utilisateur utilisateur);

    // Delete
    public int MdlUtilisateur_Supprimer(int id);

}
