package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_COMMAND_GUIDE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND_GUIDE_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String WRONG_INPUT_BRIDGE_LENGTH_MESSAGE = "\n[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String WRONG_INPUT_MOVE_COMMAND_MESSAGE = "\n[ERROR] 이동 가능한 칸은 U 또는 D입니다.";
    private static final String WRONG_INPUT_GAME_COMMAND_MESSAGE = "\n[ERROR] 입력 가능한 명령어 R 또는 Q입니다.";

    private static final String ONLY_NUMBERS_REGEX = "^[0-9]*$";
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUITE_COMMAND = "Q";
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final int MIN_BRIDGE_SIZE = 3;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE);
        return convertBridgeSize(Console.readLine());
    }

    private int convertBridgeSize(String input) {
        try {
            validateOnlyNumbers(input);
            return validateSizeOfNumber(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void validateOnlyNumbers(String input) {
        if (!input.matches(ONLY_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }
    }

    private int validateSizeOfNumber(String input) {
        int number = Integer.parseInt(input);

        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }

        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_MOVE_COMMAND_GUIDE_MESSAGE);
            return validateMoveCommand(Console.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private String validateMoveCommand(String input) {
        if (!input.equals(UP_COMMAND) && !input.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(WRONG_INPUT_MOVE_COMMAND_MESSAGE);
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println(INPUT_GAME_COMMAND_GUIDE_MESSAGE);
            return validateGameCommand(Console.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private String validateGameCommand(String input) {
        if (!input.equals(RETRY_COMMAND) && !input.equals(QUITE_COMMAND)) {
            throw new IllegalArgumentException(WRONG_INPUT_GAME_COMMAND_MESSAGE);
        }

        return input;
    }
}
