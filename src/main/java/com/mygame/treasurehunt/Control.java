package com.mygame.treasurehunt;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Truong
 */
public class Control implements KeyListener {
    FrameScreen f;
    public Control(FrameScreen thamso){
        f = thamso;
    }

    @Override
        public void keyTyped(KeyEvent e) {}

    @Override
        public void keyPressed(KeyEvent e) {
            if(f.B.hetDuong()) {
                f.nangluong2.setString("Không thể di chuyển được nữa !!!");
                f.daThua2=true;
                for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(f.B.T[i][j]==0) f.game2.thuchienthua(i,j);
            }
          
            if(f.diem2>0)
            if(e.getKeyCode() == e.VK_LEFT) 
                if(f.B.sangTrai()){
                    f.B.go();
                    f.game2.thuchien(f.B.getX(), f.B.getY());
                    f.game2.thuchienlai(f.B.getX(), f.B.getY()+1);
                    f.diem2+=f.gt.a[f.B.getX()][f.B.getY()]; f.upd2(f.diem2);
                    
                }
            if(f.diem2>0)
            if(e.getKeyCode() == e.VK_RIGHT) 
                if(f.B.sangPhai()){
                    f.B.go();
                    f.game2.thuchien(f.B.getX(), f.B.getY());
                    f.game2.thuchienlai(f.B.getX(), f.B.getY()-1);
                    f.diem2+=f.gt.a[f.B.getX()][f.B.getY()]; f.upd2(f.diem2);
                }
            if(f.diem2>0)
            if(e.getKeyCode() == e.VK_UP) 
                if(f.B.lenTren()){
                    f.B.go();
                    f.game2.thuchien(f.B.getX(), f.B.getY());
                    f.game2.thuchienlai(f.B.getX()+1, f.B.getY());
                    f.diem2+=f.gt.a[f.B.getX()][f.B.getY()]; f.upd2(f.diem2);
                }
            if(f.diem2>0)
            if(e.getKeyCode() == e.VK_DOWN) 
                if(f.B.xuongDuoi()){
                    f.B.go();
                    f.game2.thuchien(f.B.getX(), f.B.getY());
                    f.game2.thuchienlai(f.B.getX()-1, f.B.getY());
                    f.diem2+=f.gt.a[f.B.getX()][f.B.getY()]; f.upd2(f.diem2);
                   
                }
            if(f.B.getX()==14 && f.B.getY()==14){
                f.thang2();
                if(!f.daThang2)
                    {f.thang2 = new TenThang(2,f.diem2*100/f.diemtoiuu,f.mucchoi);
                     f.thang2.setVisible(true);}
                f.daThang2=true;
            }
            
    //========================================================================  
            if(f.A.hetDuong()) {
                f.nangluong.setString("Không thể di chuyển được nữa !!!");
                f.daThua1=true;
                for(int i=0;i<15;i++)
                    for(int j=0;j<15;j++)
                        if(f.A.T[i][j]==0) f.game.thuchienthua(i,j);
            }
            
            
            if(f.diem1>0)
            if(e.getKeyCode() == e.VK_A) 
                if(f.A.sangTrai()){
                    f.A.go();
                    f.game.thuchien(f.A.getX(), f.A.getY());
                    f.game.thuchienlai(f.A.getX(), f.A.getY()+1);
                    f.diem1+=f.gt.a[f.A.getX()][f.A.getY()]; f.upd1(f.diem1);
                }
            if(f.diem1>0)
            if(e.getKeyCode() == e.VK_D) 
                if(f.A.sangPhai()){
                    f.A.go();
                    f.game.thuchien(f.A.getX(), f.A.getY());
                    f.game.thuchienlai(f.A.getX(), f.A.getY()-1);
                    f.diem1+=f.gt.a[f.A.getX()][f.A.getY()]; f.upd1(f.diem1);
                }
            if(f.diem1>0)
            if(e.getKeyCode() == e.VK_W) 
                if(f.A.lenTren()){
                    f.A.go();
                    f.game.thuchien(f.A.getX(), f.A.getY());
                    f.game.thuchienlai(f.A.getX()+1, f.A.getY());
                    f.diem1+=f.gt.a[f.A.getX()][f.A.getY()]; f.upd1(f.diem1);
                }
            if(f.diem1>0)
            if(e.getKeyCode() == e.VK_S) 
                if(f.A.xuongDuoi()){
                    f.A.go();
                    f.game.thuchien(f.A.getX(), f.A.getY());
                    f.game.thuchienlai(f.A.getX()-1, f.A.getY());
                    f.diem1+=f.gt.a[f.A.getX()][f.A.getY()]; f.upd1(f.diem1);
                }
            if(f.A.getX()==14 && f.A.getY()==14) 
                {
                    f.thang1(); 
                    if(!f.daThang1)
                     {f.thang1 = new TenThang(1,f.diem1*100/f.diemtoiuu,f.mucchoi);
                      f.thang1.setVisible(true);}
                    f.daThang1=true;
                }
              }

        @Override
        public void keyReleased(KeyEvent e) {
           }

    
}
