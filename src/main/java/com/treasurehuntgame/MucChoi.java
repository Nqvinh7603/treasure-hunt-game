//package com.treasurehuntgame;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
///**
// *
// * @author Vinh
// */
//public class MucChoi extends JDialog {
//
//    private JComboBox cb;
//
//    public MucChoi() {
//        setSize(500, 300);
//        JPanel p = new JPanel();
//        p.setLayout(null);
//        p.setBounds(0, 0, 500, 300);
//        p.setBackground(new Color(34, 177, 76));
//        add(p);
//        setTitle("DIFFICULTY LEVEL");
//        setLayout(null);
//        String md[] = {"VERY EASY", "EASY ", "MEDIUM",
//            "HARD", "VERY HARD"};
//        JLabel lbl = new JLabel("CHOOSE LEVEL");
////        JLabel lbl2 = new JLabel();
////        lbl2.setBounds(110, 125, 100, 116);
////        lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
////        p.add(lbl2);
//
////        JLabel lbl3 = new JLabel();
////        lbl3.setBounds(195, 125, 150, 131);
////        lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucchoi2.PNG")));
////        p.add(lbl3);
//
//        lbl.setBounds(120, 0, 400, 70);
//        lbl.setFont(new Font("Tahama", 1, 30));
//        lbl.setForeground(Color.red);
//        p.add(lbl);
//
//        cb = new JComboBox(md);
//        cb.setBounds(130, 80, 200, 50);
//        cb.setFont(new Font("Tahama", 1, 20));
//        cb.setForeground(Color.blue);
//        cb.setBackground(Color.yellow);
//        p.add(cb);
//
//        JButton button = new JButton("OK");
//        button.setBounds(200, 200, 80, 50);
//        button.setFont(new Font("Tahama", 1, 30));
//        button.setForeground(Color.red);
//        p.add(button);
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
//    public int getMuc() {
//        return cb.getSelectedIndex() + 1;
//    }
//
//}

package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MucChoi extends JDialog {

    private JComboBox<String> cb;

    public MucChoi() {
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("DIFFICULTY LEVEL");

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 300);
        p.setBackground(new Color(34, 177, 76));
        add(p);

        JLabel lbl = new JLabel("CHOOSE LEVEL", SwingConstants.CENTER);
        lbl.setBounds(100, 20, 300, 70);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl.setForeground(Color.RED);
        p.add(lbl);

        String[] md = {"VERY EASY", "EASY", "MEDIUM", "HARD", "VERY HARD"};
        cb = new JComboBox<>(md);
        cb.setBounds(150, 100, 200, 40);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.BLUE);
        cb.setRenderer(new CustomComboBoxRenderer());
        p.add(cb);

        JButton button = new JButton("OK");
        button.setBounds(200, 180, 100, 50);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setForeground(Color.RED);
        p.add(button);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public int getMuc() {
        return cb.getSelectedIndex() + 1;
    }

    class CustomComboBoxRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(javax.swing.JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setBackground(new Color(255, 255, 153)); // Màu nền tùy chỉnh
            return label;
        }
    }
}
