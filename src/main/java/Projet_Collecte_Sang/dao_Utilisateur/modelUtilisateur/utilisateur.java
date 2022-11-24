package Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur;
public class utilisateur {
    private int id;
    private String  nom ="";
    private String  prenom ="";
    private String  dateNaissance ="";
    private String  telphone ="";
    private String  email ="";
    private String  addresse ="";
    private double  poids =0.0;
    private String  groupage ="";
    private String  sexe ="";
    
    
    public utilisateur() {
    }

    
    public utilisateur(int id, String nom, String prenom, String dateNaissance, String telphone, String email,
            String addresse, double poids, String groupage, String sexe) {
                this.setId(id);
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setDateNaissance(dateNaissance);
                this.setTelphone(telphone);
                this.setEmail(email);
                this.setAddresse(addresse);
                this.setPoids(poids);
                this.setGroupage(groupage);
                this.setSexe(sexe);
            }

            public utilisateur(String nom, String prenom, String dateNaissance, String telphone, String email,
            String addresse, double poids, String groupage, String sexe) {
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setDateNaissance(dateNaissance);
                this.setTelphone(telphone);
                this.setEmail(email);
                this.setAddresse(addresse);
                this.setPoids(poids);
                this.setGroupage(groupage);
                this.setSexe(sexe);
            }


    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getTelphone() {
        return telphone;
    }
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getPoids() {
        return poids;
    }
    public void setPoids(double poids) {
        this.poids = poids;
    }
    public String getGroupage() {
        return groupage;
    }
    public void setGroupage(String groupage) {
        this.groupage = groupage;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getAddresse() {
        return addresse;
    }
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
