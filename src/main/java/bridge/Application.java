package bridge;

import java.util.*;

public class Application {


    
        public static void main(String[] args){
            InputView inn = new InputView ();
            
            BridgeMaker BM = new BridgeMaker();

            int size=inn.readBridgeSize(); //다리길이 입력  
            int n=BM.CreateN(); //0,1중에 랜덤 생성
            boolean [][] Bridge=BM.makeBridge(size);  //boolean 형태 다리생성
            //boolean m=BM.reverse(n); //1일때 true 값 부여
            //String Move=in.readMoving(); //U,D입력
            
            //int i = BM.startGame(Move,Bridge); //U,D입력으로 i값생성
            //System.out.println(Bridge);
            boolean game = true;
            System.out.println(Bridge[0][0]);
            System.out.println(Bridge[1][0]);
            int j=0;
            while(game){
                String Move=inn.readMoving();           
                
                int m = BM.startGame(Move,Bridge,j);
                
                System.out.println(m);

                if (m==0){
                    game=false;
                }

            }
    }











    
}


