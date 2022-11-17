package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String BRIDGE_SIZE_REQUEST_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_REQUEST_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printBridgeSizeRequestMessage();
        String bridgeSize = Console.readLine();
        inputValidator.validateBridegeSize(bridgeSize);
        printEnter();
        return parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printMovingRequestMessage();
        String moving = Console.readLine();
        inputValidator.validateMoving(moving);
        printEnter();
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void printEnter() {
        System.out.println();
    }

    private void printBridgeSizeRequestMessage() {
        System.out.println(BRIDGE_SIZE_REQUEST_MESSAGE);
    }

    private void printMovingRequestMessage() {
        System.out.println(MOVING_REQUEST_MESSAGE);
    }
}
