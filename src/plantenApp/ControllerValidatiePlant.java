package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    public Label lblFrequentie1;
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
    public Label lblType;
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
    public Label lblBezonning;
    public Label lblVochtBehoefte;
    public Label lblVoedingsbehoefte;
    public Label lblReactie;
    public Label lblGrondsoort;
    public Label lblHabitat;
    public Label lblNectarwaarde;
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
    public FenoMulti_Eigenschap MultiFenoBloeiminHgte;
    public FenoMulti_Eigenschap MultiFenoBldkleur;
    public FenoMulti_Eigenschap MultiFenoBloeikleur;
    public FenoMulti_Eigenschap MultiFenoBloeimaxHgte;
    public Label blMinBloeihoogteSept;
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
        FotoInitialize();
        StandaardInitialize();
        ExtraInitialize();
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

    //Author : Leandro
    public void Clicked_Wijzig(MouseEvent mouseEvent) throws IOException, SQLException {
        //Scherm benaming meegeven in de methode om naar het scherm te gaan
        Scherm = "PlantWijzigen";
        Schermkiezen(mouseEvent, Scherm, plant.getId());

    }

    //Author : Leandro
    public void Clicked_Terug(MouseEvent mouseEvent) throws IOException {
        //Scherm benaming meegeven in de methode om naar het scherm te gaan
        Scherm = "ControlerenEnGoedkeurenTransacties";
        Schermkiezen(mouseEvent, Scherm);
    }

    //Author : Ayoub
    public void Clicked_Ok(MouseEvent mouseEvent) throws IOException, SQLException
    {
        // Hier sla ik de opties op om ze als variabel te gebruiken
        Object[] options = {"OK", "CANCEL"};
        //Hier controleer ik of ze effectief bevestigen of niet voor ik de data wegschrijf naar Database
        if (JOptionPane.showOptionDialog(null, "You clicked OK, Click OK to continue", "Clicked OK",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]) == 0) {
            plantDAO.setStatus(2,plant.getId());
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");
        }
    }

    //Author : Ayoub
    public void Clicked_NietOk(MouseEvent mouseEvent) throws IOException, SQLException
    {
        // Hier sla ik de opties op om ze als variabel te gebruiken
        Object[] options = {"OK", "CANCEL"};
        //Hier controleer ik of ze effectief bevestigen of niet voor ik de data wegschrijf naar Database
        if (JOptionPane.showOptionDialog(null, "You clicked NIET OK, Click OK to continue", "Clicked Niet OK",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]) == 0) {
            plantDAO.setStatus(0,plant.getId());
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");
        }
    }

    //Author : Leandro -> methode om te switchen van scherm
    public void Schermkiezen(MouseEvent mouseEvent, String scherm) throws IOException {
        //Hier vang ik de verwijzing op indien ze  een scherm meegeven die niet bestaat
        try {
            //Hier zet ik de root naar het gewenste scherm
            Parent root = FXMLLoader.load(getClass().getResource("view/" + scherm + ".fxml"));
            Scene scene = new Scene(root);
            //Hier link ik een event (bijvoorbeeld button) aan zodat het scherm open gaat bij het event
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            //Scherm tonen
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Scherm niet gevonden");
        }
    }

    //Author : Leandro -> methode schermkiezen overloaded met extra parameter Int Plantid
    public void Schermkiezen(MouseEvent mouseEvent, String scherm, Integer PlantId) throws IOException, SQLException {
        //Hier vang ik de verwijzing op indien ze  een scherm meegeven die niet bestaat
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/" + scherm + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            //Hier link ik een event (bijvoorbeeld button) aan zodat het scherm open gaat bij het event
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            //Controller Aanvragen van Scherm (deze is gelinkt in schermxml) --> KLasse Controller nog aanpassen naar correcte controller volgens scherm.
            Controller controller = loader.getController(); // --> moet aangepast worden naar correcte controller bv validatieplantController controller = ...
            //hier de Methode initialize aan gesproken en parameter meegegeven. --> Indien de methode anders gebruik word moet deze hier ook aangepast worden.
            controller.initialize(PlantId);
            window.setScene(scene);
            //Scherm tonen
            window.show();
        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Het gevraagde scherm is niet gevonden");
        }
    }

    //Author : Ayoub -> Alle Foto gegevens gelinkt aan de plant weergeven
    //Editor : Leandro -> Foutaf1handeling gemaakt
    private void FotoInitialize() throws SQLException, IOException {
        try {
            imgHabitus.setImage(infoTablesDAO.getInfoTableBlobHabitus(plant.getFenotype().getHabitus()));
            try {
                plant.setFoto(fotoDAO.getFotoById(plant.getId()));
                imgBlad.setImage((Image) plant.getFoto().getFotos().get(0).getImage());
                imgBloei.setImage((Image) plant.getFoto().getFotos().get(1).getImage());
            } catch (NullPointerException ne) {
                System.out.println("er werden geen foto's gevonden");
            }

        } catch (NullPointerException | IOException npe) {
            System.out.println("Geen foto");
        }
    }

    //Author : Ayoub -> Alle Foto gegevens gelinkt aan de plant weergeven
    //Editor : Leandro -> Foutafhandeling gemaakt
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
            System.out.println("Er werden bepaalde  hoofdeigenschappen niet terug gevonden");
        }
    }

    //Author : Ayoub -> Alle Abiotische gegevens gelinkt aan de plant weergeven in het scherm  /
    // Editor : Leandro -> Dynamisch gemaakt, enkele problemen opgelost, Multi-eigenschappen in een loop gestoken en fout-afhandeling gefixed
    private void AbiotischeInitialize() throws SQLException {
        //Fout afhandeling, Als er geen gegevens ingeladen wordt, word dit weergegeven in label Bezonning
        try {
            plant.setAbiotischeFactoren(abiotischeFactorenDAO.getById(plant.getId()));
            lblBezonning.setText("" + plant.getAbiotischeFactoren().getBezonning());
            lblVochtBehoefte.setText("" + plant.getAbiotischeFactoren().getVochtbehoefte());
            lblVoedingsbehoefte.setText("" + plant.getAbiotischeFactoren().getVoedingsbehoefte());
            lblReactie.setText("" + plant.getAbiotischeFactoren().getReactieAntagonistischeOmgeving());
            lblGrondsoort.setText("" + plant.getAbiotischeFactoren().getGrondsoort());

            //voor alle ingevulde eigenschappen een loop gemaakt zodat ze allemaal weergegeven worden.
            try { //Hier controleren of er wel gegevens aanwezig zijn voor weer te geven
                for (int i = 0; i < plant.getAbiotischeFactoren().getMultiEigenschappen().size(); i++) {
                    lblHabitat.setText(lblHabitat.getText() + "\n" + plant.getAbiotischeFactoren().getMultiEigenschappen().get(i).getValue());
                }
            } catch (IndexOutOfBoundsException ioe) {
                System.out.println("Er waren geen habitat gegevens beschikbaar");
            }
        } catch (NullPointerException ne) {
            System.out.println("Bepaalde data niet gevonden voor Abiotische Gegevens");
        }
    }

    //Author : Ayoub -> Alle Beheer gegevens gelinkt aan de plant weergeven in het scherm
    //Editor : Leandro -> Foutafhandeling gemaakt & tip gegeven om switch-case te maken ipv allemaal if-else
    private void BeheerInitialize() throws SQLException {
        try {
            plant.setBeheer(beheerDAO.getById(plant.getId()));
            lblBehandeling1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getOpmerking());
            lblFrequentie1.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getFrequentie());
            switch (plant.getBeheer().getMultiEigenschappen().get(0).getMaand()) {
                case "januari":
                    cbxJan1.setSelected(true);
                    break;
                case "februari":
                    cbxFeb1.setSelected(true);
                    break;
                case "maart":
                    cbxMaa1.setSelected(true);
                    break;
                case "april":
                    cbxApr1.setSelected(true);
                    break;
                case "mei":
                    cbxMei1.setSelected(true);
                    break;
                case "juni":
                    cbxJun1.setSelected(true);
                    break;
                case "juli":
                    cbxJul1.setSelected(true);
                    break;
                case "augustus":
                    cbxAug1.setSelected(true);
                    break;
                case "september":
                    cbxSep1.setSelected(true);
                    break;
                case "oktober":
                    cbxOkt1.setSelected(true);
                    break;
                case "november":
                    cbxNov1.setSelected(true);
                    break;
                case "december":
                    cbxDec1.setSelected(true);
                    break;
            }

        } catch (NullPointerException ne) {
            System.out.println("Bepaalde gegevens van beheer werden niet gevonden");
        }
    }

    //Author : Ayoub -> Alle Commensalisme gegevens gelinkt aan de plant weergeven in het scherm
    //Editor : Leandro -> Foutafhandeling gemaakt en loop gemaakt voor multi-eigenschappen
    private void CommensalismeInitialize() throws SQLException {
        //proberen om gegevens op te halen, indien dit niet overal lukt wordt dit weergegeven
        try {
            plant.setCommensalisme(commensalismeDAO.getById(plant.getId()));
            lblOntwikkelingssnelheid.setText("" + plant.getCommensalisme().getOntwikkelingssnelheid());
            lblStrategie.setText("" + plant.getCommensalisme().getStrategie());

            //Deze in een extra try gestoken zodat een out-of-bounds opgevangen wordt.
            try { //Loop om door alle multi-eigenschappen te gaan en weer te geven
                for (int i = 0; i < plant.getCommensalisme().getMultiEigenschappen().size(); i++) {
                    lblLevensduur.setText(lblLevensduur.getText() +
                            "\n" + infoTablesDAO.getInfoTables().getConcurentiekrachten().get((Integer.parseInt(plant.getCommensalisme().getMultiEigenschappen().get(i).getValue()))));

                }
                //de get(1) is de multi eigenschap : Sociabiliteit
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
            System.out.println("Bepaalde gegevens van Commensalisme werden niet gevonden");
        }
    }

    //Author : Ayoub -> Alle Extra gegevens gelinkt aan de plant weergeven in het scherm
    //Editor : Leandro -> Foutafhandeling gemaakt
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
            System.out.println("Er zijn bepaalde Extra gegevens niet gevonden");
        }
    }

    //Author : Leandro -> alle Fenotype gegevens gelinkt aan de plant weergeven in het scherm
    private void FenoInitialize() throws SQLException {
        try {
            //Hier vul ik alle veriabelen op met de Gegevens uit de DB en zet ik alle fenotype data in de plant
            plant.setFenotype(fenotypeDAO.getById(plant.getId()));
            Fenotype PlantFeno = plant.getFenotype();
            lblBldGrootte.setText("" + PlantFeno.getBladgrootte());
            lblBldVrm.setText(PlantFeno.getBladvorm());
            lblRatio.setText(PlantFeno.getRatio_bloei_blad());
            lblSpruitfnlgie.setText(PlantFeno.getSpruitfenologie());
            lblRaunkhiaer.setText(PlantFeno.getLevensvorm());
            lblHabitus.setText(PlantFeno.getHabitus());
            lblBloeiwijze.setText(PlantFeno.getBloeiwijze());

            //Variabelen gemaakt zodanig dat het overzichteljk blijft en geen ellenlange code + copy past moet gebeuren
            MultiFenoBldHgte = PlantFeno.getMultiEigenschappen().get(0); //Bladhoogte
            MultiFenoBloeiminHgte = PlantFeno.getMultiEigenschappen().get(1); //min-Bloeihoogte
            MultiFenoBloeimaxHgte = PlantFeno.getMultiEigenschappen().get(2); //max-Bloeihoogte
            MultiFenoBldkleur = PlantFeno.getMultiEigenschappen().get(3); //Bladkleur
            MultiFenoBloeikleur = PlantFeno.getMultiEigenschappen().get(4); //Bloeikleur
            System.out.println(PlantFeno.getMultiEigenschappen().get(2).getNaam());

            //Deze werkt per maand de Max-Bladhoogte. variabel gebruikt om het overzichtelijk te houden
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

            //Deze werkt per maand de BLadkleur. variabel gebruikt om het overzichtelijk te houden
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

            //Deze werkt per maand de Bloeikleur. variabel gebruikt om het overzichtelijk te houden
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

            //Deze lijst is voor Maxbloeihoogte
            blMinBloeihoogteJan.setText(MultiFenoBloeiminHgte.getJan());
            blMinBloeihoogteFeb.setText(MultiFenoBloeiminHgte.getFeb());
            blMinBloeihoogteMaa.setText(MultiFenoBloeiminHgte.getMaa());
            blMinBloeihoogteApr.setText(MultiFenoBloeiminHgte.getApr());
            blMinBloeihoogteMei.setText(MultiFenoBloeiminHgte.getMei());
            blMinBloeihoogteJun.setText(MultiFenoBloeiminHgte.getJun());
            blMinBloeihoogteJul.setText(MultiFenoBloeiminHgte.getJul());
            blMinBloeihoogteAug.setText(MultiFenoBloeiminHgte.getAug());
            blMinBloeihoogteSept.setText(MultiFenoBloeiminHgte.getSep());
            blMinBloeihoogteOkt.setText(MultiFenoBloeiminHgte.getOkt());
            blMinBloeihoogteNov.setText(MultiFenoBloeiminHgte.getNov());
            blMinBloeihoogteDev.setText(MultiFenoBloeiminHgte.getDec());

            //Deze lijst is voor minbloeihoogte
            blMxBloeihoogteJan.setText(MultiFenoBloeimaxHgte.getJan());
            blMxBloeihoogteFeb.setText(MultiFenoBloeimaxHgte.getFeb());
            blMxBloeihoogteMaa.setText(MultiFenoBloeimaxHgte.getMaa());
            blMxBloeihoogteApr.setText(MultiFenoBloeimaxHgte.getApr());

        } catch (NullPointerException nex) {
            System.out.println("geen data gevonden");
        }

    }

    //Author : Leandro -> Hiermee maak ik dat de scrollpane zich automatisch aanpast aan de grootte van het scherm.
    private void SchermInitialize() {
        ScrollPane.prefWidthProperty().bind(Anchorpane.widthProperty());
        ScrollPane.prefHeightProperty().bind(Anchorpane.heightProperty());

    }

}









