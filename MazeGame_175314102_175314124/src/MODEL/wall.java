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
public class wall extends Sel {

    static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private char nilai;

    public wall(int x, int y, char nilai) {

        URL loc = this.getClass().getResource("/Image/tembok.jpg");
        ImageIcon wall = new ImageIcon(loc);
        Image image = wall.getImage();

        this.nilai = nilai;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

}
