/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt.view;

import com.mygame.treasurehunt.Algorithm;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author vinh
 */
public class GameFrm extends JPanel {
    private Algorithm algorithm;
    private JLabel[][] map = new JLabel[15][15];

    public GameFrm(Algorithm algorithm) {
        this.algorithm = algorithm;
        creTable();
    }
    public GameFrm(GameFrm gameFrm) {
        algorithm = new Algorithm(0);
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                algorithm.grid[i][j] = gameFrm.algorithm.grid[i][j];
        creTable();
    }
    public void Action(int x, int y, Color color) {
        map[x][y].setBackground(color);
    }
    private void creTable() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        setLayout(new GridLayout(15, 15));
         for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++) {
                map[i][j] = new JLabel();
                map[i][j].setFont(new Font("Tahoma", Font.BOLD, 14));
                map[i][j].setHorizontalAlignment(JTextField.CENTER);
                map[i][j].setText(String.valueOf(algorithm.grid[i][j]));
                map[i][j].setBorder(border);
                map[i][j].setOpaque(true);
                add(map[i][j]);

                setIconAndText(map[i][j], i, j);
            }
         setIconAndText(map[0][0], 0, 0, "");// "" : picture: vị trí bắt đầu
        setIconAndText(map[14][14], 14, 14, "");//"": picture: báu vật

    }
    private void setIconAndText(JLabel label, int i, int j, String iconName) {
        label.setText("");
        label.setIcon(new ImageIcon(getClass().getResource(iconName)));
    }
    private void setIconAndText(JLabel label, int i, int j) {
        if (algorithm.grid[i][j] == areaCode.BOOM.getValue()) {
            setIconAndText(label, i, j, "boom.PNG");
        } else if (algorithm.grid[i][j] == areaCode.RAN.getValue()) {
            setIconAndText(label, i, j, "ran.PNG");
        } else if (algorithm.grid[i][j] == areaCode.RET.getValue()) {
            setIconAndText(label, i, j, "ret.PNG");
        } else if (algorithm.grid[i][j] == areaCode.BOCAP.getValue()) {
            setIconAndText(label, i, j, "bocap.PNG");
        }
    }
    private enum areaCode{
        BOOM(1000000), RAN(70), RET(50), BOCAP(30);
        private final int value;

        areaCode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    
}
