package com.mygame.treasurehunt;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


/**
 *
 * @author Truong
 */

public class FrameScreen extends javax.swing.JFrame implements Serializable{
    public Game game, game2;
    public MaTran A,B;
    public int diem1 , diem2;
    public JProgressBar nangluong;
    public JProgressBar nangluong2;
    public GiaiThuat gt ;
    static Menu menu;
    Luu luu;
    boolean daThang1=false, daThang2=false, daThua1=false, daThua2=false;
    public int diemtoiuu;
    TenThang thang1, thang2;
    int mucchoi;
    
    
    public FrameScreen(int thamso_n,int choiTiep, Luu ff){
       
        setIconImage(new ImageIcon(getClass().getResource("/img/mypicture.jpg")).getImage());
        gt = new GiaiThuat(thamso_n);
        mucchoi=thamso_n/5;
        if(choiTiep==1)
        for (int i = 0; i < 15; i++) 
            for (int j = 0; j < 15; j++) 
                gt.a[i][j] = ff.value[i][j];
        
        luu = new Luu();
        setTitle("GAME TÌM KHO BÁU");
        setSize(1370, 730);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        game = new Game(gt);
        game2 = new Game(gt);
        
        
      
        A = new MaTran();
        B = new MaTran();
        Control control = new Control(this);
        this.addKeyListener(control);
        
        Header header = new Header();
        header.setBounds(0, 0, 1370, 80);
        add(header);
        
          
        diemtoiuu=game.gt.tinhToiUu();
        diem1=diemtoiuu  +600-20*thamso_n;
        diem2=diemtoiuu  +600-20*thamso_n;        
        nangluong = new JProgressBar(0,diemtoiuu+600-20*thamso_n);
        nangluong2 = new JProgressBar(0,diemtoiuu+600-20*thamso_n);
        
        
        JButton btnSolve = new JButton("XEM LỜI GIẢI");
        JButton btnTrove = new JButton("THOÁT VÀ LƯU");
        
         
       
         btnTrove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                close();
                //new Menu();
                File file = new File("test.txt");
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        
                    }
                }
                FileOutputStream fi = null;
                try {
                    fi = new FileOutputStream(file);
                    
                } catch (FileNotFoundException ex) {
                 
                }
                ObjectOutputStream o = null;
                try {
                    o = new ObjectOutputStream(fi);
                } catch (IOException ex) {
                   
                }
                
                
                luu.mucChoi = thamso_n/5;
                mucchoi=thamso_n/5;
                luuTrangThai();
                try {
                    o.writeObject(luu);
                } catch (IOException ex) {
                  
                }
                try {
                    o.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrameScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fi.close();
                } catch (IOException ex) {
                    Logger.getLogger(FrameScreen.class.getName()).log(Level.SEVERE, null, ex);
                } //System.out.println("Luu thanh cong");
                menu.setVisible(true);
            }
    });
         
          btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Game gg=new Game(game);
                DapAn da = new DapAn(gg);
                //da.add(gg);
                da.setVisible(true);
                
            }
    });
  
        game.taoBang();
        game2.taoBang();
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                luu.value[i][j]=gt.a[i][j];
                if(gt.a[i][j] > 0)
                    gt.a[i][j]= - gt.a[i][j];
            }
        }
        
        game.setBounds(20, 85, 560, 560);
        add(game);
        
        game2.setBounds(780, 85, 560, 560);
        add(game2);
       
        JLabel lbl = new JLabel();
        lbl.setBounds(582, 110, 203 , 467);
        lbl.setIcon(new ImageIcon(getClass().getResource("huongdan4.PNG")));
        add(lbl);
        
        
        //Footer footer1 = new Footer();
        //Footer footer2 = new Footer();
        
        JLabel lblP1 = new JLabel("P1");
        JLabel lblP2 = new JLabel("P2");
        lblP1.setBounds(20, 650, 50, 50);
        lblP1.setFont(new Font("Tahoma",1,30));
        lblP1.setForeground(Color.white);
        lblP1.setBackground(Color.black);
        lblP1.setOpaque(true);
        lblP1.setHorizontalAlignment(JTextField.CENTER);
        add(lblP1);
        
        lblP2.setBounds(1290, 650, 50, 50);
        lblP2.setFont(new Font("Tahoma",1,30));
        lblP2.setForeground(Color.white);
        lblP2.setBackground(Color.black);
        lblP2.setOpaque(true);
        lblP2.setHorizontalAlignment(JTextField.CENTER);
        add(lblP2);
        
        nangluong.setStringPainted(true);
        nangluong.setValue(diem1);
        nangluong.setString("Năng lượng: "+diem1);
        nangluong.setBounds(80, 650, 500 , 50);
        nangluong.setBackground(Color.white);
        nangluong.setForeground(Color.red);
        
        add(nangluong);
       
        nangluong.setFont(new Font("Tahoma",1,23));
        nangluong2.setFont(new Font("Tahoma",1,23));
        nangluong2.setStringPainted(true);
        nangluong2.setValue(diem2);
        nangluong2.setString("Năng lượng: "+diem2);
        nangluong2.setBounds(780, 650, 500 , 50);
        nangluong2.setForeground(Color.red);
        add(nangluong2);
        
        
       Footer nen = new Footer();
       nen.setBackground(Color.GREEN);
       add(nen);
       
       
        setVisible(true);
        //header.addKeyListener(this);
        setFocusable(true);
        JButton btnChoi = new JButton();
       // header.add(btnChoi);
        btnChoi.setText("Chơi");
        btnChoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                btnChoi.addKeyListener(control);
               
            }
    });
        JLabel lblMucChoi = new JLabel();
        if(thamso_n==5) lblMucChoi.setText(" Mức chơi: Rất dễ  "+"    Năng lượng bạn có: "+diem1+"      ");
        else if(thamso_n==10) lblMucChoi.setText(" Mức chơi: Dễ  "+"    Năng lượng bạn có: "+diem1+"      ");
        else if(thamso_n==15) lblMucChoi.setText(" Mức chơi: Trung bình  "+"    Năng lượng bạn có: "+diem1+"      ");
        else if(thamso_n==20) lblMucChoi.setText(" Mức chơi: Khó  "+"    Năng lượng bạn có: "+diem1+"      ");
        else lblMucChoi.setText("Mức chơi: Rất khó  "+"    Năng lượng bạn có: "+diem1+"      ");
        
        lblMucChoi.setForeground(Color.white);
        lblMucChoi.setFont(new Font("Tahoma",1,18));
        btnTrove.setFont(new Font("Tahoma",1,18));
        btnSolve.setFont(new Font("Tahoma",1,18));
        header.add(lblMucChoi); 
        header.add(btnTrove); header.add(btnSolve);
        
        JLabel lblDiem = new JLabel();
        lblDiem.setForeground(Color.white);
        lblDiem.setFont(new Font("Tahoma",1,18));
        lblDiem.setText("       Năng lượng tối ưu: "+diemtoiuu);
        
        header.add(lblDiem);   
        btnSolve.setForeground(Color.red);
        btnTrove.setForeground(Color.red);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    
    public void upd1(int diem){
        if(diem>0)
            nangluong.setString("Năng lượng: "+diem);
        else {
            nangluong.setString("Hết năng lượng !!!");
            daThua1=true;
            for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(A.T[i][j]==0) game.thuchienthua(i,j);
        }
        nangluong.setValue(diem);
    }
    
    public void upd2(int diem){
        if(diem>0)
            nangluong2.setString("Năng lượng: "+diem);
        else {
            nangluong2.setString("Hết năng lượng !!!");
            daThua2=true;
            for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(B.T[i][j]==0) game2.thuchienthua(i,j);
        }
        nangluong2.setValue(diem);
    }
    
    public static void main(String[] args) {
       // FrameScreen f = new FrameScreen();
        menu = new Menu();
       
        
    }
    
    public void thang1(){
        for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(A.T[i][j]==0) game.thuchienthang(i,j);
        
    }
    
        public void thang2(){
        for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(B.T[i][j]==0) game2.thuchienthang(i,j);
    }
    
    public void thua1(){
        daThua1=true;
        for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(A.T[i][j]==0) game.thuchienthua(i,j);
        
    }
    
        public void thua2(){
            daThua2=true;
        for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(B.T[i][j]==0) game2.thuchienthua(i,j);
    }    
        
      void close(){
        setVisible(false);
    }  
    
   public void luuTrangThai(){
       
       luu.xA=A.x; luu.yA=A.y;
       luu.xB=B.x; luu.yB=B.y;
       luu.diem1=diem1;
       luu.diem2=diem2;
       luu.nlA = nangluong.getString();
       luu.nlB = nangluong2.getString();
       luu.daThang1=this.daThang1;
       luu.daThang2=this.daThang2;
       luu.daThua1=this.daThua1;
       luu.daThua2=this.daThua2;
       for(int i=0;i<15;i++)
           for(int j=0;j<15;j++){
               luu.goneA[i][j] = A.T[i][j];
               luu.goneB[i][j] = B.T[i][j];
            }
   }
   
   
   public void tiepTuc(Luu lu){
     for (int i = 0; i < 15; i++) 
            for (int j = 0; j < 15; j++) {
                game.remove(game.A[i][j]);
                game2.remove(game2.A[i][j]);
                A.T[i][j]=lu.goneA[i][j];
                B.T[i][j]=lu.goneB[i][j];
                game.gt.a[i][j]=lu.value[i][j];
                game2.gt.a[i][j]=lu.value[i][j];
                daThang1=lu.daThang1;
                daThang2=lu.daThang2;
                daThang1=lu.daThang1;
                daThang2=lu.daThang2;
                daThua1=lu.daThua1;
                daThua2=lu.daThua2;
            }
     
     game.taoBang();
     game2.taoBang();
     
     for (int i = 0; i < 15; i++) 
            for (int j = 0; j < 15; j++) 
                if(i+j>0 && i+j <28) {
                if(A.T[i][j]==1) game.thuchienlai(i,j);
                if(B.T[i][j]==1) game2.thuchienlai(i,j);
            }
     A.x = lu.xA; A.y = lu.yA;
     B.x = lu.xB; B.y = lu.yB;
     game.thuchien(A.x, A.y);
     game2.thuchien(B.x, B.y);
     diem1 = lu.diem1;
     diem2 = lu.diem2;
     
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if(gt.a[i][j] > 0)
                    gt.a[i][j]= - gt.a[i][j];
            }
        }
    nangluong.setValue(diem1);
    nangluong2.setValue(diem2);
    nangluong.setString(lu.nlA);
    nangluong2.setString(lu.nlB);
   }
}
