/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Usuário
 */
public class ShipPick extends VBox{
    
    private ImageView circleImage;
    private ImageView shipImage;
    
    private final String circleChoose = "/Imagem/green_boxTick.png";
    private final String circleNotChoose = "/Imagem/grey_circle.png";
    private SHIP ship;
    private boolean circleTrueOrFalse;
    
    public ShipPick(SHIP ship){
        circleImage = new ImageView(circleNotChoose);
        shipImage = new ImageView(ship.getUrlShip());
        this.ship = ship;
        circleTrueOrFalse = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circleImage);
        this.getChildren().add(shipImage);
        
    }
    public SHIP getShip(){
        return ship;
    }
    public boolean getcircleTrueOrFalse(){
        return circleTrueOrFalse;
    }
    public void setCircleTrueOrFalse(boolean  circleTrueOrFalse){
        this.circleTrueOrFalse = circleTrueOrFalse;
        String imageToSet = this.circleTrueOrFalse ? circleChoose : circleNotChoose;
        circleImage.setImage(new Image(imageToSet));
    }
}
