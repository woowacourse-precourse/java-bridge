package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        int cnt=0;
        //다리 길이 입력 받기
        System.out.println("다리 건너기 게임을 시작합니다.");
        try{
        while (true){
            cnt+=1;
            int bridge_size;
            boolean check;
            String retry,result;
            bridge_size=InputView.readBridgeSize();
            if(bridge_size==0 ){
                break;
            }

            System.out.println(bridge_size);
            result=BridgeGame.move(bridge_size,cnt);
            if(result.equals("")){
                break;
            }
            check=BridgeGame.retry(result,cnt);
            if(check!=true){
                break;
            }

        }}catch (Exception e){
            System.out.println("[ERROR]");
    }
    }


}
