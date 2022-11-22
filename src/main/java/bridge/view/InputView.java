package bridge.view;

import bridge.constants.GameCommand;
import bridge.constants.Moving;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String SIZE_RANGE_ERROR = "[ERROR] 다리의 길이는 3 이상 20 이하 입니다.";
    private static final String SIZE_NUMBER_ERROR = "[ERROR] 다리의 길이는 숫자만 입력 가능합니다.";
    private static final String MOVING_ERROR = "[ERROR] 이동은 U와 D로만 가능합니다.";
    private static final String GAME_COMMAND_ERROR = "[ERROR] 게임 재시작과 종료는 R과 Q로만 가능합니다";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size;
        try {
            size = stringToInteger(Console.readLine());
            validateSize(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return size;
    }

    private int stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SIZE_NUMBER_ERROR);
        }
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(SIZE_RANGE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Moving readMoving() {
        try {
            return Moving.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(MOVING_ERROR);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            return GameCommand.valueOf(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(GAME_COMMAND_ERROR);
            return readGameCommand();
        }
    }
}
