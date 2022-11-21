package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {


        //다리 길이 입력 받기
        System.out.println("다리 건너기 게임을 시작합니다.");
        while (true){
            int bridge_size;
            boolean check;
            String retry;
            bridge_size=InputView.readBridgeSize();
            System.out.println(bridge_size);
            BridgeGame.move(bridge_size);
            check=BridgeGame.retry();
            if(check!=true){
                break;
            }


        }

        }


}
