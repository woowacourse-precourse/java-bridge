package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        List<String> bridge = bridgeGame.getBridge(inputView.readBridgeSize());
        if (moveResult(bridge)) {
            moveResult(bridge);
        }
    }

    private static boolean moveResult(List<String> bridge) {
        boolean isCorrect = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(bridge, isCorrect);
        return isCorrect;
    }
}
