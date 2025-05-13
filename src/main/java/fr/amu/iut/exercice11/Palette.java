package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javax.script.Bindings;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;

    private StringProperty message;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        nbFois = new SimpleIntegerProperty();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);
        texteDuHaut.textProperty().bind(message)
        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        message = new SimpleStringProperty();

        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        nbVert = 0;
        rouge = new Button("Rouge");
        nbRouge = 0;
        bleu = new Button("Bleu");
        nbBleu = 0;


        /* VOTRE CODE ICI */
        vert.setOnAction(event -> {
            ++nbVert;
            nbFois.set(nbVert);

            panneau.setStyle("-fx-background-color: #19e023");

            message.set("Le Vert est une jolie couleur !");
            texteDuBas.setText(message.get());
            texteDuBas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
            texteDuBas.setTextFill(Color.GREEN);
        });
        rouge.setOnAction(event -> {
            ++nbRouge;
            nbFois.set(nbRouge);
            message.set("Le Rouge est une jolie couleur !");
            panneau.setStyle("-fx-background-color: #e01919");

            message.set("Le Rouge est une jolie couleur !");
            texteDuBas.setText(message.get());
            texteDuBas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
            texteDuBas.setTextFill(Color.RED);
        });
        bleu.setOnAction(event -> {
            ++nbBleu;
            nbFois.set(nbBleu);
            message.set("Le Bleu est une jolie couleur !");
            panneau.setStyle("-fx-background-color: #1941e0");

            message.set("Le Bleu est une jolie couleur !");
            texteDuBas.setText(message.get());
            texteDuBas.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
            texteDuBas.setTextFill(Color.BLUE);
        });


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

