package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_ONLY_NUMBER = "다리길이는 숫자여야 합니다.";
    private static final String NOT_MOVING_PATTERN = "[^UD]";
    private static final String INPUT_U_OR_D = "위 칸은 U, 아래 칸은 D로만 입력 가능합니다.";
    private static final String NOT_GAME_COMMAND_PATTERN = "[^RQ]";
    private static final String INPUT_R_OR_Q = "재시작은 R, 종료는 Q로만 입력 가능합니다.";

    public int readBridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_ONLY_NUMBER);
        }
        return bridgeSize;
    }

    public String readMoving() {
        String moving = Console.readLine();
        validate(moving, NOT_MOVING_PATTERN, INPUT_U_OR_D);
        return moving;
    }

    public String readGameCommand() {
        String gameCommand = Console.readLine();
        validate(gameCommand, NOT_GAME_COMMAND_PATTERN, INPUT_R_OR_Q);
        return gameCommand;
    }

    private void validate(String input, String pattern, String errorMessage) {
        if (input.matches(pattern)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
