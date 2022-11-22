package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame game;

    public void start() {
        setBridgeGame();
        do {
            boolean trialResult = trial();
            if (trialResult) {
                break;
            }
        } while (doesPlayerWantRetry());
        OutputView.printResult(game.getBridgeGameResult());
    }

    private boolean doesPlayerWantRetry() {
        Boolean doRetry = null;
        while (doRetry == null) {
            try {
                doRetry = GameCommand.doRetry(InputView.readGameCommand());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return doRetry;
    }

    private boolean trial() {
        int round = 1;
        while (round <= game.getBridgeSize()) {
            boolean roundResult = playRound(round);
            if (!roundResult) {
                return false;
            }
            round += 1;
        }
        return true;
    }

    private boolean playRound(int round) {
        reTryIfNotFirstRound(round);
        BridgeMove playerMove = readRoundPlayerMoving();
        return game.move(round, playerMove);
    }

    private void reTryIfNotFirstRound(int round) {
        if (round > 1) {
            game.retry();
        }
    }

    private BridgeMove readRoundPlayerMoving() {
        BridgeMove playerMove = null;
        while (playerMove == null) {
            try {
                playerMove = BridgeMove.getBridgeMoveByMoveCommand(InputView.readMoving());
                OutputView.printMap(new BridgeGameTrialResult());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return playerMove;
    }

    private void setBridgeGame() {
        BridgeSize bridgeSize = null;
        while (bridgeSize == null) {
            try {
                bridgeSize = new BridgeSize(InputView.readBridgeSize());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        game = new BridgeGame(bridgeSize);
    }


}
