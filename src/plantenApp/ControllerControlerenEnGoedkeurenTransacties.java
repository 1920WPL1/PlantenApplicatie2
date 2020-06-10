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

public class ControllerControlerenEnGoedkeurenTransacties {
    // Auteur Dario
    // enum aangemaakt voor magic numbers te vermijden voor te zoeken naar de status van de plant
    public enum Status {
        //Naamgeving van waardes
        inBewerking(0),
        teControleren(1),
        goedgekeurd(2);

        //variabel voor enum
        private final int statusValue;

        //Constructor enum
        Status(int i) {
            this.statusValue = i;
        }

        //getter enum
        public int GetStatusValeu() {
            return statusValue;
        }
    }

    public enum Rol {
        gast,
        leerling,
        admin,
        docent
    }

    // Variabelen
    public List<Plant> lijstPlanten = new ArrayList<Plant>();
    public Gebruiker gebruiker;
    public GebruikerDAO gebruikerDAO;
    public PlantDAO plantDAO;
    public Connection dbconnection;


    public AnchorPane AnchorPaneBase;
    public TitledPane TitledPaneMain;
    public ScrollPane ScrollPaneList;

    public VBox VBoxPlantNaam;
    public VBox VBoxNaamGebruiker;
    public VBox VBoxDatumToegevoegd;
    public VBox VBoxStatusPlant;
    public VBox VBoxButtonsControleer;
    public HBox HBoxListToCheck;

    //Deze waarde bepaald de weergave van de lijst.
    public Status StatusToCheck;

    //Author : Dario -> Constructor
    public ControllerControlerenEnGoedkeurenTransacties() throws SQLException {
    }

    //Author : Dario -> Initialize
    //Editor : Leandro -> fout-afhandeling ingestoken + Methode LijstWeerTeGevenControle();
    public void initialize() throws SQLException {
        try {
            dbconnection = Database.getInstance().getConnection();
            plantDAO = new PlantDAO(dbconnection);
            gebruikerDAO = new GebruikerDAO(dbconnection);
            gebruiker = gebruikerDAO.getGebruikerById(4); //test  4   leerling : 1
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Er liep iets fout met de verbinding");
        }

        LijstWeerTeGevenControle();
        if (lijstPlanten.size() == 0) {
            Label temp = new Label("Er zijn geen planten te controleren.");
            temp.setStyle("-fx-font: 14 system;");
            temp.setPadding(new Insets(0, 30, 0, 30));
            HBoxListToCheck.getChildren().clear();
            HBoxListToCheck.getChildren().add(temp);
        } else {
            try {
                for (int i = 0; i < lijstPlanten.size(); i++) {
                    Gebruiker temp = gebruikerDAO.getGebruikerById(lijstPlanten.get(i).getLaatste_update_door());
                    AddToCheckLine(lijstPlanten.get(i).getId(), lijstPlanten.get(i).getFgsv().trim(), temp.getVoornaam().trim() + " " + temp.getAchternaam(), lijstPlanten.get(i).getLaatste_update_datum(), lijstPlanten.get(i).getStatus());
                }
            } catch (NullPointerException ne) {
                JOptionPane.showMessageDialog(null, "Er zijn bepaalde gegevens van de gebruiker niet gevonden");
            }

        }
        SchermProperties();
    }


    // Functions
    // Auteur Dario
    // genereert een nieuwe regel dat gecontroleerd moet worden
    private void AddToCheckLine(int plantID, String plantnaam, String naamGebruiker, Date lastUpdated, int status) {
        //Labels aanmaken voor in de nieuwe regel
        Label linePlantnaam = new Label("Plant: " + plantnaam);
        Label lineNaamGebruiker = new Label("Aangepast door: " + naamGebruiker);
        Label lineDatumToegevoed = new Label("Datum: " + lastUpdated);

        //Labels stylen voor in de nieuwe regel
        linePlantnaam.setStyle("-fx-font: 14 system;");
        lineNaamGebruiker.setStyle("-fx-font: 14 system;");
        lineDatumToegevoed.setStyle("-fx-font: 14 system;");

        Button bttnControleer = new Button("controleer");
        bttnControleer.setId(Integer.toString(plantID));
        bttnControleer.setStyle("-fx-font: 14 system;");

        if (gebruiker.getRol().equals("student")) {
            Status temp = null;
            switch (status)
            {
                case 0:
                    temp = Status.inBewerking;
                    break;
                case 1:
                    temp = Status.teControleren;
                    break;
                case 2:
                    temp = Status.goedgekeurd;
                    break;
            }
            Label lineStatusPlant = new Label("status: " + temp);
            lineStatusPlant.setStyle("-fx-font: 14 system;");
            VBoxStatusPlant.getChildren().add(lineStatusPlant);

            bttnControleer.setText("Wijzigen");
            //Click event aanmaken voor op de Button voor de nieuwe regel
            bttnControleer.setOnMouseClicked(mouseEvent -> {
                try {
                    ButtonEventGoToCheckID(bttnControleer, "PlantWijzigen");
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            });
        } else if ((gebruiker.getRol().equals("docent")) || (gebruiker.getRol().equals("admin"))) {
            System.out.println("ik ga in docent");
            bttnControleer.setText("Controleren");

            //Click event aanmaken voor op de Button voor de nieuwe regel
            bttnControleer.setOnMouseClicked(mouseEvent -> {
                try {
                    ButtonEventGoToCheckID(bttnControleer, "GedetailleerdeFiches_(teControleren)");
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            });
        }
        //De regel plaatsen in de bestaande Vboxen. Dit dient om een mooie uitlijning te krijgen
        VBoxPlantNaam.getChildren().add(linePlantnaam);
        VBoxNaamGebruiker.getChildren().add(lineNaamGebruiker);
        VBoxDatumToegevoegd.getChildren().add(lineDatumToegevoed);
        VBoxButtonsControleer.getChildren().add(bttnControleer);
    }

    // Auteur Dario
    // opent de gedetailleerde scherm met de gevraagde ID
    private void ButtonEventGoToCheckID(Button button, String Scherm) throws IOException, SQLException {
        //Hier vang ik de verwijzing op indien ze  een scherm meegeven die niet bestaat
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/" + Scherm + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            //Hier link ik een event (bijvoorbeeld button) aan zodat het scherm open gaat bij het event
            Stage window = (Stage) button.getScene().getWindow();
            //Controller Aanvragen van Scherm (deze is gelinkt in schermxml) --> KLasse Controller nog aanpassen naar correcte controller volgens scherm.
            ControllerValidatiePlant controller = loader.getController();
            //hier de Methode initialize aan gesproken en parameter meegegeven. --> Indien de methode anders gebruik word moet deze hier ook aangepast worden.
            controller.initialize(Integer.parseInt(button.getId()));
            window.setScene(scene);
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Het gevraagde scherm is niet gevonden");
        }
    }

    // Auteur Dario
    // gaat terug naar zoekscherm
    public void Clicked_terug(MouseEvent mouseEvent) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/Zoekscherm.fxml"));
            Scene scene = new Scene(root);
            //Hier link ik een event (bijvoorbeeld button) aan zodat het scherm open gaat bij het event
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Het gevraagde scherm is niet gevonden");
        }
    }

    // Auteur Dario
    // het zetten van de scherm properties zodat het mee transformeert met de window
    private void SchermProperties() {
        // dit doen we om een correcte hoogte & breedte weer te geven bij opstart
        AnchorPaneBase.setPrefHeight(ScrollPaneList.getHeight());
        AnchorPaneBase.setPrefWidth(ScrollPaneList.getWidth());

        //Hier binden we de title pane aan de anchorpane
        TitledPaneMain.prefWidthProperty().bind(AnchorPaneBase.widthProperty());
        TitledPaneMain.prefHeightProperty().bind(AnchorPaneBase.heightProperty());
    }

    //Author : Leandro
    private void LijstWeerTeGevenControle() throws SQLException {
        try {
            switch (gebruiker.getRol()) {
                case "student":
                    lijstPlanten = plantDAO.Getplantbylaatstupdatedoor(gebruiker.getID());
                    System.out.println("student");
                    break;
                case "docent":
                case "admin":
                    lijstPlanten = plantDAO.GetPlantIdByStatus(Status.teControleren.statusValue);
                    System.out.println("docent/admin");
                    break;
                default:
                    StatusToCheck = null;
                    lijstPlanten = null;
                    break;
            }

        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Er werd geen gebruiker terug gevonden");

        }
    }
}
