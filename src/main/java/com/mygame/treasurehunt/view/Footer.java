/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame.treasurehunt.view;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author vinh
 */
public class Footer extends JPanel {
//    public Footer(){
//        setBackground(Color.BLUE);
//        JLabel score = new JLabel();
//        score.setText("Power: ");
//        JProgressBar power = new JProgressBar(0,2000);
//        power.setValue(500);
//        power.setBounds(20, 650, 560 , 50);
//        add(power);
//        
//    }
     private JLabel scoreLabel = new JLabel("Power: ");
    private JProgressBar powerProgressBar = new JProgressBar(0, 2000);

    public Footer() {
        setBackground(Color.BLUE);
        powerProgressBar.setValue(500);
        powerProgressBar.setBounds(20, 650, 560, 50);
        add(scoreLabel); // Add scoreLabel to the panel
        add(powerProgressBar);
    }

    // Method to update the power value
    public void setPower(int value) {
        powerProgressBar.setValue(value);
    }
}
