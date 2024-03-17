package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vinh
 */
//public class Top10 extends JDialog{
//    private JComboBox cb;
//    String s,ss="  ";
//    JLabel[] top = new JLabel[11];
//    public Top10() {
//        setSize(500, 550);
//        setTitle("TOP 10");
//        JPanel p = new JPanel();
//        p.setLayout(null);
//        p.setBounds(0, 0, 500, 550);
//        p.setBackground(new Color(181,230,29));
//        add(p);
//        
//        setLayout(null);
//        String md[] = { "RẤT DỄ", "DỄ ", "TRUNG BÌNH", 
//                "KHÓ", "RẤT KHÓ" };
//        JLabel lbl = new JLabel("CHỌN MỨC ĐỘ CHƠI");
//        JLabel lbl2 = new JLabel();
//        lbl2.setBounds(10, 75, 100, 116);
//        lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
//        p.add(lbl2);
//        
//        JLabel lbl3 = new JLabel();
//        lbl3.setBounds(325, 50, 150, 148);
//        lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhtop10.PNG")));
//        p.add(lbl3);
//        
//        lbl.setBounds(70, 0, 400, 70);
//        lbl.setFont(new Font("Tahama",1,30));
//        lbl.setForeground(Color.red);
//        p.add(lbl);
//        
//        cb = new JComboBox(md);
//        cb.setBounds(140, 67, 180, 50);
//        cb.setFont(new Font("Tahama",1,20));
//        cb.setForeground(Color.blue);
//        cb.setBackground(Color.yellow);
//        p.add(cb);
//        s="top10_1.txt";
//        
//        String[] ten = new String[11];
//        String[] diem = new String[11];
//        
//         try {
//             FileReader fr = new FileReader(s);
//             BufferedReader br = new BufferedReader(fr);
//             String line ="";
//             int i=0;
//             while (++i<=10) {
//                 line = br.readLine();
//                 ten[i]=new String(line);
//                 line = br.readLine();
//                 diem[i]=new String(line);
//             }
//            br.close();
//            fr.close();
//        } catch (Exception ex) {} 
//         for(int i=1;i<=10;i++){
//           ss="Top "+i+":   "+ten[i]+"                                              "+diem[i]+"%";
//           top[i]=new JLabel(ss.substring(0, 37)+ss.substring(ss.length()-5,ss.length()));
//            top[i].setForeground(Color.red);
//            top[i].setFont(new Font("Tahama",1,20));
//            top[i].setBounds(50, 25*i+170, 400, 23);
//            p.add(top[i]);
//        }
//        
//        
//         cb.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            
//        int cbx = cb.getSelectedIndex()+1;
//        s="top10_"+cbx+".txt";
//         try {
//             FileReader fr = new FileReader(s);
//             BufferedReader br = new BufferedReader(fr);
//             String line ="";
//             int i=0;
//             while (++i<=10) {
//                 line = br.readLine();
//                 ten[i]=new String(line);
//                 line = br.readLine();
//                 diem[i]=new String(line);
//             }
//            br.close();
//            fr.close();
//        } catch (Exception ex) {} 
//           for(int i=1;i<=10;i++){
//               ss="Top "+i+":   "+ten[i]+"                                               "+diem[i]+"%";
//               top[i].setText(ss.substring(0, 37)+ss.substring(ss.length()-5,ss.length()));
//        }
//            }
//            
//          
//
//    });
//        
//        
//        JButton button = new JButton("ĐÓNG");
//        button.setBounds(330, 450, 150, 50);
//        button.setFont(new Font("Tahama",1,30));
//        button.setForeground(Color.red);
//        p.add(button);
//      
//        
//        setBackground(Color.yellow);
//        setLocationRelativeTo(null);
//        
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//            }
//
//        });    
//    }
//    
//    
//}
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Top10 extends JDialog {
    private JComboBox<String> cb;
    private JLabel[] topPlayers;
    private JLabel[] historyPlayers;

    public Top10() {
        setSize(500, 550);
        setTitle("TOP 10");
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 550);
        p.setBackground(new Color(181, 230, 29));
        add(p);

        JLabel lbl = new JLabel("CHỌN MỨC ĐỘ CHƠI");
        lbl.setBounds(70, 0, 400, 70);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        p.add(lbl);

        String[] md = { "RẤT DỄ", "DỄ", "TRUNG BÌNH", "KHÓ", "RẤT KHÓ" };
        cb = new JComboBox<>(md);
        cb.setBounds(140, 67, 180, 50);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.BLUE);
        cb.setBackground(Color.YELLOW);
        p.add(cb);

        JLabel lblTop10 = new JLabel();
        lblTop10.setBounds(10, 75, 100, 116);
        lblTop10.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
        p.add(lblTop10);

        JLabel lblHistory = new JLabel();
        lblHistory.setBounds(325, 50, 150, 148);
        lblHistory.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhtop10.PNG")));
        p.add(lblHistory);

        JButton btnClose = new JButton("ĐÓNG");
        btnClose.setBounds(330, 450, 150, 50);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnClose.setForeground(Color.RED);
        p.add(btnClose);

        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMode = (String) cb.getSelectedItem();
                displayTopPlayers(p, selectedMode);
                displayHistoryPlayers(p, selectedMode);
            }
        });

        setBackground(Color.YELLOW);
        setLocationRelativeTo(null);
    }

    private void displayTopPlayers(JPanel panel, String mode) {
        ArrayList<Player> playerList = readPlayerData("top10_" + mode.toLowerCase() + ".txt");
        topPlayers = new JLabel[Math.min(playerList.size(), 10)];

        for (int i = 0; i < Math.min(playerList.size(), 10); i++) {
            Player player = playerList.get(i);
            String playerInfo = "Top " + (i + 1) + ": " + player.getName() + " - " + player.getScore() + "%";

            JLabel label = new JLabel(playerInfo);
            label.setForeground(Color.RED);
            label.setFont(new Font("Tahoma", Font.BOLD, 20));
            label.setBounds(50, 25 * (i + 1) + 170, 400, 23);
            panel.add(label);
            topPlayers[i] = label;
        }
    }

    private void displayHistoryPlayers(JPanel panel, String mode) {
        ArrayList<Player> playerList = readPlayerData("history_" + mode.toLowerCase() + ".txt");
        historyPlayers = new JLabel[playerList.size()];

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            String playerInfo = player.getName() + " - " + player.getScore() + "%";

            JLabel label = new JLabel(playerInfo);
            label.setForeground(Color.BLACK);
            label.setFont(new Font("Tahoma", Font.PLAIN, 16));
            label.setBounds(50, 25 * (i + 1) + 250, 400, 23);
            panel.add(label);
            historyPlayers[i] = label;
        }
    }

    private ArrayList<Player> readPlayerData(String fileName) {
        ArrayList<Player> playerList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    playerList.add(new Player(name, score));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return playerList;
    }

    private static class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
