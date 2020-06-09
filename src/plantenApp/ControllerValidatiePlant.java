package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import plantenApp.java.dao.*;
import plantenApp.java.model.FenoMulti_Eigenschap;
import plantenApp.java.model.Fenotype;
import plantenApp.java.model.Plant;

import javax.swing.*;
import java.io.IOException;
import java.sql.Blob;
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
    public CheckBox cbxSoc1;
    public CheckBox cbxSoc2;
    public CheckBox cbxSoc3;
    public CheckBox cbxSoc4;
    public CheckBox cbxSoc5;
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
    public ImageView imgHabitus;
    public ImageView imgBlad;
    public ImageView imgBloei;
    public Label lblmin;
    public Label lblmax;
    public Label lblFamilie;
    public javafx.scene.control.ScrollPane ScrollPane;
    public AnchorPane Anchorpane;
    public String Scherm;
    public FenotypeDAO fenotypeDAO;
    public Plant plant;
    public PlantDAO plantDAO;
    public AbiotischeFactorenDAO abiotischeFactorenDAO;
    public BeheerDAO beheerDAO;
    public CommensalismeDAO commensalismeDAO;
    public FotoDAO fotoDAO;
    public InfoTablesDAO infoTablesDAO;
    public ExtraDAO extraDAO;
    public FenoMulti_Eigenschap MultiFenoBldHgte;
    public FenoMulti_Eigenschap MultiFenoBloeiHgte;
    public FenoMulti_Eigenschap MultiFenoBldkleur;
    public FenoMulti_Eigenschap MultiFenoBloeikleur;
    Connection dbConnection;

    //Author : Leandro , Een Parameter Plantid toegevoegd om de Waarde van ControlerenEnGoedkeurenTransacties Scherm  te onthouden
    public void initialize(Integer Plantid) throws SQLException, IOException {
        SchermInitialize();
        DBInitialize();
        plant = plantDAO.getPlantById(Plantid);
        FenoInitialize();
        BeheerInitialize();
        AbiotischeInitialize();
        CommensalismeInitialize();
        ExtraInitialize();
        FotoInitialize();
        StandaardInitialize();

    }

    //Author : Leandro & Ayoub : Hier maken we connectie met alle dao's om de gegevens te halen.
    private void DBInitialize() throws SQLException {
        //Fout-afhandeling indien er geen connectie kan gemaakt worden
        try {
            dbConnection = Database.getInstance().getConnection();
            abiotischeFactorenDAO = new AbiotischeFactorenDAO(dbConnection);
            beheerDAO = new BeheerDAO(dbConnection);
            commensalismeDAO = new CommensalismeDAO(dbConnection);
            extraDAO = new ExtraDAO(dbConnection);
            fotoDAO = new FotoDAO(dbConnection);
            infoTablesDAO = new InfoTablesDAO(dbConnection);
            plantDAO = new PlantDAO(dbConnection);
            fenotypeDAO = new FenotypeDAO(dbConnection);
        } catch (
                Exception CE) {
            JOptionPane.showMessageDialog(null, "Er liep iets fout met de verbinding");

        }

    }

    public void Clicked_Wijzig(MouseEvent mouseEvent) throws IOException, SQLException {
        Scherm = "PlantWijzigen";
        Schermkiezen(mouseEvent, Scherm, plant.getId());

    }

    public void Clicked_Terug(MouseEvent mouseEvent) throws IOException {
        Scherm = "ControlerenEnGoedkeurenTransacties";
        Schermkiezen(mouseEvent, Scherm);
    }

    public void Clicked_Ok(MouseEvent mouseEvent) throws IOException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked OK, Click OK to continue", "Clicked OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            plantDAO.setStatus(2,plant.getId());
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");


        }
    }

    public void Clicked_NietOk(MouseEvent mouseEvent) throws IOException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked NIET OK, Click OK to continue", "Clicked Niet OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            plantDAO.setStatus(0,plant.getId());
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");


        }
    }

    public void Schermkiezen(MouseEvent mouseEvent, String scherm) throws IOException {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("view/" + scherm + ".fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Scherm niet gevonden");
        }
    }

    public void Schermkiezen(MouseEvent mouseEvent, String scherm, Integer PlantId) throws IOException, SQLException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/" + scherm + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Controller controller = loader.getController();
            controller.initialize(PlantId);
            window.setScene(scene);
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Het gevraagde scherm is niet gevonden");
        }
    }

    private void FenoInitialize() throws SQLException {
        try {
            plant.setFenotype(fenotypeDAO.getById(plant.getId()));
            Fenotype PlantFeno = plant.getFenotype();
            MultiFenoBldHgte = PlantFeno.getMultiEigenschappen().get(0);
            MultiFenoBloeiHgte = PlantFeno.getMultiEigenschappen().get(1);
            MultiFenoBldkleur = PlantFeno.getMultiEigenschappen().get(2);
            MultiFenoBloeikleur = PlantFeno.getMultiEigenschappen().get(3);
            lblBldGrootte.setText("" + PlantFeno.getBladgrootte());
            lblBldVrm.setText(PlantFeno.getBladvorm());
            lblRatio.setText(PlantFeno.getRatio_bloei_blad());
            lblSpruitfnlgie.setText(PlantFeno.getSpruitfenologie());
            lblRaunkhiaer.setText(PlantFeno.getLevensvorm());
            lblHabitus.setText(PlantFeno.getHabitus());
            lblBloeiwijze.setText(PlantFeno.getBloeiwijze());
            blMxBladhoogteJan.setText(MultiFenoBldHgte.getJan());
            blMxBladhoogteFeb.setText(MultiFenoBldHgte.getFeb());
            blMxBladhoogteMaa.setText(MultiFenoBldHgte.getMaa());
            blMxBladhoogteApr.setText(MultiFenoBldHgte.getApr());
            blMxBladhoogteMei.setText(MultiFenoBldHgte.getMei());
            blMxBladhoogteJun.setText(MultiFenoBldHgte.getJun());
            blMxBladhoogteJul.setText(MultiFenoBldHgte.getJul());
            blMxBladhoogteAug.setText(MultiFenoBldHgte.getAug());
            blMxBladhoogteSept.setText(MultiFenoBldHgte.getSep());
            blMxBladhoogteOkt.setText(MultiFenoBldHgte.getOkt());
            blMxBladhoogteNov.setText(MultiFenoBldHgte.getNov());
            blMxBladhoogteDec.setText(MultiFenoBldHgte.getDec());

            lblBladKlrJan.setText(MultiFenoBldkleur.getJan());
            lblBladKlrFeb.setText(MultiFenoBldkleur.getFeb());
            lblBladKlrMaa.setText(MultiFenoBldkleur.getMaa());
            lblBladKlrApr.setText(MultiFenoBldkleur.getApr());
            lblBladKlrMei.setText(MultiFenoBldkleur.getMei());
            lblBladKlrJun.setText(MultiFenoBldkleur.getJun());
            lblBladKlrJul.setText(MultiFenoBldkleur.getJul());
            lblBladKlrAug.setText(MultiFenoBldkleur.getAug());
            lblBladKlrSept.setText(MultiFenoBldkleur.getSep());
            lblBladKlrOkt.setText(MultiFenoBldkleur.getOkt());
            lblBladKlrNov.setText(MultiFenoBldkleur.getNov());
            lblBladKlrDec.setText(MultiFenoBldkleur.getDec());


            lblBloeiKlrJan.setText(MultiFenoBloeikleur.getJan());
            lblBloeiKlrFeb.setText(MultiFenoBloeikleur.getFeb());
            lblBloeiKlrMaa.setText(MultiFenoBloeikleur.getMaa());
            lblBloeiKlrApr.setText(MultiFenoBloeikleur.getApr());
            lblBloeiKlrMei.setText(MultiFenoBloeikleur.getMei());
            lblBloeiKlrJun.setText(MultiFenoBloeikleur.getJun());
            lblBloeiKlrJul.setText(MultiFenoBloeikleur.getJul());
            lblBloeiKlrAug.setText(MultiFenoBloeikleur.getAug());
            lblBloeiKlrSept.setText(MultiFenoBloeikleur.getSep());
            lblBloeiKlrOkt.setText(MultiFenoBloeikleur.getOkt());
            lblBloeiKlrNov.setText(MultiFenoBloeikleur.getNov());
            lblBloeiKlrDec.setText(MultiFenoBloeikleur.getDec());
        } catch (Exception ex) {
            lblBldGrootte.setText("Oops Er liep iets fout met de verbinding");
        }

    }

    private void AbiotischeInitialize() throws SQLException {
        try {
            plant.setAbiotischeFactoren(abiotischeFactorenDAO.getById(plant.getId()));
            lblBezonning.setText("" + plant.getAbiotischeFactoren().getBezonning());
            lblVochtBehoefte.setText("" + plant.getAbiotischeFactoren().getVochtbehoefte());
            lblVoedingsbehoefte.setText("" + plant.getAbiotischeFactoren().getVoedingsbehoefte());
            lblReactie.setText("" + plant.getAbiotischeFactoren().getReactieAntagonistischeOmgeving());
            lblGrondsoort.setText("" + plant.getAbiotischeFactoren().getGrondsoort());

            for (int i = 0; i < plant.getAbiotischeFactoren().getMultiEigenschappen().size(); i++) {
                System.out.println("1" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(i).getValue());
                System.out.println("2" + infoTablesDAO.getInfoTables().getHabitats().get(3));
                System.out.println("3" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(4).getValue());
                lblHabitat.setText(lblHabitat.getText() + "\n" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(i).getValue());

            }
        } catch (NullPointerException ne) {
            lblBezonning.setText("Oops er liep iets mis met ophalen van gegevens");
        }
    }

    private void BeheerInitialize() throws SQLException {
        try {
            plant.setBeheer(beheerDAO.getById(plant.getId()));
            lblBehandeling1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getOpmerking());
            lblFrequentie1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getFrequentie());
            switch (plant.getBeheer().getMultiEigenschappen().get(0).getMaand()) {
                case "januari":
                    cbxJan1.setSelected(true);
                case "februari":
                    cbxFeb1.setSelected(true);
                case "maart":
                    cbxMaa1.setSelected(true);
                case "april":
                    cbxApr1.setSelected(true);
                case "mei":
                    cbxMei1.setSelected(true);
                case "juni":
                    cbxJun1.setSelected(true);
                case "juli":
                    cbxJul1.setSelected(true);
                case "augustus":
                    cbxAug1.setSelected(true);
                case "september":
                    cbxSep1.setSelected(true);
                case "oktober":
                    cbxOkt1.setSelected(true);
                case "november":
                    cbxNov1.setSelected(true);
                case "december":
                    cbxDec1.setSelected(true);
                case "test":
                    cbxDec1.setSelected(true);
            }

        } catch (NullPointerException ne) {
            lblBehandeling1.setText("Oops er liep iets verkeerd bij ophalen gegevens");
        }
    }

    private void CommensalismeInitialize() throws SQLException {
        try {
            plant.setCommensalisme(commensalismeDAO.getById(plant.getId()));
            lblOntwikkelingssnelheid.setText("" + plant.getCommensalisme().getOntwikkelingssnelheid());
            lblStrategie.setText("" + plant.getCommensalisme().getStrategie());
            try {
                for (int i = 0; i < plant.getCommensalisme().getMultiEigenschappen().size(); i++) {

                    lblLevensduur.setText(lblLevensduur.getText() +
                            "\n" + infoTablesDAO.getInfoTables().getConcurentiekrachten().get((Integer.parseInt(plant.getCommensalisme().getMultiEigenschappen().get(i).getValue()))));
                    lblLevensduur.setWrapText(true);
                    lblLevensduur.setText(lblLevensduur.getText() + "Er zijn geen correcte gegevens");
                }

                switch (plant.getCommensalisme().getMultiEigenschappen().get(1).getValue()) {
                    case "1":
                        cbxSoc1.setSelected(true);
                    case "2":
                        cbxSoc2.setSelected(true);
                    case "3":
                        cbxSoc3.setSelected(true);
                    case "4":
                        cbxSoc4.setSelected(true);
                    case "5":
                        cbxSoc5.setSelected(true);
                }
            } catch (IndexOutOfBoundsException ne) {
                lblStrategie.setText("Er is geen Commensalisme aanwezig");
            }
        } catch (NullPointerException ne) {
            lblLevensduur.setText("Oops er liep iets mis bij het ophalen van de gegevens");
        }
    }

    private void ExtraInitialize() throws SQLException {
        try {
            plant.setExtra(extraDAO.getExtraById(plant.getId()));
            lblNectarwaarde.setText("" + plantDAO.getPlantById(1).getExtra());
            lblPollenwaarde.setText("" + plantDAO.getPlantById(1).getExtra());
            lblBijvriendelijk.setText("" + plantDAO.getPlantById(1).getExtra());
            lblVlindervriendelijk.setText("" + plantDAO.getPlantById(1).getExtra());
            lblEetbaar.setText("" + plantDAO.getPlantById(1).getExtra());
            lblKruidgebruik.setText("" + plantDAO.getPlantById(1).getExtra());
            lblGeurend.setText("" + plantDAO.getPlantById(1).getExtra());
            lblVorstgevoelig.setText("" + plantDAO.getPlantById(1).getExtra());
        } catch (NullPointerException ne) {
            lblBezonning.setText("Er zijn geen Extra gegevens gevonden");
        }
    }

    private void FotoInitialize() throws SQLException {
        //try {
        //plant.setFoto(fotoDAO.getFotoById(plant.getId()));
        //imgHabitus.setImage((Image) infoTablesDAO.getInfoTables().getHabitusFotos().get(Integer.parseInt(plant.getFenotype().getHabitus())));
//        imgHabitus.setImage((Image) infoTablesDAO.getInfoTables().getHabitusFotos().get(1));
        //imgBlad.setImage((Image) plant.getFoto().getFotos().get(0).getImage());
        //imgBloei.setImage((Image) plant.getFoto().getFotos().get(1).getImage());

        //} catch (NullPointerException npe) {

        //System.out.println("Geen foto");
        //}
    }

    private void StandaardInitialize() throws SQLException {
        try {
            lblType.setText("" + plant.getPlanttype());
            lblFamilie.setText("" + plant.getFamilie());
            lblGeslacht.setText("" + plant.getGeslacht());
            lblSoort.setText("" + plant.getSoort());
            lblVariant.setText("" + plant.getVariatie());
            lblmin.setText("" + plant.getMinPlantdichtheid());
            lblmax.setText("" + plant.getMaxPlantdichtheid());
        } catch (NullPointerException ne) {
            lblType.setText("Oops er liep iets verkeerd bij ophalen van gegevens");
        }
    }

    private void SchermInitialize() {
        ScrollPane.prefWidthProperty().bind(Anchorpane.widthProperty());
        ScrollPane.prefHeightProperty().bind(Anchorpane.heightProperty());

    }

}









