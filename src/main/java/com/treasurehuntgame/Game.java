package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import static java.lang.Thread.sleep;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vinh
 */
public class Game extends JPanel {

    public Algorithm gt;
    JLabel[][] A = new JLabel[15][15];

    public Game(Algorithm thamso) {
        gt = thamso;
    }

    public Game(Game d) {
        gt = new Algorithm(0);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                gt.a[i][j] = d.gt.a[i][j];

            }
        }
        taoBang();
    }

    public void thuchien(int x, int y) {
        A[x][y].setBackground(new Color(221, 160, 221));
    }

    public void thuchienlai(int x, int y) {
        A[x][y].setBackground(Color.YELLOW);
    }

    public void thuchienthang(int x, int y) {
        A[x][y].setBackground(new Color(81, 230, 50));
        //81, 230, 29
    }

    public void thuchienthua(int x, int y) {
        A[x][y].setBackground(new Color(252, 66, 3));
    }

    public void taoBang() {
        setLayout(new GridLayout(15, 15));
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                A[i][j] = new JLabel();
                A[i][j].setFont(new Font("Tahoma", Font.BOLD, 16));
                A[i][j].setHorizontalAlignment(JLabel.CENTER);
                A[i][j].setOpaque(true);

                if (gt.a[i][j] == 1000000) {
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/boom.PNG")));
                } else if (gt.a[i][j] == 150) {
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/khunglong.PNG")));
                } else if (gt.a[i][j] == 100) {
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/ho.PNG")));
                } else if (gt.a[i][j] == 70) {
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/chosoi.PNG")));
                } else {
                    A[i][j].setText(String.valueOf(gt.a[i][j]));
                }

                // Thiết lập màu nền và đường viền cho các ô
                if (gt.a[i][j] == 1000000) {
                    A[i][j].setBackground(new Color(255, 51, 51)); // Màu đỏ sáng tượng trưng cho bom
                } else {
                    A[i][j].setBackground(new Color(204, 204, 204)); // Màu xám nhạt tượng trưng cho các ô bình thường
                }
                A[i][j].setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 1)); // Màu xanh lá cây cho đường viền

                add(A[i][j]);
            }
        }

        A[0][0].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/nha.PNG")));
        A[14][14].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/khobau.PNG")));
        A[0][0].setText("");
        A[14][14].setText("");

    }
}
