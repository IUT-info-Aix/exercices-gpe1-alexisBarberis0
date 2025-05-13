package fr.amu.iut.exercice8;

import com.example.partie3.AlertHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

public class LoginControl extends GridPane {

    @FXML
    private TextField user;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    private void okClicked() {
        Window owner = ok.getScene().getWindow();
        if (user.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your user id");
            return;
        }
        if (pwd.getText().isEmpty()){
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your password");
            return;
        }
        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + user.getText());
    }

    @FXML
    private void cancelClicked() {
        Platform.exit();
    }
}