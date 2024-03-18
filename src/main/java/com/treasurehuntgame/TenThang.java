package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Vinh
 */
public class TenThang extends JDialog {

    private JTextField cb;

    public TenThang(int ten, int diem, int mucchoi) {
        setSize(500, 300);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 300);
        p.setBackground(new Color(181, 230, 29));
        add(p);
        setTitle("ENTER NAME");
        setLayout(null);
        JLabel lbl = new JLabel("PLAYER " + ten + " WIN : " + diem + "%");
        JLabel lbl2 = new JLabel();
        lbl2.setBounds(110, 125, 100, 116);
        lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
        p.add(lbl2);

        JLabel lbl3 = new JLabel();
        lbl3.setBounds(195, 125, 150, 131);
        lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucchoi2.PNG")));
        p.add(lbl3);

        lbl.setBounds(70, 0, 400, 70);
        lbl.setFont(new Font("Tahama", 1, 30));
        lbl.setForeground(Color.red);
        p.add(lbl);

        cb = new JTextField();
        cb.setBounds(130, 67, 200, 50);
        cb.setFont(new Font("Tahama", 1, 20));
        cb.setForeground(Color.blue);
        cb.setBackground(Color.yellow);
        p.add(cb);

        JButton button = new JButton("OK");
        button.setBounds(390, 200, 80, 50);
        button.setFont(new Font("Tahama", 1, 30));
        button.setForeground(Color.red);
        p.add(button);
        setBackground(Color.yellow);
        setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                String s = "/com/treasurehuntgame/data_top10/top10_" + mucchoi + ".txt";
                String ten[] = new String[12];
                int Diem[] = new int[12];
                try {
                    FileReader fr = new FileReader(s);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    int i = 0;
                    while (++i <= 10) {
                        line = br.readLine();
                        ten[i] = new String(line);
                        line = br.readLine();
                        Diem[i] = Integer.parseInt(line);
                    }
                    ten[11] = new String(cb.getText().toString().trim());
                    if (ten[11].equals("")) {
                        ten[11] = "no name";
                    }
                    Diem[11] = diem;
                    int o;
                    for (o = 1; o <= 11; o++) {
                        if (diem > Diem[o]) {
                            break;
                        }
                    }
                    for (i = 10; i > o; i--) {
                        ten[i] = ten[i - 1];
                        Diem[i] = Diem[i - 1];
                    }
                    ten[o] = ten[11];
                    Diem[o] = diem;

                    try {
                        FileWriter fw = new FileWriter(s);
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (i = 1; i <= 10; i++) {
                            bw.write(ten[i] + "\n");
                            bw.write(Diem[i] + "\n");
                        }
                        bw.close();
                        fw.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    br.close();
                    fr.close();
                } catch (Exception ex) {
                }

            }

        });

    }

}
