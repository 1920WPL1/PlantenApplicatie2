package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    public Label blMinBloeihoogteSept;
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
    public Label lblBehandeling;
    public Label lblFrequentie;
    public CheckBox cbxJan;
    public CheckBox cbxFeb;
    public CheckBox cbxMaa;
    public CheckBox cbxApr;
    public CheckBox cbxMei;
    public CheckBox cbxJun;
    public CheckBox cbxJul;
    public CheckBox cbxAug;
    public CheckBox cbxSep;
    public CheckBox cbxOkt;
    public CheckBox cbxNov;
    public CheckBox cbxDec;
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
    public HBox HboxLabelMaanden;
    public VBox VboxBeheer;
    public VBox VboxLBLFrequentie;
    public VBox VboxlabelBeheer;
    public HBox HboxBeheer;
    public Label JanBeheer = new Label("Jan");
    public Label FebBeheer = new Label("Feb");
    public Label MaaBeheer = new Label("Maa");
    public Label AprBeheer = new Label("Apr");
    public Label MeiBeheer = new Label("Mei");
    public Label JunBeheer = new Label("Jun");
    public Label JulBeheer = new Label("Jul");
    public Label AugBeheer = new Label("Aug");
    public Label SepBeheer = new Label("Sep");
    public Label OktBeheer = new Label("Okt");
    public Label NovBeheer = new Label("Nov");
    public Label DecBeheer = new Label("Dec");
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
    public FenoMulti_Eigenschap MultiFenoBldkleur;
    public FenoMulti_Eigenschap MultiFenoBloeikleur;
    public FenoMulti_Eigenschap MultiFenoBloeiminHgte;
    public FenoMulti_Eigenschap MultiFenoBloeimaxHgte;
    public HBox HboxBeheermaanden;



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

    //Author Leandro
    public void Clicked_Wijzig(MouseEvent mouseEvent) throws IOException, SQLException {
        //Scherm benaming meegeven in de methode om naar het scherm te gaan
        Scherm = "PlantWijzigen";
        Schermkiezen(mouseEvent, Scherm, plant.getId());

    }

    //Author Leandro
    public void Clicked_Terug(MouseEvent mouseEvent) throws IOException {
        //Scherm benaming meegeven in de methode om naar het scherm te gaan
        Scherm = "ControlerenEnGoedkeurenTransacties";
        Schermkiezen(mouseEvent, Scherm);
    }

    //Author Ayoub
    public void Clicked_Ok(MouseEvent mouseEvent) throws IOException, SQLException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked OK, Click OK to continue", "Clicked OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            plantDAO.setStatus(2, plant.getId());
            Schermkiezen(mouseEvent, "ControlerenEnGoedkeurenTransacties");


        }
    }

    //Author Ayoub
    public void Clicked_NietOk(MouseEvent mouseEvent) throws IOException, SQLException {
        Object[] options = {"OK", "CANCEL"};
        if (
                JOptionPane.showOptionDialog(null, "You clicked NIET OK, Click OK to continue", "Clicked Niet OK",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, options, options[0]) == 0) {
            plantDAO.setStatus(0, plant.getId());
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
            Controller controller = loader.getController(); // --> moet aangepast worden naar correcte controller bv ValidatplantController controller = ...
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
            plant.setFoto(fotoDAO.getFotoById(plant.getId()));
            //Author :Leandro -> Loop gestoken om het aantal foto's te overlopen
            for (int i = 0; i < plant.getFoto().getFotos().size(); i++) {
                //Author : Leandro -> Voorwaarde om te controleren of dat de waarde blad is , zodat de correcte foto weergegeven wordt
                switch (plant.getFoto().getFotos().get(i).getEigenschap()) {
                    case "blad":
                        imgBlad.setImage(new Image(plant.getFoto().getFotos().get(i).getImage().getBinaryStream()));
                        break;
                    //Author : Leandro -> Voorwaarde om te controleren of dat de waarde bloei is , zodat de correcte foto weergegeven wordt
                    case "bloei":
                        imgBloei.setImage(new Image(plant.getFoto().getFotos().get(i).getImage().getBinaryStream()));
                        break;
                    case "habitus":
                        imgHabitus.setImage(new Image(plant.getFoto().getFotos().get(i).getImage().getBinaryStream()));
                        break;
                }
            }
        } catch (NullPointerException ne) {
            System.out.println("er werden geen foto's gevonden");
        }
    }

    //Author : Ayoub -> Alle Foto gegevens gelinkt aan de plant weergeven
    //Editor : Leandro -> Foutafhandeling gemaakt
    private void StandaardInitialize() throws SQLException {
        try {
            lblType.setText("" + plant.getType());
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
            // Author : Leandro Aantal beheersdaden doorlopen
            for (int j = 0; j < plant.getBeheer().getMultiEigenschappen().size(); j++) {
                //Leandro :Loop maken om generiek terug tegeven
                //Leandro :Hier Hbox creeren samen met Labels die nodig zijn
                HBox Hbox = new HBox();
                Hbox.setId("Beheerdaad" + j);  // Id's zetten.

                // Leandro :Label maken + stylen +generiek invullen
                Label freq = new Label();
                freq.setPadding(new Insets(7, 11, 0, 0));
                freq.setStyle("-fx-font: 14 system;");
                freq.setText("" + plant.getBeheer().getMultiEigenschappen().get(j).getFrequentie());

                // Leandro :Label maken + stylen + generiek invullen
                Label Behand = new Label();
                Behand.setStyle("-fx-font: 14 system;");
                Behand.setPadding(new Insets(7, 11, 0, 0));
                Behand.setText(plant.getBeheer().getMultiEigenschappen().get(j).getOpmerking());

                // Leandro :De labels toevoegen aan De correcte Vboxen
                VboxlabelBeheer.getChildren().add(Behand);
                VboxLBLFrequentie.getChildren().add(freq);

                // Leandro :12 checkboxen + labels aanmaken per daad
                for (int i = 0; i < 12; i++) {
                    CheckBox box = new CheckBox();

                    box.setDisable(true);
                    box.setStyle("-fx-font: 14 system;");
                    box.setId(HboxBeheermaanden.getChildren().get(i).getId() + i);
                    box.setPadding(new Insets(7, 11, 0, 0));
                    Hbox.getChildren().add(box);

                    lblFrequentie.setText("" + plant.getBeheer().getMultiEigenschappen().get(0).getFrequentie());
                    lblBehandeling.setText((plant.getBeheer().getMultiEigenschappen().get(0).getOpmerking()));

                    switch (plant.getBeheer().getMultiEigenschappen().get(j).getMaand()) {
                        case "januari":
                            if (box.getId().equals(cbxJan.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "februari":
                            if (box.getId().equals(cbxFeb.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "maart":
                            if (box.getId().equals(cbxMaa.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "april":
                            if (box.getId().equals(cbxApr.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "mei":
                            if (box.getId().equals(cbxMei.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "juni":
                            if (box.getId().equals(cbxJun.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "juli":
                            if (box.getId().equals(cbxJul.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "augustus":
                            if (box.getId().equals(cbxAug.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "september":
                            if (box.getId().equals(cbxSep.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "oktober":
                            if (box.getId().equals(cbxOkt.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "november":
                            if (box.getId().equals(cbxNov.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                        case "december":
                            if (box.getId().equals(cbxDec.getId() + i)) {
                                box.setSelected(true);
                            }
                            break;

                    }
                }
                //Leandro :Voorwaarde om de bestaande Rij+Labels te verwijderen en en zo geheel generiek te maken
                if (j == 0) {
                    VboxBeheer.getChildren().clear(); //Alles verwijderen
                    beheerLijstGUI();
                    HBox lblBox = new HBox(JanBeheer, FebBeheer, MaaBeheer, AprBeheer, MeiBeheer, JunBeheer, JulBeheer, AugBeheer, SepBeheer, OktBeheer, NovBeheer, DecBeheer);
                    VboxBeheer.getChildren().add(lblBox);
                }
                VboxBeheer.getChildren().add(Hbox);
            }


        } catch (NullPointerException ne) {
            System.out.println("Bepaalde gegevens van beheer werden niet gevonden");
        }
    }
    //Author : Leandro
    private void beheerLijstGUI() {
        //Alle paddings instellen
        JanBeheer.setPadding(new Insets(0, 7, 0, 0));
        FebBeheer.setPadding(new Insets(0, 7, 0, 0));
        MaaBeheer.setPadding(new Insets(0, 6, 0, 0));
        AprBeheer.setPadding(new Insets(0, 6, 0, 0));
        MeiBeheer.setPadding(new Insets(0, 7, 0, 0));
        JunBeheer.setPadding(new Insets(0, 7, 0, 0));
        JulBeheer.setPadding(new Insets(0, 12, 0, 0));
        AugBeheer.setPadding(new Insets(0, 4, 0, 0));
        SepBeheer.setPadding(new Insets(0, 6, 0, 0));
        OktBeheer.setPadding(new Insets(0, 6, 0, 0));
        NovBeheer.setPadding(new Insets(0, 7, 0, 0));
        DecBeheer.setPadding(new Insets(0, 7, 0, 0));

        //Alle Fonts instellen
        JanBeheer.setStyle("-fx-font: 14 system;");
        FebBeheer.setStyle("-fx-font: 14 system;");
        MaaBeheer.setStyle("-fx-font: 14 system;");
        AprBeheer.setStyle("-fx-font: 14 system;");
        MeiBeheer.setStyle("-fx-font: 14 system;");
        JunBeheer.setStyle("-fx-font: 14 system;");
        JulBeheer.setStyle("-fx-font: 14 system;");
        AugBeheer.setStyle("-fx-font: 14 system;");
        SepBeheer.setStyle("-fx-font: 14 system;");
        OktBeheer.setStyle("-fx-font: 14 system;");
        NovBeheer.setStyle("-fx-font: 14 system;");
        DecBeheer.setStyle("-fx-font: 14 system;");

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
                for (int i = 0; i < plant.getCommensalisme().getMultiEigenschappen().size(); i++) {
                    System.out.println(plant.getCommensalisme().getMultiEigenschappen().get(i).getValue() + "\n");
                    switch (plant.getCommensalisme().getMultiEigenschappen().get(i).getValue()) {
                        case "1":
                            cbxSoc1.setSelected(true);
                            break;
                        case "2":
                            cbxSoc2.setSelected(true);
                            break;
                        case "3":
                            cbxSoc3.setSelected(true);
                            break;
                        case "4":
                            cbxSoc4.setSelected(true);
                            break;
                        case "5":
                            cbxSoc5.setSelected(true);
                            break;
                    }
                }
            } catch (IndexOutOfBoundsException ne) {
                System.out.println("Er is geen Commensalisme aanwezig");
            }
        } catch (NullPointerException ne) {
            System.out.println("Bepaalde gegevens van Commensalisme werden niet gevonden");
        }
    }

    //Author : Ayoub -> Alle Extra gegevens gelinkt aan de plant weergeven in het scherm --> Aanpassingen gemaakt om values correct weer te geven
    //Editor : Leandro -> Foutafhandeling gemaakt
    private void ExtraInitialize() throws SQLException {
        try {
            plant.setExtra(extraDAO.getExtraById(plant.getId()));
            lblNectarwaarde.setText("" + plant.getExtra().getNectarwaarde());
            lblPollenwaarde.setText("" + plant.getExtra().getPollenwaarde());
            lblBijvriendelijk.setText("" + plant.getExtra().getBijvriendelijk());
            lblVlindervriendelijk.setText("" + plant.getExtra().getVlindervriendelijk());
            lblEetbaar.setText("" + plant.getExtra().getEetbaar());
            lblKruidgebruik.setText("" + plant.getExtra().getKruidgebruik());
            lblGeurend.setText("" + plant.getExtra().getGeurend());
            lblVorstgevoelig.setText("" + plant.getExtra().getVorstgevoelig());
        } catch (NullPointerException ne) {
            System.out.println("Er zijn bepaalde Extragegevens niet gevonden");
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

            //Deze lijst is voor minbloeihoogte variabel gebruikt om het overzichtelijk te houden
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

            //Deze lijst is voor Maxbloeihoogte variabel gebruikt om het overzichtelijk te houden
            blMxBloeihoogteJan.setText(MultiFenoBloeimaxHgte.getJan());
            blMxBloeihoogteFeb.setText(MultiFenoBloeimaxHgte.getFeb());
            blMxBloeihoogteMaa.setText(MultiFenoBloeimaxHgte.getMaa());
            blMxBloeihoogteApr.setText(MultiFenoBloeimaxHgte.getApr());
            blMxBloeihoogteMei.setText(MultiFenoBloeimaxHgte.getMei());
            blMxBloeihoogteJun.setText(MultiFenoBloeimaxHgte.getJun());
            blMxBloeihoogteJul.setText(MultiFenoBloeimaxHgte.getJul());
            blMxBloeihoogteAug.setText(MultiFenoBloeimaxHgte.getAug());
            blMxBloeihoogteSept.setText(MultiFenoBloeimaxHgte.getSep());
            blMxBloeihoogteOkt.setText(MultiFenoBloeimaxHgte.getOkt());
            blMxBloeihoogteNov.setText(MultiFenoBloeimaxHgte.getNov());
            blMxBloeihoogteDec.setText(MultiFenoBloeimaxHgte.getDec());


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