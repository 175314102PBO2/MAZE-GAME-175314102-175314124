/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import MODEL.Tempat;
import VIEW.TempatPanel;
import VIEW.gameFrame;
import javax.swing.JFileChooser;
import MODEL.Sel;
import java.awt.Color;
import java.io.IOException;

/**
 *
 * @author ACER
 */
public class TestGame2 {

    public static void main(String[] args) throws IOException {
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showOpenDialog(null);
        Tempat tempat = new Tempat();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tempat.bacaKonfigurasi(jf.getSelectedFile());
            // menampilkan atribut 'isi' dari kelas Tempat
            System.out.println("Isi peta = ");
            System.out.println(tempat.getIsi());
            if (tempat.getDaftarSel() != null) {
                for (int i = 0; i < tempat.getDaftarSel().size(); i++) {
                    // menampilkan nilai posisi Baris,posisi Kolom dan nilai
                    System.out.println(
                            tempat.getDaftarSel().get(i).getBaris() + ","
                            + tempat.getDaftarSel().get(i).getKolom() + ","
                            + tempat.getDaftarSel().get(i).getNilai());

                }
            }
        }
        // Set ukuran tempat
        Tempat.batasKanan = 350;
        Tempat.batasBawah = 350;
        // buat tempatPanel dan tambahkan tempat ke tempatPanel
        TempatPanel tempatPanel = new TempatPanel();
        tempatPanel.setTempat(tempat);
        // buat gameFrame dan tambahkan tempatPanel ke gameFrame
        gameFrame game = new gameFrame("Amel Siska", tempatPanel);
    }
}
