package bridge.view;

import bridge.utils.Validator;
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
        Validator.checkIsNumber(bridgeSize);
        Validator.checkBridgeSize(Integer.parseInt(bridgeSize));
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moveSide = Console.readLine();
        Validator.checkIsSide(moveSide);
        return moveSide;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readRetry() {
        String retry = Console.readLine();
        Validator.checkIsRetry(retry);
        return retry;
    }
}
