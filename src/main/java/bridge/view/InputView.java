package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.util.InputCommandValidator;
import bridge.util.InputMovingValidator;
import bridge.util.InputSizeValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String MESSAGE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MESSAGE_INPUT_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(MESSAGE_INPUT_BRIDGE_SIZE);
        String input = readLine();
        try {
            InputSizeValidator.validator(input);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MESSAGE_INPUT_MOVING);
        String input = readLine();
        InputMovingValidator.validator(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(MESSAGE_INPUT_RESTART);
        String input = readLine();
        InputCommandValidator.validator(input);
        return input;
    }
}
