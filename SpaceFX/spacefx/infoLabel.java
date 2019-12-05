
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

public class infoLabel extends Label{
      private final static String  fontPath = "src/Imagem/kenvector_future.ttf";
      private final static String  backImage = "/Imagem/green_button13.png";
      
      public infoLabel(String text){
          setPrefWidth(350);
          setPrefHeight(49);
          setText(text);
          setWrapText(true);
          setLabelFont();
          setAlignment(Pos.CENTER);
          BackgroundImage bgImage = new BackgroundImage(new Image(backImage, 350,49, false, true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, null);
          setBackground(new Background(bgImage));
      }
      public infoLabel(String text, double x, double y){
          setPrefWidth(x);
          setPrefHeight(y);
          setText(text);
          setWrapText(true);
          setLabelFont();
          setAlignment(Pos.CENTER);
          BackgroundImage bgImage = new BackgroundImage(new Image(backImage, x,y, false, true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, null);
          setBackground(new Background(bgImage));
      }
        /*seta a fonte usada nos botões*/
      private void setLabelFont(){
          try {
              setFont(Font.loadFont(new FileInputStream(new File(fontPath)), 23));
          } catch (FileNotFoundException ex) {
              setFont(Font.font("Verdana",23));
          }
      }
      
      
      
}
