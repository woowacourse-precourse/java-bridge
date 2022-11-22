package bridge;

import bridge.exception.LogicException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        LogicException.verifyBridgeSize(bridgeSize);
        int bridgeSizeIntValue = Integer.parseInt(bridgeSize);
        return bridgeSizeIntValue;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMoving = Console.readLine();
        LogicException.verifyUserInput(inputMoving);
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryOrQuit = Console.readLine();
        LogicException.verifyRetryOrQuit(retryOrQuit);
        return retryOrQuit;
    }
}
