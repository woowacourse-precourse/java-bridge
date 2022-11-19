package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> correctBridge = bridgeGame.makeCorrectBridge(InputView.readBridgeSize());
        OutputView outputView = new OutputView();
        outputView.printMap(correctBridge);
    }
}
