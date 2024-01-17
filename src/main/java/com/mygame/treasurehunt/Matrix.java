/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt;

/**
 *
 * @author vinh
 */
public class Matrix {

    private static final int SIZE = 15;
    int[][] T = new int[SIZE][SIZE];
    int x, y;

    public boolean lenTren() {
        if (x > 0 && T[x - 1][y] != 1) {
            x--;
            return true;
        }
        return false;
    }

    public boolean xuongDuoi() {
        if (x < SIZE - 1 && T[x + 1][y] != 1) {
            x++;
            return true;
        }
        return false;
    }

    public boolean sangPhai() {
        if (y < SIZE - 1 && T[x][y + 1] != 1) {
            y++;
            return true;
        }
        return false;
    }

    public boolean sangTrai() {
        if (y > 0 && T[x][y - 1] != 1) {
            y--;
            return true;
        }
        return false;
    }

    public boolean lenTrenOK() {
        int topBoundary = 0;
        return x > topBoundary && T[x - 1][y] != 1;
    }

    public boolean xuongDuoiOK() {
        int bottomBoundary = SIZE - 1;
        return x < bottomBoundary && T[x + 1][y] != 1;
    }

    public boolean sangPhaiOK() {
        int rightBoundary = SIZE - 1;
        return y < rightBoundary && T[x][y + 1] != 1;
    }

    public boolean sangTraiOK() {
        int leftBoundary = 0;
        return y > leftBoundary && T[x][y - 1] != 1;
    }

}
