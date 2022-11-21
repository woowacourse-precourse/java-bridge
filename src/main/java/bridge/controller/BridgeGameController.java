package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.model.GameCommand;
import bridge.model.Moving;
import bridge.model.MovingHistory;
import bridge.model.MovingResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    public static final boolean IN_PROGRESS = true;
    public static final boolean GAME_OVER = false;

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printGameIntro();

        BridgeGame bridgeGame = new BridgeGame(makeBridge());
        MovingHistory movingHistory = new MovingHistory();

        progressGame(bridgeGame, movingHistory);

        outputView.printResult(movingHistory, bridgeGame);
    }

    private Bridge makeBridge() {
        int bridgeSize = readBridgeSize();

        return Bridge.of(makeBridgeDirections(bridgeSize));
    }

    private void progressGame(BridgeGame bridgeGame, MovingHistory movingHistory) {
        boolean inProgress = IN_PROGRESS;
        while (inProgress) {
            MovingResult movingResult = move(bridgeGame, movingHistory);
            inProgress = updateGameStatus(bridgeGame, movingResult, movingHistory);
        }
    }

    private MovingResult move(BridgeGame bridgeGame, MovingHistory movingHistory) {
        Moving moving = readMoving();
        MovingResult movingResult = bridgeGame.move(moving);
        movingHistory.save(movingResult);

        outputView.printMap(movingHistory);

        return movingResult;
    }

    private Moving readMoving() {
        Moving moving;

        try {
            moving = inputView.readMoving();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return readMoving();
        }
        return moving;
    }

    private int readBridgeSize() {
        int bridgeSize;

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return readBridgeSize();
        }
        return bridgeSize;
    }

    private boolean updateGameStatus(BridgeGame bridgeGame, MovingResult movingResult, MovingHistory movingHistory) {
        if (movingResult.isFail()) {
            return askRestart(bridgeGame, movingHistory);
        }
        if (bridgeGame.getGameResult().isSuccess()) {
            return GAME_OVER;
        }
        return IN_PROGRESS;
    }

    private boolean askRestart(BridgeGame bridgeGame, MovingHistory movingHistory) {
        GameCommand command = inputView.readGameCommand();

        if (command.isRestart()) {
            bridgeGame.retry();
            movingHistory.reset();
            return IN_PROGRESS;
        }
        return GAME_OVER;
    }

    private List<String> makeBridgeDirections(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
