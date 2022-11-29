package Projet_Collecte_Sang.dao_Donnneur.modelDonneur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoDonneur implements IDonneur {
    private static Connection conn = null;
    private static DaoDonneur instanceDao = null;

    // MySQL
    //private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String NOM_BD = "collectesang";
    private static final String URL_BD = "jdbc:mysql://localhost/" +NOM_BD;     
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM donneur WHERE ID_DONNEUR=?";
    private static final String GET_ALL = "SELECT * FROM donneur ORDER BY ID_DONNEUR";
    private static final String GET_BY_ID = "SELECT * FROM donneur WHERE ID_DONNEUR=?";
    private static final String GET_BY_CHAMPS = "SELECT * FROM donneur WHERE ";
    private static final String ENREGISTRER = "INSERT INTO donneur VALUES(0,?,?,?,?,?,?,?,?,?,?)";
    private static final String MODIFIER = "UPDATE donneur SET NUM_ASS_MAL=?,NOM=?,PRENOM=?,DATE_NAISSANCE=?,TEL=?,EMAIL=?,ADRESSE=?,POIDS=?,GROUPAGE=?,SEXE=? WHERE ID_DONNEUR=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique. 
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoDonneur(){};

    public static synchronized DaoDonneur getLivreDao () {
        try {
                if (instanceDao == null) {
                    instanceDao = new DaoDonneur();
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
    public String MdlDonneur_Enregistrer(Donneur donneur) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, donneur.getNoRamq());
            stmt.setString(2, donneur.getNom());
            stmt.setString(3, donneur.getPrenom());
            stmt.setString(4, donneur.getDateNaissance());
            stmt.setString(5, donneur.getTelphone());
            stmt.setString(6, donneur.getEmail());
            stmt.setString(7, donneur.getAddresse());
            stmt.setDouble(8, donneur.getPoids());
            stmt.setString(9, donneur.getGroupage());
            stmt.setString(10, donneur.getSexe());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                donneur.setId(rs.getInt(1));
            }
            return "donneur est bien enregistré ";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<Donneur> MdlDonneur_GetAll() {
            PreparedStatement stmt = null;
            List<Donneur> listeDonneurs = new ArrayList<Donneur>();
    
            try {
                stmt = conn.prepareStatement(GET_ALL);
                ResultSet rs = stmt.executeQuery();
    
                while (rs.next()) {
                    Donneur donneur = new Donneur();
                    donneur.setId(rs.getInt(1));
                    donneur.setNoRamq(rs.getString(2));
                    donneur.setNom(rs.getString(3));
                    donneur.setPrenom(rs.getString(4));
                    donneur.setDateNaissance(rs.getString(5));
                    donneur.setTelphone(rs.getString(6));
                    donneur.setEmail(rs.getString(7));
                    donneur.setAddresse(rs.getString(8));
                    donneur.setPoids(rs.getDouble(9));
                    donneur.setGroupage(rs.getString(10));
                    donneur.setSexe(rs.getString(11));
                    listeDonneurs.add(donneur);
                }
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                Mdl_Fermer(stmt);
               // Mdldonneur_Fermer(conn);
            }
    
            return listeDonneurs;
        }
    

    @Override
    public Donneur MdlDonneur_GetByID(int id) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Donneur donneur = new Donneur();
                donneur.setId(rs.getInt(1));
                donneur.setNoRamq(rs.getString(2));
                donneur.setNom(rs.getString(3));
                donneur.setPrenom(rs.getString(4));
                donneur.setDateNaissance(rs.getString(5));
                donneur.setTelphone(rs.getString(6));
                donneur.setEmail(rs.getString(7));
                donneur.setAddresse(rs.getString(8));
                donneur.setPoids(rs.getDouble(9));
                donneur.setGroupage(rs.getString(10));
                donneur.setSexe(rs.getString(11));

                return donneur;
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
    public List<Donneur> MdlDonneur_GetByChamps(String champs, String valeur) {
        PreparedStatement stmt = null;
        List<Donneur> listeDonneurs = new ArrayList<Donneur>();

        try {
            stmt = conn.prepareStatement(GET_BY_CHAMPS + champs + "=?");
            stmt.setString(1, valeur);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Donneur donneur = new Donneur();
                donneur.setId(rs.getInt(1));
                donneur.setNoRamq(rs.getString(2));
                donneur.setNom(rs.getString(3));
                donneur.setPrenom(rs.getString(4));
                donneur.setDateNaissance(rs.getString(5));
                donneur.setTelphone(rs.getString(6));
                donneur.setEmail(rs.getString(7));
                donneur.setAddresse(rs.getString(8));
                donneur.setPoids(rs.getDouble(9));
                donneur.setGroupage(rs.getString(10));
                donneur.setSexe(rs.getString(11));
            listeDonneurs.add(donneur);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // Mdldonneur_Fermer(conn);
        }

        return listeDonneurs;
}

    @Override
    public int MdlDonneur_Modifier(Donneur donneur) {
        PreparedStatement stmt = null;
       
        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setString(1, donneur.getNoRamq());
            stmt.setString(2, donneur.getNom());
            stmt.setString(3, donneur.getPrenom());
            stmt.setString(4, donneur.getDateNaissance());
            stmt.setString(5, donneur.getTelphone());
            stmt.setString(6, donneur.getEmail());
            stmt.setString(7, donneur.getAddresse());
            stmt.setDouble(8, donneur.getPoids());
            stmt.setString(9, donneur.getGroupage());
            stmt.setString(10, donneur.getSexe());
            stmt.setInt(11, donneur.getId());

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
    public int MdlDonneur_Supprimer(int id) {
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
    public int MdlDonneur_EnregistrerParRequete(String strSql,String valeur) {
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
