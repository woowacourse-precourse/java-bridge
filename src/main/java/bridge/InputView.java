package bridge;

import static bridge.BridgeGame.QUIT;
import static bridge.BridgeGame.RETRY;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WRONG_INPUT_MESSAGE = "[ERROR] Please input only number.\n";
    private static final String WRONG_SIZE_MESSAGE = "[ERROR] Bridge size must be a number between 3 and 20.\n";
    private static final String WRONG_MOVE_MESSAGE = "[ERROR] Please input U or D.\n";
    private static final String WRONG_COMMAND_MESSAGE = "[ERROR] Please input R or Q.\n";
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.\n";
    private static final String INPUT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    private static final String INPUT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";

    protected static final String UP = "U";
    protected static final String DOWN = "D";
    private static final int MIN_NUMBER = 3;
    private static final int MAX_NUMBER = 20;

    private String currStep;

    public void printGameStart() {
        System.out.printf(GAME_START_MESSAGE);
    }

    private void printInputBridgeSize() {
        System.out.printf(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    private void printInputDirection() {
        System.out.printf(INPUT_DIRECTION_MESSAGE);
    }

    private void printInputCommand() {
        System.out.printf(INPUT_COMMAND_MESSAGE);
    }

    public int readBridgeSize() {
        printInputBridgeSize();
        while (true) {
            try {
                return validateBridgeSize(convertToInt(Console.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    private int validateBridgeSize(int size) {
        if (size >= MIN_NUMBER && size <= MAX_NUMBER) {
            return size;
        }
        throw new IllegalArgumentException(WRONG_SIZE_MESSAGE);
    }

    public String readMoving() {
        printInputDirection();
        while (true) {
            try {
                currStep = validateMove(Console.readLine());
                return currStep;
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    private String validateMove(String input) {
        if (input.equals(UP) || input.equals(DOWN)) {
            return input;
        }
        throw new IllegalArgumentException(WRONG_MOVE_MESSAGE);
    }

    public String readGameCommand() {
        printInputCommand();
        while (true) {
            try {
                return validateCommand(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    private String validateCommand(String input) {
        if (input.equals(RETRY) || input.equals(QUIT)) {
            return input;
        }
        throw new IllegalArgumentException(WRONG_COMMAND_MESSAGE);
    }

    public boolean isUP() {
        return currStep.equals(UP);
    }
}