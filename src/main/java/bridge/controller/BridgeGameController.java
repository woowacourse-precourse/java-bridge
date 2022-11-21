package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;

public class BridgeGameController {

    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;
    private static final String UP_MOVE_COMMAND = "U";
    private static final String DOWN_MOVE_COMMAND = "D";
    private static final String RETRY_GAME_COMMAND = "R";
    private static final String QUIT_GAME_COMMAND = "Q";

    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    private int bridgeSize;
    private int userPosition = 0;
    private int userTryCount = 1;

    public void run() {
        try {
            this.bridgeSize = setBridgeSize();
            bridgeGame.setGame(bridgeSize);
            controlGame();
            System.out.println("trycount:" + userTryCount);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private int setBridgeSize() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void controlGame() {
        while (true) {
            if (!startRound()) {
                return;
            }
            if (userPosition == bridgeSize) {
                return;
            }
        }
    }

    private boolean startRound() {
        if (!setMoving()) {
            if (!setRetry()) {
                return false;
            }
            userTryCount ++;
            userPosition = 0;
            return true;
        }
        userPosition++;
        return true;
    }

    private boolean setMoving() {
        while (true) {
            try {
                String moveCommand = inputView.readMoving();
                validateMovingCommand(moveCommand);
                return bridgeGame.move(moveCommand);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private boolean setRetry() {
        while (true) {
            try {
                String retryCommand = inputView.readGameCommand();
                validateRetryCommand(retryCommand);
                return bridgeGame.retry(retryCommand);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateMovingCommand(String command) {
        if (!command.equals(UP_MOVE_COMMAND) && !command.equals(DOWN_MOVE_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 건널 칸은 U 또는 D 문자여야 합니다.");
        }
    }

    private void validateRetryCommand(String command) {
        if (!command.equals(RETRY_GAME_COMMAND) && !command.equals(QUIT_GAME_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R 또는 Q 문자여야 합니다.");
        }
    }


}

