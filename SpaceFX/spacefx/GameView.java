
package spacefx;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameView {
    private static String nomePlayer;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuGame;
    private ImageView ship;
    private boolean pressKeyA;
    private boolean pressKeyD;
    private int angle;
    private AnimationTimer gameTimer;
    private AnimationTimer gameTimerLaser;
    private GridPane gridPane1;
    private GridPane gridPane2;
    private final static String  backgImage = "/Imagem/Space.jpg";
    private final static String  asteroidImage = "/Imagem/Asteroid.png";
    private final static String  lifeScore = "/Imagem/Life.png";
    private final static String  laser = "/Imagem/laser.png";
    private final static String  pointImagem = "/Imagem/points.png";
    private ImageView laserImage;
    private final int laserQuantidade = 5;
    private boolean laserFlag = false;
    private ImageView lifeS;
    private final ImageView iVpoint = new ImageView(pointImagem);
    private ScoreLabel score;
    private ImageView[] playerLifeArray;
    private int playerLife;
    private int points;
    private final static int PONTISDETECTOR = 12;
    private final static int shipDetector = 27;
    private final static int asteroidDedetector = 20;
    private static int[] scoreVetor = new int[3];
    private static String[] scoreNome = new String[3];
    private Gson gson = new Gson();
    private ImageView[] asteroidArray;
    private Random randomAsteroids;
    private static final int gameX = 1000;
    private static final int gameY = 600;
    private String backSound = "src/som/som.mp3";
    private sound sound = new sound(backSound);
    
    public static String getNomePlayer() {
        return nomePlayer;
    }
    public static void setNomePlayer(String aNomePlayer) {
        nomePlayer = aNomePlayer;
    }
    public AnchorPane getGamePane() {
        return gamePane;
    }
    public void setGamePane(AnchorPane gamePane) {
        this.gamePane = gamePane;
    }
    public Scene getGameScene() {
        return gameScene;
    }
    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }
    public Stage getGameStage() {
        return gameStage;
    }
    public void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }
    public Stage getMenuGame() {
        return menuGame;
    }
    public void setMenuGame(Stage menuGame) {
        this.menuGame = menuGame;
    }
    public ImageView getShip() {
        return ship;
    }
    public void setShip(ImageView ship) {
        this.ship = ship;
    }
    public boolean isPressKeyA() {
        return pressKeyA;
    }
    public void setPressKeyA(boolean pressKeyA) {
        this.pressKeyA = pressKeyA;
    }
    public boolean isPressKeyD() {
        return pressKeyD;
    }
    public void setPressKeyD(boolean pressKeyD) {
        this.pressKeyD = pressKeyD;
    }
    public int getAngle() {
        return angle;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }

    public AnimationTimer getGameTimer() {
        return gameTimer;
    }
    public void setGameTimer(AnimationTimer gameTimer) {
        this.gameTimer = gameTimer;
    }
    public AnimationTimer getGameTimerLaser() {
        return gameTimerLaser;
    }
    public void setGameTimerLaser(AnimationTimer gameTimerLaser) {
        this.gameTimerLaser = gameTimerLaser;
    }
    public GridPane getGridPane1() {
        return gridPane1;
    }
    public void setGridPane1(GridPane gridPane1) {
        this.gridPane1 = gridPane1;
    }
    public GridPane getGridPane2() {
        return gridPane2;
    }
    public void setGridPane2(GridPane gridPane2) {
        this.gridPane2 = gridPane2;
    }
    public static String getBackgImage() {
        return backgImage;
    }
    public static String getAsteroidImage() {
        return asteroidImage;
    }
    public static String getLifeScore() {
        return lifeScore;
    }
    public static String getLaser() {
        return laser;
    }

    public static String getPointImagem() {
        return pointImagem;
    }
    public ImageView getLaserImage() {
        return laserImage;
    }
    public void setLaserImage(ImageView laserImage) {
        this.laserImage = laserImage;
    }
    public int getLaserQuantidade() {
        return laserQuantidade;
    }

    public boolean isLaserFlag() {
        return laserFlag;
    }
    public void setLaserFlag(boolean laserFlag) {
        this.laserFlag = laserFlag;
    }

    public ImageView getLifeS() {
        return lifeS;
    }
    public void setLifeS(ImageView lifeS) {
        this.lifeS = lifeS;
    }

    public ImageView getiVpoint() {
        return iVpoint;
    }

    public ScoreLabel getScore() {
        return score;
    }

    public void setScore(ScoreLabel score) {
        this.score = score;
    }

    public ImageView[] getPlayerLifeArray() {
        return playerLifeArray;
    }
    public void setPlayerLifeArray(ImageView[] playerLifeArray) {
        this.playerLifeArray = playerLifeArray;
    }
    public int getPlayerLife() {
        return playerLife;
    }
    public void setPlayerLife(int playerLife) {
        this.playerLife = playerLife;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public static int getPONTISDETECTOR() {
        return PONTISDETECTOR;
    }
    public static int getShipDetector() {
        return shipDetector;
    }
    public static int getAsteroidDedetector() {
        return asteroidDedetector;
    }
    public static int[] getScoreVetor() {
        return scoreVetor;
    }
    public static void setScoreVetor(int[] aScoreVetor) {
        scoreVetor = aScoreVetor;
    }
    public static String[] getScoreNome() {
        return scoreNome;
    }
    public static void setScoreNome(String[] aScoreNome) {
        scoreNome = aScoreNome;
    }
    public Gson getGson() {
        return gson;
    }
    public void setGson(Gson gson) {
        this.gson = gson;
    }
    public ImageView[] getAsteroidArray() {
        return asteroidArray;
    }
    public void setAsteroidArray(ImageView[] asteroidArray) {
        this.asteroidArray = asteroidArray;
    }
    public Random getRandomAsteroids() {
        return randomAsteroids;
    }
    public void setRandomAsteroids(Random randomAsteroids) {
        this.randomAsteroids = randomAsteroids;
    }
    public static int getGameX() {
        return gameX;
    }
    public static int getGameY() {
        return gameY;
    }
    public String getBackSound() {
        return backSound;
    }
    public void setBackSound(String backSound) {
        this.backSound = backSound;
    }
    /*aqui onde chama os inicializadores do jogo
    como a o metodo de mover o personagem*/
    public GameView(){
        inicializedStage();
        createGameMove();
        randomAsteroids = new Random();
    }
    /*aqui cria a janela do jogo e a cena onde vai ser setado todos os elementos*/
    private void inicializedStage() {
        setGamePane(new AnchorPane());
        setGameScene(new Scene(getGamePane(), getGameX(), getGameY()));
        setGameStage(new Stage());
        getGameStage().setScene(getGameScene());
    }
    /*aqui é ond emovimenta o personagem principal*/
    private void createGameMove() {
        getGameScene().setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == KeyCode.A) {
                setPressKeyA(true);
            }else if(event.getCode() ==  KeyCode.D){
                setPressKeyD(true);
            }
        });
        
        getGameScene().setOnKeyReleased((KeyEvent event) -> {
            if (event.getCode() == KeyCode.A) {
                setPressKeyA(false);
            }else if(event.getCode() ==  KeyCode.D){
                setPressKeyD(false);
            }
        });
        getGameScene().setOnMouseClicked((MouseEvent event) -> {
            if(event.getButton().equals(event.getButton().PRIMARY)){
                createLaser();
                
            }
        });
    }
    /*aqui é onde chamado os metodos essenciais para o jogo funcionar, a base 
    para criar os elementos do jogo*/
    public void createNEwGame(Stage menuStage,SHIP shipChoosen){
        
        this.setMenuGame(menuStage);
        this.getMenuGame().hide();
        createGridPane();
        createShip(shipChoosen);
        createAsteroids(LIFE.life1);
        gameLoop();
        try {
            setScoreNome(getGson().lerNome());
            setScoreVetor(getGson().lerScore());
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        sound.playMusic();
        getGameStage().show();
        
    }
    /*aqui é setado a nave que o jogador escolheu*/
    private void createShip(SHIP shipChoosen){
        setShip(new ImageView(shipChoosen.getUrlShip()));
        getShip().setLayoutX(getGameX()/2);
        getShip().setLayoutY(getGameY()-90);
        getGamePane().getChildren().add(getShip());
    }
    /*aqui é um loop que funciona com um animationtimer
    esse loop é responsavel pela movimentação dos elementos da tela*/
    private void gameLoop(){
        setGameTimer(new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveSpace();
                moveElemets();
                CollisionWithShip();
                collisionDetected();
                moveShip();
            }
        });
        getGameTimer().start();
    }
    /*aqui é a outra parte da movimentação da nave, onde é setado para onde ela se movimenta*/
    private void moveShip(){
        if(isPressKeyA() && !isPressKeyD()){
            if(getShip().getLayoutX() > -20){
                getShip().setLayoutX(getShip().getLayoutX() -4);
            }
        }if(isPressKeyD() && !isPressKeyA()){
            if(getShip().getLayoutX() < 950){
                getShip().setLayoutX(getShip().getLayoutX() +4);
            }
        }
    }
    /*aqui é setado o ambiete do espaço, com as imagens*/
    public void createGridPane(){
        setGridPane1(new GridPane());
        setGridPane2(new GridPane());
        for (int i = 0; i < 12; i++) {
            ImageView backGround1 = new ImageView(getBackgImage());
            ImageView backGround2 = new ImageView(getBackgImage());
            GridPane.setConstraints(backGround1, i%3, i/3);
            GridPane.setConstraints(backGround2, i%3, i/3);
            getGridPane1().getChildren().add(backGround1);
            getGridPane2().getChildren().add(backGround2);
            
        }
        getGridPane2().setLayoutY(-1024);
        getGamePane().getChildren().addAll(getGridPane1(), getGridPane2());
        
    }
    /*aqui move o espaço no fundo do game*/
    public void moveSpace(){
        getGridPane1().setLayoutY(getGridPane1().getLayoutY() + 0.5);
        getGridPane2().setLayoutY(getGridPane2().getLayoutY() + 0.5);
        
        if(getGridPane1().getLayoutY() >= 1024){
            getGridPane1().setLayoutY(-1024);
        }
        if(getGridPane2().getLayoutY() >= 1024){
            getGridPane2().setLayoutY(-1024);
        }
    }
    /*cria os asteroides no mapa*/
    public void createAsteroids(LIFE life){
        setAsteroidArray(new ImageView[20]);
        CreateLife(life);
        
        for (int i = 0; i < getAsteroidArray().length; i++) {
            getAsteroidArray()[i]= new ImageView(getAsteroidImage());
            setPosition(getAsteroidArray()[i]);
            getGamePane().getChildren().add(getAsteroidArray()[i]);
        }
    }
    /*seta as posições dos asteroides e das mini naves*/
    public void setPosition(ImageView imageView){
        imageView.setLayoutX(getRandomAsteroids().nextInt(950));
        imageView.setLayoutY(-(randomAsteroids.nextInt(3200)+600));
    }
    /*aqui move os asteroides e as mini naves*/
    public void moveElemets(){
        getiVpoint().setLayoutY(getiVpoint().getLayoutY() + 5);

        for (int i = 0; i < getAsteroidArray().length; i++) {
            getAsteroidArray()[i].setLayoutY(getAsteroidArray()[i].getLayoutY() + 6);
            getAsteroidArray()[i].setRotate(getAsteroidArray()[i].getRotate()+ 4);
            
        }
    }
    /*aqui defini as posiçoes q os asteroides podem nascer*/
    public void CollisionWithShip(){
        if(getiVpoint().getLayoutY() > 1200){
            setPosition(getiVpoint());
        }
        for (int i = 0; i < getAsteroidArray().length; i++) {
            if (getAsteroidArray()[i].getLayoutY() > 900) {
                setPosition(getAsteroidArray()[i]);
            }
            
        }
    }
    /*aqui cria as vidas do personagem na tela do game e tambem a tabela de pontos*/
    public void CreateLife(LIFE lifeShip){
        setPlayerLife(2);
        setLifeS(new ImageView(getLifeScore()));
        setPosition(getLifeS());
        getGamePane().getChildren().add(getiVpoint());
        getGamePane().getChildren().add(getLifeS());
        setScore(new ScoreLabel("Points : 00"));
        getScore().setLayoutX(870);
        getScore().setLayoutY(20);
        getGamePane().getChildren().add(getScore());
        setPlayerLifeArray(new ImageView[5]);
        
        for (int i = 0; i < getPlayerLifeArray().length; i++) {
            getPlayerLifeArray()[i] = new ImageView(lifeShip.getUrlLife());
            getPlayerLifeArray()[i].setLayoutX(850+(i*50));
            getPlayerLifeArray()[i].setLayoutY(80);
            getGamePane().getChildren().add(getPlayerLifeArray()[i]);
                    
        }
    }
    /*aqui remove a vida do personagem e tambem interrompe o jogo se acaabr as vidas*/
    private void removeLife(){
        getGamePane().getChildren().remove(getPlayerLifeArray()[getPlayerLife()]);
        setPlayerLife(getPlayerLife() - 1);
        if(getPlayerLife() < 0){
            getGson().verificandoVetor(getScoreVetor(), getScoreNome(), getNomePlayer(), getPoints());
            sound.stopMusic();
            getGameStage().close();
            getGameTimer().stop();
            getMenuGame().show();
        }
        
    }
    /*calcula a distancia de dois objetos*/
    private double calculatorDistance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow(x1-x2, 2)+ Math.pow(y1-y2, 2));
    }
    /*aqui é passados as localizações no mapa, para veerificar se ocorreu colisões
    tanto da nave com asterides como com as mini naves*/
    private void collisionDetected(){
        if(getShipDetector() + getPONTISDETECTOR() > calculatorDistance(getShip().getLayoutX()+55, getiVpoint().getLayoutX()+30,
                getShip().getLayoutY()+45, getiVpoint().getLayoutY()+30)){
            setPosition(getiVpoint());
            setPoints(getPoints() + 1);
            String textToset = "POINTS: ";
            if(getPoints() < 10){
                textToset += "0";
            }

            getScore().setText(textToset + getPoints());
        }
        for (int i = 0; i < getAsteroidArray().length; i++) {
           if(getShipDetector() + getAsteroidDedetector() > calculatorDistance(getShip().getLayoutX() +49,
                   getAsteroidArray()[i].getLayoutX() +20, getShip().getLayoutY() +45,  getAsteroidArray()[i].getLayoutY()+25)){
               removeLife();
               setPosition(getAsteroidArray()[i]);
           }
            
        }

    }
    private void createLaser(){
            setLaserImage(new ImageView(getLaser()));
            getLaserImage().setLayoutX(getShip().getLayoutX()+10);
            getLaserImage().setLayoutY(getShip().getLayoutY());
            getGamePane().getChildren().add(getLaserImage());
            setGameTimer(new AnimationTimer() {
                @Override
                public void handle(long now) {
                    moveLaser();
                }
            });
        if(getLaserQuantidade() > 0){
            getGameTimer().start();
        }
        
    }
    private void moveLaser(){
            getLaserImage().setLayoutY(getLaserImage().getLayoutY() - 3);
    }
    public void lerScore(){
        try {
            setScoreVetor(getGson().lerScore());
            setScoreNome(getGson().lerNome());
        } catch (IOException ex) {
            Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
