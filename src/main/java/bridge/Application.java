package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
      /*  String key = "";
        do {
            boolean flag = true;
            while (flag) {
                flag = bridgeGame.move(InputView.readMoving());
            }
            key = InputView.readGameCommand();
        } while (key.equals("R"));*/
    }
}
