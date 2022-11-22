package bridge.view;

import bridge.model.GameCommandFlag;
import camp.nextstep.edu.missionutils.Console;

import static bridge.Constant.*;

public class InputView {
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
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    private int validateSize(String input) {
        int size = Integer.parseInt(input);
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_MESSAGE);
        }
        return size;
    }

    private void validateMovingInput(String input) {
        if (!input.equals(MOVING_COMMAND_UP) && !input.equals(MOVING_COMMAND_DOWN)) {
            throw new IllegalArgumentException(MOVING_COMMAND_ONLY_U_OR_D);
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals(GAME_COMMAND_RETRY) && !input.equals(GAME_COMMAND_QUIT)) {
            throw new IllegalArgumentException(GAME_COMMAND_ONLY_R_OR_Q);
        }
    }
}
