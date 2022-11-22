package bridge.View;

import static bridge.View.OutputView.printBridgeLengthMsg;
import static bridge.View.OutputView.printMovingMsg;
import static bridge.View.OutputView.printRetryQuitMsg;
import static bridge.Validator.Validator.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */

public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printBridgeLengthMsg();
        String bridgeLength = readLine();
        validateBridgeLength(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printMovingMsg();
        String bridgeMoving = readLine();
        validateMoving(bridgeMoving);
        return bridgeMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printRetryQuitMsg();
        String gameCheck = readLine();
        validateGameCheck(gameCheck);
        return gameCheck;
    }
}
