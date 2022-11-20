package bridge.view;

import static bridge.view.Validator.validateInputSizeException;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.messages.Message;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private String inputSize;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int inputBridgeSize() {
        System.out.println(Message.INPUT_SIZE.getMessage());
        inputSize = readLine();
        System.out.println();
        try {
            validateInputSizeException(inputSize);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputBridgeSize();
        }
        return Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputMovingDirection() {
        System.out.println(Message.SELECT_DIRECTION.getMessage());
        String inputDirection = readLine();
        Validator.validateInputDirectionNull(inputDirection);
        Validator.validateInputDirection(inputDirection);
        Validator.validateInputDirectionLowerCase(inputDirection);
        return inputDirection;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputGameRestart() {
        System.out.println(Message.ASK_RESTART.getMessage());
        String inputRestart = readLine();
        Validator.validateInputGameRestartNull(inputRestart);
        Validator.validateInputGameRestart(inputRestart);
        Validator.validateInputGameRestartLowerCase(inputRestart);
        return inputRestart;
    }
}
