package Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur;
import java.util.List;

public interface IDonneur {

    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlDonneur_Enregistrer(utilisateur donneur);
    public int MdlDonneur_EnregistrerParRequete(String strSql,String valeur);
    
    // Read
    public List<utilisateur> MdlDonneur_GetAll();

    public utilisateur MdlDonneur_GetByID(int id);

    public List<utilisateur> MdlDonneur_GetByChamps(String champs,String valeur);
    
    // Update
    public int MdlDonneur_Modifier(utilisateur donneur);

    // Delete
    public int MdlDonneur_Supprimer(int id);

}
