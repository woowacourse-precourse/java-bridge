package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_COMMAND_GUIDE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_COMMAND_GUIDE_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String WRONG_INPUT_BRIDGE_LENGTH_MESSAGE = "\n[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n";
    private static final String WRONG_INPUT_MOVE_COMMAND_MESSAGE = "\n[ERROR] 이동 가능한 칸은 U 또는 D입니다.\n";
    private static final String WRONG_INPUT_GAME_COMMAND_MESSAGE = "\n[ERROR] 입력 가능한 명령어 R 또는 Q입니다.\n";

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
        try {
            System.out.println(INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE);
            String input = Console.readLine();
            validateBridgeSize(input);
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void validateBridgeSize(String input) {
        if (!input.matches(ONLY_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }

        int number = Integer.parseInt(input);

        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_BRIDGE_LENGTH_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            System.out.println(INPUT_MOVE_COMMAND_GUIDE_MESSAGE);
            String input = Console.readLine();
            validateMoveCommand(input);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private void validateMoveCommand(String input) {
        if (!input.equals(UP_COMMAND) && !input.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(WRONG_INPUT_MOVE_COMMAND_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            System.out.println(INPUT_GAME_COMMAND_GUIDE_MESSAGE);
            String input = Console.readLine();
            validateGameCommand(input);
            return input;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static void validateGameCommand(String input) {
        if (!input.equals(RETRY_COMMAND) && !input.equals(QUITE_COMMAND)) {
            throw new IllegalArgumentException(WRONG_INPUT_GAME_COMMAND_MESSAGE);
        }
    }
}
