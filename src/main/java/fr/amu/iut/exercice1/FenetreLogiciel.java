package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    //Petite modification
    @Override
    public void start(Stage primaryStage) {
        Separator separator = new Separator();
        BorderPane root = new BorderPane();

        SeparatorMenuItem separatorMenuItem1= new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem2= new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem3= new SeparatorMenuItem();

        Menu menuFile = new Menu("File");
        MenuItem menuFileNew = new MenuItem("New");
        MenuItem menuFileOpen = new MenuItem("Open");
        MenuItem menuFileSave = new MenuItem("Save");
        MenuItem menuFileClose = new MenuItem("Close");
        menuFile.getItems().addAll(
                menuFileNew,
                separatorMenuItem1,
                menuFileOpen,
                separatorMenuItem2,
                menuFileSave,
                separatorMenuItem3,
                menuFileClose
        );

        SeparatorMenuItem separatorMenuItem4= new SeparatorMenuItem();
        SeparatorMenuItem separatorMenuItem5= new SeparatorMenuItem();
        Menu menuEdit = new Menu("Edit");
        MenuItem menuEditCut = new MenuItem("Cut");
        MenuItem menuEditCopy = new MenuItem("Copy");
        MenuItem menuEditPaste = new MenuItem("Paste");
        menuEdit.getItems().addAll(
                menuEditCut,
                separatorMenuItem4,
                menuEditCopy,
                separatorMenuItem5,
                menuEditPaste
        );

        Menu menuHelp = new Menu("Help");

        MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuHelp);
        root.setTop(menuBar);

        VBox barreLateraleGauche = new VBox();
        Label lesBoutons = new Label("Boutons :");
        Button bouton1  = new Button("Bouton 1");
        Button bouton2  = new Button("Bouton 2");
        Button bouton3  = new Button("Bouton 3");
        Separator separator1 = new Separator(Orientation.VERTICAL);
        barreLateraleGauche.getChildren().addAll(lesBoutons,bouton1, bouton2, bouton3);
        barreLateraleGauche.setAlignment(Pos.CENTER);
        VBox.setMargin(barreLateraleGauche, new Insets(10.0d));
        HBox partieGauche = new HBox();
        partieGauche.getChildren().addAll(barreLateraleGauche,separator1);

        root.setLeft(partieGauche);



        GridPane partieCentraleForm = new GridPane();
        Label NameLabel = new Label("Name :");
        TextField NameChamp = new TextField();
        Label EmailLabel = new Label("Email :");
        TextField EmailChamp = new TextField();
        Label PasswordLabel = new Label("Password :");
        PasswordField PasswordChamp = new PasswordField();

        partieCentraleForm.add(NameLabel,0,0);
        partieCentraleForm.add(NameChamp,1,0);
        partieCentraleForm.add(EmailLabel,0,1);
        partieCentraleForm.add(EmailChamp,1,1);
        partieCentraleForm.add(PasswordLabel,0,2);
        partieCentraleForm.add(PasswordChamp,1,2);

        HBox partieCentraleBoutons = new HBox();
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");

        partieCentraleBoutons.getChildren().addAll(submit,cancel);

        VBox partieCentrale = new VBox();
        partieCentrale.getChildren().addAll(partieCentraleForm,partieCentraleBoutons);
        partieCentrale.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        root.setCenter(partieCentrale);
        partieCentrale.setAlignment(Pos.CENTER);


        VBox basDePage = new VBox();
        Separator separator2 = new Separator(Orientation.HORIZONTAL);
        Label texteBasDePage = new Label("Ceci est un label de bas de page");
        basDePage.getChildren().addAll(separator2,texteBasDePage);
        basDePage.setAlignment(Pos.CENTER);

        root.setBottom(basDePage);


        Scene scene = new Scene(root,800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant des conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

