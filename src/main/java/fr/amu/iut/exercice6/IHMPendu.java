package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer
        int nbVies = 7;
        Dico dico = new Dico();
        String motADecouvrir = dico.getMot();
        TextField textField = new TextField();
        Label labelVies = new Label("Nombre de vies : " + nbVies);
        char[] motCache = new char[motADecouvrir.length()];
        for (int i = 0; i < motCache.length; ++i) {
            motCache[i] = '*';
        }
        String motAnoyme = new  String(motCache);
        Label motCacheLabel = new Label(motAnoyme);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelVies,textField, motCacheLabel);
        Scene scene = new Scene(vBox);
        scene.addEventHandler(KeyEvent.KEY_PRESSED,new KeyPressedPenduEvent());
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
