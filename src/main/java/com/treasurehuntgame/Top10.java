package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Top10 extends JDialog {
    private JComboBox<String> cb;
    String s;
    JLabel[] top = new JLabel[11];

    public Top10() {
        setSize(500, 550);
        setTitle("TOP 10");
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 550);
        p.setBackground(new Color(34, 177, 76));
        add(p);

        setLayout(null);
        String[] md = {"VERY EASY", "EASY", "MEDIUM", "HARD", "VERY HARD"};
        JLabel lbl = new JLabel("CHOOSE LEVEL");
        lbl.setBounds(70, 0, 400, 70);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        p.add(lbl);

        cb = new JComboBox<>(md);
        cb.setBounds(140, 67, 180, 50);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.BLUE);
        cb.setBackground(new Color(255, 255, 153)); // Chỉnh màu nền của JComboBox
        p.add(cb);
        s = "src/main/java/com/treasurehuntgame/data_top10/top10_1.txt";

        String[] ten = new String[11];
        String[] diem = new String[11];

        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int i = 0;
            while (++i <= 10) {
                line = br.readLine();
                ten[i] = new String(line);
                line = br.readLine();
                diem[i] = new String(line);
            }
            br.close();
            fr.close();
        } catch (Exception ex) {
        }
        for (int i = 1; i <= 10; i++) {
            String ss = "Top " + i + ":   " + ten[i] + "                                              " + diem[i] + "%";
            top[i] = new JLabel(ss.substring(0, 37) + ss.substring(ss.length() - 5, ss.length()));
            top[i].setForeground(Color.RED);
            top[i].setFont(new Font("Tahoma", Font.BOLD, 20));
            top[i].setBounds(50, 25 * i + 170, 400, 23);
            p.add(top[i]);
        }

        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int cbx = cb.getSelectedIndex() + 1;
                s = "src/main/java/com/treasurehuntgame/data_top10/top10_" + cbx + ".txt";
                try {
                    FileReader fr = new FileReader(s);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    int i = 0;
                    while (++i <= 10) {
                        line = br.readLine();
                        ten[i] = new String(line);
                        line = br.readLine();
                        diem[i] = new String(line);
                    }
                    br.close();
                    fr.close();
                } catch (Exception ex) {
                }
                for (int i = 1; i <= 10; i++) {
                    String ss = "Top " + i + ":   " + ten[i] + "                                               " + diem[i] + "%";
                    top[i].setText(ss.substring(0, 37) + ss.substring(ss.length() - 5, ss.length()));
                }
            }
        });

        JButton button = new JButton("CLOSE");
        button.setBounds(330, 450, 150, 50);
        button.setFont(new Font("Tahoma", Font.BOLD, 30));
        button.setForeground(Color.RED);
        p.add(button);

        setBackground(Color.YELLOW);
        setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
