/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author vinh
 */
public class GameLevel extends JDialog {

    private JComboBox<String> cb;

    public GameLevel(JFrame parent) {
        super(parent, "MỨC CHƠI", true);
        setSize(500, 300);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(181, 230, 29));

        JLabel lbl = new JLabel("CHỌN MỨC ĐỘ CHƠI");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl.setForeground(Color.red);
        panel.add(lbl, BorderLayout.NORTH);

        String[] md = {"RẤT DỄ", "DỄ ", "TRUNG BÌNH", "KHÓ", "RẤT KHÓ"};
        cb = new JComboBox<>(md);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.blue);
        cb.setBackground(Color.yellow);
        panel.add(cb, BorderLayout.CENTER);

        JButton button = new JButton("OK");
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setForeground(Color.red);
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            setVisible(false);
            dispose();
        });

        add(panel);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
    }

    public int getMuc() {
        return cb.getSelectedIndex() + 1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton openDialogButton = new JButton("Open Dialog");
        openDialogButton.addActionListener(e -> new GameLevel(frame));

        frame.getContentPane().add(openDialogButton);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
