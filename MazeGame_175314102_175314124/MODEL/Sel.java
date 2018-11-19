/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.awt.Color;

/**
 *
 * @author jarkom
 */
public class Sel {

    private int posisiX;
    private int posisiY;
    private char nilai;
    private int lebar;
    private int tinggi;
    private Color warna;

    public Sel() {
    }

    public Sel(int posisiX, int posisiY, char nilai) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.nilai = nilai;
    }

    public Sel(int posisiX, int posisiY, char nilai, Color warna) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int posisiX, int posisiY, int lebar, int tinggi, char nilai, Color warna) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public char getNilai() {
        return nilai;
    }

    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    @Override
    public String toString() {
        return posisiX + "," + posisiY + "," + nilai;
    }

    public boolean Pemain() {
        // menggunakan tanda @, karena seorang pemain dilambangkan dengan tanda tersebut
        return nilai == '@';
    }

    public boolean Hambatan() {
        return nilai == '#';
    }

    public boolean isBatasKiri() {
        if (posisiX <= 0) {
            return true;
        } else {
            return false;
        }

    }

}
