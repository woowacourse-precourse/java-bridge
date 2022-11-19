package bridge.input;

import static bridge.input.InputExceptionHandler.validateBridgeLengthInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class InputView {

    /**
     * 다리의 길이를 입력받고, 해당 다리의 길이를 반환합니다.
     * 이때 비정상적인 입력이 들어올 경우, 다시 재귀를 통해 입력을 받습니다.
     * @throws IllegalStateException 입력받은 다리의 길이가 1 이상의 정수가 아닌 경우
     */
    public int readBridgeSize() {
        String brideLength;
        try {
            brideLength = readLine();
            validateBridgeLengthInput(brideLength);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
        return Integer.parseInt(brideLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
