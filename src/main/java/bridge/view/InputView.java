package bridge.view;

import bridge.domain.message.ErrorMessage;
import bridge.domain.utils.BridgeCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    //TODO: InputView의 출력 사이에 개행을 맞춰야함
    public static final String INPUT_FOR_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_FOR_MOVING_BRIDGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_FOR_RETRY_OR_END = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_FOR_BRIDGE_SIZE);
        String input = Console.readLine();

        int result = convertBridgeSizeToInteger(input);
        validateBridgeSizeIsZero(result);

        return result;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = "";
        try {
            System.out.println(INPUT_FOR_MOVING_BRIDGE);
            input = Console.readLine();
            validateUserInputIsUpAndDown(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_FOR_RETRY_OR_END);
        String input = Console.readLine();
        return input;
    }

    private int convertBridgeSizeToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NUMERIC);
        }
    }

    private void validateBridgeSizeIsZero(int result) {
        if (result == 0)
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_ZERO);
    }

    private void validateUserInputIsUpAndDown(String input) {
        if (!input.equals(BridgeCommand.DOWN.getCommand()) && !input.equals(BridgeCommand.UP.getCommand()))
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_INPUT_ONLY_UP_AND_DOWN);
    }
}
