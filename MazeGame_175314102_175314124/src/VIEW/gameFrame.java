/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Tempat;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class gameFrame extends JFrame {

    private TempatPanel tempatPanel;
    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton okButton;
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;
    private JMenuItem SimpanKonfigurasiMenuItem;
    private JButton pindahKananButton;
    private JButton pindahKiriButton;
    private JButton pindahAtasButton;
    private JButton pindahBawahButton;

    public gameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public gameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        SimpanKonfigurasiMenuItem = new JMenuItem("Simpan");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(SimpanKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perfom for bacaKonfigurasiMenuItem
        bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnVal = jf.showOpenDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    try {
                        tempat.bacaKonfigurasi(jf.getSelectedFile());
                    } catch (IOException ex) {
                        Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Tempat.batasKanan = 500;
                Tempat.batasBawah = 300;
                // buat tempatPanel dan tambahkan tempat ke tempatPanel
                tempatPanel = new TempatPanel();
                tempatPanel.setTempat(tempat);
                init();
            }
        }
        );

        SimpanKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        }
        );

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                System.exit(0);
            }
        }
        );

        // panel selatan
        JPanel southPanel = new JPanel();

        southPanel.setLayout(
                new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");

        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);

        southPanel.add(perintahText);

        this.okButton = new JButton("OK");

        southPanel.add(okButton);

        okButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if ("L".equalsIgnoreCase(perintahText.getText())) {
                    pindahKiri();
                } else if ("R".equalsIgnoreCase(perintahText.getText())) {
                    pindahKanan();
                } else if ("U".equalsIgnoreCase(perintahText.getText())) {
                    pindahAtas();
                } else if ("D".equalsIgnoreCase(perintahText.getText())) {
                    pindahBawah();
                }
            }
        }
        );

        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel
                != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }

        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(
                true);
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahKiri() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kiri
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahAtas() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke atas
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahBawah() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke bawah
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }
}
