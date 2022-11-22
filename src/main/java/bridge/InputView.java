package bridge;


import camp.nextstep.edu.missionutils.Console;

import static bridge.Enums.InputEnum.*;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        INPUT_SIZE.getMessage();
        String bridgeSize = Console.readLine();
        Validate.isInputBridgeSizeValid(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        INPUT_MOVING.getMessage();
        String upOrDown = Console.readLine();
        Validate.isUOrD(upOrDown);
        return upOrDown.toUpperCase();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        INPUT_RETRY.getMessage();
        String retryOrQuit = Console.readLine();
        Validate.isROrQ(retryOrQuit);
        return retryOrQuit.toUpperCase();
    }
}
