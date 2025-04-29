package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private Label label;
    private Pane panneau;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(400, 200);

        Label label = new Label();

        Pane panneau = new Pane();

        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandlerEx4(label,panneau,vert,rouge,bleu));
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandlerEx4(label,panneau,vert,rouge,bleu));
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED,  new ButtonClickHandlerEx4(label,panneau,vert,rouge,bleu));
        HBox bas = new HBox(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);
        HBox.setMargin(vert, new Insets(10));
        HBox.setMargin(rouge, new Insets(10));
        HBox.setMargin(bleu, new Insets(10));

        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);

        BorderPane.setAlignment(label, Pos.CENTER);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

