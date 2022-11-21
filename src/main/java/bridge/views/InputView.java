package bridge.views;

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
        String bridgeSizeInput = readValidBridgeSize();
        System.out.println();
        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 유효한 다리의 길이를 입력받을 때 까지 반복해서 입력을 받는다.
     * @return 유효한 다리의 길이(3 ~ 20)
     */
    private String readValidBridgeSize() {
        while (true) {
            String bridgeSizeInput = readLine();
            try {
                InputValidator.validateBridgeSize(bridgeSizeInput);
                return bridgeSizeInput;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printChooseMovingInputMessage();
        String moveDirection = readValidMoving();
        return moveDirection;
    }

    /**
     * 유효한 이동 방향을 입력받을 때 까지 입력을 받는다.
     * @return 유효한 이동방향(U, D)
     */
    private String readValidMoving() {
        while (true) {
            String moveDirection = readLine();
            try {
                InputValidator.validateMoveDirection(moveDirection);
                return moveDirection;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(ErrorMessage.INVALID_MOVE_DIRECTION.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetryInputMessage();
        String retryInput = readValidGameCommand();
        return retryInput;
    }

    /**
     * 게임을 다시 시도할지 종료할지에 대한 유효한 입력을 받을때까지 입력을 받는다.
     * @return 유효한 게임 재시도 여부(R, Q)
     */
    private String readValidGameCommand() {
        while (true) {
            String retryInput = readLine();
            try {
                InputValidator.validateRetryInput(retryInput);
                return retryInput;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }
}
