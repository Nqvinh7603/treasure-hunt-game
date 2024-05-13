//package com.treasurehuntgame;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
///**
// *
// * @author Vinh
// */
//public class TenThang extends JDialog {
//
//    private JTextField cb;
//
//    public TenThang(int ten, int diem, int mucchoi) {
//        setSize(500, 300);
//        JPanel p = new JPanel();
//        p.setLayout(null);
//        p.setBounds(0, 0, 500, 300);
//        p.setBackground(new Color(181, 230, 29));
//        add(p);
//        setTitle("ENTER NAME");
//        setLayout(null);
//        JLabel lbl = new JLabel("PLAYER " + ten + " WIN : " + diem + "%");
//        JLabel lbl2 = new JLabel();
//        lbl2.setBounds(110, 125, 100, 116);
//        //lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
//        p.add(lbl2);
//
//        JLabel lbl3 = new JLabel();
//        lbl3.setBounds(195, 125, 150, 131);
//        //lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucchoi2.PNG")));
//        p.add(lbl3);
//
//        lbl.setBounds(70, 0, 400, 70);
//        lbl.setFont(new Font("Tahama", 1, 30));
//        lbl.setForeground(Color.red);
//        p.add(lbl);
//
//        cb = new JTextField();
//        cb.setBounds(130, 67, 200, 50);
//        cb.setFont(new Font("Tahama", 1, 20));
//        cb.setForeground(Color.blue);
//        cb.setBackground(Color.yellow);
//        p.add(cb);
//
//        JButton button = new JButton("OK");
//        button.setBounds(390, 200, 80, 50);
//        button.setFont(new Font("Tahama", 1, 30));
//        button.setForeground(Color.red);
//        p.add(button);
//        setBackground(Color.yellow);
//        setLocationRelativeTo(null);
//
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//                String s = "src/main/java/com/treasurehuntgame/data_top10/top10_" + mucchoi + ".txt";
//                String[] ten = new String[12];
//                int[] Diem = new int[12];
//
//                try {
//                    FileReader fr = new FileReader(s);
//                    BufferedReader br = new BufferedReader(fr);
//                    String line = "";
//                    int i = 0;
//                    while (++i <= 10) {
//                        line = br.readLine();
//                        if (line == null) // Kiểm tra nếu đọc tới cuối tệp
//                        {
//                            break;
//                        }
//                        ten[i] = line;
//                        line = br.readLine();
//                        if (line == null) // Kiểm tra nếu đọc tới cuối tệp
//                        {
//                            break;
//                        }
//                        Diem[i] = Integer.parseInt(line);
//                    }
//                    ten[11] = cb.getText().trim();
//                    if (ten[11].isEmpty()) {
//                        ten[11] = "no name";
//                    }
//                    Diem[11] = diem;
//                    int o;
//                    for (o = 1; o <= 11; o++) {
//                        if (diem > Diem[o] || Diem[o] == 0) { // Sửa điều kiện kiểm tra
//                            break;
//                        }
//                    }
//                    for (i = 10; i > o; i--) {
//                        ten[i] = ten[i - 1];
//                        Diem[i] = Diem[i - 1];
//                    }
//                    ten[o] = ten[11];
//                    Diem[o] = diem;
//
//                    try (FileWriter fw = new FileWriter(s); BufferedWriter bw = new BufferedWriter(fw)) {
//                        for (i = 1; i <= 10; i++) {
//                            bw.write(ten[i] + "\n");
//                            bw.write(Diem[i] + "\n");
//                        }
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                    br.close();
//                    fr.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//    }
//}
package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Winner extends JDialog {

    private JTextField cb;

    public Winner(int ten, int diem, int mucchoi) {
        setSize(500, 300);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 300);
        p.setBackground(new Color(34, 177, 76)); // Thay đổi màu nền của panel thành màu xanh lá cây
        add(p);
        setTitle("ENTER NAME");
        setLayout(null);
        JLabel lbl = new JLabel("PLAYER " + ten + " WIN : " + diem + "%");
        lbl.setBounds(0, 10, 500, 50); // Canh giữa tiêu đề
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        lbl.setForeground(Color.RED);
        p.add(lbl);

        JLabel lbl2 = new JLabel();
        lbl2.setBounds(50, 70, 180, 180);
        p.add(lbl2);

        JLabel lbl3 = new JLabel();
        lbl3.setBounds(270, 70, 180, 180);
        p.add(lbl3);

        cb = new JTextField();
        cb.setBounds(120, 120, 260, 40);
        cb.setFont(new Font("Tahoma", Font.PLAIN, 18));
        cb.setForeground(Color.BLUE);
        cb.setBackground(Color.WHITE);
        p.add(cb);

        JButton button = new JButton("OK");
        button.setBounds(200, 200, 100, 50);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setForeground(Color.RED);
        p.add(button);
        p.setBackground(new Color(34, 139, 34)); // Thay đổi màu nền của panel thành màu xanh lá cây
        setLocationRelativeTo(null);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                String s = "src/main/java/com/treasurehuntgame/data_top10/top10_" + mucchoi + ".txt";
                String[] ten = new String[12];
                int[] Diem = new int[12];

                try {
                    FileReader fr = new FileReader(s);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    int i = 0;
                    while (++i <= 10) {
                        line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        ten[i] = line;
                        line = br.readLine();
                        if (line == null) {
                            break;
                        }
                        Diem[i] = Integer.parseInt(line);
                    }
                    ten[11] = cb.getText().trim();
                    if (ten[11].isEmpty()) {
                        ten[11] = "No Name";
                    }
                    Diem[11] = diem;
                    int o;
                    for (o = 1; o <= 11; o++) {
                        if (diem > Diem[o] || Diem[o] == 0) { 
                            break;
                        }
                    }
                    for (i = 10; i > o; i--) {
                        ten[i] = ten[i - 1];
                        Diem[i] = Diem[i - 1];
                    }
                    ten[o] = ten[11];
                    Diem[o] = diem;

                    try (FileWriter fw = new FileWriter(s); BufferedWriter bw = new BufferedWriter(fw)) {
                        for (i = 1; i <= 10; i++) {
                            bw.write(ten[i] + "\n");
                            bw.write(Diem[i] + "\n");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    br.close();
                    fr.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}

