/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author ACER
 */
public class Pelakon extends Sel{
       public Pelakon(int X, int Y) {
        super(X, Y);

        URL loc = this.getClass().getResource("pemain.png");
        ImageIcon iia = new ImageIcon(loc);

        Image image = iia.getImage();

        this.setImage(image);
    }

    public void MLAKU(int X, int Y) {
        int nx = this.getPosisiX() + X;
        int ny = this.getPosisiY() + Y;
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    } 
}
