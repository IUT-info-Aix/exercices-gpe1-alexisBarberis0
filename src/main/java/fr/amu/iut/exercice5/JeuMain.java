package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();

        //panneau du jeu
        Pane jeu = new Pane();
        root.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        // on positionne le fantôme 20 positions vers la droite
        pacman.setLayoutX(0);
        pacman.setLayoutY(0);
        fantome.setLayoutX(640);
        fantome.setLayoutY(480);
        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
            }
            if (j1.estEnCollision(j2)){
                System.out.println("Collision");
                VBox fin = new VBox();
                Label titre_fin = new Label();
                titre_fin.setText("Pac Man a perdu ...");
                Button restart = new Button("Restart");
                restart.setOnMouseClicked((MouseEvent event_fin) -> {
                    Stage stage = new Stage();
                    j1.setLayoutX(0);
                    j2.setLayoutY(0);
                    j2.setLayoutX(scene.getWidth());
                    j2.setLayoutY(scene.getHeight());
                    start(stage);
                });
                VBox.setMargin(titre_fin, new Insets(10));
                fin.setAlignment(Pos.CENTER);
                fin.getChildren().addAll(titre_fin,restart);
                root.setCenter(fin);
            }

        });
    }


}
