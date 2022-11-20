package ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private void validNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("NULL 불가.");
        }
    }

    private void validNotBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("Blank 불가.");
        }
    }

    public String userInput() {
        String input = Console.readLine();
        validNotNull(input);
        validNotBlank(input);
        return input;
    }

    private void validBridgeNumber(String input) {
        validNotStartWithZero(input);
        validNumber(input);
        validRange(input);
    }

    private void validNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }
    }

    private void validNotStartWithZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("숫자는 0으로 시작 X");
        }
    }

    private void validRange(String input) {
        if (input.length() > 2) {
            throw new IllegalArgumentException("범위 초과");
        } else if (input.length() == 2) {
            if (input.charAt(0) < '1' || input.charAt(0) > '2') {
                throw new IllegalArgumentException("범위 초과");
            }
        } else if (input.length() == 1) {
            if (input.charAt(0) <= '2') {
                throw new IllegalArgumentException("범위 초과");
            }
        }
    }

    private int inputToInteger(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            sum *= 10;
            sum += input.charAt(i) - '0';
        }
        return sum;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String input = userInput();
            validBridgeNumber(input);
            return inputToInteger(input);
        } catch (Exception e) {
            System.out.println(e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    private void validateCommandLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("명령의 길이가 다릅니다.");
        }
    }

    private void validateMovingCommand(String input) {
        if (!input.equals("U") || !input.equals("D")) {
            throw new IllegalArgumentException("유효하지 않은 이동 명령");
        }
    }

    public String readMoving() {
        try {
            String input = Console.readLine();
            validateCommandLength(input);
            validateMovingCommand(input);
            return input;
        } catch (Exception e) {
            System.out.println(e);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    private void validateGameCommand(String input) {
        if (!input.equals("R") || !input.equals("Q")) {
            throw new IllegalArgumentException("유효하지 않은 게임 명령입니다.");
        }
    }

    public String readGameCommand() {
        try {
            String input = Console.readLine();
            validateCommandLength(input);
            validateGameCommand(input);
            return input;
        } catch (Exception e) {
            System.out.println(e);
            return readGameCommand();
        }
    }
}
