
import java.awt.HeadlessException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author Vinh
 */
public class DapAn extends JFrame implements Runnable{
    Game g;
    int[] temp = new int [255];
    public int diem,count;
    
    public DapAn(Game gg) {
        this.g = gg;
        setSize(700,700);
        setLocationRelativeTo(null);
           for(int i=0;i<15;i++)
            for(int j=0;j<15;j++){
    
                if(g.gt.a[i][j] == -1000000)
                {   g.A[i][j].setText(""); 
                    g.A[i][j].setIcon(new ImageIcon(getClass().getResource("boom.PNG")));
                } else
                if(g.gt.a[i][j] == -70)
                {   g.A[i][j].setText("");
                    g.A[i][j].setIcon(new ImageIcon(getClass().getResource("khunglong.PNG")));
                } else
                if(g.gt.a[i][j] == -50)
                {   g.A[i][j].setText(""); 
                    g.A[i][j].setIcon(new ImageIcon(getClass().getResource("ho.PNG")));
                } else
                if(g.gt.a[i][j] == -30)
                {   g.A[i][j].setText(""); 
                    g.A[i][j].setIcon(new ImageIcon(getClass().getResource("chosoi.PNG")));
                } 
    }
        add(g);
        Thread t = new Thread(this);
        
        t.start();
       // g.thuchien(3,3);
    }

    @Override
    public void run() {
        giai();
    for(int i=count;i>=0;i--)
    {
        g.thuchien(temp[i]/15,temp[i]%15);
        if(i!=count) g.thuchienlai(temp[i+1]/15,temp[i+1]%15);
        try {
            sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(DapAn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }
    
    public void giai(){
        int a[][] = new int[225][225];
  
        for(int i=0;i<225;i++)
            for(int j=0;j<225;j++){
                a[i][j]=-10000000;
            }
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++){
                if(j<14) a[15*i+j][15*i+j+1]=g.gt.a[i][j+1];
                if(i>0) a[15*i+j][15*(i-1)+j]=g.gt.a[i-1][j];
                if(j>0) a[15*i+j][15*i+j-1]=g.gt.a[i][j-1];
                if(i<14) a[15*i+j][15*(i+1)+j]=g.gt.a[i+1][j];
            }
            for(int i=0;i<225;i++)
                for(int j=0;j<225;j++){
                  a[i][j]=-a[i][j];
            }
             
   
  int n=224;    
  int MAXINT = 10000000;
  int src =0, des = 224;
int[] DanhDau = new int[n + 1];
int[] Nhan = new int[n + 1];
int[] Truoc = new int[n + 1];
int  min, i;
  
for (i = 0; i <= n; i++)
{
    Nhan[i] = MAXINT;
    DanhDau[i] = 0;
    Truoc[i] = src;
}
Nhan[src] = 0;
DanhDau[src] = 0;

int u;
while (true){
    min = MAXINT; u=-1;
    for (int j = 0; j <= n; j++)
        if (min > Nhan[j] && DanhDau[j] == 0)
        {
            min = Nhan[j];
            u = j;
        }
    if(u==-1||u==n) break;
    
    DanhDau[u] = 1;
 
    for (int v = 0; v <= n; v++)
        if (Nhan[v] > a[u][v] + Nhan[u] && DanhDau[v] == 0)
        {
            Nhan[v] = a[u][v] + Nhan[u];
            Truoc[v] = u;
        }
}

             
// Truy vết đường đi và in kết quả

temp[0] = des;
temp[1] = Truoc[des];
i = Truoc[des];
int count = 2;
while (i != src)
{
    i = Truoc[i];
    temp[count] = i;
    count++;
}

this.count = count-1;
//for (i = count - 1; i >= 1; i--)
//    System.out.println(temp[i] + " --> ");
//    System.out.println(temp[0] + ": " + Nhan[des]);  
    
        setTitle("Năng lượng tiêu thụ ít nhất: "+Nhan[des]);
    this.diem=Nhan[des];
//for(i=0;i<225;i++)
              
      
    }
}
