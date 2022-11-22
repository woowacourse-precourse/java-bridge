package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    final private ValidateInputView validateInputView;

    public InputView() {
        validateInputView = new ValidateInputView();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readLine();
        try {
            return validateInputView.validateBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = readLine();
        try {
            validateInputView.validateMove(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = readLine();
        try {
            validateInputView.validateGameCommand(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }


}
