package bridge;

import java.util.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {





    
    
    public static int CreateN()
    {   
        Random rd = new Random();
        int n = rd.nextInt(1); 
        return n;
    }
    
    public static boolean[][] makeBridge(int size) {
        boolean array[][];
        array= new boolean[2][size];
        int n;
        boolean m;
        for(int i=0;i<size;i++){
            n=CreateN();
            m=reverse(n);

            array[0][i]=m;
            array[1][i]=!m;
        }
        
        return array; 
    }


    public static boolean reverse(int n){
        //n=CreateN();
        boolean m;
        
        if (n==1){
            m=true;
        }
        else{
            m=false;
        }

        return m;
    }

    public static int startGame(String move,boolean [][] array,int j)
    {
        int i;
        
        if (move=="U"){

            i=upMove(array,j);
        }
        
        else if(move=="D"){
            i=downMove(array,j);
        }
        else{

            System.out.println("[ERROR] 입력값이 틀렸습니다.");
            return 0;
        }

        return i;
    }

    public static int upMove(boolean [][] array,int i){
        //boolean [][] array=makeBridge(int size)
        
        if(array[0][i]==false){
            i=0;
        }

        else{

            i++;

        }
        return i;
            
        
    }

    public static int downMove(boolean [][] array,int i){
        
        
        if(array[1][i]==true){
            
            i++;

        }

        else{
            i=0;
        }

        return i;
            
        
    }









        
}


