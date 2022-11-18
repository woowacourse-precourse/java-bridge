package bridge;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.startPrint();

        int size = InputView.readBridgeSize();

        List<String> bridge = BridgeMaker.makeBridge(size);
        System.out.println(bridge);

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStart(bridge);

        // TODO: 프로그램 구현
    }
}
