package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static int MIN_BRIDGE_LENGTH = 3;
    private static int MAX_BRIDGE_LENGTH = 20;
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
        OutputView.printResult(game);
    }

    private boolean doesPlayerWantRetry() {
        Boolean doRetry = null;
        while (doRetry == null) {
            try {
                doRetry = GameCommand.doRetry(InputView.readGameCommand());
            } catch (Exception exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return doRetry;
    }

    private boolean trial(int trial) {
        reTryIfNotFirstTrial(trial);
        int round = 1;
        while (round <= game.getBridgeSize()) {
            boolean roundResult = playRound(trial, round);
            if (!roundResult) {
                return false;
            }
            round += 1;
        }
        return true;
    }

    private boolean playRound(int trial, int round) {
        BridgeMove playerMove = readRoundPlayerMoving();
        boolean passed = game.move(round, playerMove);
        OutputView.printMap(game.getResult().getTrialResult(trial));
        return passed;
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
        int size = readBridgeSize();
        game = new BridgeGame(size, new BridgeRandomNumberGenerator());
    }

    private int readBridgeSize() {
        int size = -1;
        while (size == -1) {
            try {
                size = InputView.readBridgeSize();
                checkLengthIsInRange(size);
            } catch (IllegalArgumentException exception) {
                OutputView.printErrorMessage(exception);
            }
        }
        return size;
    }


    private void checkLengthIsInRange(int size) {
        if (size < MIN_BRIDGE_LENGTH || size > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException("다리의 길이는 3부터 20 사이의 자연수여야 합니다.");
        }
    }

}
