package bridge;

import static bridge.InputValidator.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String candidate = readLine();
        int lengthOfBridge = validateNumeric(candidate);
        validateRange(lengthOfBridge);
        return lengthOfBridge;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String candidate = readLine();
        validateUpOrDown(candidate);
        return candidate;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String candidate = readLine();
        validateRetry(candidate);
        return candidate;
    }
}
