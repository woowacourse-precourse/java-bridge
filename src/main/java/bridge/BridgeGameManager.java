package bridge;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.domain.BridgeGameState.*;
import static bridge.domain.BridgeGameState.START;

public class BridgeGameManager {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameManager(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void playGame() {
        bridgeGame.startGameWithBridgeSizeAs(getBridgeSize());
        BridgeGameState bridgeGameState = START;
        while (bridgeGameState.isBridgeGameContinue()) {
            bridgeGameState = handlePlayerMove();
            outputView.printMap(bridgeGame.getGameHistory());
            bridgeGameState = checkBridgeGameState(bridgeGameState);
        }
        outputView.printResult(bridgeGame.getGameHistory());
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private BridgeGameState handlePlayerMove() {
        while (true) {
            try {
                return bridgeGame.move(getMoveType());
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private BridgeMoveType getMoveType() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }

    private BridgeGameState checkBridgeGameState(BridgeGameState bridgeGameState) {
        if (bridgeGameState.isSuccess()) {
            return SUCCESS;
        }
        if (bridgeGameState.isFail()) {
            return checkGameEndType();
        }
        return bridgeGameState;
    }

    private BridgeGameState checkGameEndType() {
        BridgeGameEndType gameEndType = getGameEndCommand();
        if (gameEndType.isEnd()) {
            return FAIL;
        }
        bridgeGame.retry();
        return START;
    }

    private BridgeGameEndType getGameEndCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printException(e.getMessage());
            }
        }
    }
}
