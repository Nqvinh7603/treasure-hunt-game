package com.treasurehuntgame;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 *
 * @author Vinh
 */
public class Game extends JPanel{
    public GiaiThuat gt;
    JLabel [][] A = new JLabel[15][15];
    
    public Game(GiaiThuat thamso){
       gt = thamso;
    }

    public Game(Game d) {
        gt = new GiaiThuat(0);
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++){
                gt.a[i][j] = d.gt.a[i][j];
                
            }
    taoBang();
    }
    
    
    
    
    public void thuchien(int x, int y){
        A[x][y].setBackground(new Color(221,160,221));
    }
    
    public void thuchienlai(int x, int y){
        A[x][y].setBackground(Color.YELLOW);
    }
    
    public void thuchienthang(int x, int y){
        A[x][y].setBackground(new Color(181,230,29));
    }
    
    public void thuchienthua(int x, int y){
        A[x][y].setBackground(new Color(252,66,3));
    }
    
    public void taoBang(){
        Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
        setLayout(new GridLayout(15, 15));
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++){
                A[i][j] = new JLabel();
                A[i][j].setFont(new Font("Tahoma",1,14));
                A[i][j].setHorizontalAlignment(JTextField.CENTER);
                A[i][j].setText(gt.a[i][j]+"");
                A[i][j].setBorder(border);
                A[i][j].setOpaque(true);
                add(A[i][j]);
                if(gt.a[i][j] == 1000000)
                {   A[i][j].setText(""); 
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/boom.PNG")));
                } else
                if(gt.a[i][j] == 70)
                {   A[i][j].setText("");
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/khunglong.PNG")));
                } else
                if(gt.a[i][j] == 50)
                {   A[i][j].setText(""); 
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/ho.PNG")));
                } else
                if(gt.a[i][j] == 30)
                {   A[i][j].setText(""); 
                    A[i][j].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/chosoi.PNG")));
                } 
    }
        A[0][0].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/nha.PNG")));
        A[14][14].setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/khobau.PNG")));
        A[0][0].setText("");
        A[14][14].setText("");
        
    }
}
