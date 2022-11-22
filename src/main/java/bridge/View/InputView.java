package bridge.View;

import static bridge.View.Validator.InputValidator.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String candidate = readLine();
            validateInteger(candidate);
            int lengthOfBridge = Integer.parseInt(candidate);
            validateRange(lengthOfBridge);
            return lengthOfBridge;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String candidate = readLine();
            validateUpOrDown(candidate);
            return candidate;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String candidate = readLine();
            validateRetryOrQuit(candidate);
            return candidate;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return readGameCommand();
        }
    }
}
