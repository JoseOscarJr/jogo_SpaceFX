/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;


public enum SHIP {
    
    ship1("/Imagem/nave1.png"),
    ship2("/Imagem/nave2.png"),
    ship3("/Imagem/nave3.png");
    
    
    private String urlShip;
    private SHIP(String urlShip){
        this.urlShip = urlShip;
    }

    public String getUrlShip() {
        return urlShip;
    }
    
}
