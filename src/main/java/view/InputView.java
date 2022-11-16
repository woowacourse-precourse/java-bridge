package view;

import camp.nextstep.edu.missionutils.Console;
import constants.BridgeConstants;
import constants.Message;

import java.util.regex.Pattern;

public class InputView {

    private static final Pattern DIGIT_REGEX = Pattern.compile("[0-9]+");

    public int readBridgeSize() {
        try {
            String userInput = Console.readLine();

            validateBridgeSize(userInput);

            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return readBridgeSize();
        }
    }

    private void validateBridgeSize(String userInput) {
        validateExistsString(userInput);
        validateBridgeSizeRange(Integer.parseInt(userInput));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateExistsString(String userInput) {
        if (!userInput.matches(DIGIT_REGEX.pattern())) {
            throw new IllegalArgumentException(Message.INPUT_PATTERN_ERROR_MESSAGE);
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < BridgeConstants.MIN_BRIDGE_SIZE
                || bridgeSize > BridgeConstants.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Message.BRIDGE_SIZE_ERROR_MESSAGE);
        }
    }
}
