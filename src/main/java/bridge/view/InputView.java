package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;
    static final String IS_NOT_NUMBER = "다리 길이는 숫자여야 합니다";
    static final String IS_NOT_IN_RANGE = "다리 길이는 3 이상, 20 이하의 숫자여야 합니다";
    static final String IS_NOT_PROPER_MOVING = "이동할 칸은 대문자 U 또는 D 중 하나여야 합니다";

    public int readBridgeSize() {
        String bridgeSize = readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String moving = readLine();
        validateMoving(moving);
        return moving;
    }

    public String readGameCommand() {
        return null;
    }

    private void validateBridgeSize(String input) {
        int bridgeSize = strToInt(input);
        isBetweenRange(bridgeSize);
    }

    private void validateMoving(String input) {
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException(IS_NOT_PROPER_MOVING);
        }
    }

    private int strToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    private void isBetweenRange(int input) {
        if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(IS_NOT_IN_RANGE);
        }
    }
}
