
package spacefx;

public enum LIFE {
     life1("/Imagem/Life.png");
    
    
    
    private String urlLife;
    private LIFE(String urlLife){
        this.urlLife = urlLife;
    }

    public String getUrlLife() {
        return urlLife;
    }
}
