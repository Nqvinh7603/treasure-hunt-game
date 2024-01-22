
import java.io.Serializable;

/**
 *
 * @author Vinh
 */
public class MaTran{
    int[][] T = new int[15][15];
    int x,y;
    public MaTran(){
        x=0;
        y=0;
        T[0][0] = 1;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    public void go(){
        T[x][y]=1;
    }
    public boolean lenTren(){
        if(x==0) return false;
        if(T[x-1][y] == 1) return false;
        x--;
        return true;
    }
    
    public boolean xuongDuoi(){
        if(x==14) return false;;
        if(T[x+1][y] == 1) return false;
        x++;
        return true;
    }
    
     public boolean sangPhai(){
        if(y==14) return false;;
        if(T[x][y+1] == 1) return false;
        y++;
        return true;
    }
    
     public boolean  sangTrai(){
        if(y==0) return false;
        if(T[x][y-1] == 1) return false;
        y--;
        return true;
    } 
    
    public boolean sangPhaiOK(){
        if(y==14) return false;;
        if(T[x][y+1] == 1) return false;
        return true;
    }
    
     public boolean sangTraiOK(){
        if(y==0) return false;
        if(T[x][y-1] == 1) return false;
        return true;
    }
     
    public boolean lenTrenOK(){
        if(x==0) return false;
        if(T[x-1][y] == 1) return false;
        return true;
    }
    
    public boolean xuongDuoiOK(){
        if(x==14) return false;;
        if(T[x+1][y] == 1) return false;
        return true;
    }
    
   
     
    public boolean hetDuong(){
        if(!sangPhaiOK() && !sangTraiOK() && !lenTrenOK() && !xuongDuoiOK())
            return true;
        return false;
    } 
}
