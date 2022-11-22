package bridge;

import static bridge.ValidateInput.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        String number = readLine();
        return checkBridgeSizeRange(isNumber(checkEmptyInput(number)));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String space = readLine();
        return checkSpaceToMove(checkEmptyInput(space));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String space = readLine();
        return checkGameRetry(checkEmptyInput(space));
    }
}
