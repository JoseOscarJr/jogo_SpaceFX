/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/**
 *
 * @author Usuário
 */
public class SpaceButton extends Button{
    private final String  fontPath = "src/Imagem/kenvector_future.ttf";
    private final String buttonPress = "-fx-background-color: transparent; -fx-backgroud-image: url('/Imagem/green_button00.png');";
    private final String buttonFree = "-fx-background-color: transparent; -fx-background-image: url('/Imagem/green_button01.png');";
    public SpaceButton(String text){
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(45);
        setStyle(buttonFree);
        inicilizedButton();
    }
    /*seta a fonte usada nos botões*/
    private void setButtonFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(fontPath), 23));
        } catch (FileNotFoundException ex) {
            setFont(Font.font("Verdana",23));
        }
    }
    /*aqui cria o efeito de pressionar o botão*/
    private void setButtonPress(){
        setStyle(buttonPress);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }
    /*aqui cria o efeito de soltar o botão*/
     private void setButtonFree(){
        setStyle(buttonFree);
        setPrefHeight(45);
        setLayoutY(getLayoutY() - 4);
    }
     /*os metodos abaixo são responsavel por criar o efeito de clicar num botão
     aquele efeito de aprecer que o botão esta pressionado*/
     private void inicilizedButton(){
         setOnMousePressed(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                if(event.getButton().equals(event.getButton().PRIMARY)){
                    setButtonPress();
                }
             }
         });
         
         setOnMouseReleased(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                if(event.getButton().equals(event.getButton().PRIMARY)){
                    setButtonFree();
                }
             }
         });
         
          setOnMouseEntered(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 setEffect(new DropShadow());
             }
         });
          
          setOnMouseExited(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent event) {
                 setEffect(null);
             }
         });
         
     }
     
         
 }
