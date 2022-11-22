package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = BridgeMaker.makeBridge(bridgeSize);
        List<String> userMoving = new ArrayList<>();
        BridgeGame.move(bridge, userMoving);
        BridgeGame.gameResult(bridge, userMoving);
        OutputView.printResult(bridge,userMoving,BridgeGame.failCheck,BridgeGame.playCount);
    }

}
