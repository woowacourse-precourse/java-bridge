package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void start() {
        output.printStart();
        Bridge randomBridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        gameStart(bridgeGame, randomBridge);
    }

    private void gameStart(BridgeGame bridgeGame, Bridge randomBridge) {
        Result result = new Result();
        while (!randomBridge.isSize(result.nowCount()) && result.movable()) {
            output.printMove();
            String inputMove = input.readMoving();
            result.updateState(inputMove, bridgeGame.move(inputMove, result.nowCount()));
        }
    }

    private Bridge makeBridge() {
        output.printInputBridgeSize();
        while (true) {
            try {
                int bridgeSize = input.readBridgeSize();
                return new Bridge(maker.makeBridge(bridgeSize));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
