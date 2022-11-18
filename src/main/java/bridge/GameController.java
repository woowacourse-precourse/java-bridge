package bridge;

import java.util.List;

public class GameController {
    private static final String RETRY_COMMAND = "R";
    private static final String POSSIBLE_MOVE = "O";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private boolean success = false;

    public void play() {
        outputView.printGameStartMessage();
        Integer size = inputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame();
        startWalk(bridgeGame, bridge);
    }

    private void walk(BridgeGame bridgeGame, List<String> bridge) {
        for (String bridgeStatus : bridge) {
            if (isMovePossible(bridgeGame, bridgeStatus)) {
                outputView.printMap();
                continue;
            }
            return;
        }
        success = true;
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge) {
        while (!isSuccess()) {
            walk(bridgeGame, bridge);
            if (isRetry()) {
                bridgeGame.retry();
                continue;
            }
            break;
        }
    }

    private boolean isSuccess() {
        return success;
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus) {
        String moving = inputView.readMoving();
        String movePossible = bridgeGame.move(moving, bridgeStatus);
        return movePossible.equals(POSSIBLE_MOVE);
    }

    private boolean isRetry() {
        if (isSuccess()) {
            return false;
        }
        String command = inputView.readGameCommand();
        return command.equals(RETRY_COMMAND);
    }
}