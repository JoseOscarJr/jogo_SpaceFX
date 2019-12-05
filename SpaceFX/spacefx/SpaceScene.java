/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

/**
 *
 * @author Usuário
 */
public class SpaceScene extends SubScene{
    
     private final static String  fontPath = "src/Imagem/kenvector_future.ttf";
     private final static String  backgImage = "/Imagem/green_panel.png";
     private boolean isHidden = true;
     
    public SpaceScene() {
        super(new AnchorPane(), 400, 400);
        prefHeight(400);
        prefWidth(400);
        BackgroundImage bgImage = new BackgroundImage(new Image(backgImage, 400,400, false, true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(bgImage));
        
        setLayoutX(1024);
        setLayoutY(220);
        
    }
    /*aqui move o painel verde na tela inicial*/
    public void moveScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if(isHidden){
            transition.setToX(-480);
            isHidden = false;
        }else{
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }


    public AnchorPane getPane(){
        return (AnchorPane) this.getRoot();
    }
}
