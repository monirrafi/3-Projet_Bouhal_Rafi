package Projet_Collecte_Sang.dao_Collecte.modelCollecte;
import java.util.List;

public interface ICollecte {

    // Pour le CRUD - Create Read Update Delete
    
    // Create
    public String MdlCollecte_Enregistrer(Collecte collecte);
    public int MdlCollecte_EnregistrerParRequete(String strSql,String valeur);
    
    // Read
    public List<Collecte> MdlCollecte_GetAll();

    public Collecte MdlCollecte_GetByID(int id);

    public List<Collecte> MdlCollecte_GetByChamps(String champs,String valeur);
    
    // Update
    public int MdlCollecte_Modifier(Collecte collecte);

    // Delete
    public int MdlCollecte_Supprimer(int id);

}
