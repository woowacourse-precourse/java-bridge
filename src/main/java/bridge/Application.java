package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        try{
            InputController inputController = new InputController();

            int bridgeSize = inputController.getBridgeSize(InputView.readBridgeSize());
            BridgeGame bridgeGame = new BridgeGame(bridgeSize);

            List<String> bridge = bridgeGame.makeBridge();
            OutputView.printGameStart();

            List<List<String>> bridgeMap;
            boolean success;
            int gameCount = 0;

            do {
                success = true;
                gameCount = bridgeGame.countGame(gameCount);
                bridgeMap = new ArrayList<>();
                for (String bridgeBlock : bridge) {
                    String moving = inputController.getMoving(InputView.readMoving());
                    if (!bridgeGame.move(moving, bridgeBlock, bridgeMap)) {
                        success = false;
                        break;
                    }
                    OutputView.printMap(bridgeMap);
                }
                if (success) {
                    break;
                }
            } while (bridgeGame.retry(inputController.getGameCommand(InputView.readGameCommand())));
            OutputView.printResult(bridgeMap, success, gameCount);

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
