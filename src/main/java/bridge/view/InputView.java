package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String NUMBER_RANGE_REGEX = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^[2]{1}[0]{1}$";
    private static final String MOVING_REGEX = "^[UD]$";
    private static final String GAME_COMMAND_REGEX = "^[RQ]$";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 3~20 범위의 숫자를 입력해주세요.";
    private static final String MOVING_ERROR_MESSAGE = "[ERROR] U 혹은 D를 입력해주세요.";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R 혹은 Q를 입력해주세요.";

    public int readBridgeSize() {
        while (true) {
            String input = readInput(NUMBER_RANGE_REGEX, NUMBER_RANGE_ERROR_MESSAGE);
            if (input != null) {
                return Integer.parseInt(input);
            }
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            String input = readInput(MOVING_REGEX, MOVING_ERROR_MESSAGE);
            if (input != null) {
                return input;
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            String input = readInput(GAME_COMMAND_REGEX, GAME_COMMAND_ERROR_MESSAGE);
            if (input != null) {
                return input;
            }
        }
    }

    private String readInput(String regex, String errorMessage) {
        try {
            String input = Console.readLine();
            validate(input, regex, errorMessage);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private void validate(String input, String regex, String errorMessage) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
