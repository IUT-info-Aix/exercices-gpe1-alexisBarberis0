package fr.amu.iut.exercice6;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class KeyPressedPenduEvent implements EventHandler<KeyEvent>{
    private char[] motCache;

    private int nbVies;

    private String motADecouvrir;

    private Label labelVies;

    private Label motCacheLabel;

    private TextField textField;

    @Override
    public void handle(KeyEvent keyEvent) {
        if (textField.getText().length() !=1){
            System.out.println("l'entrée n'est pas un unique caractère");
            return;
        }
        char[] motInit = motCache;
        for (int i = 0; i < motADecouvrir.length(); ++i) {
            if (motADecouvrir.charAt(i) == textField.getText().charAt(0)) {
                motCache[i] = motADecouvrir.charAt(i);
            }
        }
        if (motInit.equals(motCache)) {
            --nbVies;
        }
        motCacheLabel.setText("");
        labelVies.setText("Nombre de vies : " + nbVies);

    }
}
