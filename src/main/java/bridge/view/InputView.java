package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INTRO = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INTRO = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String INVALID_INPUT = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    private static final String INVALID_RANGE_INPUT = "[ERROR] 다리 길이의 범위는 3~20 입니다.";
    private static final String INVALID_MOVEMENT = "[ERROR] 플레이어는 U(위 칸) 또는 D(아래 칸)으로만 이동할 수 있습니다.";
    private static final String INVALID_RETRY_INPUT = "[ERROR] 게임을 재시도하기 위해서는 R, 종료하기 위해서는 Q를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            System.out.println(BRIDGE_SIZE_INTRO);
            String bridgeLength = Console.readLine();
            validateInput(bridgeLength);
            return convertToInteger(bridgeLength);
        }
    }

    private void validateInput(String bridgeLength) {
        try {
            validate(bridgeLength);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validate(String bridgeLength) {
        int winningNumber = convertToInteger(bridgeLength);
        if (winningNumber < 3 || 20 < winningNumber) {
            throw new IllegalArgumentException(INVALID_RANGE_INPUT);
        }
    }

    private int convertToInteger(String bridgeLength) {
        try {
            return Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            System.out.println(MOVE_INTRO);
            String input = Console.readLine();
            validateMoving(input);
            return input;
        }
    }

    private void validateMoving(String input) {
        try {
            validateMovingInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateMovingInput(String input) {
        if (!input.equals("D") && !input.equals("U")) {
            throw new IllegalArgumentException(INVALID_MOVEMENT);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            System.out.println(RETRY);
            String input = Console.readLine();
            validateCommand(input);
            return input;
        }
    }

    private void validateCommand(String input) {
        try {
            validateCommandInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateCommandInput(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_RETRY_INPUT);
        }
    }
}
