/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author user only
 */
public class Sel {

    private int posisiY;
    private int posisiX;
    private int Jarak = 450;

    private Image image;

    public Sel() {
    }

    public Sel(int baris, int kolom) {
        this.posisiY = baris;
        this.posisiX = kolom;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean PosisiKiri(Sel Objek) {
        return ((this.getPosisiY() - Jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX());
    }

    public boolean PosisiKanan(Sel sel) {
        return ((this.getPosisiY() + Jarak) == sel.getPosisiY()) && (this.getPosisiX() == sel.getPosisiX());
    }

    public boolean PosisiAtas(Sel sel) {
        return ((this.getPosisiX() - Jarak) == sel.getPosisiX()) && (this.getPosisiY() == sel.getPosisiY());
    }

    public boolean PosisiBawah(Sel sel) {
        return ((this.getPosisiX() + Jarak) == sel.getPosisiX()) && (this.getPosisiY() == sel.getPosisiY());
    }

}
