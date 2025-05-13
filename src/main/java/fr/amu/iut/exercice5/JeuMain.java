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

import java.time.Instant;

import static fr.amu.iut.exercice5.Personnage.LARGEUR_PERSONNAGE;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private Obstacle[] obstacleListe;
    private Instant temps = Instant.EPOCH;
    private long tempsSecondes;
    private Label tempsLabel;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();

        //panneau du jeu
        Pane jeu = new Pane();
        root.setPrefSize(640, 480);
        tempsSecondes = 10 - temps.getEpochSecond();
        System.out.println("Temps : " + tempsSecondes);
        tempsLabel = new Label("Il reste : " + tempsSecondes + " secondes");
        tempsLabel.setLayoutX(300.0);
        jeu.getChildren().add(tempsLabel);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        // on positionne le fantôme 20 positions vers la droite
        pacman.setLayoutX(0);
        pacman.setLayoutY(0);
        fantome.setLayoutX(root.getPrefWidth());
        fantome.setLayoutY(root.getPrefHeight());
        fantome.setLayoutX(root.getPrefWidth()-LARGEUR_PERSONNAGE);
        fantome.setLayoutY(root.getPrefHeight()-LARGEUR_PERSONNAGE);
        //Gestion du déplacement du personnage

        Obstacle obstacle1 = new Obstacle(60, 180);
        obstacle1.setStyle("-fx-fill: red;");
        obstacle1.setLayoutX(480);
        obstacle1.setLayoutY(80);
        root.getChildren().add(obstacle1);

        Obstacle obstacle2 = new Obstacle(60, 60);
        obstacle2.setStyle("-fx-fill: red;");
        obstacle2.setLayoutX(60);
        obstacle2.setLayoutY(80);
        root.getChildren().add(obstacle2);

        Obstacle obstacle3 = new Obstacle(120, 180);
        obstacle3.setStyle("-fx-fill: red;");
        obstacle3.setLayoutX(220);
        obstacle3.setLayoutY(200);
        root.getChildren().add(obstacle3);

        obstacleListe = new Obstacle[]{obstacle1, obstacle2, obstacle3};
        deplacer(pacman,fantome);
        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private boolean collision_obstacle(Personnage joueur) {
        double posX = joueur.getLayoutX() ;
        double posY = joueur.getLayoutY() ;
        for (Obstacle obstacle : obstacleListe) {
            if (!(posX < obstacle.getLayoutX()) && !(posY < obstacle.getLayoutY()  )
            && !(posX+ LARGEUR_PERSONNAGE > obstacle.getLayoutX()+ obstacle.getWidth()) && !(posY + LARGEUR_PERSONNAGE > obstacle.getLayoutY() + obstacle.getHeight())) {
                return true;
            }
        }
        return false;
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
                    if (collision_obstacle(j1)){
                        j1.deplacerADroite(scene.getWidth());
                    }
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    if (collision_obstacle(j1)) {
                       j1.deplacerAGauche();
                    }
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    if (collision_obstacle(j1)){
                        j1.deplacerEnBas(scene.getHeight());
                    }
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());

                    if (collision_obstacle(j1)){
                        j1.deplacerEnHaut();
                    }
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    if (collision_obstacle(j2)){
                        j2.deplacerEnBas(scene.getHeight());
                    }
                    break;
                case Q:
                    j2.deplacerAGauche();
                    if (collision_obstacle(j2)){
                        j2.deplacerADroite(scene.getWidth());
                    }
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());

                    if (collision_obstacle(j2)){
                        j2.deplacerEnHaut();
                    }
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    if (collision_obstacle(j2)) {
                        j2.deplacerAGauche();
                    }
                    break;
            }
            if (j1.estEnCollision(j2)){
                VBox fin = new VBox();
                Label titre_fin = new Label();
                titre_fin.setText("Pac Man a perdu ...");
                Button restart = new Button("Restart");
                restart.setOnMouseClicked((MouseEvent event_fin) -> {;
                    Personnage pacman = new Pacman();
                    Personnage fantome = new Fantome();
                    Pane jeu = new Pane();
                    root.setPrefSize(640, 480);
                    jeu.getChildren().add(pacman);
                    jeu.getChildren().add(fantome);
                    pacman.setLayoutX(0);
                    pacman.setLayoutY(0);
                    fantome.setLayoutX(root.getPrefWidth()-LARGEUR_PERSONNAGE);
                    fantome.setLayoutY(root.getPrefHeight()-LARGEUR_PERSONNAGE);
                    root.setCenter(jeu);
                    deplacer(pacman, fantome);
                });
                VBox.setMargin(titre_fin, new Insets(10));
                fin.setAlignment(Pos.CENTER);
                fin.getChildren().addAll(titre_fin,restart);
                root.setCenter(fin);
            }
            tempsSecondes = 10 - temps.getEpochSecond();
            tempsLabel.setText("Il reste : " + tempsSecondes + " secondes");
            if (tempsSecondes < 0) {
                if (j1.estEnCollision(j2)){
                    VBox fin = new VBox();
                    Label titre_fin = new Label();
                    titre_fin.setText("Le fantôme a perdu ...");
                    Button restart = new Button("Restart");
                    restart.setOnMouseClicked((MouseEvent event_fin) -> {
                        Personnage pacman = new Pacman();
                        Personnage fantome = new Fantome();
                        Pane jeu = new Pane();
                        root.setPrefSize(640, 480);
                        jeu.getChildren().add(pacman);
                        jeu.getChildren().add(fantome);
                        pacman.setLayoutX(0);
                        pacman.setLayoutY(0);
                        fantome.setLayoutX(root.getPrefWidth()-LARGEUR_PERSONNAGE);
                        fantome.setLayoutY(root.getPrefHeight()-LARGEUR_PERSONNAGE);
                        root.setCenter(jeu);
                        deplacer(pacman, fantome);
                    });
                    VBox.setMargin(titre_fin, new Insets(10));
                    fin.setAlignment(Pos.CENTER);
                    fin.getChildren().addAll(titre_fin,restart);
                    root.setCenter(fin);
                }
            }
        });
    }


}
