package plantenApp.java.dao;

import plantenApp.java.model.Gebruiker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bart Maes
 */
public class GebruikerDAO implements Queries {
    private Connection dbConnection;
    private PreparedStatement stmtSelectGebruikerByEmail;
    private PreparedStatement stmtSetWachtwoordHash;
    private PreparedStatement stmtSelectGebruikerById;

    public GebruikerDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectGebruikerByEmail = dbConnection.prepareStatement(GETGEBRUIKERBYEMAILADRES);
        //stmtSetWachtwoordHash = dbConnection.prepareStatement(SETWACHTWOORDHASH);
        stmtSelectGebruikerById = dbConnection.prepareStatement(GETGEBRUIKERBYID);
    }

    /**
     * @return alle gebruikers
     * @author Bart Maes
     */
    public List<Gebruiker> getAllGebruiker() {
        List<Gebruiker> gebruikersList = new ArrayList<>();
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(GETALLGEBRUIKERS);
            while (rs.next()) {
                Gebruiker gebruiker =
                        new Gebruiker(
                                rs.getInt("gebruiker_id"),
                                rs.getString("voornaam"),
                                rs.getString("achternaam"),
                                rs.getString("email"),
                                rs.getString("rol"),
                                rs.getDate("aanvraag_datum"),
                                rs.getInt("aanvraag_goedgekeurd"),
                                rs.getDate("last_login"),
                                rs.getInt("geregistreerd"),
                                rs.getBytes("wachtwoord_hash"),
                                rs.getBytes("salt")
                        );
                gebruikersList.add(gebruiker);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GebruikerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gebruikersList;
    }

    /**
     * @param email -> email
     * @return gebruikersgegevens van emailadres
     * @author Bart Maes
     */
    public Gebruiker getByEmail(String email) throws SQLException {
        Gebruiker user = null;
        stmtSelectGebruikerByEmail.setString(1, email);
        ResultSet rs = stmtSelectGebruikerByEmail.executeQuery();
        if (rs.next()) {
            user = new Gebruiker(
                    rs.getInt("gebruiker_id"),
                    rs.getString("voornaam"),
                    rs.getString("achternaam"),
                    rs.getString("email"),
                    rs.getString("rol"),
                    rs.getDate("aanvraag_datum"),
                    rs.getInt("aanvraag_goedgekeurd"),
                    rs.getDate("last_login"),
                    rs.getInt("geregistreerd"),
                    rs.getBytes("wachtwoord_hash"),
                    rs.getBytes("salt")
            );
        }
        return user;
    }

    public Gebruiker getGebruikerById(int gebruikerID) throws SQLException {
        Gebruiker user = null;

        stmtSelectGebruikerById.setInt(1, gebruikerID);
        ResultSet rs = stmtSelectGebruikerById.executeQuery();
        if (rs.next()) {
            user = new Gebruiker(
                    rs.getInt("gebruiker_id"),
                    rs.getString("voornaam"),
                    rs.getString("achternaam"),
                    rs.getString("email"),
                    rs.getString("rol"),
                    rs.getDate("aanvraag_datum"),
                    rs.getInt("aanvraag_goedgekeurd"),
                    rs.getDate("last_login"),
                    rs.getInt("geregistreerd"),
                    rs.getBytes("wachtwoord_hash"),
                    rs.getBytes("salt")
            );
        }
        return user;
    }
}
