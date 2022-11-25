package Projet_Collecte_Sang.dao_Utilisateur.modelUtilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoUtilisateur implements IUtilisateur {
    private static Connection conn = null;
    private static DaoUtilisateur instanceDao = null;

    // MySQL
    //private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String NOM_BD = "collectesang";
    private static final String URL_BD = "jdbc:mysql://localhost/" +NOM_BD;     
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM Utilisateur WHERE ID_Utilisateur=?";
    private static final String GET_ALL = "SELECT * FROM Utilisateur ORDER BY ID_Utilisateur";
    private static final String GET_BY_ID = "SELECT * FROM Utilisateur WHERE ID_Utilisateur=?";
    private static final String GET_BY_CHAMPS = "SELECT * FROM Utilisateur WHERE ";
    private static final String ENREGISTRER = "INSERT INTO Utilisateur VALUES(0,?,?,?, ?,?,?, ?,?,?,?)";
    private static final String MODIFIER = "UPDATE Utilisateur SET NOM=?,PRENOM=?,TEL=?,EMAIL=?,USERNAME=?,MOTDEPASSE=?,NOVEAU=? WHERE ID_Utilisateur=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique. 
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoUtilisateur(){};

    public static synchronized DaoUtilisateur getUtilisateurDao () {
        try {
                if (instanceDao == null) {
                    instanceDao = new DaoUtilisateur();
                    conn = DriverManager.getConnection(URL_BD, USAGER, PASS);
                }
                return instanceDao;
            
        } 
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   
    private static void Mdl_Fermer(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    private static void Mdl_Fermer(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    public Connection getConn() {
        return conn;
    }

    @Override
    public String MdlUtilisateur_Enregistrer(Utilisateur Utilisateur) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, Utilisateur.getNom());
            stmt.setString(2, Utilisateur.getPrenom());
            stmt.setString(3, Utilisateur.getTelphone());
            stmt.setString(4, Utilisateur.getEmail());
            stmt.setString(5, Utilisateur.getUserName());
            stmt.setString(6, Utilisateur.getMotPasse());
            stmt.setInt(7, Utilisateur.getNiveau());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                Utilisateur.setId(rs.getInt(1));
            }
            return "Utilisateur est bien enregistré ";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<Utilisateur> MdlUtilisateur_GetAll() {
            PreparedStatement stmt = null;
            List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
    
            try {
                stmt = conn.prepareStatement(GET_ALL);
                ResultSet rs = stmt.executeQuery();
    
                while (rs.next()) {
                    Utilisateur Utilisateur = new Utilisateur();
                    Utilisateur.setId(rs.getInt(1));
                    Utilisateur.setNom(rs.getString(2));
                    Utilisateur.setPrenom(rs.getString(3));
                    Utilisateur.setTelphone(rs.getString(4));
                    Utilisateur.setEmail(rs.getString(5));
                    Utilisateur.setUserName(rs.getString(6));
                    Utilisateur.setMotPasse(rs.getString(7));
                    Utilisateur.setNiveau(rs.getInt(8));
                    listeUtilisateurs.add(Utilisateur);
                }
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                Mdl_Fermer(stmt);
               // MdlUtilisateur_Fermer(conn);
            }
    
            return listeUtilisateurs;
        }
    

    @Override
    public Utilisateur MdlUtilisateur_GetByID(int id) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setId(rs.getInt(1));
                Utilisateur.setNom(rs.getString(2));
                Utilisateur.setPrenom(rs.getString(3));
                Utilisateur.setTelphone(rs.getString(4));
                Utilisateur.setEmail(rs.getString(5));
                Utilisateur.setUserName(rs.getString(6));
                Utilisateur.setMotPasse(rs.getString(7));
                Utilisateur.setNiveau(rs.getInt(8));

                return Utilisateur;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
//            MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<Utilisateur> MdlUtilisateur_GetByChamps(String champs, String valeur) {
        PreparedStatement stmt = null;
        List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();

        try {
            stmt = conn.prepareStatement(GET_BY_CHAMPS + champs + "=?");
            stmt.setString(1, valeur);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Utilisateur Utilisateur = new Utilisateur();
                Utilisateur.setId(rs.getInt(1));
                Utilisateur.setNom(rs.getString(2));
                Utilisateur.setPrenom(rs.getString(3));
                Utilisateur.setTelphone(rs.getString(4));
                Utilisateur.setEmail(rs.getString(5));
                Utilisateur.setUserName(rs.getString(6));
                Utilisateur.setMotPasse(rs.getString(7));
                Utilisateur.setNiveau(rs.getInt(8));
                listeUtilisateurs.add(Utilisateur);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlUtilisateur_Fermer(conn);
        }

        return listeUtilisateurs;
}

    @Override
    public int MdlUtilisateur_Modifier(Utilisateur Utilisateur) {
        PreparedStatement stmt = null;
       
        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1, Utilisateur.getNom());
            stmt.setString(2, Utilisateur.getPrenom());
            stmt.setString(3, Utilisateur.getTelphone());
            stmt.setString(4, Utilisateur.getEmail());
            stmt.setString(5, Utilisateur.getUserName());
            stmt.setString(6, Utilisateur.getMotPasse());
            stmt.setInt(7, Utilisateur.getId());
            stmt.setInt(8, Utilisateur.getNiveau());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
            //MdlLivre_Fermer(conn);
        }
    }

    @Override
    public int MdlUtilisateur_Supprimer(int id) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(SUPPRIMER);
            stmt.setInt(1, id);

            return stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public int MdlUtilisateur_EnregistrerParRequete(String strSql,String valeur) {
        PreparedStatement stmt = null;
        int cle=0;
        try {
            stmt = conn.prepareStatement(strSql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, valeur);
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                cle = rs.getInt(1);
            }
            return cle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlLivre_Fermer(conn);
        }
    }

}
