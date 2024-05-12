package com.treasurehuntgame;

import java.io.Serializable;

/**
 *
 * @author Vinh
 */
public class Luu implements Serializable {

    int[][] goneA = new int[15][15], goneB = new int[15][15], value = new int[15][15];
    int diem1, diem2;
    int mucChoi;
    int xA, yA, xB, yB;
    boolean daThang1, daThang2, daThua1, daThua2;
    String nlA, nlB;
    public Luu() {
    }
}
