package bridge.view;

import bridge.domain.BridgeValue;
import bridge.Validation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final static String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: " + BridgeValue.UP.getValue() + ", 아래: " + BridgeValue.DOWN.getValue() + " )";
    private final static String INPUT_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String inputBridgeSize = Console.readLine();
        Validation.validateBridgeSizeInput(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String inputMoving = Console.readLine();
        Validation.validateMovingInput(inputMoving);
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
        String inputCommand = Console.readLine();
        Validation.validateCommandInput(inputCommand);
        return inputCommand;
    }
}
