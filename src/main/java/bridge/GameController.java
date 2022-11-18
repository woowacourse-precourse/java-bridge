package bridge;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        outputView.printGameStartMessage();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Integer size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        for (int turn = 0; turn < size; turn++) {
            String moving = inputView.readMoving();
            String movePossible = bridgeGame.move(moving, bridge.get(turn));
            if (movePossible.equals("O")) {
                continue;
            }
        }
    }
}