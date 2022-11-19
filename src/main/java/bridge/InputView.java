package bridge;

import bridge.messages.ErrorMessage;
import bridge.validators.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        String bridgeSizeInput = readLine();
        if (!InputValidator.isValidBridgeSize(bridgeSizeInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printChooseMovingInputMessage();
        String moveDirection = readLine();
        if (!InputValidator.isValidMoveDirection(moveDirection)) {
            throw new IllegalArgumentException();
        }
        return moveDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
