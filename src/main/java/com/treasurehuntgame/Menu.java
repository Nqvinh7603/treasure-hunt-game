package com.treasurehuntgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Vinh
 */
public class Menu extends JFrame {

    static MucChoi mucChoi = new MucChoi();
    Top10 top10 = new Top10();
    Luu l;

    public Menu() {
        setIconImage(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/nengame.PNG")).getImage());
        setTitle("Treasure Hunt Game");
        setSize(809, 580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 809, 580);

        //p.setBackground(new Color(181,230,29));
        p.setBackground(new Color(34, 177, 76));
        JLabel picLabel = new JLabel(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/menu2.JPG")));
        picLabel.setBounds(0, 40, 809, 500);
        add(picLabel);

        add(p);
        JButton btn0 = new JButton("HOME");
        JButton btn1 = new JButton("NEW GAME");
        JButton btn2 = new JButton("CONTINUE");
        JButton btn3 = new JButton("LEVELS");
        JButton btn4 = new JButton("INSTRUCTIONS");
        JButton btn5 = new JButton("ABOUT");
        JButton btn6 = new JButton("TOP 10");

        btn0.setFont(new Font("Tahoma", 1, 13));
        btn0.setForeground(Color.black);
        btn1.setFont(new Font("Tahoma", 1, 13));
        btn1.setForeground(Color.black);
        btn2.setFont(new Font("Tahoma", 1, 13));
        btn2.setForeground(Color.black);
        btn3.setFont(new Font("Tahoma", 1, 13));
        btn3.setForeground(Color.black);
        btn4.setFont(new Font("Tahoma", 1, 13));
        btn4.setForeground(Color.black);
        btn5.setFont(new Font("Tahoma", 1, 13));
        btn5.setForeground(Color.black);
        btn6.setFont(new Font("Tahoma", 1, 13));
        btn6.setForeground(Color.black);
        p.add(btn0);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        p.add(btn6);
        p.add(btn4);
        p.add(btn5);

        //======================= nut Trang chu 0  ======================   
        btn0.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                picLabel.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/menu2.JPG")));

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn0.setForeground(Color.blue);
                btn0.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn0.setForeground(Color.black);
                btn0.setFont(new Font("Tahoma", 1, 13));
            }
        });
        //======================= nut CHOI VAN MOI  1 ======================         

        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new FrameScreen(5 * mucChoi.getMuc(), 0, l);

                close();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn1.setForeground(Color.blue);
                btn1.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn1.setForeground(Color.black);
                btn1.setFont(new Font("Tahoma", 1, 13));
            }
        });

        //======================= nut CHOI TIẾP  2 ======================         
        btn2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                File file = new File("test.txt");
                FileInputStream fi = null;
                try {
                    fi = new FileInputStream(file);
                } catch (FileNotFoundException ex) {

                }
                ObjectInputStream o = null;
                try {
                    o = new ObjectInputStream(fi);
                } catch (Exception ex) {

                }
                Luu f = null;
                try {
                    f = (Luu) o.readObject();
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {

                }

                FrameScreen tt = new FrameScreen(f.mucChoi * 5, 1, f);
                tt.tiepTuc(f);
                if (tt.daThang1) {
                    tt.thang1();
                }
                if (tt.daThang2) {
                    tt.thang2();
                }
                if (tt.daThua1) {
                    tt.thua1();
                }
                if (tt.daThua2) {
                    tt.thua2();
                }
                close();

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn2.setForeground(Color.blue);
                btn2.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn2.setForeground(Color.black);
                btn2.setFont(new Font("Tahoma", 1, 13));
            }
        });

        //======================= nut MỨC CHƠI  3 ======================         
        btn3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mucChoi.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn3.setForeground(Color.blue);
                btn3.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn3.setForeground(Color.black);
                btn3.setFont(new Font("Tahoma", 1, 13));
            }
        });

        //======================= nut HUONG DAN  4 ======================         
        btn4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                picLabel.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/huongdanchoi.PNG")));

                /*
               - Khi đến được kho báu, bạn sẽ thắng!
               - Mỗi một mức chơi sẽ có bản đồ riêng.
               - Bạn được cấp nguồn năng lượng ứng với mức chơi và bản đồ.
               - Di chuyển theo 4 hướng: trên, dưới, phải, trái.
               - Không được di chuyển vào ô đã đi.
               - Di chuyển đến ô nào sẽ bị trừ lượng trong ghi trong ô đó.
               - Hết năng lượng hoặc không thể di chuyển, bạn sẽ thua!
                 */
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn4.setForeground(Color.blue);
                btn4.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn4.setForeground(Color.black);
                btn4.setFont(new Font("Tahoma", 1, 13));
            }
        });
        //======================= nut THONG TIN 5 ======================        

        btn5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                picLabel.setIcon(new ImageIcon(getClass().getResource("/com/treasurehuntgame/img/thongtin.PNG")));
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn5.setForeground(Color.blue);
                btn5.setFont(new Font("Tahoma", 1, 17));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn5.setForeground(Color.black);
                btn5.setFont(new Font("Tahoma", 1, 13));
            }
        });

        //====================== nút TOP 10 ========================================        
        btn6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                top10 = new Top10();
                top10.setVisible(true);

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn6.setForeground(Color.blue);
                btn6.setFont(new Font("Tahoma", 1, 17));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn6.setForeground(Color.black);
                btn6.setFont(new Font("Tahoma", 1, 13));
            }
        });

        setVisible(true);
        setResizable(false);
    }

    void close() {
        setVisible(false);
    }

}
