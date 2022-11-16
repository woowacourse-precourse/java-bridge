package bridge.Controller;

import bridge.domain.Bridge;

public class BridgeController {

    public void run(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        //다리 생성
        Bridge bridge = new Bridge();

        for (int bridgePosition = 0; bridgePosition < bridge.getBridgeSize(); bridgePosition++) {

        }
    }
}
