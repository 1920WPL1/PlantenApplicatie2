package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.AbiotischeFactoren;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.Plant;

import javax.swing.*;
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
    public Label lblGeslacht;
    public Label lblSoort;
    public Label lblVariant;
    public Label lblOntwikkelingssnelheid;
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
    public ImageView imgHabitus;
    public ImageView imgBlad;
    public ImageView imgBloei;
    public CheckBox cbxSoc1;
    public CheckBox cbxSoc2;
    public CheckBox cbxSoc3;
    public CheckBox cbxSoc4;
    public CheckBox cbxSoc5;
    public Label lblsoc;
    public Label lblFamilie;



    public PlantDAO plantDAO;
    Connection dbConnection;
    public AbiotischeFactorenDAO abiotischeFactorenDAO;
    BeheerDAO beheerDAO;
    CommensalismeDAO commensalismeDAO;
    FotoDAO fotoDAO;
    InfoTablesDAO infoTablesDAO;
    ExtraDAO extraDAO;
    public Plant plant;

    public ControllerValidatiePlant() throws SQLException {
    }

    public void initialize() throws SQLException {
        DBInitialize();
        plant = plantDAO.getPlantById(101);
        System.out.println(plant.getFamilie());


        BeheerInitialize();
        CommensalismeInitialize();
        AbiotischeInitialize();
        ExtraInitialize();
        FotoInitialize();
        StandaardInitialize();
    }


    public void Clicked_Ok(MouseEvent mouseEvent) throws IOException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked OK, Click OK to continue", "Clicked OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");
        }
    }

    public void Clicked_NietOk(MouseEvent mouseEvent) throws IOException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked NIET OK, Click OK to continue", "Clicked Niet OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");
        }
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

    private void AbiotischeInitialize() throws SQLException {
        System.out.println(abiotischeFactorenDAO.getById(101).getBezonning());
        plant.setAbiotischeFactoren(abiotischeFactorenDAO.getById(101));
        lblBezonning.setText("" + plant.getAbiotischeFactoren().getBezonning());
        lblVochtBehoefte.setText("" + plant.getAbiotischeFactoren().getVochtbehoefte());
        lblVoedingsbehoefte.setText("" + plant.getAbiotischeFactoren().getVoedingsbehoefte());
        lblReactie.setText("" + plant.getAbiotischeFactoren().getReactieAntagonistischeOmgeving());
        lblGrondsoort.setText("" + plant.getAbiotischeFactoren().getGrondsoort());
        lblHabitat.setText("" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(1).getValue());
    }

    private void BeheerInitialize() throws SQLException {
        plant.setBeheer(beheerDAO.getById(101));
        lblBehandeling1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getOpmerking());
        lblFrequentie1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getFrequentie());
        //cbxJan1.isSelected(plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxFeb1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxMaa1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxApr1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxMei1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxJun1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxJul1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxAug1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxJul1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxSep1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxOkt1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxNov1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());
        cbxDec1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getMaand());

    }

    private void CommensalismeInitialize() throws SQLException {
        plant.setCommensalisme(commensalismeDAO.getById(101));
        lblOntwikkelingssnelheid.setText("" + plant.getCommensalisme().getOntwikkelingssnelheid());
        lblStrategie.setText("" + plant.getCommensalisme().getStrategie());
        lblLevensduur.setText("" + infoTablesDAO.getInfoTables().getConcurentiekrachten().get(1));
        lblsoc.setText("" + plant.getCommensalisme().getMultiEigenschappen().get(1).getValue());
        /*if (){
            cbxSoc1.setSelected(true);
            cbxSoc2.setSelected(false);
            cbxSoc3.setSelected(false);
            cbxSoc4.setSelected(false);
            cbxSoc5.setSelected(false);
        } else if (){
            cbxSoc1.setSelected(false);
            cbxSoc2.setSelected(true);
            cbxSoc3.setSelected(false);
            cbxSoc4.setSelected(false);
            cbxSoc5.setSelected(false);
        } else if (){
            cbxSoc1.setSelected(false);
            cbxSoc2.setSelected(false);
            cbxSoc3.setSelected(true);
            cbxSoc4.setSelected(false);
            cbxSoc5.setSelected(false);
        } else if (){
            cbxSoc1.setSelected(false);
            cbxSoc2.setSelected(false);
            cbxSoc3.setSelected(false);
            cbxSoc4.setSelected(true);
            cbxSoc5.setSelected(false);
        } else {
            cbxSoc1.setSelected(false);
            cbxSoc2.setSelected(false);
            cbxSoc3.setSelected(false);
            cbxSoc4.setSelected(false);
            cbxSoc5.setSelected(true);
        }*/
    }

    private void ExtraInitialize() throws SQLException {
        plant.setExtra(extraDAO.getExtraById(101));
        lblNectarwaarde.setText("" + plant.getExtra().getNectarwaarde());
        lblPollenwaarde.setText("" + plant.getExtra().getPollenwaarde());
        lblBijvriendelijk.setText("" + plant.getExtra().getBijvriendelijk());
        //lblVlindervriendelijk.setText("" + plant.getExtra());
        lblEetbaar.setText("" + plant.getExtra().getEetbaar());
        lblKruidgebruik.setText("" + plant.getExtra().getKruidgebruik());
        lblGeurend.setText("" + plant.getExtra().getGeurend());
        lblVorstgevoelig.setText("" + plant.getExtra().getVorstgevoelig());
    }

    private void FotoInitialize() throws SQLException {
        try {
            plant.setFoto(fotoDAO.getFotoById(101));

            imgHabitus.setImage((Image) plant.getFoto().getFotos().get(1).getImage());
            imgBlad.setImage((Image) plant.getFoto().getFotos().get(1).getImage());
            imgBloei.setImage((Image) plant.getFoto().getFotos().get(1).getImage());
        } catch (NullPointerException npe) {
            System.out.println("Geen foto");
        }

    }

    private void StandaardInitialize() throws SQLException {
        lblType.setText("" + plant.getType());
        lblFamilie.setText("" + plant.getFamilie());
        lblGeslacht.setText("" + plant.getGeslacht());
        lblSoort.setText("" + plant.getSoort());
        lblVariant.setText("" + plant.getVariatie());
    }


}
