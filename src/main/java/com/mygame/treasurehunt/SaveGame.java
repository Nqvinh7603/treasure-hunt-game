/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

/**
 *
 * @author vinh
 */
public class SaveGame {
    
    private final int[][] GONE_A = new int[15][15], GONE_B = new int[15][15], VALUE = new int[15][15];

    private int score1, score2;
    private int gameLevel;
    private int playerAX, playerAY, playerBX, playerBY;
    private boolean player1Won, player2Won, player1Lost, player2Lost;
    private String playerAName, playerBName;

    public SaveGame() {
    }
}
