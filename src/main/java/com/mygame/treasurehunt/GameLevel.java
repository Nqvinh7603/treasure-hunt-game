/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLevel extends JDialog {
    private JComboBox<String> cb;

    public GameLevel() {
        initComponents();
    }

    private void initComponents() {
        setSize(500, 300);
        JPanel p = new JPanel(new FlowLayout());
        p.setBackground(new Color(181, 230, 29));
        add(p);
        setTitle("Game Level");

        JLabel lbl = createLabel("Choose the level of play", 70, 0, 400, 70, Font.BOLD, 30, Color.RED);
        p.add(lbl);

        p.add(createImageLabel("anhmucdo.PNG", 110, 125, 100, 116));
        p.add(createImageLabel("anhmucchoi2.PNG", 195, 125, 150, 131));

        cb = new JComboBox<>(new String[]{"VERY EASY", "EASY ", "NORMAL", "HARD", "VERY HARD"});
        cb.setBounds(130, 67, 200, 50);
        cb.setFont(new Font("Tahoma", Font.BOLD, 20));
        cb.setForeground(Color.blue);
        cb.setBackground(Color.yellow);
        p.add(cb);

        JButton button = new JButton("OK");
        button.setBounds(390, 200, 80, 50);
        button.setFont(new Font("Tahoma", Font.BOLD, 30));
        button.setForeground(Color.red);
        p.add(button);

        setBackground(Color.yellow);
        setLocationRelativeTo(null);

        button.addActionListener(e -> setVisible(false));
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, int fontStyle, int fontSize, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Tahoma", fontStyle, fontSize));
        label.setForeground(color);
        return label;
    }

    private JLabel createImageLabel(String imageName, int x, int y, int width, int height) {
        JLabel label = new JLabel(new ImageIcon(getClass().getResource(imageName)));
        label.setBounds(x, y, width, height);
        return label;
    }

    public int get() {
        return cb.getSelectedIndex() + 1;
    }
}

