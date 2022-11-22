package bridge.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

import camp.nextstep.edu.missionutils.Console;

import static bridge.messages.ExceptionMessage.*;

/**
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String LINE_BREAK = System.lineSeparator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
        return validateStringToInt(validateNotEmpty(Console.readLine()));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(LINE_BREAK + MOVE_INPUT_MESSAGE);
        return validateNotEmpty(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(LINE_BREAK + GAME_COMMAND_INPUT_MESSAGE);
        return validateNotEmpty(Console.readLine());
    }

    private String validateNotEmpty(String readLine) {
        if (readLine.isBlank()) {
            throw new IllegalArgumentException(ERROR_INPUT_LENGTH_ZERO.getMessage());
        }
        return readLine;
    }

    private int validateStringToInt(String readLine) {
        try {
            return Integer.parseInt(validateNotEmpty(readLine));
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER.getMessage());
        }
    }
}
