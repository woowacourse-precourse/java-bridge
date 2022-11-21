package bridge.view;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_BLOCK_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String INPUT_GAME_COMMAND_ERROR = "[ERROR] 게임 재시작/종료 값은 R 또는 Q 중 하나의 문자여야 합니다.";
    private static final String INPUT_VALUE_LENGTH_ERROR = "[ERROR] 입력 값의 길이는 1이어야 합니다.";
    private static final String INPUT_BLOCK_TO_MOVE_ERROR = "[ERROR] 이동할 칸은 U 또는 D 중 하나의 문자여야 합니다.";
    private static final String INPUT_NOT_INTEGER_ERROR = "[ERROR] 생성할 다리의 길이는 정수만 입력이 가능합니다.";
    private static final String INPUT_VALID_RANGE_OF_NUMBER_ERROR = "[ERROR] 3~20사이의 숫자만 입력이 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;

        while (true) {
            try {
                System.out.println(INPUT_BRIDGE_SIZE);
                input = Console.readLine();
                validateBridgeSize(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;

        while (true) {
            try {
                System.out.println(INPUT_BLOCK_TO_MOVE);
                input = Console.readLine();
                validateBlockToMove(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;

        while (true) {
            try {
                System.out.println(INPUT_GAME_COMMAND);
                input = Console.readLine();
                validateGameCommand(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return input;
    }

    private void validateBridgeSize(String input) {
        validateInteger(input);
        validateRange(parseInt(input));
    }

    private void validateBlockToMove(String input) {
        validateLength(input);
        validateCorrectBlock(input);
    }

    private void validateGameCommand(String input) {
        validateLength(input);
        validateCorrectCommand(input);
    }

    private void validateCorrectCommand(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(INPUT_GAME_COMMAND_ERROR);
        }
    }

    private void validateLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException(INPUT_VALUE_LENGTH_ERROR);
        }
    }

    private void validateCorrectBlock(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(INPUT_BLOCK_TO_MOVE_ERROR);
        }
    }

    private void validateInteger(String size) {
        String regex = "^[0-9]+$";

        if (!size.matches(regex)) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR);
        }

    }

    private void validateRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(INPUT_VALID_RANGE_OF_NUMBER_ERROR);
        }
    }
}
