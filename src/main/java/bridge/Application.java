package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        int bridge_size;
        //다리 길이 입력 받기
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridge_size=InputView.readBridgeSize();
        BridgeGame.move(bridge_size);

        }


}
