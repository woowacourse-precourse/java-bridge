package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), Collections.emptyList(), bridgeSize);
        List<List<String>> bridgeValues = null;

        while (true) {
            for (int i = 0; i < bridgeSize; i++) {
                String moveTo = inputView.readMoving();
                bridgeGame.move(moveTo);
                bridgeValues = bridgeGame.decideBridgeValues();
                outputView.printMap(bridgeValues);
                if (bridgeGame.isGameEnd()) {
                    break;
                }
            }
            if (bridgeGame.getGameStatus().isGameWon().equals("성공")) {
                break;
            }

            String retryStatus = inputView.readGameCommand();

            if (!bridgeGame.retry(retryStatus)) {
                break;
            }
        }
        outputView.printResult(bridgeValues, bridgeGame.getGameStatus());

    }
}
