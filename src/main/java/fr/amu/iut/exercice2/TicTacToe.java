package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane rootGrid = new GridPane();
        ImageView caseVide = new ImageView("exercice2/Vide.png");
        ImageView caseCroix = new ImageView("exercice2/Croix.png");
        ImageView caseRond= new ImageView("exercice2/Rond.png");

        Label case0_0 = new Label();
        case0_0.setGraphic(caseVide);
        rootGrid.add(case0_0, 0, 0);

        Label case0_1 = new Label();
        case0_1.setGraphic(caseVide);
        rootGrid.add(case0_1, 0, 1);

        Label case0_2 = new Label();
        case0_2.setGraphic(caseVide);
        rootGrid.add(case0_2, 0,2);

        Label case1_0 = new Label();
        case1_0.setGraphic(caseVide);
        rootGrid.add(case1_0, 1,0);

        Label case1_1 = new Label();
        case1_1.setGraphic(caseVide);
        rootGrid.add(case1_1, 1,1);

        Label case1_2 = new Label();
        case1_2.setGraphic(caseVide);
        rootGrid.add(case1_2, 1,2);

        Label case2_0 = new Label();
        case2_0.setGraphic(caseVide);
        rootGrid.add(case2_0, 2,0);

        Label case2_1 = new Label();
        case2_1.setGraphic(caseVide);
        rootGrid.add(case2_1, 2,1);

        Label case2_2 = new Label();
        case2_2.setGraphic(caseVide);
        rootGrid.add(case2_2, 2,2);

        Scene scene = new Scene(rootGrid);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }
}

