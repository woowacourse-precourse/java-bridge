package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.model.Command;
import bridge.model.Move;
import bridge.util.InputCommandValidator;
import bridge.util.InputMovingValidator;
import bridge.util.InputSizeValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String MESSAGE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String MESSAGE_INPUT_MOVING = String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            Move.UP.getCommand(), Move.DOWN.getCommand());
    private static final String MESSAGE_INPUT_RESTART = String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            Command.RETRY.getCommand(), Command.QUIT.getCommand());

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = inputAboutDescription(MESSAGE_INPUT_BRIDGE_SIZE);
        try {
            InputSizeValidator.validator(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = inputAboutDescription(MESSAGE_INPUT_MOVING);
        try {
            InputMovingValidator.validator(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = inputAboutDescription(MESSAGE_INPUT_RESTART);
        try {
            InputCommandValidator.validator(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return input;
    }

    private String inputAboutDescription(String message) {
        System.out.println(message);
        return readLine();
    }
}
