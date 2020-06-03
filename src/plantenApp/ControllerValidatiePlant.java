package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.AbiotischeFactoren;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.Plant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ControllerValidatiePlant {
    public Label lblBehandeling1;
    public Label lblBehandeling2;
    public Label lblFrequentie1;
    public Label lblFrequentie2;
    public CheckBox cbxJan1;
    public CheckBox cbxFeb1;
    public CheckBox cbxMaa1;
    public CheckBox cbxApr1;
    public CheckBox cbxMei1;
    public CheckBox cbxJun1;
    public CheckBox cbxJul1;
    public CheckBox cbxAug1;
    public CheckBox cbxSep1;
    public CheckBox cbxOkt1;
    public CheckBox cbxNov1;
    public CheckBox cbxDec1;
    public CheckBox cbxJan2;
    public CheckBox cbxFeb2;
    public CheckBox cbxMaa2;
    public CheckBox cbxApr2;
    public CheckBox cbxMei2;
    public CheckBox cbxJun2;
    public CheckBox cbxJul2;
    public CheckBox cbxAug2;
    public CheckBox cbxSep2;
    public CheckBox cbxOkt2;
    public CheckBox cbxNov2;
    public CheckBox cbxDec2;
    public Label lblXValue;
    public Label lblYValue;
    public Label lblType;
    public Label lblValue;
    public Label lblGeslacht;
    public Label lblSoort;
    public Label lblVariant;
    public Label lblOntwikkelingssnelheid;
    public CheckBox cbxSociabiliteit1;
    public CheckBox cbxSociabiliteit2;
    public CheckBox cbxSociabiliteit3;
    public CheckBox cbxSociabiliteit4;
    public CheckBox cbxSociabileit5;
    public Label lblStrategie;
    public Label lblLevensduur;
    public Slider sldrBezonning;
    public Label lblBezonning;
    public Slider sldrVochtBehoefte;
    public Label lblVochtBehoefte;
    public Slider sldrVoedingsbehoefte;
    public Label lblVoedingsbehoefte;
    public Label lblReactie;
    public Label lblGrondsoort;
    public Label lblHabitat;
    public Slider sldrNectarwaarde;
    public Label lblNectarwaarde;
    public Slider sldrPollenwaarde;
    public Label lblPollenwaarde;
    public Label lblBijvriendelijk;
    public Label lblVlindervriendelijk;
    public Label lblEetbaar;
    public Label lblKruidgebruik;
    public Label lblGeurend;
    public Label lblVorstgevoelig;
    PlantDAO plantDAO;
    Connection dbConnection;
    AbiotischeFactorenDAO abiotischeFactorenDAO;
    BeheerDAO beheerDAO;
    CommensalismeDAO commensalismeDAO;
    FotoDAO fotoDAO;
    InfoTablesDAO infoTablesDAO;
    ExtraDAO extraDAO;
    Plant plant;

    public ControllerValidatiePlant() throws SQLException {
    }

    public void initialize() throws SQLException {
        Connection dbcon = Database.getInstance().getConnection();
        PlantDAO dao = new PlantDAO(dbcon);
        Plant plant = dao.getPlantById(101);
        System.out.println(plant.getFamilie());

        DBInitialize();
        BeheerInitialize();
        CommensalismeInitialize();
    }


    public void Clicked_Ok(MouseEvent mouseEvent) throws IOException {
        Schermkiezen(mouseEvent, "Zoekscherm");
    }

    public void Clicked_NietOk(MouseEvent mouseEvent) throws IOException {
        Schermkiezen(mouseEvent, "Zoekscherm");
    }

    public void Schermkiezen(MouseEvent mouseEvent, String scherm) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/" + scherm + ".fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    private void DBInitialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        beheerDAO = new BeheerDAO(dbConnection);
        commensalismeDAO = new CommensalismeDAO(dbConnection);
        extraDAO = new ExtraDAO(dbConnection);
        fotoDAO = new FotoDAO(dbConnection);
        infoTablesDAO = new InfoTablesDAO(dbConnection);
        plantDAO = new PlantDAO(dbConnection);

    }

    private void BeheerInitialize() throws SQLException {
        plant.setBeheer(plant.getBeheer());
        lblBehandeling1.setText("" + plantDAO.getPlantById(1).getBeheer());
        lblFrequentie1.setText("" + plantDAO.getPlantById(1).getBeheer());
        lblBehandeling2.setText("" + plantDAO.getPlantById(2).getBeheer());
        lblFrequentie2.setText("" + plantDAO.getPlantById(2).getBeheer());

    }

    private void CommensalismeInitialize() throws SQLException {
        plant.setCommensalisme(plant.getCommensalisme());
        lblOntwikkelingssnelheid.setText("" + plantDAO.getPlantById(1).getCommensalisme());
        lblStrategie.setText("" + plantDAO.getPlantById(1).getCommensalisme());
        lblLevensduur.setText("" + plantDAO.getPlantById(1).getCommensalisme());
    }


}
