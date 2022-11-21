package bridge.controller;

import bridge.view.InputView;

public class BridgeGameController {

    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;
    private static final String UP_MOVE_COMMAND = "U";
    private static final String DOWN_MOVE_COMMAND = "D";
    private static final String RETRY_GAME_COMMAND = "R";
    private static final String QUIT_GAME_COMMAND = "Q";

    InputView inputView = new InputView();

    public void run() {
        makeBridgeBySize();
        controlMove();
        controlRetry();
    }

    public void makeBridgeBySize() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                if (!isValidateBridgeSize(bridgeSize)) {
                    throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
                }
                return;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void controlMove() {
        while (true) {
            try {
                String moveCommand = inputView.readMoving();
                if (!isValidateMovingCommand(moveCommand)) {
                    throw new IllegalArgumentException("[ERROR] 건널 칸은 U 또는 D 문자여야 합니다.");
                }
                return;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void controlRetry() {
        while (true) {
            try {
                String retryCommand = inputView.readGameCommand();
                if (!isValidateRetryCommand(retryCommand)) {
                    throw new IllegalArgumentException("[ERROR] 게임 재시도 여부는 R 또는 Q 문자여야 합니다.");
                }
                return;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private boolean isValidateBridgeSize(int size) {
        return size >= MIN_BRIDGE_SIZE && size <= MAX_BRIDGE_SIZE;
    }

    private boolean isValidateMovingCommand(String command) {
        return command.equals(UP_MOVE_COMMAND) || command.equals(DOWN_MOVE_COMMAND);
    }

    private boolean isValidateRetryCommand(String command) {
        return command.equals(RETRY_GAME_COMMAND) || command.equals(QUIT_GAME_COMMAND);
    }
}

