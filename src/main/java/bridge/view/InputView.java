package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import bridge.validate.Validator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        Validator.isNum(bridgeSize);
        Validator.isProperBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }
    
    public String readMoving() {
        String move = Console.readLine();
        Validator.isMove(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
