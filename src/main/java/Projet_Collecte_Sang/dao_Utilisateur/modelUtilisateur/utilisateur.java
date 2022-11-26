package Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur;
public class Utilisateur {
    private int id;
    private String  nom ="";
    private String  prenom ="";
    private String  telphone ="";
    private String  email ="";
    private String userName;
    private String motPasse;
    private int niveau=0;
    
    
    public Utilisateur() {
    }

    
    public Utilisateur(int id, String nom, String prenom, String telphone, String email, String userName,
            String motPasse, int niveau) {
                this.setId(id);
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setTelphone(telphone);
                this.setEmail(email);
                this.setUserName(userName);
                this.setMotPasse(motPasse);
                this.setNiveau(niveau);
    }

    public Utilisateur(String nom, String prenom, String telphone, String email, String userName,
            String motPasse, int niveau) {
                this.setNom(nom);
                this.setPrenom(prenom);
                this.setTelphone(telphone);
                this.setEmail(email);
                this.setUserName(userName);
                this.setMotPasse(motPasse);
                this.setNiveau(niveau);
    }

            public int getId() {
                return id;
            }


            public void setId(int id) {
                this.id = id;
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


            public String getUserName() {
                return userName;
            }


            public void setUserName(String userName) {
                this.userName = userName;
            }


            public String getMotPasse() {
                return motPasse;
            }


            public void setMotPasse(String motPasse) {
                this.motPasse = motPasse;
            }


            public int getNiveau() {
                return niveau;
            }


            public void setNiveau(int niveau) {
                this.niveau = niveau;
            }


    
}
