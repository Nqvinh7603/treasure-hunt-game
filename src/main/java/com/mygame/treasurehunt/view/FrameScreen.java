/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt.view;

import com.mygame.treasurehunt.Algorithm;
import com.mygame.treasurehunt.Matrix;
import com.mygame.treasurehunt.SaveGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameScreen extends JFrame implements Serializable {

    private GameFrm game, game2;
    private Matrix matrixA, matrixB;
    private JProgressBar energyBar1, energyBar2;
    private Algorithm algorithm;
    private SaveGame save;
    private boolean isWin1 = false, isWin2 = false, isLose1 = false, isLose2 = false;
    private int score1, score2, optimalScore, gameLevel;

    public FrameScreen(int param_n, int continuePlay, SaveGame saveGame) {
        setIconImage(new ImageIcon(getClass().getResource("nengame.PNG")).getImage());
        algorithm = new Algorithm(param_n);
        gameLevel = param_n / 5;
        if (continuePlay == 1) {
    for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {
            algorithm.grid[i][j] = saveGame.VALUE[i][j];
        }
    }
}

        save = new SaveGame();
        setTitle("TREASURE HUNT GAME");
        setSize(1370, 730);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents(param_n, continuePlay, saveGame);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents(int param_n, int continuePlay, SaveGame saveGame) {
        game = new GameFrm(algorithm);
        game2 = new GameFrm(algorithm);

        matrixA = new Matrix();
        matrixB = new Matrix();
        //addKeyListener(new Control(this));

        Header header = new Header();
        header.setBounds(0, 0, getWidth(), 80);
        add(header);

        createGamePanels();
        createProgressBars();
        createButtons(param_n);

        Footer background = new Footer();
        background.setBackground(Color.GREEN);
        add(background);
    }

    private void createGamePanels() {
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        contentPanel.add(game);
        contentPanel.add(game2);
        contentPanel.setBounds(20, 85, 560, 560);
        add(contentPanel);
    }

//    private void createProgressBars() {
//        optimalScore = game.
//               // al.calculateOptimalScore();
//        score1 = optimalScore + 600 - 20 * algorithm.n;
//        score2 = optimalScore + 600 - 20 * algorithm.n;
//
//        energyBar1 = createProgressBar(score1, 80, 650);
//        energyBar2 = createProgressBar(score2, 780, 650);
//
//        add(energyBar1);
//        add(energyBar2);
//    }
//
//    private JProgressBar createProgressBar(int max, int x, int y) {
//        JProgressBar progressBar = new JProgressBar(0, max);
//        progressBar.setStringPainted(true);
//        progressBar.setBounds(x, y, 500, 50);
//        progressBar.setBackground(Color.white);
//        progressBar.setForeground(Color.red);
//        progressBar.setFont(new Font("Tahoma", Font.BOLD, 23));
//        return progressBar;
//    }
//
//    private void createButtons(int param_n) {
//        JButton btnSolve = new JButton("VIEW SOLUTION");
//        JButton btnExit = new JButton("EXIT AND SAVE");
//
//        btnExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                close();
//                saveToFile(param_n);
//                menu.setVisible(true);
//            }
//        });
//
//        btnSolve.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                Game gg = new Game(game);
//                Solution solution = new Solution(gg);
//                solution.setVisible(true);
//            }
//        });
//
//        addButtonsToHeader(btnExit, btnSolve, param_n);
//    }
//
//    private void addButtonsToHeader(JButton btnExit, JButton btnSolve, int param_n) {
//        Header header = (Header) getContentPane().getComponent(0);
//        JLabel lblGameLevel = createGameLevelLabel(param_n);
//        JLabel lblScore = createScoreLabel();
//
//        header.add(lblGameLevel);
//        header.add(btnExit);
//        header.add(btnSolve);
//        header.add(lblScore);
//
//        btnExit.setForeground(Color.red);
//        btnSolve.setForeground(Color.red);
//    }
//
//    private JLabel createGameLevelLabel(int param_n) {
//        JLabel lblGameLevel = new JLabel();
//        String levelText = "";
//        switch (param_n) {
//            case 5:
//                levelText = " Game Level: Very Easy ";
//                break;
//            case 10:
//                levelText = " Game Level: Easy ";
//                break;
//            case 15:
//                levelText = " Game Level: Medium ";
//                break;
//            case 20:
//                levelText = " Game Level: Hard ";
//                break;
//            default:
//                levelText = " Game Level: Very Hard ";
//                break;
//        }
//        lblGameLevel.setText(levelText + "    Your Energy: " + score1 + "      ");
//        lblGameLevel.setForeground(Color.white);
//        lblGameLevel.setFont(new Font("Tahoma", Font.BOLD, 18));
//        return lblGameLevel;
//    }
}
