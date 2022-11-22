package bridge.view;

import bridge.domain.Command;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_LENGTH_OF_BRIDGE_MSG = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_TO_GO_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_SELECT_TO_RETRY_MSG = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NULL_INPUT_ERROR_MSG = "[ERROR] 입력된 값이 없습니다.";
    private static final String BRIDGE_SIZE_ERROR_MSG = "[ERROR] 숫자 외 다른 문자를 입력할 수 없습니다.";
    private static final String MOVING_ERROR_MSG = "[ERROR] U, D 외 다른 값을 입력할 수 없습니다.";
    private static final String GAME_COMMAND_ERROR_MSG = "[ERROR] R, Q 외 다른 값을 입력할 수 없습니다.";

    private String getInput() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new IllegalArgumentException(NULL_INPUT_ERROR_MSG);
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_LENGTH_OF_BRIDGE_MSG);

        return convertStringToInteger(validateBridgeSize(getInput()));
    }

    private int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }

    private String validateBridgeSize(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MSG);
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Command readMoving() {
        System.out.println(INPUT_SELECT_TO_GO_MSG);

        return convertStringToCommand(validateMoving(getInput()));
    }

    private String validateMoving(String input) {
        if (!input.matches("^[UD]$")) {
            throw new IllegalArgumentException(MOVING_ERROR_MSG);
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public Command readGameCommand() {
        System.out.println(INPUT_SELECT_TO_RETRY_MSG);
        return convertStringToCommand(validateGameCommand(getInput()));
    }

    private String validateGameCommand(String input) {
        if (!input.matches("^[RQ]$")) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MSG);
        }
        return input;
    }

    private Command convertStringToCommand(String input) {
        return Command.getCommand(input);
    }
}
