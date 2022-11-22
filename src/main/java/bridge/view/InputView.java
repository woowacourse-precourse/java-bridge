package bridge.view;

import bridge.model.GameCommandFlag;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final String GAME_COMMAND_RETRY = "R";
    private static final String GAME_COMMAND_QUIT = "Q";
    private static final String MOVING_COMMAND_UP = "U";
    private static final String MOVING_COMMAND_DOWN = "D";
    private static final String PATTERN = "^\\d*$";

    public int readBridgeSize() {
        String bridgeSize = receiveInput();
        validateNumber(bridgeSize);
        return validateSize(bridgeSize);
    }

    public String readMoving() {
        String moving = receiveInput();
        validateMovingInput(moving);
        return moving;
    }

    public GameCommandFlag readGameCommand() {
        String gameCommand = receiveInput();
        validateGameCommand(gameCommand);
        return GameCommandFlag.toString(gameCommand);
    }

    private String receiveInput() {
        return Console.readLine();
    }

    private void validateNumber(String input) {
        if (!input.matches(PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
    }

    private int validateSize(String input) {
        int size = Integer.parseInt(input);
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    private void validateMovingInput(String input) {
        if (!input.equals(MOVING_COMMAND_UP) && !input.equals(MOVING_COMMAND_DOWN)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D를 입력해 주세요.");
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals(GAME_COMMAND_RETRY) && !input.equals(GAME_COMMAND_QUIT)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q를 입력해 주세요.");
        }
    }
}
