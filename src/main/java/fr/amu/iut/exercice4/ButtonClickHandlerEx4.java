package fr.amu.iut.exercice4;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ButtonClickHandlerEx4 implements EventHandler<Event> {
    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private Label label;
    private Pane panneau;

    public ButtonClickHandlerEx4(Label label, Pane panneau, Button vert, Button rouge, Button bleu) {
        this.label = label;
        this.panneau = panneau;
        this.vert = vert;
        this.rouge = rouge;
        this.bleu = bleu;
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == vert) {
            ++nbVert;
            panneau.setStyle("-fx-background-color: #19e023");
            label.setText("Vert choisi " + nbVert + " fois" );
        }
        if (event.getSource() == rouge) {
            ++nbRouge;
            panneau.setStyle("-fx-background-color: #e01919");
            label.setText("Rouge choisi " + nbRouge + " fois" );
        }
        if (event.getSource() == bleu) {
            ++nbBleu;
            panneau.setStyle("-fx-background-color: #1941e0");
            label.setText("Bleu choisi " + nbBleu + " fois" );
        }
    }
}
