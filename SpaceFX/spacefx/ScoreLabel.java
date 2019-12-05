
package spacefx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;


public class ScoreLabel extends Label{
    
    private final static String  fontPath = "src/Imagem/kenvector_future.ttf";
    
    public ScoreLabel(String text){
        setPrefWidth(130);
        setPrefHeight(40);
        BackgroundImage bgImage = new BackgroundImage(new Image("/Imagem/InfoLabel.png", 130,40, false, true),
                 BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, null);
        setBackground(new Background(bgImage));
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10, 10, 10, 10));
        setFontLabel();
        setText(text);
    }
    private void setFontLabel(){
          try {
              setFont(Font.loadFont(new FileInputStream(new File(fontPath)), 13));
          } catch (FileNotFoundException ex) {
              setFont(Font.font("Verdana",13));
          }
    }
            
}
