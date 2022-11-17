package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;
    static final String IS_NOT_NUMBER = "다리 길이는 숫자여야 합니다.";
    static final String IS_NOT_IN_RANGE = "다리 길이는 3 이상, 20 이하의 숫자여야 합니다.";
    static final String IS_NOT_PROPER_MOVING = "이동할 칸은 대문자 U 또는 D 중 하나여야 합니다.";
    static final String IS_NOT_PROPER_COMMAND = "게임 재시작 여부는 대문자 R 또는 Q 중 하나여야 합니다.";

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
        String command = readLine();
        validateGameCommand(command);
        return command;
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

    private void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
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
