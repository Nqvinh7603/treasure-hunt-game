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

    private JComboBox cb;
    String s, ss = "  ";
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
        lbl.setBounds(120, 0, 400, 70);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        p.add(lbl);

        // Thêm chữ "Top 10" vào cửa sổ
        JLabel top10Label = new JLabel("Top 10");
        top10Label.setBounds(160, 130, 400, 40);
        top10Label.setFont(new Font("Tahoma", Font.BOLD, 30));
        top10Label.setForeground(Color.RED);
        p.add(top10Label);

        cb = new JComboBox(md);
        cb.setBounds(140, 67, 180, 50);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.BLUE);
        cb.setBackground(new Color(255, 255, 153)); // Chỉnh màu nền của JComboBox
        cb.setBackground(new Color(255, 255, 204));
        p.add(cb);
        s = "src/main/java/com/treasurehuntgame/data_top10/top10_1.txt";
        //s = "top10_1.txt";

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
            // Sử dụng cố định độ dài cho phần tên
            String fixedName = String.format("%-20s", ten[i]);
            // Tạo chuỗi hiển thị với định dạng cố định cho mỗi dòng
            String formattedString = String.format("Top %d:   %-20s %s%%", i, ten[i], diem[i]);

            // Tạo JLabel với chuỗi đã định dạng
            top[i] = new JLabel(formattedString);
            top[i].setForeground(Color.BLUE);
            top[i].setFont(new Font("Tahoma", Font.BOLD, 20));
            top[i].setBounds(50, 25 * i + 170, 400, 23);
            p.add(top[i]);
        }
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Item state changed");
                int cbx = cb.getSelectedIndex() + 1;
                System.out.println("Selected index: " + cb.getSelectedIndex()); // In ra chỉ số của mục được chọn
                System.out.println("cbx value: " + cbx);
                s = "src/main/java/com/treasurehuntgame/data_top10/top10_" + cbx + ".txt";
                System.out.println("File path: " + s); // In ra đường dẫn của tệp tin được đọc

                // Khởi tạo và gán giá trị cho mảng ten và diem
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
                    ex.printStackTrace(); // In ra thông tin của ngoại lệ nếu có
                }
                
                for (int i = 1; i <= 10; i++) {
                    // Sử dụng cố định độ dài cho phần tên
                    String fixedName = String.format("%-20s", ten[i]);
                    // Tạo chuỗi hiển thị với định dạng cố định cho mỗi dòng
                    // Sử dụng định dạng cố định cho mỗi dòng
                    String topNum = (i < 10) ? "0" + i : String.valueOf(i);
                    String formattedString = String.format("Top %s:   %-20s %4s%%", topNum, ten[i], diem[i]);



                    // Cập nhật nội dung của JLabel
                    top[i].setText(formattedString);
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

