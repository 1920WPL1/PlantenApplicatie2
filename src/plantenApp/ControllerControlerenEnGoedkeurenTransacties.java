// Auteur Dario
package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import plantenApp.java.dao.Database;
import plantenApp.java.dao.GebruikerDAO;
import plantenApp.java.dao.PlantDAO;
import plantenApp.java.model.Gebruiker;
import plantenApp.java.model.Plant;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerControlerenEnGoedkeurenTransacties
{
    // Auteur Dario
    // enum aangemaakt voor magic numbers te vermijden voor te zoeken naar de status van de plant
    public enum Status
    {
        inBewerking (0),
        teControleren (1),
        goedgekeurt (2);

        private final int statusValue;

        Status(int i)
        {
            this.statusValue = i;
        }
        public int GetStatusValeu(){return statusValue;}
    }

    // Variabelen
    public List<Plant> lijstTeControleren = new ArrayList<Plant>();
    public Gebruiker gebruiker;

    PlantDAO plantDAO;
    GebruikerDAO gebruikerDAO;
    Connection dbconnection;

    public AnchorPane AnchorPaneBase;
    public TitledPane TitledPaneMain;
    public ScrollPane ScrollPaneList;

    public VBox VBoxPlantNaam;
    public VBox VBoxNaamGebruiker;
    public VBox VBoxDatumToegevoegd;
    public VBox VBoxButtonsControleer;
    public HBox HBoxListToCheck;

    private final Status StatusToCheck = Status.teControleren;

    // Constructor
    public ControllerControlerenEnGoedkeurenTransacties() throws SQLException
    {
    }

    // Initialize
    public void initialize() throws SQLException
    {
        try
        {
            dbconnection  = Database.getInstance().getConnection();
            plantDAO = new PlantDAO(dbconnection);
            gebruikerDAO = new GebruikerDAO(dbconnection);
            lijstTeControleren = plantDAO.GetPlantIdByStatus(StatusToCheck.statusValue);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Er liep iets fout met de verbinding");
        }


        if (lijstTeControleren.size() == 0)
        {
            Label temp = new Label("Er zijn geen planten te controleren.");
            temp.setStyle("-fx-font: 14 system;");
            temp.setPadding(new Insets(0,30,0,30));
            HBoxListToCheck.getChildren().clear();
            HBoxListToCheck.getChildren().add(temp);
        }
        else
        {
            for(int i = 0 ; i < lijstTeControleren.size(); i++)
            {
                gebruiker = gebruikerDAO.getGebruikerById(lijstTeControleren.get(i).getGebruikerID());
                AddToCheckLine(lijstTeControleren.get(i).getId(), lijstTeControleren.get(i).getFgsv().trim(), gebruiker.getVoornaam() + " " + gebruiker.getAchternaam(), lijstTeControleren.get(i).getLastUpdated());
            }
        }

        SchermProperties();
    }

    // Functions
    // Auteur Dario
    // genereert een nieuwe regel dat gecontroleert moet worden
    private void AddToCheckLine(int plantID, String plantnaam, String naamGebruiker, Date lastUpdated)
    {
        Label linePlantnaam = new Label("Plant: " + plantnaam);
        Label lineNaamGebruiker = new Label("Aangepast door: " + naamGebruiker);
        Label lineDatumToegevoed = new Label( "Datum: " + lastUpdated);

        linePlantnaam.setStyle("-fx-font: 14 system;");
        lineNaamGebruiker.setStyle("-fx-font: 14 system;");
        lineDatumToegevoed.setStyle("-fx-font: 14 system;");

        Button bttnControleer = new Button("Controleer");
        bttnControleer.setId(Integer.toString(plantID));
        bttnControleer.setStyle("-fx-font: 14 system;");

        bttnControleer.setOnAction(actionEvent -> {
            try
            {
                ButtonEventGoToCheckID(bttnControleer);
            } catch (IOException | SQLException e)
            {
                e.printStackTrace();
            }
        });

        VBoxPlantNaam.getChildren().add(linePlantnaam);
        VBoxNaamGebruiker.getChildren().add(lineNaamGebruiker);
        VBoxDatumToegevoegd.getChildren().add(lineDatumToegevoed);
        VBoxButtonsControleer.getChildren().add(bttnControleer);
    }

    // Auteur Dario
    // opent de gedetailleerde scherm met de gevraagde ID
    private void ButtonEventGoToCheckID(Button button) throws IOException, SQLException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/GedetailleerdeFiches_(teControleren).fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage window = (Stage) button.getScene().getWindow();

        ControllerValidatiePlant controller = loader.getController();
        controller.initialize(Integer.parseInt(button.getId()));

        window.setScene(scene);
        window.show();
    }

    // Auteur Dario
    // gaat terug naar zoekscherm
    public void Clicked_terug(MouseEvent mouseEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("view/Zoekscherm.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    // Auteur Dario
    // het zetten van de scherm properties zodat het mee transformeert met de window
    private void SchermProperties()
    {
        AnchorPaneBase.setPrefHeight(ScrollPaneList.getHeight());
        AnchorPaneBase.setPrefWidth(ScrollPaneList.getWidth());

        TitledPaneMain.prefWidthProperty().bind(AnchorPaneBase.widthProperty());
        TitledPaneMain.prefHeightProperty().bind(AnchorPaneBase.heightProperty());
    }
}
