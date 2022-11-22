package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<String> userMoving = new ArrayList<>();
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame.move(bridge, userMoving);
        BridgeGame.gameResult(bridge, userMoving);
        OutputView.printResult(bridge,userMoving,BridgeGame.failCheck,BridgeGame.playCount);
    }

}
