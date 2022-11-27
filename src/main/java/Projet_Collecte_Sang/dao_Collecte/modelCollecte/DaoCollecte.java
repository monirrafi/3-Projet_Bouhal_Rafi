package Projet_Collecte_Sang.dao_Collecte.modelCollecte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoCollecte implements ICollecte {
    private static Connection conn = null;
    private static DaoCollecte instanceDao = null;

    // MySQL
    //private static final String PILOTE = "com.mysql.jdbc.Driver";
    private static final String NOM_BD = "collectesang";
    private static final String URL_BD = "jdbc:mysql://localhost/" +NOM_BD;     
    private static final String USAGER = "root";
    private static final String PASS = "";

    private static final String SUPPRIMER = "DELETE FROM collecte WHERE ID_Collecte=?";
    private static final String GET_ALL = "SELECT * FROM collecte ORDER BY ID_Collecte";
    private static final String GET_BY_ID = "SELECT * FROM collecte WHERE ID_Collecte=?";
    private static final String GET_BY_CHAMPS = "SELECT * FROM collecte WHERE ";
    private static final String ENREGISTRER = "INSERT INTO collecte VALUES(0,?,?,?, ?)";
    private static final String MODIFIER = "UPDATE Collecte SET ID_LIEU=?,TYPE_COLLECTE=?,DATE_COLLECTE=?,ORGANISATEUR=? WHERE ID_Collecte=?";

    // Singleton de connexion à la BD
    // getConnexion() est devenu une zonne critique. 
    // Pour ne pas avoir deux processus légers (threads) qui
    // appellent au même temps getConnexion

    private DaoCollecte(){};

    public static synchronized DaoCollecte getCollecteDao () {
        try {
                if (instanceDao == null) {
                    instanceDao = new DaoCollecte();
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
    public String MdlCollecte_Enregistrer(Collecte collecte) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(ENREGISTRER, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, collecte.getLieu());
            stmt.setString(2, collecte.getTypeCollecte());
            stmt.setString(3, collecte.getDateCollecte());
            stmt.setString(4, collecte.getOrganisateur());
           
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                collecte.setId(rs.getInt(1));
            }
            return "Collecte est bien enregistré ";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlLivre_Fermer(conn);
        }
    }

    @Override
    public List<Collecte> MdlCollecte_GetAll() {
            PreparedStatement stmt = null;
            List<Collecte> listeCollectes = new ArrayList<Collecte>();
    
            try {
                stmt = conn.prepareStatement(GET_ALL);
                ResultSet rs = stmt.executeQuery();
    
                while (rs.next()) {
                    Collecte collecte = new Collecte();
                    collecte.setId(rs.getInt(1));
                    collecte.setLieu(rs.getInt(2));
                    collecte.setTypeCollecte(rs.getString(3));
                    collecte.setDateCollecte(rs.getString(4));
                    collecte.setOrganisateur(rs.getString(5));
                    listeCollectes.add(collecte);
                }
            } catch (SQLException e) {
                // e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                Mdl_Fermer(stmt);
               // MdlCollecte_Fermer(conn);
            }
    
            return listeCollectes;
        }
    

    @Override
    public Collecte MdlCollecte_GetByID(int id) {
        PreparedStatement stmt = null;

        try {

            stmt = conn.prepareStatement(GET_BY_ID);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Collecte collecte = new Collecte();
                collecte.setId(rs.getInt(1));
                collecte.setLieu(rs.getInt(2));
                collecte.setTypeCollecte(rs.getString(3));
                collecte.setDateCollecte(rs.getString(4));
                collecte.setOrganisateur(rs.getString(5));

                return collecte;
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
    public List<Collecte> MdlCollecte_GetByChamps(String champs, String valeur) {
        PreparedStatement stmt = null;
        List<Collecte> listeCollectes = new ArrayList<Collecte>();

        try {
            stmt = conn.prepareStatement(GET_BY_CHAMPS + champs + "=?");
            stmt.setString(1, valeur);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Collecte collecte = new Collecte();
                collecte.setId(rs.getInt(1));
                collecte.setLieu(rs.getInt(2));
                collecte.setTypeCollecte(rs.getString(3));
                collecte.setDateCollecte(rs.getString(4));
                collecte.setOrganisateur(rs.getString(5));
            listeCollectes.add(collecte);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            Mdl_Fermer(stmt);
           // MdlCollecte_Fermer(conn);
        }

        return listeCollectes;
}

    @Override
    public int MdlCollecte_Modifier(Collecte collecte) {
        PreparedStatement stmt = null;
       
        try {
            stmt = conn.prepareStatement(MODIFIER);
            stmt.setInt(1, collecte.getLieu());
            stmt.setString(2, collecte.getTypeCollecte());
            stmt.setString(3, collecte.getDateCollecte());
            stmt.setString(4, collecte.getOrganisateur());
            stmt.setInt(5, collecte.getId());
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
    public int MdlCollecte_Supprimer(int id) {
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
    public int MdlCollecte_EnregistrerParRequete(String strSql,String valeur) {
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
