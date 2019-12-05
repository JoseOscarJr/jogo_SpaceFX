/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Usuário
 */
public class TelaInicial {
    private static final int X = 1000;
    private static final int Y = 800;
    private final int buttonX = 200;
    private final int buttonY = 250;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private SpaceScene creditosScene;
    private SpaceScene scoreScene;
    private SpaceScene playScene;
    private SpaceScene sceneShow;
    private Gson gson = new Gson();
    private List<SpaceButton> listButton;
    private List<ShipPick> listShip;
    private SHIP shipChoose;
    private TextField tf = new TextField();
    private String backSound2 = "src/som/som2.mp3";
    private sound sound = new sound(backSound2);

     public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public int getButtonX() {
        return buttonX;
    }

    public int getButtonY() {
        return buttonY;
    }

    public SpaceScene getCreditosScene() {
        return creditosScene;
    }

    public void setCreditosScene(SpaceScene creditosScene) {
        this.creditosScene = creditosScene;
    }


    public SpaceScene getScoreScene() {
        return scoreScene;
    }

    public void setScoreScene(SpaceScene scoreScene) {
        this.scoreScene = scoreScene;
    }

    public SpaceScene getPlayScene() {
        return playScene;
    }

    public void setPlayScene(SpaceScene playScene) {
        this.playScene = playScene;
    }
    public SpaceScene getSceneShow() {
        return sceneShow;
    }

    public void setSceneShow(SpaceScene sceneShow) {
        this.sceneShow = sceneShow;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
    public List<SpaceButton> getListButton() {
        return listButton;
    }

    public void setListButton(List<SpaceButton> listButton) {
        this.listButton = listButton;
    }
    public List<ShipPick> getListShip() {
        return listShip;
    }

    public void setListShip(List<ShipPick> listShip) {
        this.listShip = listShip;
    }

    public SHIP getShipChoose() {
        return shipChoose;
    }

    public void setShipChoose(SHIP shipChoose) {
        this.shipChoose = shipChoose;
    }

    public TextField getTf() {
        return tf;
    }

    public void setTf(TextField tf) {
        this.tf = tf;
    }

    public String getBackSound2() {
        return backSound2;
    }

    public void setBackSound2(String backSound2) {
        this.backSound2 = backSound2;
    }
    public AnchorPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(AnchorPane mainPane) {
        this.mainPane = mainPane;
    }

    public Scene getMainScene() {
        return mainScene;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    
        public sound getSound() {
        return sound;
    }

    public void setSound(sound sound) {
        this.sound = sound;
    }
    /*construtor*/
    public TelaInicial(){
        listButton = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(getMainPane(), getX(), getY());
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        getSound().playMusic();
        createButtons();
        creatBackGround();
        logo();
        createScenes();
    }
    /*inicia a cena*/
    private void showScene(SpaceScene showS){

        if(getSceneShow() != null){
            getSceneShow().moveScene();
        }
        showS.moveScene();
        setSceneShow(showS);
    }
    /*aqui é setado as posições dos botões na tela*/
    private void menuButton(SpaceButton button){
       button.setLayoutX(getButtonX());
       button.setLayoutY(getButtonY() + (getListButton().size() * 100));
        getListButton().add(button);
       mainPane.getChildren().add(button);
       
    }
    /*aqui cria as cenas com os paineis verdes*/
    private void createScenes(){
        setCreditosScene(new SpaceScene());
        mainPane.getChildren().add(getCreditosScene());
        
        setScoreScene(new SpaceScene());
        mainPane.getChildren().add(getScoreScene());
        
        createPickShip();
        listaScore();
        creditosFinal();
    }
    /*aqui é onde chama todos os metodos para criar os botões de uma vez*/
    private void createButtons(){ 
        playButton();
        updateButton();
        creditsButton();
        exitButton();
    
    }
    /*cria o botão play na tela inicial*/
    private void playButton(){
        SpaceButton play = new SpaceButton("PLAY");
        menuButton(play);
        
        play.setOnAction((ActionEvent event) -> {
            showScene(getPlayScene());
        });
        
    }
    /*cria o botão score na tela inicial*/
   private void updateButton(){
        SpaceButton update = new SpaceButton("SCORE");
        menuButton(update);
        update.setOnAction((ActionEvent event) -> {
            listaScore();
            showScene(getScoreScene());
        }); 
    }
   /*cria o botão credits na tela inicial*/
     private void creditsButton(){
         
        SpaceButton credits = new SpaceButton("CREDITS");
        menuButton(credits);
        credits.setOnAction((ActionEvent event) -> {
            showScene(getCreditosScene());
        });
    }
     /*cria o botão exit na tela inicial*/
    private void exitButton(){
        SpaceButton exit = new SpaceButton("EXIT");
        menuButton(exit);
            exit.setOnAction((ActionEvent event) -> {
                mainStage.close();
        });
    }
    /* aqui é setado a imagem de fundo na tela inicial
    */
    private void creatBackGround(){
        Image backImage = new Image("/Imagem/BackSpace.png",1000,800,false,true);
        BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));
        
    }
    /* aqui onde é inserido a logo na tela inicial, a logo com Space FX escrito*/
    private void logo(){
        ImageView logo = new ImageView("/Imagem/Slogo.png");
        logo.setLayoutX(0);
        logo.setLayoutY(80);
        logo.setOnMouseEntered((MouseEvent event) -> {
            logo.setEffect(new DropShadow());
        });
        
         logo.setOnMouseExited((MouseEvent event) -> {
             logo.setEffect(null);
        });
         mainPane.getChildren().add(logo);
    }
    /* aqui é onde o painel do play é montado com as figuras da naves,
    e setado para a cena e tambem onde é inserido o text field para
    o usuario inserir o nome*/
    private void createPickShip() {
        setPlayScene(new SpaceScene());
        mainPane.getChildren().add(getPlayScene());
        
        try {
            getTf().setFont(Font.loadFont(new FileInputStream(new File("src/Imagem/kenvector_future.ttf")), 13));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        getTf().setLayoutX(102);
        getTf().setLayoutY(305);
        getPlayScene().getPane().getChildren().add(getTf());
        infoLabel infLabel = new infoLabel("Escolha sua Nave");
        infLabel.setLayoutX(25);
        infLabel.setLayoutY(25);
        
        infoLabel inf = new infoLabel("SEU NOME");
        inf.setLayoutX(20);
        inf.setLayoutY(250);
        getPlayScene().getPane().getChildren().add(inf);
        getPlayScene().getPane().getChildren().add(infLabel);
        getPlayScene().getPane().getChildren().add(pickerShipToPlay());
        getPlayScene().getPane().getChildren().add(buttonStarGame());
    }
    /*trata a escolha do jogadore, na hora de escolher a nave, chamando o enum para 
    auxiliar a escolha*/
    private HBox pickerShipToPlay(){
        HBox hbox = new HBox();
        
        hbox.setSpacing(20);
        setListShip(new ArrayList<>());
        for (SHIP ship : SHIP.values()) {
            ShipPick pick = new ShipPick(ship);
            hbox.getChildren().add(pick);
            getListShip().add(pick);
            pick.setOnMouseClicked((MouseEvent event) -> {
                for (ShipPick shipPick : getListShip()) {
                    shipPick.setCircleTrueOrFalse(false);
                }
                pick.setCircleTrueOrFalse(true);
                setShipChoose(pick.getShip());
            });
        }
        hbox.setLayoutX(300-(118*2));
        hbox.setLayoutY(100);
        return hbox;
    }
    /*cria o botao start da aba play, usando a classe spacebuttun para criar a interface do
    botão assim que acionado cria a aba do jogo*/
    private SpaceButton buttonStarGame(){
        SpaceButton start =new SpaceButton("START");
        start.setLayoutX(100);
        start.setLayoutY(335);
        start.setOnAction((ActionEvent event) -> {
            if(getShipChoose() != null){
                GameView gameView = new GameView();
                gameView.setNomePlayer(getTf().getText());
                getTf().setText("");
                getSound().pauseMusic();
                gameView.createNEwGame(mainStage, getShipChoose());
                
            }
        });
        return start;
    }
    /* cria o label de pontos, e le o json para preencher o vetor com os pontos e nomes dos 
        tres maiores jogadores.*/
    private void listaScore(){
        setScoreScene(new SpaceScene());
        mainPane.getChildren().add(getScoreScene());
        GameView gView = new GameView();
        gView.lerScore();
         try {
           gView.setScoreNome(getGson().lerNome());
           gView.setScoreVetor(getGson().lerScore());
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        infoLabel infLabel = new infoLabel("TOP PLAYERS");
        infLabel.setLayoutX(25);
        infLabel.setLayoutY(25);
        getScoreScene().getPane().getChildren().add(infLabel);
        infoLabel vetInf = new infoLabel("");

        for (int i = 1; i < gView.getScoreNome().length+1; i++){
            vetInf = new infoLabel(i+"ª "+gView.getScoreNome()[i-1] + ": "+Integer.toString(gView.getScoreVetor()[i-1]));
            vetInf.setLayoutX(25);
            vetInf.setLayoutY(i*100);
            getScoreScene().getPane().getChildren().add(vetInf);
        }
  
    }
    
    // cria e inseri o label na aba de score na tela inicial
    private void creditosFinal(){
        setCreditosScene(new SpaceScene());
        mainPane.getChildren().add(getCreditosScene());
        
        infoLabel credLabel = new infoLabel("SPACE FX", 300, 300);
        credLabel.setLayoutX(40);
        credLabel.setLayoutY(40);
        getCreditosScene().getPane().getChildren().add(credLabel);
    }


}

   