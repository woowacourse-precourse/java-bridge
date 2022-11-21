package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        BridgeGame bridgeGame = new BridgeGame();
        BridgeFactory bridgeFactory = new BridgeFactory();
        BridgeGameEngine bridgeGameEngine = new BridgeGameEngine(bridgeGame, bridgeFactory);

        System.out.println("다리 건너기 게임을 시작합니다");

        int bridgeSize = ConsoleUtil.inputBridgeSize();

        List<String> bridge = bridgeFactory.makeBridgeByBridgeMaker(bridgeSize);

        bridgeGameEngine.playGame(bridge);
    }
}
