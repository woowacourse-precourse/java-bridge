package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<String> userMoving = new ArrayList<>();
    public static List<String> bridge = new ArrayList<>();
    public static int bridgeSize = 0;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeSize = InputView.readBridgeSize();
        bridge = BridgeMaker.makeBridge(bridgeSize);
        BridgeGame.move(bridge, userMoving);
        BridgeGame.gameResult(bridge, userMoving);
        OutputView.printResult(bridge,userMoving,BridgeGame.failCheck,BridgeGame.playCount);
    }

}
