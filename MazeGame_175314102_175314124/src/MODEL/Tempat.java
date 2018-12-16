/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user only
 */
public class Tempat extends JPanel {

    private int tinggi = 0;
    private int lebar = 0;
    private int jarak = 45;

    private ArrayList tembok = new ArrayList();
    private ArrayList<Sel> map = new ArrayList();
    private ArrayList<String> undo = new ArrayList<>();
    private ArrayList<String> save = new ArrayList<>();

    private String isi;

    private Pelakon tukangMain;
    private Rampung selesai;
    private Tembok dinding;

    private File alamat;

    public Tempat() {
    }

    public Tempat(File file) {
        bacaPeta(file);
    }

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public ArrayList getTembok() {
        return tembok;
    }

    public ArrayList getMap() {
        return map;
    }

    public int getJarak() {
        return jarak;
    }

    public Pelakon getPelakon() {
        return tukangMain;
    }

    public Rampung getRampung() {
        return selesai;
    }

    public void setMap(ArrayList<Sel> map) {
        this.map = map;
    }

    public boolean isComplete() {
        return tukangMain.getPosisiX() == selesai.getPosisiX() && tukangMain.getPosisiY() == selesai.getPosisiY();
    }

    public ArrayList<String> getSave() {
        return save;
    }

    public void bacaPeta(File file) {
        try {
            alamat = file;
            FileInputStream input = new FileInputStream(file);
            String hasilBaca = "";
            int data;
            int posisiY = 0;
            int posisiX = 0;

            while ((data = input.read()) != -1) {
                char item = (char) data;
                switch (item) {
                    case '\n':
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                        break;
                    case '#':
                        dinding = new Tembok(posisiX, posisiY);
                        this.tembok.add(dinding);
                        posisiX += jarak;
                        break;
                    case 'o':
                        selesai = new Rampung(posisiX, posisiY);
                        posisiX += jarak;
                        break;
                    case '@':
                        tukangMain = new Pelakon(posisiX, posisiY);
                        posisiX += jarak;
                        break;
                    case ' ':
                        posisiX += jarak;
                        break;
                    default:
                        break;
                }
                tinggi = posisiY;
            }

            this.setIsi(hasilBaca);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        getMap().addAll(tembok);
        getMap().add(selesai);
        getMap().add(tukangMain);
        for (int i = 0; i < getMap().size(); i++) {
            Sel item = (Sel) getMap().get(i);
            g.drawImage(item.getImage(), item.getPosisiY(), item.getPosisiX(), this);
        }
    }

    public void MLAKU(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, " Kebanyakan Kata ! ");
        } else if (in.length == 2) {
            undo.add(input);
            if (in[0].equalsIgnoreCase("l")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "l")) {
                        tukangMain.MLAKU(0, -jarak);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "r")) {
                        tukangMain.MLAKU(0, jarak);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "d")) {
                        tukangMain.MLAKU(jarak, 0);
                        repaint();
                    }
                }
            } else if (in[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "u")) {
                        tukangMain.MLAKU(-jarak, 0);
                        repaint();
                    }
                }
            } else {
                JOptionPane.showConfirmDialog(null, " Aneh ");
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    " PERINTAH SALAH  !\nBaca About duluw! ",
                    " PERINGATAN ", 1);
        }
    }

    private boolean cekBatasTembok(Sel TukangMain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok tembok = (Tembok) this.tembok.get(i);
                if (tukangMain.PosisiAtas(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok tembok = (Tembok) this.tembok.get(i);
                if (tukangMain.PosisiBawah(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok tembok = (Tembok) this.tembok.get(i);
                if (tukangMain.PosisiKiri(tembok)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok tembok = (Tembok) this.tembok.get(i);
                if (tukangMain.PosisiKanan(tembok)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

    public void undo() {
        try {
            int nilaiUndo = undo.size() - 1;
            String input = undo.get(nilaiUndo);
            String[] ulang = input.split(" ");
            if (ulang[0].equalsIgnoreCase("l")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "r")) {
                        tukangMain.MLAKU(0, jarak);
                        repaint();
                    }
                }
                undo.remove(nilaiUndo);

            } else if (ulang[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "l")) {
                        tukangMain.MLAKU(0, -jarak);
                        repaint();
                    }
                }
                undo.remove(nilaiUndo);

            } else if (ulang[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "d")) {
                        tukangMain.MLAKU(jarak, 0);
                        repaint();
                    }
                }
                undo.remove(nilaiUndo);

            } else if (ulang[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(ulang[1])); i++) {
                    if (!cekBatasTembok(tukangMain, "u")) {
                        tukangMain.MLAKU(-jarak, 0);
                        repaint();
                    }
                }
                undo.remove(nilaiUndo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Sudah Kembali ");
        }
    }

    public void restartPlayer() {
        undo.clear();
        tembok.clear();
        getMap().clear();
        bacaPeta(alamat);
        repaint();
    }

    public void hapus() {
        undo.clear();
        tembok.clear();
        getMap().clear();
    }

    public void saveKonfigurasiPeta() {
        try {
            try (FileOutputStream fos = new FileOutputStream(new File("koordinatsave.txt"))) {
                for (int i = 0; i < undo.size(); i++) {
                    String data = undo.get(i) + ",";
                    fos.write(data.getBytes());
                }
                JOptionPane.showMessageDialog(null, " Tersimpan ");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LoadKonfigurasiPeta() {
        try {
            undo.clear();
            save.clear();
            String hasilBaca = "";
            FileInputStream fis = new FileInputStream(new File("koordinatsave.txt"));
            int dataInt;
            while ((dataInt = fis.read()) != -1) {
                if ((char) dataInt == ',') {
                    this.save.add(hasilBaca);
                    hasilBaca = "";
                } else {
                    hasilBaca = hasilBaca + (char) dataInt;
                }
            }
            Tempat tempat = new Tempat(alamat);
            tempat.save = this.save;
            for (int i = 0; i < tempat.save.size(); i++) {
                MLAKU(tempat.save.get(i));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
