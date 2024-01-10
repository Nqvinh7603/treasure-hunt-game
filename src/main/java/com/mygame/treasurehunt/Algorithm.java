/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

import java.util.Random;

/**
 *
 * @author vinh
 */
public class Algorithm {
    private static final int GRID_SIZE = 15;
    private static final int NODES = GRID_SIZE * GRID_SIZE;
    private int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    /*KHởi tạo lưu đồ(15*15) và giá trị ngẫu nhiên: -1 -> -50 
     */
    
    private void initializeGrid(int n){
        Random random = new Random();
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                grid[i][j] = -random.nextInt(50) - 1;
                if (grid[i][j] == -30 || grid[i][j] == -50 || grid[i][j] == -70)
                    grid[i][j]++;
            }
        }
        placeSpecialPoints(n, 30);
        placeSpecialPoints(n, 50);
        placeSpecialPoints(n, 70);
        placeSpecialPoints(n, 1000000);
    }

    private void placeSpecialPoints(int n, int value) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(NODES);
            while (grid[index / GRID_SIZE][index % GRID_SIZE] > 0 || isBoundary(index))
                index = random.nextInt(NODES);
            grid[index / GRID_SIZE][index % GRID_SIZE] = value;
        }
    }

    private boolean isBoundary(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
