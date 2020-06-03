// Auteur Dario
package plantenApp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerControlerenEnGoedkeurenTransacties
{
    public VBox VBoxToCheckList;
    private int amountToCheck = 1;

    public void initialize()
    {
        AddToCheckLine("roos", "jan");
        AddToCheckLine("petunia", "dan");
        AddToCheckLine("tulp", "marie");
    }

    // Auteur Dario
    // genereert een nieuwe regel dat gecontroleert moet worden
    private void AddToCheckLine(String plantnaam, String naamGebruiker)
    {
        Label emptyNextLine = new Label("");
        Label lineToCheck = new Label("Plant: " + plantnaam + " \tAangepast door: " + naamGebruiker + " \t");

        emptyNextLine.setStyle("-fx-font: 14 system;");
        lineToCheck.setStyle("-fx-font: 14 system;");

        Button bttnControleer = new Button("Controleer");
        bttnControleer.setId(Integer.toString(amountToCheck));
        bttnControleer.setStyle("-fx-font: 14 system;");
        bttnControleer.setOnAction(actionEvent -> {ButtonEventGoToCheckID(bttnControleer);});

        HBox temp = new HBox();
        temp.getChildren().add(lineToCheck);
        temp.getChildren().add(bttnControleer);

        VBoxToCheckList.getChildren().add(emptyNextLine);
        VBoxToCheckList.getChildren().add(temp);
        amountToCheck++;
    }

    // Auteur Dario
    // opent de gedetailleerde scherm met de gevraagde ID
    private void ButtonEventGoToCheckID(Button button)
    {
        button.setText(button.getId());
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
}
