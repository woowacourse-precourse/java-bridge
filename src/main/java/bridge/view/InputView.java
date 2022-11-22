package bridge.view;

import bridge.domain.rule.BridgeRule;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    BridgeRule bridgeRule = new BridgeRule();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        int number = bridgeRule.isNumber(size);
        bridgeRule.isInRange(number);
        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {

        String command = Console.readLine();
        bridgeRule.isMoveCommand(command);
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        bridgeRule.isRetryCommand(command);
        return command;
    }
}
