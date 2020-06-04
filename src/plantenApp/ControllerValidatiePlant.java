package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.Plant;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ControllerValidatiePlant {

    public Button btn_Ok;
    public Button btn_Wijzig;
    public Button btnTerug;
    public Label blMxBladhoogteJan;
    public Label blMxBladhoogteFeb;
    public Label blMxBladhoogteMaa;
    public Label blMxBladhoogteApr;
    public Label blMxBladhoogteMei;
    public Label blMxBladhoogteJun;
    public Label blMxBladhoogteJul;
    public Label blMxBladhoogteAug;
    public Label blMxBladhoogteSept;
    public Label blMxBladhoogteOkt;
    public Label blMxBladhoogteNov;
    public Label blMxBladhoogteDec;
    public Label lblBladKlrJan;
    public Label lblBladKlrFeb;
    public Label lblBladKlrMaa;
    public Label lblBladKlrApr;
    public Label lblBladKlrMei;
    public Label lblBladKlrJun;
    public Label lblBladKlrJul;
    public Label lblBladKlrAug;
    public Label lblBladKlrSept;
    public Label lblBladKlrOkt;
    public Label lblBladKlrNov;
    public Label lblBladKlrDec;
    public Label blMinBloeihoogteJan;
    public Label blMinBloeihoogteFeb;
    public Label blMinBloeihoogteMaa;
    public Label blMinBloeihoogteApr;
    public Label blMinBloeihoogteMei;
    public Label blMinBloeihoogteJun;
    public Label blMinBloeihoogteJul;
    public Label blMinBloeihoogteAug;
    public Label blMinBloeihoogteOkt;
    public Label blMinBloeihoogteNov;
    public Label blMinBloeihoogteDev;
    public Label blMxBloeihoogteJan;
    public Label blMxBloeihoogteFeb;
    public Label blMxBloeihoogteMaa;
    public Label blMxBloeihoogteApr;
    public Label blMxBloeihoogteMei;
    public Label blMxBloeihoogteJun;
    public Label blMxBloeihoogteJul;
    public Label blMxBloeihoogteAug;
    public Label blMxBloeihoogteSept;
    public Label blMxBloeihoogteOkt;
    public Label blMxBloeihoogteNov;
    public Label blMxBloeihoogteDec;
    public Label lblBloeiKlrJan;
    public Label lblBloeiKlrFeb;
    public Label lblBloeiKlrMaa;
    public Label lblBloeiKlrApr;
    public Label lblBloeiKlrMei;
    public Label lblBloeiKlrJun;
    public Label lblBloeiKlrJul;
    public Label lblBloeiKlrAug;
    public Label lblBloeiKlrSept;
    public Label lblBloeiKlrOkt;
    public Label lblBloeiKlrNov;
    public Label lblBloeiKlrDec;
    public Label lblBldGrootte;
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
    public Label lblHabitus;
    public Label lblBldVrm;
    public Label lblRatio;
    public Label lblSpruitfnlgie;
    public Label lblRaunkhiaer;
    public Label lblBloeiwijze;
    public Label Sept;
    public String Scherm;
    public FenotypeDAO fenotypeDAO;
    Plant plant;
    PlantDAO plantDAO;
    AbiotischeFactorenDAO abiotischeFactorenDAO;
    BeheerDAO beheerDAO;
    CommensalismeDAO commensalismeDAO;
    FotoDAO fotoDAO;
    InfoTablesDAO infoTablesDAO;
    ExtraDAO extraDAO;

    public void initialize(int plantID) throws SQLException {



        DBInitialize();
        //plant = plantDAO.getPlantById(plantID);
        // FenoInitialize();
        // BeheerInitialize();
        // AbiotischeInitialize();
        //   CommensalismeInitialize();
    }


    public void Clicked_Wijzig(MouseEvent mouseEvent) throws IOException {
        Scherm = "PlantWijzigen";
        Schermkiezen(mouseEvent, Scherm);
    }

    public void Clicked_Terug(MouseEvent mouseEvent) throws IOException {
        Scherm = "ControlerenEnGoedkeurenTransacties";
        Schermkiezen(mouseEvent, Scherm);
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

/*
    private void FenoInitialize() throws SQLException {
        plant.setFenotype(fenotypeDAO.getById(1));
        String PlantFeno= plant.getFenotype();
        lblBldGrootte.setText("" + plant.getFenotype().getBladgrootte());
        lblBldVrm.setText(plant.getFenotype().getBladvorm());
        lblRatio.setText(plant.getFenotype().getRatio_bloei_blad());
        lblSpruitfnlgie.setText(plant.getFenotype().getSpruitfenologie());
        lblRaunkhiaer.setText(plant.getFenotype().getLevensvorm());
        lblHabitus.setText(plant.getFenotype().getHabitus());
        lblBloeiwijze.setText(plant.getFenotype().getBloeiwijze());
        blMxBladhoogteJan.setText(""+plant.getFenotype().getMultiEigenschappen().get(0));
        blMxBloeihoogteFeb.setText(""+plant.getFenotype().getMultiEigenschappen().get(0));
        blMxBladhoogteMaa.setText(""+plant.getFenotype().getMultiEigenschappen().get(5));
        blMinBloeihoogteApr.setText(""+plant.getFenotype().getMultiEigenschappen().get(6));
        blMxBladhoogteAug.setText(""+plant.getFenotype().getMultiEigenschappen().get(4));


    }
*/

    private void DBInitialize() throws SQLException {
        Connection dbConnection = Database.getInstance().getConnection();
        abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
        beheerDAO = new BeheerDAO(dbConnection);
        commensalismeDAO = new CommensalismeDAO(dbConnection);
        extraDAO = new ExtraDAO(dbConnection);
        fotoDAO = new FotoDAO(dbConnection);
        infoTablesDAO = new InfoTablesDAO(dbConnection);
        plantDAO = new PlantDAO(dbConnection);
        fenotypeDAO = new FenotypeDAO(dbConnection);

    }
/*
    private void AbiotischeInitialize() throws SQLException {
        System.out.println(abiotischeFactorenDAO.getById(101).getBezonning());
        plant.setAbiotischeFactoren(abiotischeFactorenDAO.getById(101));
        lblBezonning.setText("" + plant.getAbiotischeFactoren().getBezonning());
        lblVochtBehoefte.setText("" + plant.getAbiotischeFactoren().getVochtbehoefte());
        lblVoedingsbehoefte.setText("" + plant.getAbiotischeFactoren().getVoedingsbehoefte());
        lblReactie.setText("" + plant.getAbiotischeFactoren().getReactieAntagonistischeOmgeving());
        lblGrondsoort.setText("" + plant.getAbiotischeFactoren().getGrondsoort());
        lblHabitat.setText("" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(0).getId());
    }

    private void BeheerInitialize() throws SQLException {
        plant.setBeheer(beheerDAO.getById(101));
        lblBehandeling1.setText("" + plant.getBeheer());
        lblFrequentie1.setText("" + plant.getBeheer());
        lblBehandeling2.setText("" + plant.getBeheer());
        lblFrequentie2.setText("" + plant.getBeheer());
        cbxJan1.setText("" + plant.getBeheer());
        cbxFeb1.setText("" + plant.getBeheer());
        cbxMaa1.setText("" + plant.getBeheer());
        cbxApr1.setText("" + plant.getBeheer());
        cbxMei1.setText("" + plant.getBeheer());
        cbxJun1.setText("" + plant.getBeheer());
        cbxJul1.setText("" + plant.getBeheer());
        cbxAug1.setText("" + plant.getBeheer());
        cbxJul1.setText("" + plant.getBeheer());
        cbxSep1.setText("" + plant.getBeheer());
        cbxOkt1.setText("" + plant.getBeheer());
        cbxNov1.setText("" + plant.getBeheer());
        cbxDec1.setText("" + plant.getBeheer());

    }

    private void CommensalismeInitialize() throws SQLException {
        plant.setCommensalisme(commensalismeDAO.getById(101));
        lblOntwikkelingssnelheid.setText("" + plant.getCommensalisme().getOntwikkelingssnelheid());
        lblStrategie.setText("" + plant.getCommensalisme().getStrategie());
        lblLevensduur.setText("" + plant.getCommensalisme());
    }

    private void ExtraInitialize() throws SQLException {
        plant.setExtra(plant.getExtra());
        lblNectarwaarde.setText("" + plantDAO.getPlantById(1).getExtra());
        lblPollenwaarde.setText("" + plantDAO.getPlantById(1).getExtra());
        lblBijvriendelijk.setText("" + plantDAO.getPlantById(1).getExtra());
        lblVlindervriendelijk.setText("" + plantDAO.getPlantById(1).getExtra());
        lblEetbaar.setText("" + plantDAO.getPlantById(1).getExtra());
        lblKruidgebruik.setText("" + plantDAO.getPlantById(1).getExtra());
        lblGeurend.setText("" + plantDAO.getPlantById(1).getExtra());
        lblVorstgevoelig.setText("" + plantDAO.getPlantById(1).getExtra());
    }

    private void FotoInitialize() throws SQLException {
        plant.setFoto(plant.getFoto());
  /*   imgHabitus.setImage(fotoDAO.getFotoById(1).getFotos());
    imgBlad.setImage(fotoDAO.getFotoById(1).getFotos());
    imgBloei.setImage(fotoDAO.getFotoById(1).getFotos());
    }
 */

}





