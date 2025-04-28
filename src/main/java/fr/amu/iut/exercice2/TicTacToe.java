package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane rootGrid = new GridPane();
        String[] images = {"Vide.png","Croix.png","Rond.png"};
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Label caseLabel = new Label();
                caseLabel.setGraphic(new ImageView("/exercice2/" + images[rand.nextInt(3)]));
                rootGrid.add(caseLabel, i, j);

            }
        }
        rootGrid.setGridLinesVisible(true);

        Scene scene = new Scene(rootGrid);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }
}

