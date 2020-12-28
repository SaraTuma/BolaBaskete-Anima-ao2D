/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaBaskete;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Sara Tuma
 */
public class Bola {
    private int posx=200;
    private int posy=2;
    private int altura=150;
    private int largura=150;
    private int dx=1;
    private int dy=1;
    private Image img;
    
    public Bola(){
        this.img = new ImageIcon(getClass().getResource("bola.png")).getImage();
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
    
    
}
