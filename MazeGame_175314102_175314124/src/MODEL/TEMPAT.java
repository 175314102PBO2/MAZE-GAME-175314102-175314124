/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class TEMPAT {

    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<SEL> daftarSel; // daftar sel

    private String isi; // isi file konfigurasi

    public static int batasKanan;
    public static int batasBawah;

    public TEMPAT() {
        daftarSel = new ArrayList<SEL>();
    }
}
