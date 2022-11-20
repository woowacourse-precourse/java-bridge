package bridge.view;

import static bridge.Constants.MoveMark.*;
import static bridge.Constants.CommandMark.*;

public class Validator {
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;
    static final String ERROR = "[ERROR] ";
    static final String IS_NOT_NUMBER = ERROR + "다리 길이는 숫자(정수)여야 합니다.";
    static final String IS_NOT_IN_RANGE = ERROR + "다리 길이는 3 이상, 20 이하의 숫자여야 합니다.";
    static final String IS_NOT_PROPER_MOVING = ERROR + "이동할 칸은 대문자 U 또는 D 중 하나여야 합니다.";
    static final String IS_NOT_PROPER_COMMAND = ERROR + "게임 재시작 여부는 대문자 R 또는 Q 중 하나여야 합니다.";

    public void validateBridgeSize(String input) {
        int bridgeSize = strToInt(input);
        isBetweenRange(bridgeSize);
    }

    public void validateMoving(String input) {
        if (!input.equals(DOWN.mark()) && !input.equals(UP.mark())) {
            throw new IllegalArgumentException(IS_NOT_PROPER_MOVING);
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals(RETRY.mark()) && !input.equals(QUIT.mark())) {
            throw new IllegalArgumentException(IS_NOT_PROPER_COMMAND);
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
