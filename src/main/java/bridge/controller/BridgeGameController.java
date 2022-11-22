package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;
    private static final String RETRY_GAME_COMMAND = "R";
    private static final String QUIT_GAME_COMMAND = "Q";

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    private int bridgeSize;

    public void run() {
        init();
        while (true) {
            if (!startRound()) {
                break;
            }
        }
        outputView.printResult(bridgeGame.getBridgeStatus(), isSucess(), bridgeGame.getTryCount());
    }

    private void init() {
        this.bridgeSize = setBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    private boolean startRound() {
        boolean isMove = bridgeGame.determineMove(setMoving());
        outputView.printMap(bridgeGame.getBridgeStatus());
        if (isMove) {
            return !isSucess();
        }
        boolean isRetry = bridgeGame.determineRetry(setRetry());
        if (isRetry) {
            return true;
        }
        return false;
    }

    private boolean isSucess() {
        return bridgeGame.isEndPosition(bridgeSize);
    }

    private int setBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSize();
                int bridgeSize = inputView.readBridgeSize();
                validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String setMoving() {
        while (true) {
            try {
                outputView.printMoving();
                String moveCommand = inputView.readMoving();
                validateMovingCommand(moveCommand);
                return moveCommand;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private String setRetry() {
        while (true) {
            try {
                outputView.printGameCommand();
                String retryCommand = inputView.readGameCommand();
                validateRetryCommand(retryCommand);
                return retryCommand;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateMovingCommand(String command) {
        if (!command.equals(Direction.UP.getMoveOutput()) && !command.equals(Direction.DOWN.getMoveOutput())) {
            throw new IllegalArgumentException("[ERROR] 건널 칸은 U 또는 D 문자여야 합니다.");
        }
    }

    private void validateRetryCommand(String command) {
        if (!command.equals(RETRY_GAME_COMMAND) && !command.equals(QUIT_GAME_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R 또는 Q 문자여야 합니다.");
        }
    }

}

