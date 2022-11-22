package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGame game;

    public void start() {
        setBridgeGame();
        int trial = 1;
        do {
            boolean trialResult = trial(trial);
            if (trialResult) {
                break;
            }
            trial += 1;
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

    private boolean trial(int trial) {
        int round = 1;
        while (round <= game.getLength()) {
            boolean roundResult = playRound(trial, round);
            if (!roundResult) {
                return false;
            }
            round += 1;
        }
        return true;
    }

    private boolean playRound(int trial, int round) {
        reTryIfNotFirstTrial(trial);
        BridgeMove playerMove = readRoundPlayerMoving();
        game.move(round, playerMove);
        OutputView.printMap(game.getBridgeGameTrialResult(trial));
        return game.move(round, playerMove);
    }

    private void reTryIfNotFirstTrial(int trial) {
        if (trial > 1) {
            game.retry();
        }
    }

    private BridgeMove readRoundPlayerMoving() {
        BridgeMove playerMove = null;
        while (playerMove == null) {
            try {
                playerMove = BridgeMove.getBridgeMoveByMoveCommand(InputView.readMoving());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return playerMove;
    }

    private void setBridgeGame() {
        BridgeLength brideLength = null;
        while (brideLength == null) {
            try {
                brideLength = new BridgeLength(InputView.readBridgeSize());
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        game = new BridgeGame(brideLength, new BridgeRandomNumberGenerator());
    }


}
