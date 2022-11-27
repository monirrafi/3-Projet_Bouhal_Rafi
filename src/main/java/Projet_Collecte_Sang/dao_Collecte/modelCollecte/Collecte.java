package Projet_Collecte_Sang.dao_Collecte.modelCollecte;
public class Collecte {
   
    private int id;
    private int  lieu;
    private String  typeCollecte ="";
    private String  dateCollecte ="";
    private String  Organisateur ="";

    

    public Collecte(int lieu, String typeCollecte, String dateCollecte, String organisateur) {
        this.lieu = lieu;
        this.typeCollecte = typeCollecte;
        this.dateCollecte = dateCollecte;
        Organisateur = organisateur;
    }
    public Collecte() {
    }
    
    public Collecte(int id, int lieu, String typeCollecte, String dateCollecte, String organisateur) {
        this.id = id;
        this.lieu = lieu;
        this.typeCollecte = typeCollecte;
        this.dateCollecte = dateCollecte;
        Organisateur = organisateur;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLieu() {
        return lieu;
    }
    public void setLieu(int lieu) {
        this.lieu = lieu;
    }
    public String getTypeCollecte() {
        return typeCollecte;
    }
    public void setTypeCollecte(String typeCollecte) {
        this.typeCollecte = typeCollecte;
    }
    public String getDateCollecte() {
        return dateCollecte;
    }
    public void setDateCollecte(String dateCollecte) {
        this.dateCollecte = dateCollecte;
    }
    public String getOrganisateur() {
        return Organisateur;
    }
    public void setOrganisateur(String organisateur) {
        Organisateur = organisateur;
    }

    
    
}
