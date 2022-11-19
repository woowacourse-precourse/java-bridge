package bridge;

import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(new GameStatus(), Collections.emptyList(), bridgeSize);

        for (int i = 0; i < bridgeSize; i++) {
            String moveTo = inputView.readMoving();
            List<String> bridgeMoved = bridgeGame.move(moveTo);
            outputView.printMap(bridgeMoved, bridgeMoved.size());
        }


    }
}
