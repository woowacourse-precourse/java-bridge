package bridge;

import bridge.controller.InputController;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        final InputController inputController = new InputController();
        List<List<String>> bridgeMap;
        boolean success;
        int gameCount = 0;

        OutputView.printGameStart();
        int bridgeSize = inputController.getBridgeSize(InputView.readBridgeSize());
        final BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        final List<String> bridge = bridgeGame.makeBridge();

        do {
            success = true;
            gameCount = bridgeGame.countGame(gameCount);
            bridgeMap = new ArrayList<>();
            for (String bridgeBlock : bridge) {
                String moving = inputController.getMoving(InputView.readMoving());
                if (!bridgeGame.move(moving, bridgeBlock, bridgeMap)) {
                    success = false;
                    OutputView.printMap(bridgeMap);
                    break;
                }
                OutputView.printMap(bridgeMap);
            }
            if (success) {
                break;
            }
        } while (bridgeGame.retry(inputController.getGameCommand(InputView.readGameCommand())));
        OutputView.printResult(bridgeMap, success, gameCount);
    }
}
