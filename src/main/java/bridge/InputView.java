package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String MESSAGE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_ERROR_INPUT_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final String REGEX_NUMBER = "\\d{1,2}";
    private static final String MESSAGE_INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String MESSAGE_ERROR_INPUT_MOVING = "[ERROR] 이동할 칸은 U 아니면 D인 1자리 문자열이어야 합니다.";
    private static final String MESSAGE_INPUT_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String MESSAGE_ERROR_INPUT_GAME_COMMAND = "[ERROR] 게임을 다시 시도할지 여부에 대한 입력은 R 아니면 Q인 1자리 문자열이어야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(MESSAGE_INPUT_BRIDGE_SIZE);
        String inputSize = Console.readLine();
        if (!inputSize.matches(REGEX_NUMBER)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_BRIDGE_SIZE);
        }
        int size = Integer.parseInt(inputSize);
        if (size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_BRIDGE_SIZE);
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MESSAGE_INPUT_MOVING);
        String moving = Console.readLine();
        if (!moving.matches(UP) && !moving.matches(DOWN)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_MOVING);
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MESSAGE_INPUT_GAME_COMMAND);
        String gameCommand = Console.readLine();
        if (!gameCommand.matches(RESTART) && !gameCommand.matches(QUIT)) {
            throw new IllegalArgumentException(MESSAGE_ERROR_INPUT_GAME_COMMAND);
        }
        return gameCommand;
    }
}
