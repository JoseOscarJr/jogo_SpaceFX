/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Usuário
 */
public class sound {
    private MediaPlayer player;
    
    public MediaPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MediaPlayer player) {
        this.player = player;
    }
    
    public sound(String music){  
        player = new MediaPlayer(new Media(new File(music).toURI().toString()));

    }
    
    public void playMusic(){
        getPlayer().play();
    }
      public void stopMusic(){
        getPlayer().stop();
    }
        public void pauseMusic(){
        getPlayer().pause();
    }

 
}