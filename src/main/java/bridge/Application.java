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
        do {
            MessageToResult messageToResult = bridgeGame.move(bridge, inputView.readMoving());
            outputView.printMap(messageToResult);
            if (!messageToResult.isCorrect()) {
                if (!bridgeGame.retry(inputView.readGameCommand())) {
                    break;
                }
                bridgeGame.clear();
                outputView.clear();
            }
        } while (!bridgeGame.isGameClear(bridge));
    }

    private static MessageToResult moveResult(List<String> bridge) {
        MessageToResult messageToResult = bridgeGame.move(bridge, inputView.readMoving());
        return messageToResult;
    }
}
