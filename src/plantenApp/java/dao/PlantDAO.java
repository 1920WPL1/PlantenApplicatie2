package plantenApp.java.dao;

import plantenApp.java.model.Plant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Siebe
 */
public class PlantDAO implements Queries {

    private Connection dbConnection;
    private PreparedStatement stmtSelectById;
    private PreparedStatement stmtSelectByPlant;
    private PreparedStatement stmtSelectByStatus;
    private PreparedStatement stmtSetPlantStatus;


    public PlantDAO(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        stmtSelectById = dbConnection.prepareStatement(GETPLANTBYID);
        stmtSelectByPlant = dbConnection.prepareStatement(GETIDSBYPLANT);
        stmtSelectByStatus = dbConnection.prepareStatement(GETPLANTBYSTATUS);
        stmtSetPlantStatus = dbConnection.prepareStatement(SETPLANTSTATUS);
    }
    // Auteur Dario
    public void setStatus(int status, int plantId) throws SQLException
    {
        stmtSetPlantStatus.setString(1,Integer.toString(status));
        stmtSetPlantStatus.setString(2,Integer.toString(plantId));
        stmtSetPlantStatus.executeUpdate();
    }

    // Auteur Dario
    public List<Plant> GetPlantIdByStatus(int status) throws SQLException {
        List<Plant> lijstPlantId = new ArrayList<Plant>();
        Plant plant = null;

        stmtSelectByStatus.setInt(1, status);
        ResultSet rs = stmtSelectByStatus.executeQuery();
        while (rs.next()) {
            plant = new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("planttype"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"),
                    rs.getInt("status"),
                    rs.getDate("last_updated"),
                    rs.getInt("gebruiker_id"));

            lijstPlantId.add(plant);
        }

        return lijstPlantId;
    }

    /**
     * @param id -> plant_id
     * @return -> alle basis factoren van de specifieke plant
     * @author Siebe
     * @author Siebe
     */
    public Plant getPlantById(int id) throws SQLException {
        Plant plant = null;

        stmtSelectById.setInt(1, id);
        ResultSet rs = stmtSelectById.executeQuery();
        if (rs.next()) {
            plant = new Plant(
                    rs.getInt("plant_id"),
                    rs.getString("planttype"),
                    rs.getString("familie"),
                    rs.getString("geslacht"),
                    rs.getString("soort"),
                    rs.getString("variatie"),
                    rs.getInt("plantdichtheid_min"),
                    rs.getInt("plantdichtheid_max"),
                    rs.getString("fgsv"),
                    rs.getInt("status"),
                    rs.getDate("last_updated"),
                    rs.getInt("gebruiker_id"));
        }
        return plant;
    }

    /**
     * @param type    -> waarde type van de plant
     * @param familie -> familie van de plant
     * @param fgsv    -> familie, geslacht, soort, variant
     * @return -> de gefilterde ids
     * @author Siebe
     */
    public ArrayList<Integer> KenmerkenFilter(String type, String familie, String fgsv) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();
        ;

        int iTrue = (type.isBlank()) ? 1 : 0;
        stmtSelectByPlant.setString(1, type);
        stmtSelectByPlant.setInt(2, iTrue);

        iTrue = (familie.isBlank()) ? 1 : 0;
        stmtSelectByPlant.setString(3, type);
        stmtSelectByPlant.setInt(4, iTrue);

        iTrue = (fgsv.isBlank()) ? 1 : 0;
        stmtSelectByPlant.setString(5, type);
        stmtSelectByPlant.setInt(6, iTrue);

        ResultSet rs = stmtSelectByPlant.executeQuery();
        while (rs.next()) {
            ids.add(rs.getInt("plant_id"));
        }
        return ids;
    }
    
}
