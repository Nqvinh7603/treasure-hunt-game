
import java.util.Random;

/**
 *
 * @author Vinh
 */
public class GiaiThuat {

    public int a[][] = new int[15][15];

    public void taoMang(int n) {
        Random r = new Random();
        int t;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                a[i][j] = -r.nextInt(50) - 1;
                if(a[i][j]==-30||a[i][j]==-50&&a[i][j]==-70)
                    a[i][j]++;
            }
        }
        for (int i = 0; i < n; i++) {
                t = r.nextInt(223) + 1;
                while (a[t / 15][t % 15] > 0) 
                    t = r.nextInt(223) + 1;
                a[t / 15][t % 15] = 30;
        }
        for (int i = 0; i < n; i++) {
                t = r.nextInt(223) + 1;
                while (a[t / 15][t % 15] > 0) 
                    t = r.nextInt(223) + 1;
                a[t / 15][t % 15] = 50;
        }
        for (int i = 0; i < n; i++) {
                t = r.nextInt(223) + 1;
                while (a[t / 15][t % 15] > 0) 
                    t = r.nextInt(223) + 1;
                a[t / 15][t % 15] = 70;
        }
        for (int i = 0; i < n; i++) {
                t = r.nextInt(223) + 1;
                while (a[t / 15][t % 15] > 0 || ngoaiLe(t)) 
                    t = r.nextInt(223) + 1;
                a[t / 15][t % 15] = 1000000;
        }
        
         
    }

    public GiaiThuat(int n) {
        taoMang(n);
        a[0][0] = 0;
        a[14][14]=0;
    }
    
    public boolean ngoaiLe(int t){
        if(t==1||t==2||t==15||t==16||t==194||t==209||t==222||t==223||t==208)
            return true;
        return false;
    }
    
    
    public int tinhToiUu(){
        
        int A[][] = new int[225][225];
  
        for(int i=0;i<225;i++)
            for(int j=0;j<225;j++){
                A[i][j]=-10000000;
            }
        for(int i=0;i<15;i++)
            for(int j=0;j<15;j++){
                if(j<14) A[15*i+j][15*i+j+1]=a[i][j+1];
                if(i>0) A[15*i+j][15*(i-1)+j]=a[i-1][j];
                if(j>0) A[15*i+j][15*i+j-1]=a[i][j-1];
                if(i<14) A[15*i+j][15*(i+1)+j]=a[i+1][j];
            }
            for(int i=0;i<225;i++)
                for(int j=0;j<225;j++){
                  if(A[i][j]<0)
                      A[i][j]=-A[i][j];
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
        if (Nhan[v] > A[u][v] + Nhan[u] && DanhDau[v] == 0)
        {
            Nhan[v] = A[u][v] + Nhan[u];
            Truoc[v] = u;
        }
}

    return Nhan[des];
    }
}
