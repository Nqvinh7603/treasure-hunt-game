package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vinh
 */
public class Top10 extends JDialog{
    private JComboBox cb;
    String s,ss="  ";
    JLabel[] top = new JLabel[11];
    public Top10() {
        setSize(500, 550);
        setTitle("TOP 10");
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 550);
        p.setBackground(new Color(181,230,29));
        add(p);
        
        setLayout(null);
        String md[] = { "RẤT DỄ", "DỄ ", "TRUNG BÌNH", 
                "KHÓ", "RẤT KHÓ" };
        JLabel lbl = new JLabel("CHỌN MỨC ĐỘ CHƠI");
        JLabel lbl2 = new JLabel();
        lbl2.setBounds(10, 75, 100, 116);
        lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
        p.add(lbl2);
        
        JLabel lbl3 = new JLabel();
        lbl3.setBounds(325, 50, 150, 148);
        lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhtop10.PNG")));
        p.add(lbl3);
        
        lbl.setBounds(70, 0, 400, 70);
        lbl.setFont(new Font("Tahama",1,30));
        lbl.setForeground(Color.red);
        p.add(lbl);
        
        cb = new JComboBox(md);
        cb.setBounds(140, 67, 180, 50);
        cb.setFont(new Font("Tahama",1,20));
        cb.setForeground(Color.blue);
        cb.setBackground(Color.yellow);
        p.add(cb);
        s="top10_1.txt";
        
        String[] ten = new String[11];
        String[] diem = new String[11];
        
         try {
             FileReader fr = new FileReader(s);
             BufferedReader br = new BufferedReader(fr);
             String line ="";
             int i=0;
             while (++i<=10) {
                 line = br.readLine();
                 ten[i]=new String(line);
                 line = br.readLine();
                 diem[i]=new String(line);
             }
            br.close();
            fr.close();
        } catch (Exception ex) {} 
         for(int i=1;i<=10;i++){
           ss="Top "+i+":   "+ten[i]+"                                              "+diem[i]+"%";
           top[i]=new JLabel(ss.substring(0, 37)+ss.substring(ss.length()-5,ss.length()));
            top[i].setForeground(Color.red);
            top[i].setFont(new Font("Tahama",1,20));
            top[i].setBounds(50, 25*i+170, 400, 23);
            p.add(top[i]);
        }
        
        
         cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
        int cbx = cb.getSelectedIndex()+1;
        s="top10_"+cbx+".txt";
         try {
             FileReader fr = new FileReader(s);
             BufferedReader br = new BufferedReader(fr);
             String line ="";
             int i=0;
             while (++i<=10) {
                 line = br.readLine();
                 ten[i]=new String(line);
                 line = br.readLine();
                 diem[i]=new String(line);
             }
            br.close();
            fr.close();
        } catch (Exception ex) {} 
           for(int i=1;i<=10;i++){
               ss="Top "+i+":   "+ten[i]+"                                               "+diem[i]+"%";
               top[i].setText(ss.substring(0, 37)+ss.substring(ss.length()-5,ss.length()));
        }
            }
            
          

    });
        
        
        JButton button = new JButton("ĐÓNG");
        button.setBounds(330, 450, 150, 50);
        button.setFont(new Font("Tahama",1,30));
        button.setForeground(Color.red);
        p.add(button);
      
        
        setBackground(Color.yellow);
        setLocationRelativeTo(null);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }

        });    
    }
    
    
}
