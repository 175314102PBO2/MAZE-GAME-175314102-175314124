/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import MODEL.Tempat;
import VIEW.TempatPanel;
import VIEW.gameFrame;

/**
 *
 * @author jarkom
 */
public class TestGame3 {

    public static void main(String[] args) {
        // buat 1 sel
//        Sel sel = new Sel(1,1 ,20,20, '@', Color.RED);
        // buat 1 tempat dan tambahkan sel ke tempat
        Tempat tempat = new Tempat();
//        tempat.tambahSel(sel);
        // Set ukuran tempat
        Tempat.batasKanan = 500;
        Tempat.batasBawah = 300;
        // buat tempatPanel dan tambahkan tempat ke tempatPanel
        TempatPanel tempatPanel = new TempatPanel();
        tempatPanel.setTempat(tempat);
        // buat gameFrame dan tambahkan tempatPanel ke gameFrame
        gameFrame game = new gameFrame("Amel Siska", tempatPanel);
    }
}