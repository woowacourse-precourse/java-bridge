package bridge.view;

import bridge.constants.GameCommand;
import bridge.constants.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String READ_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MOVING_ERROR_MESSAGE = "[ERROR] 이동은 U와 D로만 가능합니다.";
    private static final String READ_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작과 종료는 R과 Q로만 가능합니다";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(READ_SIZE_MESSAGE);
        try {
            int size = stringToInteger(Console.readLine());
            validateSize(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        try {
            return Moving.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(MOVING_ERROR_MESSAGE);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(READ_COMMAND_MESSAGE);
        try {
            return GameCommand.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(GAME_COMMAND_ERROR_MESSAGE);
            return readGameCommand();
        }
    }
}
