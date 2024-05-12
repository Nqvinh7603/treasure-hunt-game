package com.treasurehuntgame;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vinh
 */
public class Footer extends JPanel{
    public Footer(){
        setBackground(Color.BLUE);
        JLabel diem = new JLabel();
        diem.setText("Energy: ");
        //add(diem);
        JProgressBar nangluong = new JProgressBar(0,2000);
        nangluong.setValue(500);
        nangluong.setBounds(20, 650, 560 , 50);
        add(nangluong);
    }
    
}
