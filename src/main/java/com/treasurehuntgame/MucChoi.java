package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class MucChoi extends JDialog{
    private JComboBox cb;
    
    public MucChoi() {
        setSize(500, 300);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBounds(0, 0, 500, 300);
        p.setBackground(new Color(181,230,29));
        add(p);
        setTitle("MỨC CHƠI");
        setLayout(null);
        String md[] = { "RẤT DỄ", "DỄ ", "TRUNG BÌNH", 
                "KHÓ", "RẤT KHÓ" };
        JLabel lbl = new JLabel("CHỌN MỨC ĐỘ CHƠI");
        JLabel lbl2 = new JLabel();
        lbl2.setBounds(110, 125, 100, 116);
        lbl2.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucdo.PNG")));
        p.add(lbl2);
        
        JLabel lbl3 = new JLabel();
        lbl3.setBounds(195, 125, 150, 131);
        lbl3.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/anhmucchoi2.PNG")));
        p.add(lbl3);
        
        lbl.setBounds(70, 0, 400, 70);
        lbl.setFont(new Font("Tahama",1,30));
        lbl.setForeground(Color.red);
        p.add(lbl);
        
        cb = new JComboBox(md);
        cb.setBounds(130, 67, 200, 50);
        cb.setFont(new Font("Tahama",1,20));
        cb.setForeground(Color.blue);
        cb.setBackground(Color.yellow);
        p.add(cb);
        
        JButton button = new JButton("OK");
        button.setBounds(390, 200, 80, 50);
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
    
    public int getMuc(){
        return cb.getSelectedIndex()+1;
    }
 
    
}
