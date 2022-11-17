package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        try {
        List<String> bridge = bridgeGame.getBridge(inputView.readBridgeSize());
            do {
                playGame(bridge);
            } while (!bridgeGame.isGameClear(bridge));
        outputView.printFinalMessage(bridgeGame.getResult());
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static void playGame(List<String> bridge) {
        MessageToResult messageToResult = moveToBridge(bridge);
        if (!messageToResult.isCorrect()) {
            if (bridgeGame.retry(inputView.readGameCommand())) {
                outputView.clear();
                playGame(bridge);
            }
        }
    }

    private static MessageToResult moveToBridge(List<String> bridge) {
        MessageToResult messageToResult = bridgeGame.move(bridge, inputView.readMoving());
        outputView.printMap(messageToResult);
        return messageToResult;
    }
}
