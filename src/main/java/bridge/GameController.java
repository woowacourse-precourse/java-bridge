package bridge;

import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private boolean success = false;

    public void play() {
        outputView.printGameStartMessage();
        BridgeSize bridgeSize = readBridgeSize();

        Integer size = bridgeSize.getBrideSize();

        BridgeMaker bridgeMaker = bridgeMaker();

        List<String> bridge = bridgeMaker.makeBridge(size);

        BridgeGame bridgeGame = new BridgeGame();

        MoveResult moveResult = moveResult();

        startWalk(bridgeGame, bridge, moveResult);

    }

    private AttemptNumber attemptNumber() {
        return new AttemptNumber();
    }

    private BridgeSize readBridgeSize() {
        Integer size = inputView.readBridgeSize();
        return new BridgeSize(size);
    }

    private BridgeMaker bridgeMaker() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        return new BridgeMaker(bridgeNumberGenerator);
    }

    private void walk(BridgeGame bridgeGame, List<String> bridge, MoveResult moveResult) {
        for (String bridgeStatus : bridge) {
            if (isMovePossible(bridgeGame, bridgeStatus, moveResult)) {
                moveResult.printBridge(outputView);
                continue;
            }
            moveResult.printBridge(outputView);
            return;
        }
        success = true;
    }

    private void startWalk(BridgeGame bridgeGame, List<String> bridge, MoveResult moveResult) {
        AttemptNumber attemptNumber = attemptNumber(); // 리팩토링 대상
        while (!isSuccess()) {
            walk(bridgeGame, bridge, moveResult);
            if (isRetry()) {
                bridgeGame.retry(attemptNumber);
                moveResult.clearHistory();
                continue;
            }
            break;
        }
        attemptNumber.printAttemptNumber(outputView, isSuccess());
    }

    private MoveResult moveResult() {
        return new MoveResult();
    }

    private boolean isSuccess() {
        return success;
    }

    private boolean isMovePossible(BridgeGame bridgeGame, String bridgeStatus, MoveResult moveResult) {
        String moving = moving();
        boolean movePossible = bridgeGame.move(moving, bridgeStatus);
        moveResult.makeResultBridge(moving, movePossible);

        return movePossible;
    }

    private String moving() {
        String moving = inputView.readMoving();
        return new Moving(moving).getMoving();
    }

    private boolean isRetry() {
        if (isSuccess()) {
            return false;
        }
        String command = inputView.readGameCommand();
        GameCommand gameCommand = new GameCommand(command);
        return gameCommand.isRetry();
    }
}